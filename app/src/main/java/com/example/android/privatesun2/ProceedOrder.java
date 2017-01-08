package com.example.android.privatesun2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import org.json.JSONException;

public class ProceedOrder extends AppCompatActivity {


    TextView total;

    private static final String CONFIG_CLIENT_ID = "AWdmA--pripa1h2fsuW0ZvAzOPCGyDxQOc5G6MCN0nA0d8ynd6Ud6f5zaSzZuh6U1uxxUaegGF3-qfn7";

    private static PayPalConfiguration config = new PayPalConfiguration()

            // Creating a mock environment.
            .environment(PayPalConfiguration.ENVIRONMENT_NO_NETWORK)
            .clientId(CONFIG_CLIENT_ID);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceed_order);

        total = (TextView) findViewById(R.id.payTotal);

        // Start PayPalService when your activity is created and stop it upon destruction:
        Intent intentP = new Intent(this, PayPalService.class);
        intentP.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        startService(intentP);

        Intent intent = getIntent();
        if (intent != null) {
            TextView payTotal = (TextView) findViewById(R.id.payTotal);
            payTotal.setText(String.valueOf(intent.getStringExtra("Total")));
        }

        Button proceedButton = (Button) findViewById(R.id.pay);
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                EditText email = (EditText) findViewById(R.id.email2);
                EditText comment = (EditText) findViewById(R.id.comment2);
                String wholeAddress = address1.getText() + " " + address2.getText() + '\n' + city.getText() + "," + state.getText() + " " + zip.getText() + "\n" + country.getText() + "\n" + comment.getText();
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                String emailAddr = email.getText().toString();
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{emailAddr});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Private Sun Order for " + firstName.getText() + " " + lastName.getText());
                intent.putExtra(Intent.EXTRA_TEXT, "Payment Amount: $" + payTotal.getText().toString() + "\n" + "Shipping address: " + wholeAddress);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

    }

    public void payOnline(View view) {

        PayPalPayment thingToBuy = getThingToBuy(PayPalPayment.PAYMENT_INTENT_SALE);

        //Creating Paypal Payment activity intent
        Intent intent = new Intent(this, PaymentActivity.class);

        //putting the paypal configuration to the intent
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);

        //Addinging paypal payment to the intent
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, thingToBuy);

        //Starting the intent activity for result
        startActivityForResult(intent, 0);


    }

    private PayPalPayment getThingToBuy(String paymentIntent) {
        //Getting the amount from TextView
        return new PayPalPayment(new java.math.BigDecimal(String.valueOf(total.getText())), "USD", "Total price is",
                paymentIntent);

    }

    /*
     * Enable retrieval of shipping addresses from buyer's PayPal account
     */
    private void enableShippingAddressRetrieval(PayPalPayment paypalPayment, boolean enable) {
        paypalPayment.enablePayPalShippingAddressesRetrieval(enable);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            PaymentConfirmation confirm = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
            if (confirm != null) {
                try {
                    //Getting the payment details
                    String paymentDetails = confirm.toJSONObject().toString(4);
                    Log.i("paymentExample", paymentDetails);

                    //Starting a new activity for the payment details and also sending the payment details with intent
                    startActivity(new Intent(this, ConfirmationActivity.class)
                            .putExtra("PaymentDetails", paymentDetails)
                            .putExtra("PaymentAmount", total.getText()));


                } catch (JSONException e) {
                    Log.e("paymentExample", "an extremely unlikely failure occurred: ", e);
                }
            }
        } else if (resultCode == Activity.RESULT_CANCELED) {
            Log.i("paymentExample", "The user canceled.");
        } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID) {
            Log.i("paymentExample", "An invalid Payment or PayPalConfiguration was submitted. Please see the docs.");
        }
    }

    @Override
    public void onDestroy() {
        stopService(new Intent(this, PayPalService.class));
        super.onDestroy();
    }
}
