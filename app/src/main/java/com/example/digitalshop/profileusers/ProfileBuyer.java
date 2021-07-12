package com.example.digitalshop.profileusers;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.digitalshop.R;
import com.example.digitalshop.shop.BasketBuyer;
import com.example.digitalshop.shop.EditProfileBuyer;
import com.example.digitalshop.shop.GoToShop;
import com.example.digitalshop.shop.Message;
import com.example.digitalshop.shop.Settings;
import com.google.android.material.navigation.NavigationView;

public class ProfileBuyer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
   protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.profile_buyer);

       drawerLayout = findViewById(R.id.root_profile_buyer);
       navigationView = findViewById(R.id.nav_view_buyer);

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
            case R.id.profile_buyer:
                Intent intent = new Intent(ProfileBuyer.this, EditProfileBuyer.class);
                startActivity(intent);
                break;

            case R.id.message_buyer:
                Intent intent1 = new Intent(ProfileBuyer.this, Message.class);
                startActivity(intent1);
                break;

            case R.id.gotoshop_buyer:
                Intent intent2 = new Intent(ProfileBuyer.this, GoToShop.class);
                startActivity(intent2);
                break;

            case R.id.basket_buyer:
                Intent intent3 = new Intent(ProfileBuyer.this, BasketBuyer.class);
                startActivity(intent3);
                break;

            case R.id.settings:
                Intent intent4 = new Intent(ProfileBuyer.this, Settings.class);
                startActivity(intent4);
                break;
        }
        return false;
    }
}
