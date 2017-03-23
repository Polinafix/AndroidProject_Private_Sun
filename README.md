# Private Sun 

The Private Sun is a mobile application for fashion shopping, which allows users to browse and shop brand clothes. The application was created as a final project for the Android Development Course.

### Features implemented:

-	Quick navigation to the Favorites List in the tool bar and a more comprehensive one in the Navigation Drawer.
-	The main page shows existing categories of clothes. After clicking on each of them it takes you to the page which shows grid view of small pictures of clothes items of each category with a name and price.
-	See the item details with a larger image of a product, description and option to choose a particular size before adding it to the shopping cart.
-	See the shop location
-	Support of 2 languages: English and Russian
-	Deleting item from the shopping cart or favorites list by clicking on the item. 
-	Custom font was applied to some of the UI Elements
-	By double-clicking on the item picture in the detailed activity the user can add the item to the favorites list, can see an animated heart.
-	Supporting Favorites List and Shopping Cart
-	After proceeding to checkout a customer has an option to either pay online (using PayPal), or pay with cash, and in this case, receive an email confirmation of the order after filling in the personal information.
-	User can also share their favorite items with their friends via different social media networks like Facebook, Twitter and more. 

### Unfinished or partially-completed features

-	Screenshot #12.
The sharing option was not implemented. The user should have an opportunity to share the list of favorites or any chosen item (the picture and name) from the favorites on various Social Networks. 
-	Screenshot #10.
Besides the total amount and shipping address the letter should also contain a list of ordered items with name, size and price.

## Detailed description with screenshots


##### 1. Main Screen
The first page that the user sees. Contains Categories of clothes.
Clicking on any of the categories will take the user to a corresponding detailed catalog. The page is scrollable. The Toolbar at the top of the screen is consistent across several activities of the app and allows the user quickly navigate to the shopping cart and list of favorites, as well as open the Navigation Drawer.

![img1](http://i.imgur.com/uXfyLGE.png)

##### 2. Navigation Drawer Menu
Opens up if the user makes a left swipe or clicks on a hamburger icon on the Toolbar.
Contains the navigation menu. Clicking on each of the menu items takes the user to the corresponding page/activity.
Is consistent across several activities of the app.

![img2](http://i.imgur.com/jzXwxY2.png)

##### 3. Grid View of Items in each Category
Shows a detailed menu of items from a certain category.
Implemented as a gallery of clothes items with a picture, name and price.
Clicking on each of the items takes the user to the next Activity with a detailed description.
The page is scrollable.

![img3](http://i.imgur.com/8asjhv2.png)

##### 4. Detailed View of  the Item
Shows the details of the particular clothes item, such as a large picture and description.
The user can choose the size of the item and add it to the cart.
Double-tapping on the picture adds the item to the favorites.
If the item is already in the cart, the button becomes disabled.
If user forgets to choose the size, the corresponding message will pop up.
The page is scrollable.

![img4](http://i.imgur.com/mPzmO7M.png) ![img5](http://i.imgur.com/TcFkOfP.png)

##### 5. Shopping Cart
Shows the list of items chosen by the user.
To remove the item from the shopping cart, user needs to tap on it and click on the “Remove from Cart” button.
Clicking on the “Proceed to Checkout” button will take the user to the Payment activity.
The page is scrollable.

![img6](http://i.imgur.com/ISwg6T7.png)

##### 6. Proceeding with Payment
In this activity the user can see the total price and choose to pay either online or with cash.
Clicking on “Pay Online” takes the user to the PayPal payment activity.
The page is scrollable.

![img7](http://i.imgur.com/GBAm4QH.png)

##### 7. Paying with PayPal
PayPal payment activity.

![img8](http://i.imgur.com/dZTvnjA.png)

##### 8. Confirmation of Online Payment
When the payment is successfully made, the user sees this screen with the confirmation.

![img9](http://i.imgur.com/BmlsdAG.png)

##### 9. Payment with Cash
If the user decides to pay with cash, he would need to first fill in the personal information. Clicking on “Pay with Cash” will take the user to the email page with the predefined text, containing total amount and shipping address.

![img10](http://i.imgur.com/NJA2bUx.png)

##### 10. Confirmation Letter
Letter with a predefined text.
The feature was not fully implemented.

![img11](http://i.imgur.com/K2rx8H5.png)

##### 11. Favorites Page
The user can either delete the item from the list of favorites or share it.

![img12](http://i.imgur.com/2vbIN3F.png)

##### 12. Option to share Favorites
Clicking on the “Share” button opens up a window with suggested applications.
The feature was not fully implemented.

![img13](http://i.imgur.com/Jj8RBVj.png)
##### 13. Support of Russian language
If we change the settings language of the phone to Russian, the text of the whole application will be translated.




## API features and classes used in the project.
######  1) Android Design Support Library
In particular, there is a Navigation Drawer implemented in the application for easy navigation within the app and consistency in the design. Using NavigationView makes this easier by providing the necessary framework and the ability to inflate navigation items through a menu resource.
The menu for the navigation drawer is created as a collection of checkable menu items. The callbacks on selected items are implemented by setting
the OnNavigationItemSelectedListener. After clicking on a particular MenuItem, the new Activity with the corresponding contents opens up and at the same time the drawer closes.
In order to open the Navigation menu, the user needs to either drag it from the left side of the screen or click on the hamburger icon on the Toolbar.
###### 2) Multi-touch gestures, Classes: GestureDetector, MotionView
In the Activity with a larger picture and description of a particular item, the user can double-click on the picture in order to add the item to the Favorites List.
To detect a double tap on the picture a GestureDetector was instantiated.
###### 3) Animation API, Classes: Animator, AnimatorSet, ObjectAnimator, AnimatorListenerAdapter
I used the following tutorial as an example:
http://ratiksharma.com/blog/implementing-an-instagram-like-heart-animation-on-android/

After double-clicking on the picture, an animated heart appears for a moment to visually indicate that the item was actually added to the Favorites List.
The methods for creating an animation were implemented inside the “heart” class.
The shape of a heart was defined inside a vector drawable XML element which
allows to scale without losing definition.
###### 4) Graphics API, Class: Typeface
Created a new Java class MyTextView, which extends TextView. It inherits all
functionality and properties of a regular TextView and adds a custom font.
###### 5) PayPal SDK, Classes: PayPalConfiguration, PayPalPayment, PayPalService, PaymentActivity, PaymentConfirmation
The PayPal Payment is invoked after the user clicks on “Pay Online” button in the ProceedOrder Activity. First, I had to add a PayPal SDK to build.gradle file. In my application I implemented only receiving a single, immediate payment from the customer through PayPal. 
In this case I set PayPalConfiguration.ENVIRONMENT_NO_NETWORK to kick the tires without communicating to PayPal's servers. "PayPal Service" starts when the ProceedOrder Activity is created and stops upon destruction. When the user clicks the button, the payment is created and the payment intent is launched.
###### 6) Json API, Classes: JSONObject
After making a payment the user is taken to the Confirmation Page where he/she can see the status of the order, total amount and payment id. Using the Json Object we are receiving necessary details in the Intent.

##### The biggest challenges I have encountered.
Mainly, it was very challenging for me to try to implement some of the features that were not covered in class. Numerous online tutorials and training guides on the Android Developers website, in particular, were extremely helpful.
First, it took me a lot of time to make the Navigation Drawer and Toolbar look and function exactly the way I wanted. I found a lot of tutorials on how to create it and first studied them all. Then I was able to apply the new knowledge and experiment with the code to implement it in my application.
Also, I didn’t know how to make the Toolbar and the Navigation Drawer be visible across different activities of the application. I resolved this issue by creating a base Activity with Navigation drawer and then extending it in other Activities.
One of the biggest challenges for me was to be able to fill the Detailed Menu
Activity (implemented as a GridView) with different items depending on which
category the user chooses in the previous (Main) Activity. Finally, I came up with the idea to pass corresponding keys in the Intent from the Main Activity to the Detailed Menu Activity, where the necessary catalog is chosen in accordance with the key passed.

##### Limitations of the app
The main limitation of my application is that the list of clothes items is hard-coded, so it is impossible to keep track of items inventory and update the catalog. To improve this issue, I would need to save data in the Database or Cloud.
Another problem is that in the situation when the user decides to pay with cash, his final list of the items ordered is not reflected in the confirmation letter. I would need to find the way pass the order list. The same issue is with sharing the list of favorite items or just one selected item via Social Networks. In this case I would probably try using separate SDK specifically created for each Social Network.

## Acknowledgments
Tutorials that I used:
- Implementing an Instagram-like Heart Animation on Android
 http://ratiksharma.com/blog/implementing-an-instagram-like-heart-animation-on-android/
- PayPal Integration Tutorial
 https://www.simplifiedcoding.net/android-paypal-integration-tutorial/
- Toolbar and Navigation Drawer
- https://dzone.com/articles/getting-started-with-android-app-and-material-desi
- Creating a Shopping Cart for Android
http://www.androiddom.com/2011/02/android-shopping-cart-tutorial.html





  





