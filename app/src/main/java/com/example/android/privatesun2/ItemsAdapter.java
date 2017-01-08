package com.example.android.privatesun2;

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
    private boolean mshowSize;

    public ItemsAdapter(List<ItemInMenu> list, LayoutInflater inflater, boolean showCheckbox, boolean showSize) {
        mProductList = list;
        layoutInflater = inflater;
        mShowCheckbox = showCheckbox;
        mshowSize = showSize;
    }


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
            holder.size = (TextView) row.findViewById(R.id.item_size);
            holder.productCheckbox = (CheckBox) row.findViewById(R.id.CheckBoxSelected);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }


        ItemInMenu itemInMenu = mProductList.get(position);

        holder.name.setText(itemInMenu.getName());
        holder.price.setText("" + itemInMenu.getPrice());
        holder.icon.setImageResource(itemInMenu.getImageResource());
        holder.size.setText(itemInMenu.getSize());

        //specifying the params of each item in the gridview
        holder.icon.setLayoutParams(new LinearLayout.LayoutParams(250, 350));
        holder.icon.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.icon.setPadding(8, 8, 8, 8);

        //only show checkbox in the shopping cart
        if (!mShowCheckbox) {
            holder.productCheckbox.setVisibility(View.GONE);
        } else {
            if (itemInMenu.selected == true)
                holder.productCheckbox.setChecked(true);
            else
                holder.productCheckbox.setChecked(false);
        }
        if (!mshowSize) {
            holder.size.setVisibility(View.GONE);
        }

        return row;

    }

    static class ViewHolder {
        TextView name;
        TextView price;
        ImageView icon;
        TextView size;
        CheckBox productCheckbox;
    }


}