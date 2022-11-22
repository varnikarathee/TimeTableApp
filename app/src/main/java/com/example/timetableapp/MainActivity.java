package com.example.timetableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final ListView timesTableListView =findViewById(R.id.timestablesListView);

    public void generateTimesTable(int timesTableNumber){

        //Arraylist  in list view that will store you record.
        ArrayList<String> timesTableContent = new ArrayList<String>();
        for(int j =1; j<= 10;j++){
            timesTableContent.add(Integer.toString(j*timesTableNumber));
        }
        //connecting list view with arraylist

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);
        timesTableListView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Get the views
        final SeekBar timesTableSeekBar = findViewById(R.id.timestableseekBar);
        generateTimesTable(10);
        //maxlength of seekbar
        timesTableSeekBar.setMax(20);
        timesTableSeekBar.setProgress(10);

        //to show changes
        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
             //When changing where we at etc
                //for min to be 1 starts with 1
             int min =1;
             int timestablenumber;
             if(i<min){
                timestablenumber=min;
                timesTableSeekBar.setProgress(min);
             }
             else{
                 timestablenumber =1;
             }
             //to check seek bar value changing
             final String TAG ="SeekBar Value";
                Log.i(TAG, Integer.toString(timestablenumber));
             generateTimesTable(timestablenumber);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}