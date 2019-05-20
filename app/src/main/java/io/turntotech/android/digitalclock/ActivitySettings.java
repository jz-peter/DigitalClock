package io.turntotech.android.digitalclock;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class ActivitySettings extends AppCompatActivity {

    Button btnRed;
    Button btnOrange;
    Button btnYellow;
    Button btnGreen;
    Button btnBlue;
    Switch switch24hr;
    TextView txtViewDisplayColor;
    TextView txtViewTimeZone;
    ListView listViewTimeZone;
    ArrayAdapter arrayAdapter;

    SharedPreferences sharedPrefs;
    int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        btnRed = findViewById(R.id.btnRed);
        btnOrange = findViewById(R.id.btnOrange);
        btnYellow = findViewById(R.id.btnYellow);
        btnGreen = findViewById(R.id.btnGreen);
        btnBlue = findViewById(R.id.btnBlue);
        txtViewDisplayColor = findViewById(R.id.txtViewDisplayColor);
        txtViewTimeZone = findViewById(R.id.txtViewTimeZone);
        listViewTimeZone = findViewById(R.id.listViewTimeZone);
        switch24hr = findViewById(R.id.switch24hr);


        //Keep current Display Color button selected:
        int idOfSelectedButton;
        sharedPrefs = getSharedPreferences("settings", MODE_PRIVATE);
        idOfSelectedButton = sharedPrefs.getInt("btnColor",R.id.btnRed);

        Button btnSelect = findViewById(idOfSelectedButton);
        btnSelect.setSelected(true);

        //Keep 24 Hour Switch state selected:
        boolean switchValue;
        sharedPrefs = getSharedPreferences("settings",MODE_PRIVATE);
        switchValue = sharedPrefs.getBoolean("isChecked",false);
        switch24hr.setChecked(switchValue);


        //Create OnClickListener for switch:
        switch24hr.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                boolean on = ((Switch) v).isChecked(); //if switch is on, the time is 24hr format:
                SharedPreferences.Editor editor = sharedPrefs.edit();

                if (on) {
                    editor.putString("pattern", "HHmmss");
                    editor.putBoolean("isChecked",true);

                } else {
                    editor.putString("pattern", "hhmmss");
                    editor.putBoolean("isChecked",false);
                }

                editor.commit();

            }
        });


        //Create List of Cities:
        final List<City> cityList = new ArrayList<>();
        cityList.add(new City("New York City"));
        cityList.add(new City("Dubai"));
        cityList.add(new City("Sydney"));


        //Create adapter to display list of cities
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice
                , cityList);

        position = sharedPrefs.getInt("cityPosition",0);

        listViewTimeZone.setAdapter(arrayAdapter);
        listViewTimeZone.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listViewTimeZone.setItemChecked(position,true);



        sharedPrefs = getSharedPreferences("settings", MODE_PRIVATE);

        //Set OnItemClickListener for selected city:
        listViewTimeZone.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                City cityName = cityList.get(position);

                if (position == 0) {
                    SharedPreferences.Editor editor = sharedPrefs.edit();
                    editor.putString("cityTime", "US/Eastern");
                    editor.putInt("cityPosition", 0);

                    editor.commit();

                } else if (position == 1) {
                    SharedPreferences.Editor editor = sharedPrefs.edit();
                    editor.putString("cityTime", "Asia/Dubai");
                    editor.putInt("cityPosition", 1);

                    editor.commit();

                } else if (position == 2) {
                    SharedPreferences.Editor editor = sharedPrefs.edit();
                    editor.putString("cityTime", "Australia/Sydney");
                    editor.putInt("cityPosition", 2);

                    editor.commit();
                }

            }

        });

    }

    //Display Color Button clicks:
    public void clickRed(View view) {

        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("color", R.color.colorRed);
        editor.putInt("btnColor",R.id.btnRed);

        editor.commit();

        Toast.makeText(this, "Red Selected", Toast.LENGTH_LONG)
                .show();

        btnRed.setSelected(true);
        btnOrange.setSelected(false);
        btnYellow.setSelected(false);
        btnGreen.setSelected(false);
        btnBlue.setSelected(false);
    }

    public void clickOrange(View view) {

        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("color", R.color.colorOrange);
        editor.putInt("btnColor",R.id.btnOrange);

        editor.commit();

        Toast.makeText(this, "Orange Selected", Toast.LENGTH_LONG)
                .show();

        btnRed.setSelected(false);
        btnOrange.setSelected(true);
        btnYellow.setSelected(false);
        btnGreen.setSelected(false);
        btnBlue.setSelected(false);
    }

    public void clickYellow(View view) {

        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("color", R.color.colorYellow);
        editor.putInt("btnColor",R.id.btnYellow);

        editor.commit();

        Toast.makeText(this, "Yellow Selected", Toast.LENGTH_LONG)
                .show();

        btnRed.setSelected(false);
        btnOrange.setSelected(false);
        btnYellow.setSelected(true);
        btnGreen.setSelected(false);
        btnBlue.setSelected(false);
    }

    public void clickGreen(View view) {

        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("color", R.color.colorGreen);
        editor.putInt("btnColor",R.id.btnGreen);

        editor.commit();

        Toast.makeText(this, "Green Selected", Toast.LENGTH_LONG)
                .show();

        btnRed.setSelected(false);
        btnOrange.setSelected(false);
        btnYellow.setSelected(false);
        btnGreen.setSelected(true);
        btnBlue.setSelected(false);
    }

    public void clickBlue(View view) {

        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("color", R.color.colorBlue);
        editor.putInt("btnColor",R.id.btnBlue);

        editor.commit();

        Toast.makeText(this, "Blue Selected", Toast.LENGTH_LONG)
                .show();

        btnRed.setSelected(false);
        btnOrange.setSelected(false);
        btnYellow.setSelected(false);
        btnGreen.setSelected(false);
        btnBlue.setSelected(true);

    }

}


