package com.example.beakaltiliskew.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Reminder_database Helper = new Reminder_database(getApplicationContext());
        SQLiteDatabase db=  Helper.getWritableDatabase();

        // Initialize views
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        FloatingActionButton ReminderButton = (FloatingActionButton) findViewById(R.id.add_reminder);
        RecyclerView list  = (RecyclerView) findViewById(R.id.reminder_list);
        TextView NoReminder = (TextView) findViewById(R.id.no_reminder_text);

        // To check is there are saved reminders
        // If there are no reminders display a message asking the user to create reminders
        List<Reminder> mTest = Helper.getAllReminders();

        if (mTest.isEmpty()) {
            NoReminder.setVisibility(View.VISIBLE);
        }

        // Create recycler view
        //
        list.setLayoutManager(new LinearLayoutManager(this));
        registerForContextMenu(list);
        SimpleAdapter Adapter = new SimpleAdapter();
        //Adapter.setItemCount(getDefaultItemCount());
       // list.setAdapter(Adapter);

        Adapter.

        // Setup toolbar
       // setSupportActionBar(toolbar);
       toolbar.setTitle(R.string.app_name);
        ReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //going to implement add a reminder activity here
              //  Intent intent = new Intent(v.getContext(), add.class);
               // startActivity(intent);
            }
        });


    }




    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
