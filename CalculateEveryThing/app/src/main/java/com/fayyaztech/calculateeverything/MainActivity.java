package com.fayyaztech.calculateeverything;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    CardView area,perimeter,volume,time,unit,interest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // binding views
        area = findViewById(R.id.areaCard);
        perimeter = findViewById(R.id.perimiterCard);
        volume = findViewById(R.id.volumeCard);
        time = findViewById(R.id.timeCard);
        interest = findViewById(R.id.interestCard);
        unit = findViewById(R.id.unitCard);

        // click action
        area.setOnClickListener(this);
        perimeter.setOnClickListener(this);
        volume.setOnClickListener(this);
        time.setOnClickListener(this);
        interest.setOnClickListener(this);
        unit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //perform action on click
            case R.id.areaCard:
                startActivity(new Intent(MainActivity.this,Area.class));
                break;
            case R.id.perimiterCard:
                startActivity(new Intent(MainActivity.this,Perimeter.class));
                break;
            case R.id.volumeCard:
                startActivity(new Intent(MainActivity.this,Volume.class));
                break;
            case R.id.timeCard:
                startActivity(new Intent(MainActivity.this,Time.class));
                break;
            case R.id.unitCard:
                startActivity(new Intent(MainActivity.this,UnitConverter.class));
                break;
            case R.id.interestCard:
                startActivity(new Intent(MainActivity.this,Finance.class));
                break;
        }
    }




}
