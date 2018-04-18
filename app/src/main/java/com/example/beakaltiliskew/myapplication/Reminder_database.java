package com.example.beakaltiliskew.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Beakal Tiliskew on 4/11/2018.
 */

public class Reminder_database extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "reminderDb.db";


    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + contract.infoEntry.TABLE_NAME + " (" +
                    contract.infoEntry._ID + " INTEGER PRIMARY KEY," +
                    contract.infoEntry.COLUMN_ID + " TEXT," +
                    contract.infoEntry.COLUMN_TITLE + " TEXT," +
                    contract.infoEntry.COLUMN_DATE + " TEXT," +
                    contract.infoEntry.COLUMN_TIME + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " +  contract.infoEntry.TABLE_NAME;

    public Reminder_database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public Reminder_database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public int addReminder(Reminder reminder){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(contract.infoEntry.COLUMN_TITLE , reminder.getTitle());
        values.put(contract.infoEntry.COLUMN_DATE , reminder.getDate());
        values.put(contract.infoEntry.COLUMN_TIME, reminder.getTime());


        // Inserting Row
        long ID = db.insert(contract.infoEntry.TABLE_NAME, null, values);
        db.close();
        return (int) ID;
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public List<Reminder> getAllReminders(){List<Reminder> reminderList = new ArrayList<>();

        // Select all Query
        String selectQuery = "SELECT * FROM " + contract.infoEntry.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Looping through all rows and adding to list
        if(cursor.moveToFirst()){
            do{
                Reminder reminder = new Reminder();
                reminder.setID(Integer.parseInt(cursor.getString(0)));
                reminder.setTitle(cursor.getString(1));
                reminder.setDate(cursor.getString(2));
                reminder.setTime(cursor.getString(3));


                // Adding Reminders to list
                reminderList.add(reminder);
            } while (cursor.moveToNext());
        }
        return reminderList;
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


}
