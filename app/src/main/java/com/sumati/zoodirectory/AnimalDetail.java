package com.sumati.zoodirectory;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class AnimalDetail extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_detail);
        createImageAndText();

    }

    private void createImageAndText() {

        Intent intent = getIntent();
        Animal animal = (Animal) intent.getSerializableExtra("animal");

        imageView = (ImageView) findViewById(R.id.animalImage);

        // Set the image
        try {
            InputStream inputStream = getApplicationContext().getAssets().open(animal.getFilename());
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        textView = (TextView) findViewById(R.id.animalDesc);
        textView.setText(animal.getDescription());
        textView.setMovementMethod(new ScrollingMovementMethod());
        label = (TextView) findViewById(R.id.label_text);
        label.setText(animal.getName());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
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
