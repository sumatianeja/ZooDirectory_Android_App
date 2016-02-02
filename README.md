# ZooDirectory_Android_App

An android app for a fictional zoo. The app provides a listing of animals, details of each animal, and basic information about the zoo.

Requirements
The zoo app has the following requirements:

Activities
The app has 3 activities:


1. Animal listing activity  
Zoo has 8 animals. Each row in this list have:
 * a thumbnail picture of the animal
 * the name of the animal
This is implemented as a ListView. When any part of a row is clicked, it launches the details activity for the corresponding animal (described next).

2. Animal detail activity  
The animal detail activity shows details on the animal chosen in the list. The activity shows:
 * The name of the animal
 * A large image of the animal
 * A short description of the animal
The same detail activity is being reused for each animal.

3. Zoo information activity  
The zoo information activity has:
 * The name of the Zoo
 * A phone number represented as Button --> When clicked, the phone number of the zoo (888-8888) is dialed.
This activity is triggered by one of the menu items (see the "Menu Items" section below).

Menu Items
The ActionBar remains persistent throughout the app (for every Activity that's shown). The overflow menu has two items:

    Information-->  This launches the zoo information activity (described above).
    Uninstall--> This calls an intent to uninstall the app. 

The menu items listed above appear in the overflow menu and not as buttons in the action bar. This is because only frequent, important, or typical actions are supposed to appear as buttons in the ActionBar.
Dialog Box
When the user clicks on the last animal in the animal listing activity, an alert box pops-up, warning the user that the animal is very scary and asking the user if they want to proceed. If the user clicks "Yes", then the app proceeds as normal. If the user clicks "No", then the app remains on the same activity.
