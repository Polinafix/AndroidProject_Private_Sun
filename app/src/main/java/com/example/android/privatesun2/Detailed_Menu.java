package com.example.android.privatesun2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;


import java.util.List;


public class Detailed_Menu extends NavigationDrawerActivity {

    public static final String NEW_KEY = "new_key";
    private List<ItemInMenu> productList;
    int n;
    int k;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed__menu);
    }


    @Override
    protected void onStart() {
        super.onStart();
        //choosing the correspondind catalog (depending on which category was previously chosen)
        n = getIntent().getIntExtra(MainActivity.SOME_KEY, -1);

        switch (n) {
            case 1:
                productList = ShoppingCartHelper.getCatalog(getResources());
                k = 1;
                break;
            case 2:
                productList = ShoppingCartHelper.getCatalog3(getResources());
                k = 2;
                break;
            case 3:
                productList = ShoppingCartHelper.getCatalog2(getResources());
                k = 3;
                break;

            case 4:
                productList = ShoppingCartHelper.getCatalog4(getResources());
                k = 4;
                break;

        }


        GridView gridView = (GridView) findViewById(R.id.gridview);
        ItemsAdapter itemsAdapter = new ItemsAdapter(productList, getLayoutInflater(), false, false);
        gridView.setAdapter(itemsAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                Intent productLargerPicture = new Intent(Detailed_Menu.this, Larger_Picture.class);
                productLargerPicture.putExtra(ShoppingCartHelper.PRODUCT_INDEX, position);

                switch (k) {
                    case 3:
                        productLargerPicture.putExtra(NEW_KEY, 3);
                        break;
                    case 1:
                        productLargerPicture.putExtra(NEW_KEY, 1);
                        break;
                    case 2:
                        productLargerPicture.putExtra(NEW_KEY, 2);
                        break;
                    case 4:
                        productLargerPicture.putExtra(NEW_KEY, 4);
                        break;

                }

                startActivity(productLargerPicture);
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
    }

}


