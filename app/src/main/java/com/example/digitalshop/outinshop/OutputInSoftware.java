package com.example.digitalshop.outinshop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalshop.Constant;
import com.example.digitalshop.R;

public class OutputInSoftware extends AppCompatActivity {

    private TextView tvNameSoftware, tvCostSoftware, tvQuanitySoftware, tvDescrSoftware;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outputinsoftwareshop);
        init();
        getIntentMain();
    }

    private void init(){
        tvNameSoftware = findViewById(R.id.tvNameSoftware);
        tvCostSoftware = findViewById(R.id.tvCostSoftware);
        tvQuanitySoftware = findViewById(R.id.tvQuantitySoftware);
        tvDescrSoftware = findViewById(R.id.tvDescrSoftware);
    }

    private void getIntentMain(){
        Intent i = getIntent();
        if (i != null){
            tvNameSoftware.setText(i.getStringExtra(Constant.SOFTWARE_NAME));
            tvCostSoftware.setText(i.getStringExtra(Constant.SOFTWARE_COST));
            tvQuanitySoftware.setText(i.getStringExtra(Constant.SOFTWARE_QUANITY));
            tvDescrSoftware.setText(i.getStringExtra(Constant.SOFTWARE_DESCRIPTION));
        }
    }
}
