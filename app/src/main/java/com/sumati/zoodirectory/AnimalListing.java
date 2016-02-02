package com.sumati.zoodirectory;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class AnimalListing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_listing);

        final List<Animal> animals = new ArrayList<Animal>();

        String bear_description = "The Bear is a well-known animal. " +
                "It is a big animal with either lighter or darker brown fur. " +
                "Tail is short and not well seen among its fur. " +
                "The young have a white collar around their neck, sometimes the " +
                "adults also still have it. Bears walk like humans do on their soles. " +
                "It has dull teeth as all these who eat both plants and animals. " +
                "The Brown Bear is a common animal in Estonia. ";

        String deer_description = "Deer are members of the order Artiodactyle, " +
                "which means that they have hoofs with an even number of toes." +
                "Deer can be found around the world. They are native to all continents " +
                "except for Australia and Antarctica. There are about 100 types of deer, " +
                "including the whitetail deer, reindeer, elk, moose, mule deer, blacktail deer and caribou.";

        String elephant_description = "Elephants are the largest land-living mammal in the world." +
                "Both female and male African elephants have tusks but only the male Asian elephants have tusks. " +
                "They use their tusks for digging and finding food." +
                "Female elephants are called cows. They start to have calves " +
                "when they are about 12 years old and they are pregnant for 22 months." +
                "An elephant can use its tusks to dig for ground water. ";

        String tiger_description = "The Tiger has a long body, a short neck, and a firm head " +
                "with a short muzzle that contains a set of sharp teeth. " +
                "Tigers have stout legs that end in broad paws. " +
                "A well fed tiger is bulky, broad in the shoulders, back, and loins. " +
                "Males are generally longer and heavier than females. ";

        String zebra_description = "Zebras, horses and wild asses are all equids, " +
                "long-lived animals that move quickly for their large size and have " +
                "teeth built for grinding and cropping grass. Zebras have horselike bodies," +
                " but their manes are made of short, erect hair, " +
                "their tails are tufted at the tip and their coats are striped." +
                "Three species of zebra still occur in Africa, two of which are found" +
                " in East Africa. ";

        String panda_description = "Giant pandas are bears that are native to China, " +
                "where they are considered a national treasure. " +
                "Even with this exalted status, giant pandas are endangered: " +
                "only about 1,600 live in the wild, according to the " +
                "International Union for Conservation of Nature (IUCN). ";

        String monkey_description = "There are more than 260 species of Monkeys found in the " +
                "world today. They are derived from early primates that have been " +
                "around for millions of years. There isn’t enough information about " +
                "evolution to say with certainty how they came to be." +
                "Sharing 91% DNA similarities with humans is the Baboon. ";

        String kangaroo_description = "\n" +
                "Kangaroos are found in Australia and Tasmania, as well as on surrounding" +
                " islands. They live in varied habitats, from forests and woodland areas to " +
                "grassy plains and savannas. Kangaroos are grazing herbivores," +
                "They can survive long periods without water. Kangaroos are marsupials, " +
                "which means that females carry newborns, " +
                "in a pouch on the front of their abdomens.";

        animals.add(new Animal("Bear", "bear.jpg", bear_description));
        animals.add(new Animal("Deer", "deer.jpg", deer_description));
        animals.add(new Animal("Elephant", "elephant.jpg", elephant_description));
        animals.add(new Animal("Kangaroo", "kangaroo.jpg", kangaroo_description));
        animals.add(new Animal("Monkey", "monkey.jpg", monkey_description));
        animals.add(new Animal("Panda", "panda.jpg", panda_description));
        animals.add(new Animal("Zebra", "zebra.jpg", zebra_description));
        animals.add(new Animal("Tiger", "tiger.jpg", tiger_description));

        ListView listView = (ListView) findViewById(R.id.custom_list_view);
        listView.setAdapter(new CustomAdaptor(this, R.layout.custom_row, animals));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                /*Toast.makeText(getApplicationContext(),
                        ((TextView) view.findViewById(R.id.rowText)).getText().toString(), Toast.LENGTH_SHORT).show();*/

                if(position == 7) {
                    DialogInterface.OnClickListener dialogInterface = new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case DialogInterface.BUTTON_POSITIVE:
                                    //Yes button clicked
                                    Intent myIntent = new Intent(getApplicationContext(), AnimalDetail.class);
                                    myIntent.putExtra("animal", animals.get(7));
                                    startActivityForResult(myIntent, 0);
                                    break;

                                case DialogInterface.BUTTON_NEGATIVE:
                                    //No button clicked
                                    return;
                            }
                        }
                    };

                    AlertDialog.Builder builder = new AlertDialog.Builder(AnimalListing.this);
                    builder.setMessage("Tiger is very scary. Do you really want to continue?").setPositiveButton("Yes", dialogInterface)
                            .setNegativeButton("No", dialogInterface).show();
                } else {
                    Intent myIntent = new Intent(view.getContext(), AnimalDetail.class);
                    myIntent.putExtra("animal", animals.get(position));
                    startActivityForResult(myIntent, 0);
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_animal_listing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.home:
                Intent intent = new Intent(this, AnimalListing.class);
                this.startActivity(intent);
                return true;
            case R.id.action_info:
                Intent intent_zoo = new Intent(this, ZooInfo.class);
                this.startActivity(intent_zoo);
                return true;
            case R.id.action_uninstall:
                // another startActivity, this is for uninstall item
                Uri packageURI = Uri.parse("package:com.sumati.zoodirectory");
                Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI);
                startActivity(uninstallIntent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

}
