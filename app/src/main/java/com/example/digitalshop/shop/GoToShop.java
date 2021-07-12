package com.example.digitalshop.shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.digitalshop.R;
import com.google.android.material.navigation.NavigationView;

public class GoToShop extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gotoshop_activity);

        drawerLayout = findViewById(R.id.drawer_gotishop);
        navigationView = findViewById(R.id.goToShop);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

    }
    @Override
    public void onBackPressed(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.games:
                Intent intent = new Intent(GoToShop.this, games.class);
                startActivity(intent);
                break;

            case R.id.software:
                Intent intent1 = new Intent(GoToShop.this, software.class);
                startActivity(intent1);
                break;

            case R.id.creditcard:
                Intent intent2 = new Intent(GoToShop.this, creditcard.class);
                startActivity(intent2);
                break;

            case R.id.mobconnect:
                Intent intent3 = new Intent(GoToShop.this, mobconnect.class);
                startActivity(intent3);
                break;

            case R.id.accres:
                Intent intent4 = new Intent(GoToShop.this, accessres.class);
                startActivity(intent4);
                break;

            case R.id.giftcert:
                Intent intent5 = new Intent(GoToShop.this, giftcertif.class);
                startActivity(intent5);
                break;

            case R.id.socnet:
                Intent intent6 = new Intent(GoToShop.this, socnet.class);
                startActivity(intent6);
                break;
        }
        return false;
    }

}
