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
import com.example.digitalshop.outinshop.OutputInSocNet;
import com.example.digitalshop.products.SocialNetwork;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class socnet extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> stringList;
    private List<SocialNetwork> socialNetworkList;

    DatabaseReference Social_Network;
    String SOCIAL_NETWORK_KEY = "Social_Network";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.socnet_activity);
        init();
        getDataFromBD();
        setOnClickItem();
    }

    private void init(){
        listView = findViewById(R.id.listsocnet);
        stringList = new ArrayList<>();
        socialNetworkList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringList);
        listView.setAdapter(adapter);
        Social_Network = FirebaseDatabase.getInstance().getReference(SOCIAL_NETWORK_KEY);
    }

    private void getDataFromBD(){
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (stringList.size() > 0) stringList.clear();
                if (socialNetworkList.size() > 0) socialNetworkList.clear();
                for (DataSnapshot ds : snapshot.getChildren()){
                    SocialNetwork socialNetwork = ds.getValue(SocialNetwork.class);
                    assert socialNetwork != null;
                    stringList.add(socialNetwork.nameSocNet);
                    socialNetworkList.add(socialNetwork);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        Social_Network.addValueEventListener(eventListener);
    }

    private void setOnClickItem(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SocialNetwork socialNetwork = socialNetworkList.get(position);
                Intent i = new Intent(socnet.this, OutputInSocNet.class);
                i.putExtra(Constant.SOCIAL_NETWORK_NAME, socialNetwork.nameSocNet);
                i.putExtra(Constant.SOCIAL_NETWORK_COST, socialNetwork.costSocNet);
                i.putExtra(Constant.SOCIAL_NETWORK_QUANITY, socialNetwork.quantitySocNet);
                i.putExtra(Constant.SOCIAL_NETWORK_DESCRIPTION, socialNetwork.descriptionSocNet);
                startActivity(i);
            }
        });
    }

}
