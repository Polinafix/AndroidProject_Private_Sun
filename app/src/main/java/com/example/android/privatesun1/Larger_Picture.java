package com.example.android.privatesun1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.List;

public class Larger_Picture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_larger__picture);

        List<ItemInMenu> catalog = ShoppingCartHelper.getCatalog(getResources());
        final List<ItemInMenu> cart = ShoppingCartHelper.getCart();

        int productIndex = getIntent().getExtras().getInt(ShoppingCartHelper.PRODUCT_INDEX);
        final ItemInMenu selectedItem = catalog.get(productIndex);

        // Set the proper image and text
        TextView name = (TextView) findViewById(R.id.itemname);
        name.setText(selectedItem.getName());
        TextView description = (TextView) findViewById(R.id.description);
        description.setText(selectedItem.getLongDescription());
        TextView price = (TextView) findViewById(R.id.price);
        price.setText("$"+selectedItem.getPrice());
        ImageView icon = (ImageView) findViewById(R.id.image);
        icon.setImageResource(selectedItem.getImageResource());


      /*  Intent intent = getIntent();
        if (intent != null) {
            TextView name = (TextView) findViewById(R.id.itemname);
            TextView description = (TextView) findViewById(R.id.description);
            TextView price = (TextView) findViewById(R.id.price);
            ImageView icon = (ImageView) findViewById(R.id.image);

            int intName = intent.getIntExtra("ItemName", 0);
            name.setText(intName);

            int intDescription = intent.getIntExtra("ItemDescription", 0);
            description.setText(intDescription);

            int intIcon = intent.getIntExtra("ItemIcon", 0);
            icon.setImageResource(intIcon);

            int intPrice = intent.getIntExtra("ItemPrice", 0);
            price.setText(intPrice);

        }*/



        Button addToCartButton = (Button) findViewById(R.id.addtocart);
        addToCartButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                cart.add(selectedItem);//adding to the list
                finish();
            }
        });

        if(cart.contains(selectedItem)) {
            addToCartButton.setEnabled(false);
            addToCartButton.setText("Item already in Cart");
        }

        Button viewShoppingCart = (Button) findViewById(R.id.ButtonViewCart);
        viewShoppingCart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent viewShoppingCartIntent = new Intent(getBaseContext(), ShoppingCart.class);
                startActivity(viewShoppingCartIntent);
            }
        });

        // Disable the add to cart button if the item is already in the cart



    }


}




