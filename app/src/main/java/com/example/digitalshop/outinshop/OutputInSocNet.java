package com.example.digitalshop.outinshop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.digitalshop.Constant;
import com.example.digitalshop.R;

public class OutputInSocNet extends AppCompatActivity {

    private TextView tvNameSocNet, tvCostSocNet;
    private TextView tvQuanitySocNet, tvDescrSocNet;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.outputinsocnet);
        init();
        getIntentMain();
    }

    private void init(){
        tvNameSocNet = findViewById(R.id.tvNameSocNet);
        tvCostSocNet = findViewById(R.id.tvCostSocNet);
        tvQuanitySocNet = findViewById(R.id.tvQuanitySocNet);
        tvDescrSocNet = findViewById(R.id.tvDescrSocNet);
    }

    private void getIntentMain(){
        Intent i = getIntent();
        if (i != null){
            tvNameSocNet.setText(i.getStringExtra(Constant.SOCIAL_NETWORK_NAME));
            tvCostSocNet.setText(i.getStringExtra(Constant.SOCIAL_NETWORK_COST));
            tvQuanitySocNet.setText(i.getStringExtra(Constant.SOCIAL_NETWORK_QUANITY));
            tvDescrSocNet.setText(i.getStringExtra(Constant.SOCIAL_NETWORK_DESCRIPTION));
        }
    }
}
