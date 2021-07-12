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
import com.example.digitalshop.outinshop.OutputInAccRes;
import com.example.digitalshop.products.AccessResources;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class accessres extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> stringList;
    private List<AccessResources> accessResourcesList;

    DatabaseReference Access_Resources;
    String ACCESS_RESOURCES_KEY = "Access_Resources";

    @Override
    protected void onCreate(Bundle savedInstanceSaved){
        super.onCreate(savedInstanceSaved);
        setContentView(R.layout.accessres_activity);
        init();
        getDataFromBD();
        setOnClickItem();
    }

    private void init(){
        listView = findViewById(R.id.listaccres);
        stringList = new ArrayList<>();
        accessResourcesList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringList);
        listView.setAdapter(adapter);
        Access_Resources = FirebaseDatabase.getInstance().getReference(ACCESS_RESOURCES_KEY);
    }

    private void getDataFromBD(){
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (stringList.size() > 0) stringList.clear();
                if (accessResourcesList.size() > 0) accessResourcesList.clear();
                for (DataSnapshot ds : snapshot.getChildren()){
                    AccessResources accessResources = ds.getValue(AccessResources.class);
                    assert accessResources != null;
                    stringList.add(accessResources.nameAccessRes);
                    accessResourcesList.add(accessResources);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        Access_Resources.addValueEventListener(eventListener);
    }

    private void setOnClickItem(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AccessResources accessResources = accessResourcesList.get(position);
                Intent i = new Intent(accessres.this, OutputInAccRes.class);
                i.putExtra(Constant.ACCESS_RESOURCES_NAME, accessResources.nameAccessRes);
                i.putExtra(Constant.ACCESS_RESOURCES_COST, accessResources.costAccessRes);
                i.putExtra(Constant.ACCESS_RESOURCES_QUANITY, accessResources.quantityAccessRes);
                i.putExtra(Constant.ACCESS_RESOURCES_DESCRIPTION, accessResources.descriptionAccessRes);
                startActivity(i);
            }
        });
    }
}
