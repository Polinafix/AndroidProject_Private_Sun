package com.example.android.privatesun2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class FavouritesList extends AppCompatActivity {

    private List<ItemInMenu> sFavouritesList;
    private ItemsAdapter itemsAdapter;
    private List<Integer> newList;
    ItemInMenu selectedItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites_list);

        sFavouritesList = ShoppingCartHelper.getFavourites();
        newList = ShoppingCartHelper.getNewList();

        //clear the existing selections if any
        for (int i = 0; i < sFavouritesList.size(); i++) {
            sFavouritesList.get(i).selected = false;


            //create the list
            final ListView favsList = (ListView) findViewById(R.id.favouritesList);
            itemsAdapter = new ItemsAdapter(sFavouritesList, getLayoutInflater(), true, false);
            favsList.setAdapter(itemsAdapter);


            favsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position,
                                        long id) {

                    selectedItem = sFavouritesList.get(position);
                    if (selectedItem.selected == true) {
                        selectedItem.selected = false;

                    } else
                        selectedItem.selected = true;

                    itemsAdapter.notifyDataSetInvalidated();

                }
            });

            Button removeButton = (Button) findViewById(R.id.ButtonRemoveFromFavs);
            removeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    for (int i = sFavouritesList.size() - 1; i >= 0; i--) {

                        if (sFavouritesList.get(i).selected) {
                            sFavouritesList.remove(i);
                        }
                    }
                    itemsAdapter.notifyDataSetChanged();
                }
            });
            //incomplete feature for sharing the favorites list
            Button addToCartButton = (Button) findViewById(R.id.ButtonShare);
            addToCartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);

                    for (int i = sFavouritesList.size() - 1; i >= 0; i--) {

                        if (sFavouritesList.get(i).selected) {
                            selectedItem = sFavouritesList.get(i);
                            newList.add(selectedItem.getImageResource());

                        }
                    }

                    sharingIntent.setType("text/plain");
                    String shareBody = "My Favorites from the Private Sun Boutique:" + "\n" + newList;
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                    startActivity(Intent.createChooser(sharingIntent, "Share via"));

                }
            });


        }
    }
}
