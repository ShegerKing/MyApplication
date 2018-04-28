package com.example.beakaltiliskew.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;


            //Important
/**
 *
 *    What is left  to do!!
 *
 *   Add a notification functionality! This should be easy as most of the structure is complete
 *   Deleting the recycler items one by one
 *   Be able to edit each reminder on pressing on it(A clickable must be added on the Reminder Adapter, if you guys aren't sure how to do that
 *   let me know and I will do it myself
 *   Improve on the ADDReminder Layout UI( looks a bit clunky at the moment
 *   Add any additional item of your liking!
 *
 *
 *
 */

public class MainActivity extends AppCompatActivity {

    private RecyclerView myList;
    private ReminderAdapter myAdapter;
    private Toolbar myToolbar;
    private TextView myNoReminderView;
    private FloatingActionButton myAddReminderButton;
    private int mTempPost;
    public static Reminder_database rb;
    private ArrayList<ReminderAdapter.ReminderItem> ReminderList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rb = new Reminder_database(getApplicationContext());

        // Initialize views
        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myAddReminderButton = (FloatingActionButton) findViewById(R.id.add_reminder);
        myList = (RecyclerView) findViewById(R.id.reminder_list);
        myNoReminderView = (TextView) findViewById(R.id.no_reminder_text);

        //If no reminders set noReminderViewOn
        List<Reminder> mTest = rb.getAllReminders();

        if (mTest.isEmpty()) {
            myNoReminderView.setVisibility(View.VISIBLE);
        }

        // Recycler View
        myList.setLayoutManager(getLayoutManager());
        registerForContextMenu(myList);
        myAdapter = new ReminderAdapter();
        myAdapter.setItemCount(getDefaultItemCount());
        myList.setAdapter(myAdapter);

        //Go to add reminder activity
        myAddReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddReminder.class);
                startActivity(intent);
            }
        });


        myList.setAdapter(myAdapter);


    }


    // Recreate recycler view
    // This is done so that newly created reminders are displayed
    @Override
    public void onResume() {
        super.onResume();

      //IF NO REMINDER ADD A REMINDER
        List<Reminder> mTest = rb.getAllReminders();

        if (mTest.isEmpty()) {
            myNoReminderView.setVisibility(View.VISIBLE);
        } else {
            myNoReminderView.setVisibility(View.GONE);
        }
        myAdapter.setItemCount(getDefaultItemCount());

    }

    // Layout manager for recycler view
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    }

    protected int getDefaultItemCount() {
        return 100;
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    // Setup menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Setting:
                Intent intent = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(intent);
                return true;


            //This is clunky and needs to be improved on
            //I will let you guys work on it
            case R.id.clearDatabase:
                 Reminder_database  db= new Reminder_database(getApplicationContext());
                 SQLiteDatabase d  = db.getWritableDatabase();

                d.delete(contract.infoEntry.TABLE_NAME, "1", null);


                return true;



            default:

                return super.onOptionsItemSelected(item);
        }
    }
}
