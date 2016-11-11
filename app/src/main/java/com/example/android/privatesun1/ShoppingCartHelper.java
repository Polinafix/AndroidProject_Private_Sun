package com.example.android.privatesun1;

import android.content.res.Resources;

import java.util.List;
import java.util.Vector;

/**
 * Created by polinafiksson on 07/11/16.
 */
public class ShoppingCartHelper {//added

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<ItemInMenu> catalog;
    private static List<ItemInMenu> cart;


    public static List<ItemInMenu> getCatalog(Resources res){
        if(catalog == null) {
            catalog = new Vector<ItemInMenu>();
            catalog.add(new ItemInMenu(R.string.Tokyo_Coat, 110, R.drawable.out2, R.string.Tokyo_Coat_About));
            catalog.add(new ItemInMenu(R.string.New_York_Coat, 120, R.drawable.out1, R.string.New_York_Coat_About));
            catalog.add(new ItemInMenu(R.string.Tom_Boy_01_41, 150, R.drawable.out4, R.string.Tom_Boy_01_41_About));
            catalog.add(new ItemInMenu(R.string.Tom_Boy_01_42, 130, R.drawable.out3, R.string.Tom_Boy_01_42_About));
            catalog.add(new ItemInMenu(R.string.Black_Jeans_Coat, 120, R.drawable.out6, R.string.Black_Jeans_Coat_About));
            catalog.add(new ItemInMenu(R.string.Khaki_Jeans_Coat, 120, R.drawable.out5, R.string.Khaki_Jeans_Coat_About));
        }

        return catalog;
    }


    public static List<ItemInMenu> getCart() {
        if(cart == null) {
            cart = new Vector<ItemInMenu>();
        }

        return cart;
    }



}

