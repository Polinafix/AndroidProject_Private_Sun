package com.example.android.privatesun2;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends NavigationDrawerActivity {

    public static final String SOME_KEY = "some_key";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void openGridView1(View view) {

        Intent first = new Intent(this, Detailed_Menu.class);
        first.putExtra(SOME_KEY, 1);
        startActivity(first);
        // Do something in response to button
        /*Intent intent = new Intent(this, Detailed_Menu.class);
        TextView outwear = (TextView) findViewById(R.id.outwear);
        intent.putExtra("Outwear", outwear.getText());
        startActivity(intent);*/
        /*Intent intent = new Intent(this, Detailed_Menu.class);
        startActivity(intent);
*/
    }
    public void openGridView3(View view) {
        Intent third = new Intent(this, Detailed_Menu.class);
        third.putExtra(SOME_KEY, 2);
        startActivity(third);
        // Do something in response to button
        /*Intent intent = new Intent(this, Detailed_Menu.class);
        TextView tops = (TextView) findViewById(R.id.tops);
        intent.putExtra("Tops", tops.getText());*/
        //startActivity(intent);
        /*Intent intent = new Intent(this, Detailed_Menu.class);
        startActivity(intent);
*/
    }


}