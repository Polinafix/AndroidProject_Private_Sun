package com.example.android.privatesun2;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class NavigationDrawerActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_navigation_drawer, null);
        super.setContentView(drawerLayout);
        FrameLayout activityContainer = (FrameLayout) drawerLayout.findViewById(R.id.activity_content);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);
        initNavigationDrawer();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_cart) {
            //Create Intent for Shopping Cart Activity
            Intent productIntent = new Intent(this, ShoppingCart.class);
            startActivity(productIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void initNavigationDrawer() {

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();

                switch (id) {
                    case R.id.categories:
                        Intent intent = new Intent(NavigationDrawerActivity.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), "Shop", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.favs:
                        Toast.makeText(getApplicationContext(), "Favourites", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.scart:
                        Intent productIntent = new Intent(NavigationDrawerActivity.this, ShoppingCart.class);
                        startActivity(productIntent);
                        Toast.makeText(getApplicationContext(), "Shopping Cart", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.about:
                        Toast.makeText(getApplicationContext(), "About Us", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.location:
                        double latitude = 41.939633;
                        double longitude = -87.644580;
                        String label = "Private Sun Boutique";
                        String uriBegin = "geo:" + latitude + "," + longitude;
                        String query = latitude + "," + longitude + "(" + label + ")";
                        String encodedQuery = Uri.encode(query);
                        String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                        Uri uri = Uri.parse(uriString);
                        Intent intent2 = new Intent(android.content.Intent.ACTION_VIEW, uri);
                        startActivity(intent2);
                        drawerLayout.closeDrawers();
                        break;


                }
                return true;
            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }
}


