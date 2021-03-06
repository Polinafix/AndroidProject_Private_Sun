package com.example.android.privatesun2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ShoppingCart extends AppCompatActivity {

    private List<ItemInMenu> sCartList;
    private ItemsAdapter itemsAdapter;
    double subTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        sCartList = ShoppingCartHelper.getCart();

        // Refresh the data
        if (itemsAdapter != null) {
            itemsAdapter.notifyDataSetChanged();
        }

        for (ItemInMenu p : sCartList) {
            subTotal += p.getPrice();
        }


        TextView productPriceTextView = (TextView) findViewById(R.id.FinalPrice);
        productPriceTextView.setText(String.valueOf(subTotal));


        for (int i = 0; i < sCartList.size(); i++) {
            //clear the selections that already exist
            sCartList.get(i).selected = false;

            //create the list
            final ListView itemCatalog = (ListView) findViewById(R.id.itemCatalog);
            itemsAdapter = new ItemsAdapter(sCartList, getLayoutInflater(), true, true);
            itemCatalog.setAdapter(itemsAdapter);


            itemCatalog.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position,
                                        long id) {


                    ItemInMenu selectedItem = sCartList.get(position);
                    if (selectedItem.selected == true) {
                        selectedItem.selected = false;
                    } else
                        selectedItem.selected = true;

                    itemsAdapter.notifyDataSetInvalidated();

                }
            });

            Button removeButton = (Button) findViewById(R.id.ButtonRemoveFromCart);
            removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Loop through and remove all the products that are selected
                    for (int i = sCartList.size() - 1; i >= 0; i--) {

                        if (sCartList.get(i).selected) {
                            subTotal -= sCartList.get(i).getPrice();
                            sCartList.remove(i);


                        }
                    }
                    TextView productPriceTextView = (TextView) findViewById(R.id.FinalPrice);
                    productPriceTextView.setText(String.valueOf(subTotal));
                    itemsAdapter.notifyDataSetChanged();
                }
            });

            Button proceedButton = (Button) findViewById(R.id.ButtonProceed);
            proceedButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ShoppingCart.this, ProceedOrder.class);
                    TextView total = (TextView) findViewById(R.id.FinalPrice);
                    intent.putExtra("Total", total.getText());
                    startActivity(intent);


                }
            });


        }
    }

}
