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
import com.example.digitalshop.outinshop.OutputInMobConnect;
import com.example.digitalshop.products.MobileConnection;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class mobconnect extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> stringList;
    private List<MobileConnection> mobileConnectionList;

    DatabaseReference Mobile_Connection;
    String MOBILE_CONNECTION_KEY = "Mobile_Connection";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobconnect_activity);
        init();
        getDataFromBD();
        setOnClickItem();
    }

    private void init(){
        listView = findViewById(R.id.listmobcon);
        stringList = new ArrayList<>();
        mobileConnectionList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringList);
        listView.setAdapter(adapter);
        Mobile_Connection = FirebaseDatabase.getInstance().getReference(MOBILE_CONNECTION_KEY);
    }

    private void getDataFromBD(){
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (stringList.size() > 0) stringList.clear();
                if (mobileConnectionList.size() > 0) mobileConnectionList.clear();
                for (DataSnapshot ds : snapshot.getChildren()){
                    MobileConnection mobileConnection = ds.getValue(MobileConnection.class);
                    assert mobileConnection != null;
                    stringList.add(mobileConnection.nameMobConnect);
                    mobileConnectionList.add(mobileConnection);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        Mobile_Connection.addValueEventListener(eventListener);
    }

    private void setOnClickItem(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MobileConnection mobileConnection = mobileConnectionList.get(position);
                Intent i = new Intent(mobconnect.this, OutputInMobConnect.class);
                i.putExtra(Constant.MOBILE_CONNECT_NAME, mobileConnection.nameMobConnect);
                i.putExtra(Constant.MOBILE_CONNECT_COST, mobileConnection.costMobConnect);
                i.putExtra(Constant.MOBILE_CONNECT_QUANITY, mobileConnection.quantityMobConnect);
                i.putExtra(Constant.MOBILE_CONNECT_DESCRIPTION, mobileConnection.descriptionMobConnect);
                startActivity(i);
            }
        });
    }
}
