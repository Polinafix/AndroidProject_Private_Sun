package com.example.android.privatesun2;

/**
 * Created by polinafiksson on 04/11/16.
 */
public class ItemInMenu {
    private int name;
    private int price;
    private int imageResource;
    private int longDescription;
    private String size;
    public boolean selected;


    public ItemInMenu(int name, int price, int imageResource, int longDescription, String size) {
        this.name = name;
        this.price = price;
        this.imageResource = imageResource;
        this.longDescription = longDescription;
        this.size = size;
    }

    public int getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getImageResource() {
        return imageResource;
    }

    public int getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(int longDescription) {
        this.longDescription = longDescription;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected() {
        this.selected = selected;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


}