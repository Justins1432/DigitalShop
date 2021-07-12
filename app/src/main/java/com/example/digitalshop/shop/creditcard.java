package com.example.digitalshop.shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalshop.Constant;
import com.example.digitalshop.R;
import com.example.digitalshop.outinshop.OutputInCreditCard;
import com.example.digitalshop.products.CreditCard;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class creditcard extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> stringList;
    private List<CreditCard> creditCardList;

    DatabaseReference Credit_Card;
    String CREDIT_CARD_KEY = "Credit_Card";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creditcard_activity);
        init();
        getDataFromBD();
        setOnClickItem();
    }

    private void init(){
        listView = findViewById(R.id.listcreditcard);
        stringList = new ArrayList<>();
        creditCardList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringList);
        listView.setAdapter(adapter);
        Credit_Card = FirebaseDatabase.getInstance().getReference(CREDIT_CARD_KEY);
    }

    private void getDataFromBD(){
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (stringList.size() > 0) stringList.clear();
                if (creditCardList.size() > 0) creditCardList.clear();
                for (DataSnapshot ds : snapshot.getChildren()){
                    CreditCard creditCard = ds.getValue(CreditCard.class);
                    assert creditCard != null;
                    stringList.add(creditCard.nameCreditCard);
                    creditCardList.add(creditCard);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        Credit_Card.addValueEventListener(eventListener);
    }

    private void setOnClickItem(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CreditCard creditCard = creditCardList.get(position);
                Intent i = new Intent(creditcard.this, OutputInCreditCard.class);
                i.putExtra(Constant.CREDIT_CARD_NAME, creditCard.nameCreditCard);
                i.putExtra(Constant.CREDIT_CARD_COST, creditCard.costCreditCard);
                i.putExtra(Constant.CREDIT_CARD_QUANITY, creditCard.quantityCreditCard);
                i.putExtra(Constant.CREDIT_CARD_DESCRIPTION, creditCard.descriptionCreditCard);
                startActivity(i);
            }
        });
    }
}
