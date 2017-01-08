package com.example.android.privatesun2;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by polinafiksson on 07/11/16.
 */
public class ShoppingCartHelper {

    public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

    private static List<ItemInMenu> OutwearCatalog;
    private static List<ItemInMenu> TopsCatalog;
    private static List<ItemInMenu> DressesCatalog;
    private static List<ItemInMenu> BottomsCatalog;
    private static List<ItemInMenu> cart;
    private static List<ItemInMenu> myFavourites;
    private static List<Integer> myNewList;


    public static List<ItemInMenu> getCatalog(Resources res){
        if(OutwearCatalog == null) {
            OutwearCatalog = new Vector<ItemInMenu>();
            OutwearCatalog.add(new ItemInMenu(R.string.Tokyo_Coat, 110, R.drawable.out2, R.string.Tokyo_Coat_About,"s"));
            OutwearCatalog.add(new ItemInMenu(R.string.New_York_Coat, 120, R.drawable.out1, R.string.New_York_Coat_About,"s"));
            OutwearCatalog.add(new ItemInMenu(R.string.Tom_Boy_01_41, 150, R.drawable.out4, R.string.Tom_Boy_01_41_About,"s"));
            OutwearCatalog.add(new ItemInMenu(R.string.Tom_Boy_01_42, 130, R.drawable.out3, R.string.Tom_Boy_01_42_About,"s"));
            OutwearCatalog.add(new ItemInMenu(R.string.Black_Jeans_Coat, 120, R.drawable.out6, R.string.Black_Jeans_Coat_About,"s"));
           // OutwearCatalog.add(new ItemInMenu(R.string.Khaki_Jeans_Coat, 120, R.drawable.out5, R.string.Khaki_Jeans_Coat_About));
        }

        return OutwearCatalog;
    }

    public static List<ItemInMenu> getCatalog2(Resources res){
        if(TopsCatalog == null) {
            TopsCatalog = new Vector<ItemInMenu>();
            TopsCatalog.add(new ItemInMenu(R.string.Basic_Shirt, 110, R.drawable.top1, R.string.Basic_Shirt_About,"s"));
            TopsCatalog.add(new ItemInMenu(R.string.White_Shirt, 120, R.drawable.top2, R.string.White_Shirt_About,"s"));
            TopsCatalog.add(new ItemInMenu(R.string.Pullover_01, 80, R.drawable.top3, R.string.Pullover_01_About,"s"));
            TopsCatalog.add(new ItemInMenu(R.string.Pullover_04, 85, R.drawable.top4, R.string.Pullover_04_About,"s"));
        }

        return TopsCatalog;
    }

    public static List<ItemInMenu> getCatalog3(Resources res){
        if(DressesCatalog == null) {
            DressesCatalog = new Vector<ItemInMenu>();
            DressesCatalog.add(new ItemInMenu(R.string.Warm_Dress, 80, R.drawable.dress1, R.string.Warm_dress_About,"s"));
            DressesCatalog.add(new ItemInMenu(R.string.Lace_Dress, 70, R.drawable.dress2, R.string.Lace_dress_About,"s"));
        }

        return DressesCatalog;
    }

    public static List<ItemInMenu> getCatalog4(Resources res){
        if(BottomsCatalog == null) {
            BottomsCatalog = new Vector<ItemInMenu>();
            BottomsCatalog.add(new ItemInMenu(R.string.Olive_culottes, 85, R.drawable.bottom1, R.string.Olive_culottes_About,"s"));
            BottomsCatalog.add(new ItemInMenu(R.string.Khaki_Jeans, 80, R.drawable.bottom2, R.string.Khaki_Jeans_About,"s"));
            BottomsCatalog.add(new ItemInMenu(R.string.Tulle_Skirt, 70, R.drawable.bottom3, R.string.Tulle_skirt_About,"s"));
        }

        return BottomsCatalog;
    }


    public static List<ItemInMenu> getCart() {
        if(cart == null) {
            cart = new Vector<ItemInMenu>();
        }

        return cart;
    }

    public static List<ItemInMenu> getFavourites() {
        if(myFavourites == null) {
            myFavourites = new Vector<ItemInMenu>();
        }

        return myFavourites;
    }

    public static List<Integer> getNewList() {
        if(myNewList == null) {
            myNewList = new ArrayList<>();
        }

        return myNewList;
    }






}

