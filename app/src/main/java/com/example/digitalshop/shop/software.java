package com.example.digitalshop.shop;

import android.content.Intent;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalshop.Constant;
import com.example.digitalshop.R;
import com.example.digitalshop.outinshop.OutputInSoftware;
import com.example.digitalshop.products.Software;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class software extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> stringList;
    private List<Software> softwareList;

    DatabaseReference Software;
    String SOFTWARE_KEY = "Software";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.software_activity);
        init();
        getDataFromBD();
        setOnClickItem();
    }

    private void init(){
        listView = findViewById(R.id.listsoftware);
        stringList = new ArrayList<>();
        softwareList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringList);
        listView.setAdapter(adapter);
        Software = FirebaseDatabase.getInstance().getReference(SOFTWARE_KEY);
    }

    private void getDataFromBD(){
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (stringList.size() > 0) stringList.clear();
                if (softwareList.size() > 0) softwareList.clear();
                for (DataSnapshot ds : snapshot.getChildren()){
                    com.example.digitalshop.products.Software software = ds.getValue(com.example.digitalshop.products.Software.class);
                    assert software != null;
                    stringList.add(software.nameSoftware);
                    softwareList.add(software);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        Software.addValueEventListener(eventListener);
    }

    private void setOnClickItem(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                com.example.digitalshop.products.Software software = softwareList.get(position);
                Intent i = new Intent(com.example.digitalshop.shop.software.this, OutputInSoftware.class);
                i.putExtra(Constant.SOFTWARE_NAME, software.nameSoftware);
                i.putExtra(Constant.SOFTWARE_COST, software.costSoftware);
                i.putExtra(Constant.SOFTWARE_QUANITY, software.quantitySoftware);
                i.putExtra(Constant.SOFTWARE_DESCRIPTION, software.descriptionSoftware);
                startActivity(i);
            }
        });
    }

}
