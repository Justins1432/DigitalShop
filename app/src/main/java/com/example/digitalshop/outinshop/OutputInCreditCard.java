package com.example.digitalshop.outinshop;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalshop.Constant;
import com.example.digitalshop.R;

public class OutputInCreditCard extends AppCompatActivity {

    private TextView tvNameCreditCard, tvCostCreditCard;
    private TextView tvQuanityCreditCard, tvDescriptionCreditCard;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outputinshopcreditcard);

        init();
        getIntentMain();
    }

    private void init(){
        tvNameCreditCard = findViewById(R.id.tvNameCreditCard);
        tvCostCreditCard = findViewById(R.id.tvCostCreditCard);
        tvQuanityCreditCard = findViewById(R.id.tvQuantityCreditCard);
        tvDescriptionCreditCard = findViewById(R.id.tvDescrCredCard);
    }

    private void getIntentMain(){
        Intent i = getIntent();
        if (i != null){
            tvNameCreditCard.setText(i.getStringExtra(Constant.CREDIT_CARD_NAME));
            tvCostCreditCard.setText(i.getStringExtra(Constant.CREDIT_CARD_COST));
            tvQuanityCreditCard.setText(i.getStringExtra(Constant.CREDIT_CARD_QUANITY));
            tvDescriptionCreditCard.setText(i.getStringExtra(Constant.CREDIT_CARD_DESCRIPTION));
        }

    }
}
