package com.example.beakaltiliskew.myapplication;

/**
 * Created by Beakal Tiliskew on 4/11/2018.
 */

//A reminder class
public class Reminder {


        private int myID;
        private String myTitle;
        private String myDate;
        private String myTime;



        public Reminder(int ID, String Title, String Date, String Time){
            myID = ID;
            myTitle = Title;
            myDate = Date;
            myTime = Time;

        }

        public Reminder(String Title, String Date, String Time){

            myTitle = Title;
            myDate = Date;
            myTime  = Time;

        }


        public Reminder(){}

        public int getID() {
            return myID;
        }

        public void setID(int ID) {
            myID = ID;
        }

        public String getTitle() {
            return myTitle;
        }

        public void setTitle(String title) {
            myTitle = title;
        }

        public String getDate() {
            return myDate;
        }

        public void setDate(String date) {
            myDate = date;
        }

        public String getTime() {
            return myTime;
        }

        public void setTime(String time) {
            myTime= time;
        }

    }
