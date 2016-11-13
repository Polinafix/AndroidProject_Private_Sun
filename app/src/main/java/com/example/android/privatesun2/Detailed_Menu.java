package com.example.android.privatesun2;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;


public class Detailed_Menu extends NavigationDrawerActivity {
    private static final String TAG = "RatingsActivity";

    private List<ItemInMenu> mProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed__menu);
    }

    //  int n = getIntent().getExtras().getInt(MainActivity.SOME_KEY);


    @Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
        int n = getIntent().getIntExtra(MainActivity.SOME_KEY, -1);

        if (n == 1) {
            mProductList = ShoppingCartHelper.getCatalog(getResources());

        }

        if (n == 2) {
            mProductList = ShoppingCartHelper.getCatalog1(getResources());

        }


        GridView gridView = (GridView) findViewById(R.id.gridview);
        ItemsAdapter itemsAdapter = new ItemsAdapter(mProductList, getLayoutInflater(), false);
        gridView.setAdapter(itemsAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                Intent productLargerPicture = new Intent(Detailed_Menu.this, Larger_Picture.class);
                productLargerPicture.putExtra(ShoppingCartHelper.PRODUCT_INDEX, position);
                startActivity(productLargerPicture);
            }
        });
    }

    @Override
    public void finish() {
        Log.d(TAG, "finish()");
        int n = getIntent().getIntExtra(MainActivity.SOME_KEY, -1);


        /*Intent ratingResult = new Intent();
        RatingBar ratingBar = (RatingBar) findViewById(R.id.rating);
        ratingResult.putExtra("WineRating", ratingBar.getRating());
        setResult(RESULT_OK, ratingResult);*/
        super.finish();
    }

}


