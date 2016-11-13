package com.example.android.privatesun2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProceedOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceed_order);

        Intent intent = getIntent();
        if (intent != null) {
            TextView payTotal = (TextView) findViewById(R.id.payTotal);
            payTotal.setText("Total: " + intent.getCharSequenceExtra("Total"));
        }

        Button proceedButton = (Button) findViewById(R.id.pay);
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(ShoppingCart.this, ProceedOrder.class);
                TextView total = (TextView) findViewById(R.id.FinalPrice);
                intent.putExtra("Total", total.getText());
                startActivity(intent);*/

                Intent intent = new Intent(Intent.ACTION_SENDTO);//constant

                EditText firstName = (EditText) findViewById(R.id.name3);
                EditText lastName = (EditText) findViewById(R.id.name4);
                TextView payTotal = (TextView) findViewById(R.id.payTotal);
                EditText address1 = (EditText) findViewById(R.id.addL2);
                EditText address2 = (EditText) findViewById(R.id.addL4);
                EditText city = (EditText) findViewById(R.id.city2);
                EditText state = (EditText) findViewById(R.id.state2);
                EditText zip = (EditText) findViewById(R.id.zip2);
                EditText country = (EditText) findViewById(R.id.cou2);
                String wholeAddress = address1.getText()+ " "+address2.getText()+'\n' +city.getText()+","+state.getText()+" "+zip.getText()+"\n"+country.getText();
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"pd.fiksson@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Private Sun Order for "+ firstName.getText()+" "+lastName.getText());
                intent.putExtra(Intent.EXTRA_TEXT, payTotal.getText().toString()+ "\n"+"Shipping address: "+wholeAddress);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

    }
}
