package com.example.beakaltiliskew.myapplication;



import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;


import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

/**
 * Created by Beakal Tiliskew on 4/18/2018.
 */

//This class adds takes reminder input form the user
 //I used an external library form github witch gives a nice disign for picking time and date
 //The UI is kind of bad, it would be good it you improve on this pages design
public class AddReminder extends AppCompatActivity implements   DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{

        private Toolbar mToolbar;
        private EditText TitleText;
        private TextView DateText, TimeText;
        private Calendar myCalendar;
        private int Year, Month, Hour, Minute, Day;

        private String myTitle;
        private String myTime;
        private String myDate;




         @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.add_reminder_content);

            mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
            setSupportActionBar(mToolbar);
            TitleText = (EditText) findViewById(R.id.reminder_title);
            DateText = (TextView) findViewById(R.id.set_date);
            TimeText = (TextView) findViewById(R.id.set_time);




            myCalendar = Calendar.getInstance();
            Hour = myCalendar.get(Calendar.HOUR_OF_DAY);
            Minute = myCalendar.get(Calendar.MINUTE);
            Year = myCalendar.get(Calendar.YEAR);
            Month = myCalendar.get(Calendar.MONTH) + 1;
            Day = myCalendar.get(Calendar.DATE);

            myDate = Day + "/" + Month + "/" + Year;
            myTime = Hour + ":" + Minute;

             TitleText.addTextChangedListener(new TextWatcher() {

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    myTitle = s.toString().trim();
                    TitleText.setError(null);
                }

                @Override
                public void afterTextChanged(Editable s) {}
            });


            DateText.setText(myDate);
            TimeText.setText(myTime);



        }



    // Obtain date from date picker
    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        monthOfYear ++;
        Day = dayOfMonth;
        Month = monthOfYear;
        Year = year;
        myDate = dayOfMonth + "/" + monthOfYear + "/" + year;
        DateText.setText(myDate);
    }



    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        myTime  = hourOfDay+":"+minute+":"+second;
        TimeText.setText(myTime);
    }





    // On clicking Date picker
    public void setDate(View v){
        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );
        dpd.show(getFragmentManager(), "Datepickerdialog");
    }

    // On clicking Time picker
    public void setTime(View v){
        Calendar now = Calendar.getInstance();
        TimePickerDialog tpd = TimePickerDialog.newInstance(
                this,
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                false
        );
        tpd.setThemeDark(false);
        tpd.show(getFragmentManager(), "Timepickerdialog");
    }







        public void saveReminder(){
            Reminder_database rb = new Reminder_database(this);

            // Creating Reminder
            int ID = rb.addReminder(new Reminder(myTitle, myDate, myTime));

            //WE need to add an alarm that takes information form here

            Toast.makeText(getApplicationContext(), "Saved",
                    Toast.LENGTH_SHORT).show();

            onBackPressed();
        }


        @Override
        public void onBackPressed() {
            super.onBackPressed();
        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_add_reminder, menu);
            return true;
        }


        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {


                case android.R.id.home:
                    onBackPressed();
                    return true;


                case R.id.save_reminder:
                    TitleText.setText(myTitle);

                    if (TitleText.getText().toString().length() == 0)
                        TitleText.setError("Please enter reminder information");

                    else {
                        saveReminder();
                    }
                    return true;



                default:
                    return super.onOptionsItemSelected(item);
            }
        }
    }


