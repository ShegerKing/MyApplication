package com.example.beakaltiliskew.myapplication;

import android.Manifest;
import android.support.v7.widget.RecyclerView;
import android.text.method.DateKeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.beakaltiliskew.myapplication.MainActivity.rb;

/**
 * Created by Beakal Tiliskew on 4/18/2018.
 */

//This is a  basic recycle view adapter, more functionality can be added here
//The hard part is done, you guys can work on this to add some more functionality to the adapter

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.CustomItemHolder> {

    private Reminder_database db;
    private ArrayList<ReminderItem> Items;

    public ReminderAdapter(){
        Items = new ArrayList<>();

    }

    public void setItemCount(int count) {
        Items.clear();
        Items.addAll(generateData(count));
        notifyDataSetChanged();
    }




    public ReminderAdapter(ArrayList<ReminderItem> List) {
        this.Items = List;
    }

    @Override
    public CustomItemHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false);
        return new CustomItemHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomItemHolder holder, int position) {
        ReminderItem Item = Items.get(position);
        holder.myTitleText.setText(Item.myTitle);

        holder.myDateText.setText(Item.myDate);
        holder.myTimeText.setText((Item.myTime));

    }


    @Override
    public int getItemCount() {
        return Items.size();
    }


    // Class for recycler view items
    public  class ReminderItem {
        public String myTitle;
        public String myDate;
        public String myTime;

        public ReminderItem(String Title, String Date, String Time) {
            this.myTitle = Title;
            this.myDate = Date;
            this.myTime = Time;

        }
    }


    public class CustomItemHolder extends RecyclerView.ViewHolder {
        public TextView myTitleText;
        public TextView myDateText;
        public TextView myTimeText;

        public CustomItemHolder(View view) {
            super(view);

            myTitleText = (TextView) itemView.findViewById(R.id.recycle_title);
            myDateText = (TextView) itemView.findViewById(R.id.recycle_date);
            myTimeText = (TextView) itemView.findViewById(R.id.recycle_time);

        }

        public void setReminderDateTime(String date, String time) {
            myDateText.setText(date);
            myTimeText.setText(time);
        }
    }



    public List<ReminderItem> generateData(int count) {


        ArrayList<ReminderAdapter.ReminderItem> items = new ArrayList<>();



       //Get all the reminder
        List<Reminder> reminders = rb.getAllReminders();






         //Add all the reminders into the Adapter
        for (Reminder r : reminders) {

            items.add( new ReminderAdapter.ReminderItem(r.getTitle(), r.getDate() ,  r.getTime( )));


        }

        return items;
    }
}
















