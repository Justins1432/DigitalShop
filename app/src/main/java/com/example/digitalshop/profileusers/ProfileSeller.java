package com.example.digitalshop.profileusers;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.digitalshop.R;
import com.example.digitalshop.shop.AddProduct;
import com.example.digitalshop.shop.EditProfileSeller;
import com.example.digitalshop.shop.GoToShop;
import com.example.digitalshop.shop.Message;
import com.example.digitalshop.shop.Settings;
import com.google.android.material.navigation.NavigationView;

public class ProfileSeller extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_seller);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

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
            case R.id.profile_seller:
                Intent intent = new Intent(ProfileSeller.this, EditProfileSeller.class);
                startActivity(intent);
                break;

            case R.id.message:
                Intent intent1 = new Intent(ProfileSeller.this, Message.class);
                startActivity(intent1);
                break;

            case R.id.AddProduct:
                Intent intent2 = new Intent(ProfileSeller.this, AddProduct.class);
                startActivity(intent2);
                break;

            case R.id.gotoshop:
                Intent intent3 = new Intent(ProfileSeller.this, GoToShop.class);
                startActivity(intent3);
                break;

            case R.id.settings:
                Intent intent4 = new Intent(ProfileSeller.this, Settings.class);
                startActivity(intent4);
                break;

        }

        return false;
    }
}
