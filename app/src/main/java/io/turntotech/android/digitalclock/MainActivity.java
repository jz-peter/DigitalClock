package io.turntotech.android.digitalclock;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;


public class MainActivity extends AppCompatActivity {

    SimpleDateFormat dateFormat;
    SimpleDateFormat dateAmPm;

    String date;
    String ampm;
    Calendar calendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Create handler to refresh time and date:
        final TextView txtViewDate = findViewById(R.id.txtViewDate);
        final TextView txtViewAmPm = findViewById(R.id.txtViewAmPm);

        final Handler handler = new Handler();

        Runnable runnableCode = new Runnable() {

            @Override
            public void run() {


        SharedPreferences sharedPrefs;
        sharedPrefs = getSharedPreferences("settings", MODE_PRIVATE);

        //Get calendar
        calendar = Calendar.getInstance();



        CustomDotsView viewDots = findViewById(R.id.viewDots);

        CustomDigitView viewHour1 = findViewById(R.id.viewHour1);
        CustomDigitView viewHour2 = findViewById(R.id.viewHour2);
        CustomDigitView viewMin1 = findViewById(R.id.viewMin1);
        CustomDigitView viewMin2 = findViewById(R.id.viewMin2);
        CustomDigitView viewSec1 = findViewById(R.id.viewSec1);
        CustomDigitView viewSec2 = findViewById(R.id.viewSec2);


         String pattern =  sharedPrefs.getString("pattern", "hhmmss");
         dateFormat = new SimpleDateFormat(pattern);

                //When in 24 Hour Mode, Hide txtViewAmPm:
                if (pattern == ("hhmmss")){
                    txtViewAmPm.setVisibility(View.VISIBLE);
                }else {
                    txtViewAmPm.setVisibility(View.INVISIBLE);
                }


         String timeZone = sharedPrefs.getString("cityTime","US/Eastern");


          TimeZone timeZn = TimeZone.getTimeZone(timeZone);
          dateFormat.setTimeZone(timeZn);



          //Get time and date:
          dateAmPm = new SimpleDateFormat("a");
          dateAmPm.setTimeZone(timeZn);
          ampm = dateAmPm.format(calendar.getTime());
          txtViewAmPm.setText(ampm);

          dateFormat = new SimpleDateFormat("MM/dd/yyyy");
          dateFormat.setTimeZone(timeZn);


          date = dateFormat.format(calendar.getTime());
          txtViewDate.setText(date);


        //Create array for each number digit in time:
        dateFormat = new SimpleDateFormat(pattern);
        dateFormat.setTimeZone(timeZn);
        char[] timevalues = dateFormat.format(calendar.getTime()).toCharArray();

        viewHour1.setDigit(timevalues[0]);
        viewHour2.setDigit(timevalues[1]);
        viewMin1.setDigit(timevalues[2]);
        viewMin2.setDigit(timevalues[3]);
        viewSec1.setDigit(timevalues[4]);
        viewSec2.setDigit(timevalues[5]);

        //Set Digit color from shared preferences:
        viewHour1.setDigitColor(sharedPrefs.getInt("color", R.color.colorRed));
        viewHour2.setDigitColor(sharedPrefs.getInt("color", R.color.colorRed));
        viewMin1.setDigitColor(sharedPrefs.getInt("color", R.color.colorRed));
        viewMin2.setDigitColor(sharedPrefs.getInt("color", R.color.colorRed));
        viewSec1.setDigitColor(sharedPrefs.getInt("color", R.color.colorRed));
        viewSec2.setDigitColor(sharedPrefs.getInt("color", R.color.colorRed));


        viewDots.setDots();

        //Set Dots color from shared preferences:
        viewDots.setDotsColor(sharedPrefs.getInt("color",R.color.colorRed));


        handler.postDelayed(this, 500); //Dots flashing every half second:
            }

        };

        handler.post(runnableCode);
    }

    //Create settings menu:
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    //Launching new Activity when Settings is clicked:
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent settings = new Intent(MainActivity.this, ActivitySettings.class);
        MainActivity.this.startActivity(settings);
        return true;
    }
}


