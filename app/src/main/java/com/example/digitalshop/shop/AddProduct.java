package com.example.digitalshop.shop;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalshop.R;
import com.example.digitalshop.products.AccessResources;
import com.example.digitalshop.products.CreditCard;
import com.example.digitalshop.products.Games;
import com.example.digitalshop.products.GiftCertificate;
import com.example.digitalshop.products.MobileConnection;
import com.example.digitalshop.products.SocialNetwork;
import com.example.digitalshop.products.Software;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.w3c.dom.Text;

public class AddProduct extends AppCompatActivity {

    Button btnAddGame;
    Button btnAddSoftware;
    Button btnAddCreditCard;
    Button btnAddMobConnect;
    Button btnAddSocNet;
    Button btnGiftCertif;
    Button btnAccesRes;

    RelativeLayout root;

    DatabaseReference Game;
    DatabaseReference Software;
    DatabaseReference Credit_Card;
    DatabaseReference Access_Resources;
    DatabaseReference Gift_Certificate;
    DatabaseReference Mobile_Connection;
    DatabaseReference Social_Network;

    String GAME_KEY = "Game";
    String SOFTWARE_KEY = "Software";
    String CREDIT_CARD_KEY = "Credit_Card";
    String ACCESS_RESOURCES_KEY = "Access_Resources";
    String GIFT_CERTIFICATE_KEY = "Gift_Certificate";
    String MOBILE_CONNECTION_KEY = "Mobile_Connection";
    String SOCIAL_NETWORK_KEY = "Social_Network";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addproduct_activity);

        root = findViewById(R.id.root_addproduct);
        btnAddGame = findViewById(R.id.addGame);
        btnAddSoftware = findViewById(R.id.addSoftware);
        btnAddCreditCard = findViewById(R.id.addCreditCard);
        btnAddMobConnect = findViewById(R.id.addMobConnect);
        btnAddSocNet = findViewById(R.id.addSocNet);
        btnGiftCertif = findViewById(R.id.addGiftCertif);
        btnAccesRes = findViewById(R.id.addAccesRes);

        btnAddGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddShowGames();
            }
        });

        btnAddSoftware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddShowSoftware();
            }
        });

        btnAddCreditCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddShowCreditCard();
            }
        });

        btnAddMobConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddShowMobileConnect();
            }
        });

        btnAddSocNet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddShowSocialNetwork();
            }
        });

        btnGiftCertif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddShowGiftCertificate();
            }
        });

        btnAccesRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddShowAccessResources();
            }
        });

    }

    private void AddShowGames() {
        AlertDialog.Builder dialogAddGame = new AlertDialog.Builder(this);
        dialogAddGame.setTitle("Заполните данные");

        LayoutInflater inflaterAddGame = LayoutInflater.from(this);
        View add_Game = inflaterAddGame.inflate(R.layout.addproducts_seller, null);
        dialogAddGame.setView(add_Game);

        Game = FirebaseDatabase.getInstance().getReference(GAME_KEY);

        final MaterialEditText nameGame = add_Game.findViewById(R.id.NameProduct);
        final MaterialEditText costGame = add_Game.findViewById(R.id.CostProduct);
        final MaterialEditText quantityGame = add_Game.findViewById(R.id.QuantityProduct);
        final MaterialEditText descriptionGame = add_Game.findViewById(R.id.DescriptionProduct);

        dialogAddGame.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogCancAddGame, int which) {
                dialogCancAddGame.dismiss();
            }
        });

        dialogAddGame.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (TextUtils.isEmpty(nameGame.getText().toString())){
                    Snackbar.make(root, "Введите название товара", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(costGame.getText().toString())){
                    Snackbar.make(root, "Введите стоимость товара", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(quantityGame.getText().toString())){
                    Snackbar.make(root, "Введите количество товара", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                String idGame = Game.getKey();
                String NameGame = nameGame.getText().toString();
                String CostGame = costGame.getText().toString();
                String QuantityGame = quantityGame.getText().toString();
                String DescriptionGame = descriptionGame.getText().toString();

                Games games = new Games(idGame, NameGame, CostGame, QuantityGame, DescriptionGame);

                if (!TextUtils.isEmpty(NameGame) && !TextUtils.isEmpty(CostGame) && !TextUtils.isEmpty(QuantityGame)){
                    Game.push().setValue(games);
                    Snackbar.make(root, "Товар успешно добавлен", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                else {
                    Snackbar.make(root, "Что-то пошло не так", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        dialogAddGame.show();
    }

    private void AddShowSoftware() {
        AlertDialog.Builder dialogAddSoftware = new AlertDialog.Builder(this);
        dialogAddSoftware.setTitle("Заполните данные");

        LayoutInflater inflaterAddSoftware = LayoutInflater.from(this);
        View add_Software = inflaterAddSoftware.inflate(R.layout.addproducts_seller, null);
        dialogAddSoftware.setView(add_Software);

        Software = FirebaseDatabase.getInstance().getReference(SOFTWARE_KEY);

        final MaterialEditText nameSoftware = add_Software.findViewById(R.id.NameProduct);
        final MaterialEditText costSoftware = add_Software.findViewById(R.id.CostProduct);
        final MaterialEditText quantitySoftware = add_Software.findViewById(R.id.QuantityProduct);
        final MaterialEditText descriptionSoftware = add_Software.findViewById(R.id.DescriptionProduct);

        dialogAddSoftware.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogCancAddSoftware, int which) {
                dialogCancAddSoftware.dismiss();
            }
        });

        dialogAddSoftware.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (TextUtils.isEmpty(nameSoftware.getText().toString())){
                    Snackbar.make(root, "Введите наименование товара", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(costSoftware.getText().toString())){
                    Snackbar.make(root, "Введите стоимость товара", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(quantitySoftware.getText().toString())){
                    Snackbar.make(root, "Введите количество товара", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                String idSoftware = Software.getKey();
                String NameSoftware = nameSoftware.getText().toString();
                String CostSoftware = costSoftware.getText().toString();
                String QuantitySoftware = quantitySoftware.getText().toString();
                String DescriptionSoftware = descriptionSoftware.getText().toString();

                Software software = new Software(idSoftware, NameSoftware, CostSoftware, QuantitySoftware,
                        DescriptionSoftware);

                if (!TextUtils.isEmpty(NameSoftware) && !TextUtils.isEmpty(CostSoftware) && !TextUtils.isEmpty(QuantitySoftware)){
                    Software.push().setValue(software);
                    Snackbar.make(root, "Товар успешно добавлен", Snackbar.LENGTH_SHORT).show();
                    return;
                }else{
                    Snackbar.make(root, "Что-то пошло не так", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        dialogAddSoftware.show();
    }

    private void AddShowCreditCard() {
        AlertDialog.Builder dialogAddCreditCard = new AlertDialog.Builder(this);
        dialogAddCreditCard.setTitle("Заполните данные");

        LayoutInflater inflaterAddCreditCard = LayoutInflater.from(this);
        View add_CreditCard = inflaterAddCreditCard.inflate(R.layout.addproducts_seller, null);
        dialogAddCreditCard.setView(add_CreditCard);

        Credit_Card = FirebaseDatabase.getInstance().getReference(CREDIT_CARD_KEY);

        final MaterialEditText nameCreditCard = add_CreditCard.findViewById(R.id.NameProduct);
        final MaterialEditText costCreditCard = add_CreditCard.findViewById(R.id.CostProduct);
        final MaterialEditText quantityCreditCard = add_CreditCard.findViewById(R.id.QuantityProduct);
        final MaterialEditText descriptionCreditCard = add_CreditCard.findViewById(R.id.DescriptionProduct);

        dialogAddCreditCard.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogCancAddCredCard, int which) {
                dialogCancAddCredCard.dismiss();
            }
        });

        dialogAddCreditCard.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (TextUtils.isEmpty(nameCreditCard.getText().toString())){
                    Snackbar.make(root, "Введите наименование товара", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(costCreditCard.getText().toString())){
                    Snackbar.make(root, "Введите стоимость товара", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(quantityCreditCard.getText().toString())){
                    Snackbar.make(root, "Введите еоличество товара", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                String idCreditCard = Credit_Card.getKey();
                String NameCreditCard = nameCreditCard.getText().toString();
                String CostCreditCard = costCreditCard.getText().toString();
                String QuantityCreditCard = quantityCreditCard.getText().toString();
                String DescriptionCreditCard = descriptionCreditCard.getText().toString();

                CreditCard creditCard = new CreditCard(idCreditCard, NameCreditCard, CostCreditCard,
                        QuantityCreditCard, DescriptionCreditCard);

                if (!TextUtils.isEmpty(NameCreditCard) && !TextUtils.isEmpty(CostCreditCard) &&
                !TextUtils.isEmpty(QuantityCreditCard)){
                    Credit_Card.push().setValue(creditCard);
                    Snackbar.make(root, "Товар успешно добавлен", Snackbar.LENGTH_SHORT).show();
                    return;
                }else {
                    Snackbar.make(root, "Что-то пошло не так", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        dialogAddCreditCard.show();
    }

    private void AddShowMobileConnect() {
        AlertDialog.Builder dialogAddMobileConn = new AlertDialog.Builder(this);
        dialogAddMobileConn.setTitle("Заполните данные");

        LayoutInflater inflaterAddMobConn = LayoutInflater.from(this);
        View add_MobConn = inflaterAddMobConn.inflate(R.layout.addproducts_seller, null);
        dialogAddMobileConn.setView(add_MobConn);

        Mobile_Connection = FirebaseDatabase.getInstance().getReference(MOBILE_CONNECTION_KEY);

        final MaterialEditText nameMobConn = add_MobConn.findViewById(R.id.NameProduct);
        final MaterialEditText costMobConn = add_MobConn.findViewById(R.id.CostProduct);
        final MaterialEditText quantityMobConn = add_MobConn.findViewById(R.id.QuantityProduct);
        final MaterialEditText descriptionMobConn = add_MobConn.findViewById(R.id.DescriptionProduct);

        dialogAddMobileConn.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogCancAddMobConn, int which) {
                dialogCancAddMobConn.dismiss();
            }
        });

        dialogAddMobileConn.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (TextUtils.isEmpty(nameMobConn.getText().toString())){
                    Snackbar.make(root, "Введите наименование товара", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(costMobConn.getText().toString())){
                    Snackbar.make(root, "Введите стоимость товара", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(quantityMobConn.getText().toString())){
                    Snackbar.make(root, "Введите количество", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                String idMobConnect = Mobile_Connection.getKey();
                String NameMobConnect = nameMobConn.getText().toString();
                String CostMobConnect = costMobConn.getText().toString();
                String QuantityMobConnect = quantityMobConn.getText().toString();
                String DescriptionMobConnect = descriptionMobConn.getText().toString();

                MobileConnection mobileConnection = new MobileConnection(idMobConnect, NameMobConnect,
                        CostMobConnect, QuantityMobConnect, DescriptionMobConnect);

                if (!TextUtils.isEmpty(NameMobConnect) && !TextUtils.isEmpty(CostMobConnect)
                    && !TextUtils.isEmpty(QuantityMobConnect)){
                    Mobile_Connection.push().setValue(mobileConnection);
                    Snackbar.make(root, "Товар успешно добавлен", Snackbar.LENGTH_SHORT).show();
                    return;
                }else {
                    Snackbar.make(root, "Что-то пошло не так", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        dialogAddMobileConn.show();
    }

    private void AddShowSocialNetwork() {
        AlertDialog.Builder dialogAddSocNet = new AlertDialog.Builder(this);
        dialogAddSocNet.setTitle("Заполните данные");

        LayoutInflater inflaterAddSocNet = LayoutInflater.from(this);
        View add_SocNet = inflaterAddSocNet.inflate(R.layout.addproducts_seller, null);
        dialogAddSocNet.setView(add_SocNet);

        Social_Network = FirebaseDatabase.getInstance().getReference(SOCIAL_NETWORK_KEY);

        final MaterialEditText nameSocNet = add_SocNet.findViewById(R.id.NameProduct);
        final MaterialEditText costSocNet = add_SocNet.findViewById(R.id.CostProduct);
        final MaterialEditText quantitySocNet = add_SocNet.findViewById(R.id.QuantityProduct);
        final MaterialEditText descriptionSocNet = add_SocNet.findViewById(R.id.DescriptionProduct);

        dialogAddSocNet.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogCancAddSocNet, int which) {
                dialogCancAddSocNet.dismiss();
            }
        });

        dialogAddSocNet.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (TextUtils.isEmpty(nameSocNet.getText().toString())){
                    Snackbar.make(root, "Введите наименование товара", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(costSocNet.getText().toString())){
                    Snackbar.make(root, "Введите стоимость товара", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(quantitySocNet.getText().toString())){
                    Snackbar.make(root, "Введите количество товара", Snackbar.LENGTH_SHORT);
                    return;
                }

                String idSocNet = Social_Network.getKey();
                String NameSocNet = nameSocNet.getText().toString();
                String CostSocNet = costSocNet.getText().toString();
                String QuantitySocNet = quantitySocNet.getText().toString();
                String DescriptionSocNet = descriptionSocNet.getText().toString();

                SocialNetwork socialNetwork = new SocialNetwork(idSocNet, NameSocNet,
                        CostSocNet, QuantitySocNet, DescriptionSocNet);

                if (!TextUtils.isEmpty(NameSocNet) && !TextUtils.isEmpty(CostSocNet) &&
                        !TextUtils.isEmpty(QuantitySocNet)){
                    Social_Network.push().setValue(socialNetwork);
                    Snackbar.make(root, "Товар успешно добавлен", Snackbar.LENGTH_SHORT).show();
                    return;
                }else {
                    Snackbar.make(root, "Что-то пошло не так", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        dialogAddSocNet.show();
    }

    private void AddShowGiftCertificate() {
        AlertDialog.Builder dialogAddGiftCertif = new AlertDialog.Builder(this);
        dialogAddGiftCertif.setTitle("Заполните данные");

        LayoutInflater inflaterAddGiftCertif = LayoutInflater.from(this);
        View add_GiftCertif = inflaterAddGiftCertif.inflate(R.layout.addproducts_seller, null);
        dialogAddGiftCertif.setView(add_GiftCertif);

        Gift_Certificate = FirebaseDatabase.getInstance().getReference(GIFT_CERTIFICATE_KEY);

        final MaterialEditText nameGiftCertif = add_GiftCertif.findViewById(R.id.NameProduct);
        final MaterialEditText costGiftCertif = add_GiftCertif.findViewById(R.id.CostProduct);
        final MaterialEditText quantityGiftCertif = add_GiftCertif.findViewById(R.id.QuantityProduct);
        final MaterialEditText descriptionGiftCertif = add_GiftCertif.findViewById(R.id.DescriptionProduct);

        dialogAddGiftCertif.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogCancAddGiftSert, int which) {
                dialogCancAddGiftSert.dismiss();
            }
        });

        dialogAddGiftCertif.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (TextUtils.isEmpty(nameGiftCertif.getText().toString())){
                    Snackbar.make(root, "Введите наименование товара", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(costGiftCertif.getText().toString())){
                    Snackbar.make(root, "Введите стоимость товара", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(quantityGiftCertif.getText().toString())){
                    Snackbar.make(root, "Введите количество товара", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                String idGiftCertif = Gift_Certificate.getKey();
                String NameGiftCertif = nameGiftCertif.getText().toString();
                String CostGiftCertif = costGiftCertif.getText().toString();
                String QuantityGiftCertif = quantityGiftCertif.getText().toString();
                String DescriptionGiftCertif = descriptionGiftCertif.getText().toString();

                GiftCertificate giftCertificate = new GiftCertificate(idGiftCertif, NameGiftCertif,
                        CostGiftCertif, QuantityGiftCertif, DescriptionGiftCertif);

                if (!TextUtils.isEmpty(NameGiftCertif) && !TextUtils.isEmpty(CostGiftCertif)
                        && !TextUtils.isEmpty(QuantityGiftCertif)){
                    Gift_Certificate.push().setValue(giftCertificate);
                    Snackbar.make(root, "Товар успешно добавлен", Snackbar.LENGTH_SHORT).show();
                    return;
                }else {
                    Snackbar.make(root, "Что-то пошло не так", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        dialogAddGiftCertif.show();
    }

    private void AddShowAccessResources() {
        AlertDialog.Builder dialogAddAccessRes = new AlertDialog.Builder(this);
        dialogAddAccessRes.setTitle("Заполните данные");

        LayoutInflater inflaterAddAccRes = LayoutInflater.from(this);
        View add_AccRes = inflaterAddAccRes.inflate(R.layout.addproducts_seller, null);
        dialogAddAccessRes.setView(add_AccRes);

        Access_Resources = FirebaseDatabase.getInstance().getReference(ACCESS_RESOURCES_KEY);

        final MaterialEditText nameAccessRes = add_AccRes.findViewById(R.id.NameProduct);
        final MaterialEditText costAccessRes = add_AccRes.findViewById(R.id.CostProduct);
        final MaterialEditText quantityAccessRes = add_AccRes.findViewById(R.id.QuantityProduct);
        final MaterialEditText descriptionAccessRes = add_AccRes.findViewById(R.id.DescriptionProduct);

        dialogAddAccessRes.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogCancAddAccesRes, int which) {
                dialogCancAddAccesRes.dismiss();
            }
        });

        dialogAddAccessRes.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (TextUtils.isEmpty(nameAccessRes.getText().toString())){
                    Snackbar.make(root, "Введите наименование товара", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(costAccessRes.getText().toString())){
                    Snackbar.make(root, "Введите стоимость товара", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(quantityAccessRes.getText().toString())){
                    Snackbar.make(root, "Введите количество товара", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                String idAccessRes = Access_Resources.getKey();
                String NameAccessRes = nameAccessRes.getText().toString();
                String CostAccessRes = costAccessRes.getText().toString();
                String QuantityAccessRes = quantityAccessRes.getText().toString();
                String DescriptionAccessRes = descriptionAccessRes.getText().toString();

                AccessResources accessResources = new AccessResources(idAccessRes, NameAccessRes,
                        CostAccessRes, QuantityAccessRes, DescriptionAccessRes);

                if (!TextUtils.isEmpty(NameAccessRes) && !TextUtils.isEmpty(CostAccessRes) && !TextUtils.isEmpty(QuantityAccessRes)){
                    Access_Resources.push().setValue(accessResources);
                    Snackbar.make(root, "Товар добавлен успешно", Snackbar.LENGTH_SHORT).show();
                    return;
                }else {
                    Snackbar.make(root, "Что-то пошло не так", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
        dialogAddAccessRes.show();
    }
}
