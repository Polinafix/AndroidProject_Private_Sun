package com.example.android.privatesun2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Larger_Picture extends NavigationDrawerActivity {

    private ImageView heartImageView;
    private ImageView clickedImageView;
    TextView name;
    RadioGroup radioGroup;

    int m;


    List<ItemInMenu> cart = ShoppingCartHelper.getCart();
    List<ItemInMenu> myFavourites = ShoppingCartHelper.getFavourites();
    ItemInMenu selectedItem;
    List<ItemInMenu> catalog;


    // Animation Helpers
    private static final DecelerateInterpolator DECCELERATE_INTERPOLATOR
            = new DecelerateInterpolator();
    private static final AccelerateInterpolator ACCELERATE_INTERPOLATOR
            = new AccelerateInterpolator();

    // Gesture Detector
    private GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_larger__picture);


        heartImageView = (ImageView) findViewById(R.id.heart);
        clickedImageView = (ImageView) findViewById(R.id.image);


        detector = new GestureDetector(this, new GestureListener());
        clickedImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return detector.onTouchEvent(event);
            }

        });

        //showing the corresponding catalog
        m = getIntent().getIntExtra(Detailed_Menu.NEW_KEY, -1);
        switch (m) {
            case 1:
                catalog = ShoppingCartHelper.getCatalog(getResources());
                break;
            case 2:
                catalog = ShoppingCartHelper.getCatalog3(getResources());
                break;

            case 3:
                catalog = ShoppingCartHelper.getCatalog2(getResources());
                break;

            case 4:
                catalog = ShoppingCartHelper.getCatalog4(getResources());
                break;
        }


        int productIndex = getIntent().getExtras().getInt(ShoppingCartHelper.PRODUCT_INDEX);
        selectedItem = catalog.get(productIndex);
        name = (TextView) findViewById(R.id.itemname);
        name.setText(selectedItem.getName());
        TextView description = (TextView) findViewById(R.id.description);
        description.setText(selectedItem.getLongDescription());
        TextView price = (TextView) findViewById(R.id.price);
        price.setText("$" + selectedItem.getPrice());
        ImageView icon = (ImageView) findViewById(R.id.image);
        icon.setImageResource(selectedItem.getImageResource());


        Button addToCartButton = (Button) findViewById(R.id.addtocart);
        addToCartButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
                if (radioGroup.getCheckedRadioButtonId() == -1) {
                    // no radio button is checked
                    Toast.makeText(getApplicationContext(), "Please, choose the size", Toast.LENGTH_SHORT).show();

                } else {
                    // one of the radio buttons is checked
                    cart.add(selectedItem);//adding to the list
                    finish();
                }


            }
        });


        // Disable the add to cart button if the item is already in the cart
        if (cart.contains(selectedItem)) {
            addToCartButton.setEnabled(false);
            addToCartButton.setText("Item already in Cart");
        }


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButton1:
                if (checked)
                    selectedItem.setSize("Size: S");
                break;
            case R.id.radioButton2:
                if (checked)
                    selectedItem.setSize("Size: M");
                break;
            case R.id.radioButton3:
                if (checked)
                    selectedItem.setSize("Size: L");
                break;
        }
    }


    // listening to double tap
    public class GestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            heart();
            myFavourites.add(selectedItem);
            return true;
        }
    }

    //creating an animation for the heart when double-tapping
    private void heart() {
        heartImageView.setVisibility(View.VISIBLE);


        heartImageView.setScaleY(0.1f);
        heartImageView.setScaleX(0.1f);

        AnimatorSet animatorSet = new AnimatorSet();

        ObjectAnimator imgScaleUpYAnim = ObjectAnimator.ofFloat(heartImageView, "scaleY", 0.1f, 1f);
        imgScaleUpYAnim.setDuration(300);
        imgScaleUpYAnim.setInterpolator(DECCELERATE_INTERPOLATOR);
        ObjectAnimator imgScaleUpXAnim = ObjectAnimator.ofFloat(heartImageView, "scaleX", 0.1f, 1f);
        imgScaleUpXAnim.setDuration(300);
        imgScaleUpXAnim.setInterpolator(DECCELERATE_INTERPOLATOR);

        ObjectAnimator imgScaleDownYAnim = ObjectAnimator.ofFloat(heartImageView, "scaleY", 1f, 0f);
        imgScaleDownYAnim.setDuration(300);
        imgScaleDownYAnim.setInterpolator(ACCELERATE_INTERPOLATOR);
        ObjectAnimator imgScaleDownXAnim = ObjectAnimator.ofFloat(heartImageView, "scaleX", 1f, 0f);
        imgScaleDownXAnim.setDuration(300);
        imgScaleDownXAnim.setInterpolator(ACCELERATE_INTERPOLATOR);

        animatorSet.playTogether(imgScaleUpYAnim, imgScaleUpXAnim);
        animatorSet.play(imgScaleDownYAnim).with(imgScaleDownXAnim).after(imgScaleUpYAnim);

        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                reset();
            }
        });
        animatorSet.start();
    }

    public void reset() {
        heartImageView.setVisibility(View.GONE);
    }


}




