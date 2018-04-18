package com.example.beakaltiliskew.myapplication;

import android.provider.BaseColumns;

/**
 * Created by Beakal Tiliskew on 4/11/2018.
 */

public class contract {

    private contract() {


    }

    public static class infoEntry implements BaseColumns {
        public static final String TABLE_NAME = "reminderInfo";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_TIME = "time";

    }
}
