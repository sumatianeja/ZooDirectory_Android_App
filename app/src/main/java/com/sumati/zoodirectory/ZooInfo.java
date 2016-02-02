package com.sumati.zoodirectory;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.jar.Manifest;

public class ZooInfo extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo_info);

        button = (Button) findViewById(R.id.button_call);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call();
            }
        });
        }

    private void call() {
        Intent in=new Intent(Intent.ACTION_CALL);
        String phoneNumber = "8888888";
        in.setData(Uri.parse("tel:" + phoneNumber));
        in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        try{
            startActivity(in);
        }

        catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(), "yourActivity is not founded", Toast.LENGTH_SHORT).show();
        }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_animal_listing, menu);
        return true;
    }
}
