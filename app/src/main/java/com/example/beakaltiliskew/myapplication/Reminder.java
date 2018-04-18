package com.example.beakaltiliskew.myapplication;

/**
 * Created by Beakal Tiliskew on 4/11/2018.
 */

public class Reminder {


        private int IDt;
        private String Titlet;
        private String Datet;
        private String Timet;



        public Reminder(int ID, String Title, String Date, String Time){
            IDt = ID;
            Titlet = Title;
            Datet = Date;
            Timet = Time;

        }

        public Reminder(String Title, String Date, String Time){
            Titlet = Title;
            Datet= Date;
            Timet = Time;

        }

        public Reminder(){}

        public int getID() {
            return IDt;
        }

        public void setID(int ID) {
            ID = IDt;
        }

        public String getTitle() {
            return Titlet;
        }

        public void setTitle(String title) {
            Titlet = title;
        }

        public String getDate() {
            return Datet;
        }

        public void setDate(String date) {
            Datet = date;
        }

        public String getTime() {
            return Timet;
        }

        public void setTime(String time) {
            Timet = time;
        }

    }
