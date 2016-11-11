package com.example.android.privatesun1;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by polinafiksson on 07/11/16.
 */
public class ItemsAdapter extends BaseAdapter {

    private List<ItemInMenu> mProductList;
    private LayoutInflater layoutInflater;
    private boolean mShowCheckbox;

    public ItemsAdapter(List<ItemInMenu> list, LayoutInflater inflater, boolean showCheckbox) {
        mProductList = list;
        layoutInflater = inflater;
        mShowCheckbox = showCheckbox;
    }


   /* private LayoutInflater layoutInflater;

    private final Context mContext;
    private final ItemInMenu[] items;*/

    // constructor to instantiate an ItemsAdapter.
   /* public ItemsAdapter(Context mContext, ItemInMenu[] items) {
        super();
        this.mContext = mContext;
        this.items = items;
    }*/

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // return the number of cells to render.
    /*@Override
    public int getCount() {
        return items.length;
    }

    @Override
    public long getItemId(int i) {
        return 0;}

    @Override
    public Object getItem(int i) {
        return i;
    }*/



    /*@Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        ViewHolder holder;

        if (row == null) {
            layoutInflater = ((Activity) mContext).getLayoutInflater();
            //LayoutInflater.from(mContext);
            row = layoutInflater.inflate(R.layout.linearlayout_item,null);
            holder = new ViewHolder();

            holder.icon = (ImageView) row.findViewById(R.id.imageview_cover_art);
            holder.name = (TextView) row.findViewById(R.id.textview_item_name);
            holder.price = (TextView) row.findViewById(R.id.textview_item_price);
            row.setTag(holder);
        }else {
            holder = (ViewHolder) row.getTag();
        }

        ItemInMenu itemInMenu = items[position];

        holder.name.setText(itemInMenu.getName());
        holder.price.setText(itemInMenu.getPrice());
        holder.icon.setImageResource(itemInMenu.getImageResource());


        holder.icon.setLayoutParams(new LinearLayout.LayoutParams(250, 350));
        holder.icon.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.icon.setPadding(8, 8, 8, 8);


        holder.icon.setImageResource(itemInMenu.getImageResource());
        holder.name.setText(mContext.getString(itemInMenu.getName()));
        holder.price.setText(mContext.getString(itemInMenu.getPrice()));
        return row;


    }

    static class ViewHolder {
        TextView name;
        TextView price;
        ImageView icon;
    }*/
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        ViewHolder holder;

        if (row == null) {


            row = layoutInflater.inflate(R.layout.linearlayout_item,
                    null);

            holder = new ViewHolder();

            holder.icon = (ImageView) row.findViewById(R.id.imageview_cover_art);
            holder.name = (TextView) row.findViewById(R.id.textview_item_name);
            holder.price = (TextView) row.findViewById(R.id.textview_item_price);
            holder.productCheckbox = (CheckBox) row.findViewById(R.id.CheckBoxSelected);
            row.setTag(holder);
        }else {
            holder = (ViewHolder) row.getTag();
        }

           // item = new ViewItem();

        ItemInMenu itemInMenu = mProductList.get(position);

        holder.name.setText(itemInMenu.getName());
        holder.price.setText("$" + itemInMenu.getPrice());
        holder.icon.setImageResource(itemInMenu.getImageResource());


        holder.icon.setLayoutParams(new LinearLayout.LayoutParams(250, 350));
        holder.icon.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.icon.setPadding(8, 8, 8, 8);




        if(!mShowCheckbox) {
            holder.productCheckbox.setVisibility(View.GONE);
        } else {
            if(itemInMenu.selected == true)
                holder.productCheckbox.setChecked(true);
            else
                holder.productCheckbox.setChecked(false);
        }

        return row;

    }

    static class ViewHolder {
        TextView name;
        TextView price;
        ImageView icon;
        CheckBox productCheckbox;
    }



}