package com.example.digitalshop.outinshop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalshop.Constant;
import com.example.digitalshop.R;

import org.w3c.dom.Text;

public class OutputInMobConnect extends AppCompatActivity {

    private TextView tvNameMobCon, tvCostMobCon;
    private TextView tvQuanityMobCon, tvDescrMobCon;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outputinmobconn);
        init();
        getIntentMain();
    }

    private void init(){
        tvNameMobCon = findViewById(R.id.tvNameMobCon);
        tvCostMobCon = findViewById(R.id.tvCostMobCon);
        tvQuanityMobCon = findViewById(R.id.tvQuanityMobCon);
        tvDescrMobCon = findViewById(R.id.tvDescrMobCon);
    }

    private void getIntentMain(){
        Intent i = getIntent();
        if (i != null){
            tvNameMobCon.setText(i.getStringExtra(Constant.MOBILE_CONNECT_NAME));
            tvCostMobCon.setText(i.getStringExtra(Constant.MOBILE_CONNECT_COST));
            tvQuanityMobCon.setText(i.getStringExtra(Constant.MOBILE_CONNECT_QUANITY));
            tvDescrMobCon.setText(i.getStringExtra(Constant.MOBILE_CONNECT_DESCRIPTION));
        }
    }
}
