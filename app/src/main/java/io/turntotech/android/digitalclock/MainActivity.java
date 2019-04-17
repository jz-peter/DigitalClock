package io.turntotech.android.digitalclock;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;


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

        final TextView txtViewDate = findViewById(R.id.txtViewDate);
        final TextView txtViewAmPm = findViewById(R.id.txtViewAmPm);

        final Handler handler = new Handler();



        Runnable runnableCode = new Runnable() {

            @Override
            public void run() {

        //Get current date:
        calendar = Calendar.getInstance();

        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        date = dateFormat.format(calendar.getTime());
        txtViewDate.setText(date);

        //Get time am,pm
        dateAmPm = new SimpleDateFormat("a");
        ampm = dateAmPm.format(calendar.getTime());
        txtViewAmPm.setText(ampm);


        CustomDotsView viewDots = findViewById(R.id.viewDots);

        CustomDigitView viewHour1 = findViewById(R.id.viewHour1);
        CustomDigitView viewHour2 = findViewById(R.id.viewHour2);
        CustomDigitView viewMin1 = findViewById(R.id.viewMin1);
        CustomDigitView viewMin2 = findViewById(R.id.viewMin2);
        CustomDigitView viewSec1 = findViewById(R.id.viewSec1);
        CustomDigitView viewSec2 = findViewById(R.id.viewSec2);



        dateFormat = new SimpleDateFormat("hhmmss");
        char[] timevalues = dateFormat.format(calendar.getTime()).toCharArray();


        viewHour1.setDigit(timevalues[0]);
        viewHour2.setDigit(timevalues[1]);
        viewMin1.setDigit(timevalues[2]);
        viewMin2.setDigit(timevalues[3]);
        viewSec1.setDigit(timevalues[4]);
        viewSec2.setDigit(timevalues[5]);


        viewDots.setDots();


        handler.postDelayed(this, 500);
            }

        };


        handler.post(runnableCode);
    }


}


