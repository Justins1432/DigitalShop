package com.example.digitalshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.digitalshop.profileusers.ProfileBuyer;
import com.example.digitalshop.profileusers.ProfileSeller;
import com.example.digitalshop.users.Buyer;
import com.example.digitalshop.users.Seller;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn, btnRegist;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference buyers, sellers;

    RelativeLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnRegist = findViewById(R.id.btnRegister);
        root = findViewById(R.id.root_element);
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        buyers = db.getReference("Buyers");
        sellers = db.getReference("Sellers");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignInShop();
            }
        });
        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegisterUsers();
            }
        });
    }

    private void showSignInShop() {
        AlertDialog.Builder dialogSignIn = new AlertDialog.Builder(this);
        dialogSignIn.setTitle("Войти под видом пользователя......");

        LayoutInflater inflaterSignInBuyer = LayoutInflater.from(this);
        View sign_in = inflaterSignInBuyer.inflate(R.layout.sign_in_wind, null);
        dialogSignIn.setView(sign_in);

        Button btnSignInBuyer = sign_in.findViewById(R.id.btnSignInBuyer);
        Button btnSignInSeller = sign_in.findViewById(R.id.btnSignInSeller);

        btnSignInBuyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignInProfileBuyer();
            }
        });

        btnSignInSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignInProfileSeller();
            }
        });

        dialogSignIn.show();
    }

    private void SignInProfileBuyer() {
        AlertDialog.Builder dialogSignInBuyer = new AlertDialog.Builder(this);
        dialogSignInBuyer.setMessage("Введите логин и пароль");

        LayoutInflater inflaterSignInProfBuyer = LayoutInflater.from(this);
        View sign_in_buyer = inflaterSignInProfBuyer.inflate(R.layout.sign_buyer_or_seller, null);
        dialogSignInBuyer.setView(sign_in_buyer);

        final MaterialEditText emailField = sign_in_buyer.findViewById(R.id.emailFiled);
        final MaterialEditText passField = sign_in_buyer.findViewById(R.id.passField);

        dialogSignInBuyer.setNegativeButton("Выход", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogExitSignBuyer, int which) {
                dialogExitSignBuyer.dismiss();
            }
        });

        dialogSignInBuyer.setPositiveButton("Войти", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (TextUtils.isEmpty(emailField.getText().toString())){
                    Snackbar.make(root, "Почта не введена",
                            Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(passField.getText().toString())){
                    Snackbar.make(root, "Пароль не введён",
                            Snackbar.LENGTH_SHORT).show();
                    return;
                }

                auth.signInWithEmailAndPassword(emailField.getText().toString(), passField.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                startActivity(new Intent(MainActivity.this, ProfileBuyer.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Snackbar.make(root, "Ошибка авторизации" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                    }
                });
            }
        });
        dialogSignInBuyer.show();
    }

    private void SignInProfileSeller() {
        AlertDialog.Builder dialogSignInSeller = new AlertDialog.Builder(this);
        dialogSignInSeller.setMessage("Введите логин и пароль");

        LayoutInflater inflaterSignInProfSeller = LayoutInflater.from(this);
        View sign_in_seller = inflaterSignInProfSeller.inflate(R.layout.sign_buyer_or_seller, null);
        dialogSignInSeller.setView(sign_in_seller);

        final MaterialEditText emailField = sign_in_seller.findViewById(R.id.emailFiled);
        final MaterialEditText passField = sign_in_seller.findViewById(R.id.passField);

        dialogSignInSeller.setNegativeButton("Выход", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogExitSignSeller, int which) {
                dialogExitSignSeller.dismiss();
            }
        });

        dialogSignInSeller.setPositiveButton("Войти", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (TextUtils.isEmpty(emailField.getText().toString())){
                    Snackbar.make(root, "Почта не введена", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(passField.getText().toString())){
                    Snackbar.make(root, "Пароль не введён", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                auth.signInWithEmailAndPassword(emailField.getText().toString(), passField.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                startActivity(new Intent(MainActivity.this, ProfileSeller.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Snackbar.make(root, "Ошибка авторизации" + e.getMessage(), Snackbar.LENGTH_SHORT).show();
                    }
                });
            }
        });
        dialogSignInSeller.show();
    }

    private void showRegisterUsers() {
        AlertDialog.Builder dialogRegWindow = new AlertDialog.Builder(this);
        dialogRegWindow.setTitle("Зарегистрироваться как.......");
        dialogRegWindow.setMessage("Выберите тип пользователя");

        LayoutInflater inflaterRegWind = LayoutInflater.from(this);
        View register_window = inflaterRegWind.inflate(R.layout.regist_window, null);
        dialogRegWindow.setView(register_window);

        Button btnRegBuyer = register_window.findViewById(R.id.btnRegBuyer);
        Button btnRegSeller = register_window.findViewById(R.id.btnRegSeller);

        btnRegBuyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistrationBuyer();
            }
        });

        btnRegSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegistrationSeller();
            }
        });
        dialogRegWindow.show();
    }

    private void RegistrationBuyer() {
        AlertDialog.Builder dialogRegBuyer = new AlertDialog.Builder(this);
        dialogRegBuyer.setTitle("Регистрация");
        dialogRegBuyer.setMessage("Заполните данные");

        LayoutInflater inflaterRegBuyer = LayoutInflater.from(this);
        View register_buyer = inflaterRegBuyer.inflate(R.layout.regist_buyer, null);
        dialogRegBuyer.setView(register_buyer);

        final MaterialEditText email_Buyer = register_buyer.findViewById(R.id.emailBuyer);
        final MaterialEditText pass_Buyer = register_buyer.findViewById(R.id.passwordBuyer);
        final MaterialEditText surname_Buyer = register_buyer.findViewById(R.id.surnameBuyer);
        final MaterialEditText name_Buyer = register_buyer.findViewById(R.id.nameBuyer);
        final MaterialEditText patron_Buyer = register_buyer.findViewById(R.id.patronBuyer);
        final MaterialEditText number_Phone_Buyer = register_buyer.findViewById(R.id.numberPhoneBuyer);
        final MaterialEditText debCard_Buyer = register_buyer.findViewById(R.id.debCardBuyer);

        dialogRegBuyer.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogCanceledRegBuyer, int which) {
                dialogCanceledRegBuyer.dismiss();
            }
        });

        dialogRegBuyer.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (TextUtils.isEmpty(email_Buyer.getText().toString())){
                    Snackbar.make(root, "Введите вашу почту", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (pass_Buyer.getText().toString().length() < 5){
                    Snackbar.make(root, "Введите пароль который больше 5 символов",
                            Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(surname_Buyer.getText().toString())){
                    Snackbar.make(root, "Введите вашу фамилию", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(name_Buyer.getText().toString())){
                    Snackbar.make(root, "Введите ваше имя", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(patron_Buyer.getText().toString())){
                    Snackbar.make(root, "Введите ваше отчество", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(number_Phone_Buyer.getText().toString())){
                    Snackbar.make(root, "Ввведите ваш номер телефона", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(debCard_Buyer.getText().toString())){
                    Snackbar.make(root, "Введите номер карты", Snackbar.LENGTH_SHORT).show();
                    return;
                }else if(debCard_Buyer.getText().toString().length() > 16){
                    Snackbar.make(root, "Номер карты больше 16 символов", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                //Регистрация пользователя
                auth.createUserWithEmailAndPassword(email_Buyer.getText().toString(), pass_Buyer.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Buyer buyer = new Buyer();
                                buyer.setEmailBuyer(email_Buyer.getText().toString());
                                buyer.setPasswordBuyer(pass_Buyer.getText().toString());
                                buyer.setSurnameBuyer(surname_Buyer.getText().toString());
                                buyer.setNameBuyer(name_Buyer.getText().toString());
                                buyer.setPatronBuyer(patron_Buyer.getText().toString());
                                buyer.setNumberPhoneBuyer(number_Phone_Buyer.getText().toString());
                                buyer.setDebCardBuyer(debCard_Buyer.getText().toString());

                                buyers.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(buyer)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Snackbar.make(root, "Пользователь добавлен",
                                                        Snackbar.LENGTH_SHORT).show();
                                            }
                                        });
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Snackbar.make(root, "Ошибка регистрации" + e.getMessage(),
                                Snackbar.LENGTH_SHORT).show();
                    }
                });
            }
        });
        dialogRegBuyer.show();
    }

    private void RegistrationSeller() {
        AlertDialog.Builder dialogRegSeller = new AlertDialog.Builder(this);
        dialogRegSeller.setTitle("Регистрация");
        dialogRegSeller.setMessage("Заполните данные");

        LayoutInflater inflaterRegSeller = LayoutInflater.from(this);
        View register_seller = inflaterRegSeller.inflate(R.layout.regist_seller, null);
        dialogRegSeller.setView(register_seller);

        final MaterialEditText sellerEmail = register_seller.findViewById(R.id.emailSeller);
        final MaterialEditText sellerPassword = register_seller.findViewById(R.id.passwordSeller);
        final MaterialEditText sellerSurname = register_seller.findViewById(R.id.surnameSeller);
        final MaterialEditText sellerName = register_seller.findViewById(R.id.nameSeller);
        final MaterialEditText sellerPatron = register_seller.findViewById(R.id.patronSeller);
        final MaterialEditText sellerNumberPhone = register_seller.findViewById(R.id.numberPhoneSeller);
        final MaterialEditText sellerPayPal = register_seller.findViewById(R.id.PayPalBuyer);

        dialogRegSeller.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogCanceledRegSeller, int which) {
                dialogCanceledRegSeller.dismiss();
            }
        });

        dialogRegSeller.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (TextUtils.isEmpty(sellerEmail.getText().toString())){
                    Snackbar.make(root, "Почта не введена", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (sellerPassword.getText().toString().length() < 5){
                    Snackbar.make(root, "Пароль должен содержать более 5 символов",
                            Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(sellerSurname.getText().toString())){
                    Snackbar.make(root, "Введите свою фамилию", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(sellerName.getText().toString())){
                    Snackbar.make(root, "Введите своё имя", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(sellerPatron.getText().toString())){
                    Snackbar.make(root, "Введите своё отчество", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(sellerNumberPhone.getText().toString())){
                    Snackbar.make(root, "Введите ваш номер телефона",
                            Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(sellerPayPal.getText().toString())){
                    Snackbar.make(root, "Введите ваш электронный адрес PayPal",
                            Snackbar.LENGTH_SHORT).show();
                    return;
                }
                //Регистрация продавца
                auth.createUserWithEmailAndPassword(sellerEmail.getText().toString(), sellerPassword.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Seller seller = new Seller();
                                seller.setSellerEmail(sellerEmail.getText().toString());
                                seller.setSellerPass(sellerPassword.getText().toString());
                                seller.setSellerSurname(sellerSurname.getText().toString());
                                seller.setSellerName(sellerName.getText().toString());
                                seller.setSellerPatron(sellerPatron.getText().toString());
                                seller.setSellerNumberPhone(sellerNumberPhone.getText().toString());
                                seller.setSellerPayPal(sellerPayPal.getText().toString());

                                sellers.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(seller)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Snackbar.make(root, "Пользователь добавлен",
                                                        Snackbar.LENGTH_SHORT).show();
                                            }
                                        });
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Snackbar.make(root, "Ошибка регистрации" + e.getMessage(),
                                Snackbar.LENGTH_SHORT).show();
                    }
                });
            }
        });
        dialogRegSeller.show();
    }


}