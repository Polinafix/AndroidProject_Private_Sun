package com.example.android.privatesun1;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.List;


public class Detailed_Menu extends AppCompatActivity {

    private List<ItemInMenu> mProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed__menu);

        mProductList = ShoppingCartHelper.getCatalog(getResources());

        GridView gridView = (GridView)findViewById(R.id.gridview);
        ItemsAdapter itemsAdapter = new ItemsAdapter(mProductList,getLayoutInflater(), false);
        gridView.setAdapter(itemsAdapter);

        //ItemsAdapter itemsAdapter = new ItemsAdapter(this, items);
       // gridView.setAdapter(itemsAdapter);



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {


                //ItemInMenu selectedItem = items[position];

               /* //Create intent
                Intent intent = new Intent(Detailed_Menu.this, Larger_Picture.class);
                intent.putExtra("ItemName", selectedItem.getName());
                intent.putExtra("ItemDescription", selectedItem.getLongDescription());
                intent.putExtra("ItemIcon", selectedItem.getImageResource());
                intent.putExtra("ItemPrice", selectedItem.getPrice());
                //Start details activity
                startActivity(intent);*/

                Intent productLargerPicture = new Intent(getBaseContext(),Larger_Picture.class);
                productLargerPicture.putExtra(ShoppingCartHelper.PRODUCT_INDEX, position);
                startActivity(productLargerPicture);
            }
        });
    }


  /*  public ItemInMenu[] items = {
            new ItemInMenu(R.string.Tokyo_Coat, R.string.Price_110, R.drawable.out2, R.string.Tokyo_Coat_About),
            new ItemInMenu(R.string.New_York_Coat, R.string.Price_120, R.drawable.out1, R.string.New_York_Coat_About),
            new ItemInMenu(R.string.Tom_Boy_01_41, R.string.Price_150, R.drawable.out4, R.string.Tom_Boy_01_41_About),
            new ItemInMenu(R.string.Tom_Boy_01_42, R.string.Price_130, R.drawable.out3, R.string.Tom_Boy_01_42_About),
            new ItemInMenu(R.string.Black_Jeans_Coat, R.string.Price_120, R.drawable.out6, R.string.Black_Jeans_Coat_About),
            new ItemInMenu(R.string.Khaki_Jeans_Coat, R.string.Price_120, R.drawable.out5, R.string.Khaki_Jeans_Coat_About)

    };*/


}
