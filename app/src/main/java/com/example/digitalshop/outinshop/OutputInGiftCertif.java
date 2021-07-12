package com.example.digitalshop.outinshop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalshop.Constant;
import com.example.digitalshop.R;

public class OutputInGiftCertif extends AppCompatActivity {

    private TextView tvNameGiftCert, tvCostGiftCert;
    private TextView tvQuanityGiftCert, tvDescrGiftDescr;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outputingiftcertshop);
        init();
        getIntentMain();
    }

    private void init(){
        tvNameGiftCert = findViewById(R.id.tvNameGiftCert);
        tvCostGiftCert = findViewById(R.id.tvCostGiftCert);
        tvQuanityGiftCert = findViewById(R.id.tvQuanityGiftCert);
        tvDescrGiftDescr = findViewById(R.id.tvDescrGiftDescr);
    }

    private void getIntentMain(){
        Intent i = getIntent();
        if (i != null){
            tvNameGiftCert.setText(i.getStringExtra(Constant.GIFT_CERTIFICATE_NAME));
            tvCostGiftCert.setText(i.getStringExtra(Constant.GIFT_CERTIFICATE_COST));
            tvQuanityGiftCert.setText(i.getStringExtra(Constant.GIFT_CERTIFICATE_QUANITY));
            tvDescrGiftDescr.setText(i.getStringExtra(Constant.GIFT_CERTIFICATE_DESCRIPTION));
        }
    }

}
