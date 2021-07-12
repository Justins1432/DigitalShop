package com.example.digitalshop.outinshop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalshop.Constant;
import com.example.digitalshop.R;

public class OutputInAccRes extends AppCompatActivity {

    private TextView tvNameAccRes, tvCostAccRes;
    private TextView tvQuanityAccRes, tvDescrAccRes;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outputinaccres);
        init();
        getIntentMain();
    }

    private void init(){
        tvNameAccRes = findViewById(R.id.tvNameAccRes);
        tvCostAccRes = findViewById(R.id.tvCostAccRes);
        tvQuanityAccRes = findViewById(R.id.tvQuanityAccRes);
        tvDescrAccRes = findViewById(R.id.tvDescrAssRes);
    }

    private void getIntentMain(){
        Intent i = getIntent();
        if (i != null){
            tvNameAccRes.setText(i.getStringExtra(Constant.ACCESS_RESOURCES_NAME));
            tvCostAccRes.setText(i.getStringExtra(Constant.ACCESS_RESOURCES_COST));
            tvQuanityAccRes.setText(i.getStringExtra(Constant.ACCESS_RESOURCES_QUANITY));
            tvDescrAccRes.setText(i.getStringExtra(Constant.ACCESS_RESOURCES_DESCRIPTION));
        }
    }
}
