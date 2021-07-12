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
import com.example.digitalshop.outinshop.OutputInGiftCertif;
import com.example.digitalshop.products.GiftCertificate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class giftcertif extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> stringList;
    private List<GiftCertificate> giftCertificateList;

    DatabaseReference Gift_Certificate;
    String GIFT_CERTIFICATE_KEY = "Gift_Certificate";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giftcertif_activity);
        init();
        getFromBD();
        setOnClickItem();
    }

    private void init(){
        listView = findViewById(R.id.listgiftcert);
        stringList = new ArrayList<>();
        giftCertificateList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringList);
        listView.setAdapter(adapter);
        Gift_Certificate = FirebaseDatabase.getInstance().getReference(GIFT_CERTIFICATE_KEY);
    }

    private void getFromBD(){
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (stringList.size() > 0) stringList.clear();
                if (giftCertificateList.size() > 0) giftCertificateList.clear();
                for (DataSnapshot ds : snapshot.getChildren()){
                    GiftCertificate giftCertificate = ds.getValue(GiftCertificate.class);
                    assert giftCertificate != null;
                    stringList.add(giftCertificate.nameGiftSertif);
                    giftCertificateList.add(giftCertificate);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        Gift_Certificate.addValueEventListener(eventListener);
    }

    private void setOnClickItem(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GiftCertificate giftCertificate = giftCertificateList.get(position);
                Intent i = new Intent(giftcertif.this, OutputInGiftCertif.class);
                i.putExtra(Constant.GIFT_CERTIFICATE_NAME, giftCertificate.nameGiftSertif);
                i.putExtra(Constant.GIFT_CERTIFICATE_COST, giftCertificate.costGiftSertif);
                i.putExtra(Constant.GIFT_CERTIFICATE_QUANITY, giftCertificate.quantityGiftSertif);
                i.putExtra(Constant.GIFT_CERTIFICATE_DESCRIPTION, giftCertificate.descriptionGiftSertif);
                startActivity(i);
            }
        });
    }
}
