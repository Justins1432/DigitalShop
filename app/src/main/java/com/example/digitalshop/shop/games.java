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
import com.example.digitalshop.outinshop.OutputInGames;
import com.example.digitalshop.products.Games;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class games extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> stringList;
    private List<Games> gamesList;

    DatabaseReference Game;
    String GAME_KEY = "Game";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.games_activity);

        init();
        getDataFromBD();
        setOnClickItem();
    }

    private void init(){
        listView = findViewById(R.id.listgames);
        stringList = new ArrayList<>();
        gamesList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringList);
        listView.setAdapter(adapter);
        Game = FirebaseDatabase.getInstance().getReference(GAME_KEY);
    }

    private void getDataFromBD(){
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (stringList.size() > 0) stringList.clear();
                if (gamesList.size() > 0) gamesList.clear();
                for (DataSnapshot ds : snapshot.getChildren()){
                    Games games = ds.getValue(Games.class);
                    assert games != null;
                    stringList.add(games.nameGame);
                    gamesList.add(games);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        Game.addValueEventListener(eventListener);
    }

    private void setOnClickItem(){
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Games games = gamesList.get(position);
                Intent i = new Intent(games.this, OutputInGames.class);
                i.putExtra(Constant.GAME_NAME, games.nameGame);
                i.putExtra(Constant.GAME_COST, games.costGame);
                i.putExtra(Constant.GAME_QUANITY, games.quantityGame);
                i.putExtra(Constant.GAME_DESCRIPTION, games.descriptionGame);
                startActivity(i);
            }
        });
    }

}
