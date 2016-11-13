package com.example.android.privatesun2;

import android.content.Intent;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Larger_Picture extends NavigationDrawerActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_larger__picture);



        List<ItemInMenu> catalog = ShoppingCartHelper.getCatalog(getResources());
        final List<ItemInMenu> cart = ShoppingCartHelper.getCart();

        int productIndex = getIntent().getExtras().getInt(ShoppingCartHelper.PRODUCT_INDEX);
        final ItemInMenu selectedItem = catalog.get(productIndex);

        TextView name = (TextView) findViewById(R.id.itemname);
        name.setText(selectedItem.getName());
        TextView description = (TextView) findViewById(R.id.description);
        description.setText(selectedItem.getLongDescription());
        TextView price = (TextView) findViewById(R.id.price);
        price.setText("$" + selectedItem.getPrice());
        ImageView icon = (ImageView) findViewById(R.id.image);
        icon.setImageResource(selectedItem.getImageResource());


        Button addToCartButton = (Button) findViewById(R.id.addtocart);
        addToCartButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                cart.add(selectedItem);//adding to the list
                finish();
            }
        });
        // Disable the add to cart button if the item is already in the cart
        if (cart.contains(selectedItem)) {
            addToCartButton.setEnabled(false);
            addToCartButton.setText("Item already in Cart");
        }


    }




}




