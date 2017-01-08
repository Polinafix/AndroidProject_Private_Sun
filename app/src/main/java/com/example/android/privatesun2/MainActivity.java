package com.example.android.privatesun2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends NavigationDrawerActivity {

    public static final String SOME_KEY = "some_key";//sending the key to the next Activity to determine the right catalog


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void openGridView1(View view) {

        Intent first = new Intent(this, Detailed_Menu.class);
        first.putExtra(SOME_KEY, 1);
        startActivity(first);
    }

    public void openGridView2(View view) {

        Intent second = new Intent(this, Detailed_Menu.class);
        second.putExtra(SOME_KEY, 2);
        startActivity(second);

    }

    public void openGridView3(View view) {
        Intent third = new Intent(this, Detailed_Menu.class);
        third.putExtra(SOME_KEY, 3);
        startActivity(third);
    }

    public void openGridView4(View view) {
        Intent fourth = new Intent(this, Detailed_Menu.class);
        fourth.putExtra(SOME_KEY, 4);
        startActivity(fourth);

    }


}