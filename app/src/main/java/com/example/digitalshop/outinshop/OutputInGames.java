package com.example.digitalshop.outinshop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalshop.Constant;
import com.example.digitalshop.R;

public class OutputInGames extends AppCompatActivity {

    private TextView tvNameGame, tvCostGame, tvQuantityGame, tvDescrGame;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outputingamesshop);
        init();
        getIntentMain();
    }

    private void init(){
        tvNameGame = findViewById(R.id.tvNameGame);
        tvCostGame = findViewById(R.id.tvCostGame);
        tvQuantityGame = findViewById(R.id.tvQuantityGame);
        tvDescrGame = findViewById(R.id.tvDescriptionGame);
    }

    private void getIntentMain(){
        Intent i = getIntent();
        if (i != null){
            tvNameGame.setText(i.getStringExtra(Constant.GAME_NAME));
            tvCostGame.setText(i.getStringExtra(Constant.GAME_COST));
            tvQuantityGame.setText(i.getStringExtra(Constant.GAME_QUANITY));
            tvDescrGame.setText(i.getStringExtra(Constant.GAME_DESCRIPTION));
        }

    }
}
