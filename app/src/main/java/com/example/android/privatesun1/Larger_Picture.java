package com.example.android.privatesun1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Larger_Picture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_larger__picture);

        Intent intent = getIntent();
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


            //name.setText(intent.getCharSequenceExtra("ItemName"));
           // description.setText(intent.getCharSequenceExtra("ItemDescription"));
           // icon.setImageResource(intent.getIntExtra("ItemIcon"));

        }


    }


}




