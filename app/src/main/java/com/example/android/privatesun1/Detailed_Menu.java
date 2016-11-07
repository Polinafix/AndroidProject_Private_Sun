package com.example.android.privatesun1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Detailed_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed__menu);

        GridView gridView = (GridView)findViewById(R.id.gridview);
        ItemsAdapter itemsAdapter = new ItemsAdapter(this, items);
        gridView.setAdapter(itemsAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // ItemInMenu = (ItemInMenu) parent.getItemAtPosition(position);

                ItemInMenu selectedItem = items[position];

                //Create intent
                Intent intent = new Intent(Detailed_Menu.this, Larger_Picture.class);
                intent.putExtra("ItemName", selectedItem.getName());
                intent.putExtra("ItemDescription", selectedItem.getLongDescription());
                //intent.putExtra("ItemIcon", Wine.getIconResource(selectedWine.getType()));
                intent.putExtra("ItemIcon", selectedItem.getImageResource());
                intent.putExtra("ItemPrice", selectedItem.getPrice());
                //Start details activity
                startActivity(intent);
            }
        });
    }

    public static class ItemsAdapter extends BaseAdapter {

        private LayoutInflater layoutInflater;

        private final Context mContext;
        private final ItemInMenu[] items;

        // constructor to instantiate an ItemsAdapter.
        public ItemsAdapter(Context mContext, ItemInMenu[] items) {
            super();
            this.mContext = mContext;
            this.items = items;
        }

        // return the number of cells to render.
        @Override
        public int getCount() {
            return items.length;
        }

        @Override
        public long getItemId(int i) {
            return 0;}

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View row = convertView;
            ViewHolder holder;

           // final ItemInMenu item = items[position];


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
            //holder.icon.setImageDrawable();



            //Wine wine = WINES[position];
           // holder.name.setText(wine.getName());
            //holder.description.setText(wine.getShortDescription());
           // holder.icon.setImageBitmap(icons.get(wine.getType()));
           // holder.rating.setText(wine.getRating() + " stars");
            //return row;


           /* final ImageView imageView = (ImageView)convertView.findViewById(R.id.imageview_cover_art);
            final TextView nameTextView = (TextView)convertView.findViewById(R.id.textview_item_name);
            final TextView priceTextView = (TextView)convertView.findViewById(R.id.textview_item_price);
            final ImageView imageViewFavorite = (ImageView)convertView.findViewById(R.id.imageview_favorite);*/

            holder.icon.setLayoutParams(new LinearLayout.LayoutParams(250, 350));
            holder.icon.setScaleType(ImageView.ScaleType.CENTER_CROP);
            holder.icon.setPadding(8, 8, 8, 8);


            holder.icon.setImageResource(itemInMenu.getImageResource());
            holder.name.setText(mContext.getString(itemInMenu.getName()));
            holder.price.setText(mContext.getString(itemInMenu.getPrice()));
            return row;

            //return convertView;
        }

        static class ViewHolder {
            TextView name;
            TextView price;
            ImageView icon;
        }

    }


    private ItemInMenu[] items = {
            new ItemInMenu(R.string.Tokyo_Coat, R.string.Price_110, R.drawable.out2, R.string.Tokyo_Coat_About),
            new ItemInMenu(R.string.New_York_Coat, R.string.Price_120, R.drawable.out1, R.string.New_York_Coat_About),
            new ItemInMenu(R.string.Tom_Boy_01_41, R.string.Price_150, R.drawable.out4, R.string.Tom_Boy_01_41_About),
            new ItemInMenu(R.string.Tom_Boy_01_42, R.string.Price_130, R.drawable.out3,R.string.Tom_Boy_01_42_About ),
            new ItemInMenu(R.string.Black_Jeans_Coat, R.string.Price_120, R.drawable.out6, R.string.Black_Jeans_Coat_About),
            new ItemInMenu(R.string.Khaki_Jeans_Coat, R.string.Price_120, R.drawable.out5, R.string.Khaki_Jeans_Coat_About)

    };





}
