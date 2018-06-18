package com.fayyaztech.calculateeverything;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class UnitConverter extends AppCompatActivity {

    private static final String TAG = "UnitConverter";
    Spinner distSpinner1,distSpinner2,liqSpinner1,liqSpinner2,weiSpinner1,weiSpinner2,tempSpinner1,tempSpinner2;
    EditText distVal,liqVal,weiVal,tempVal;
    Button distCalc,distBtn,liqbtn,liqCalc,weiBtn,weiCalc,tempBtn,tempCalc;
    Double num2;
    TextView distResultView,liqResultView,weiResultView,tempResultView;

    // card view button
    CardView distView,liqView,weiView,tempView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter);

        // card view Clicks
        ViewCardOnClick();

        distanceUnitCalculator();
        LiquidUnitCalculatator();
        weightUnitCalculator();
        tempretureCalculatot();


    }

    private void ViewCardOnClick() {
        distView = findViewById(R.id.distView);
        liqView = findViewById(R.id.liquidView);
        weiView = findViewById(R.id.weightView);
        tempView = findViewById(R.id.tempView);

        //buttons
        distBtn = findViewById(R.id.distanceBtn);
        liqbtn = findViewById(R.id.liquidBtn);
        weiBtn = findViewById(R.id.weightBtn);
        tempBtn = findViewById(R.id.tempratureBtn);

        // onclick listener
        distBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                distView.setVisibility(View.VISIBLE);
                liqView.setVisibility(View.GONE);
                weiView.setVisibility(View.GONE);
                tempView.setVisibility(View.GONE);
            }
        });

        // liquid
        liqbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liqView.setVisibility(View.VISIBLE);
                distView.setVisibility(View.GONE);
                weiView.setVisibility(View.GONE);
                tempView.setVisibility(View.GONE);
            }
        });

        //weight
        weiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liqView.setVisibility(View.GONE);
                distView.setVisibility(View.GONE);
                weiView.setVisibility(View.VISIBLE);
                tempView.setVisibility(View.GONE);
            }
        });

        tempBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liqView.setVisibility(View.GONE);
                distView.setVisibility(View.GONE);
                weiView.setVisibility(View.GONE);
                tempView.setVisibility(View.VISIBLE);
            }
        });
    }

    private void tempretureCalculatot() {
        tempSpinner1 = findViewById(R.id.tempSpring1);
        tempSpinner2 = findViewById(R.id.tempSpring2);

        tempCalc = findViewById(R.id.tempCalcBtn);
        tempVal = findViewById(R.id.tempVal);
        tempResultView = findViewById(R.id.tempResult);

        tempCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String originalUnit = tempSpinner1.getSelectedItem().toString().toLowerCase();
                String newUnit = tempSpinner2.getSelectedItem().toString().toLowerCase();

                Double num1;
                if (tempVal.getText().toString().matches("")){
                    num1=1.0;
                }else{
                    num1 = Double.parseDouble(tempVal.getText().toString());
                }

                switch (originalUnit){
                    case "celsius":
                        switch (newUnit){
                            case "celsius":
                                num2 = num1;
                                break;
                            case "farhenheit":
                                num2 = num1*33.8;
                                break;
                            case "kelvin":
                                num2 = num1*274.15;
                                break;
                        }
                        break;
                    case "farhenheit":
                        switch (newUnit){
                            case "celsius":
                                num2 = num1*-17.2222;
                                break;
                            case "farhenheit":
                                num2 = num1;
                                break;
                            case "kelvin":
                                num2 = num1*255.9278;
                                break;
                        }
                        break;
                    case "kelvin":
                        switch (newUnit){
                            case "celsius":
                                num2 = num1*-272.15;
                                break;
                            case "farhenheit":
                                num2 = num1*-457.87;
                                break;
                            case "kelvin":
                                num2 = num1;
                                break;
                        }
                        break;


                }

            }
        });
    }

    private void weightUnitCalculator() {
        weiSpinner1 = findViewById(R.id.weiSpring1);
        weiSpinner2 = findViewById(R.id.weiSpring2);

        weiCalc = findViewById(R.id.weiCalcBtn);
        weiVal = findViewById(R.id.weiVal);
        weiResultView = findViewById(R.id.weiResult);

        //calulation
        weiCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String originalUnit = weiSpinner1.getSelectedItem().toString().toLowerCase();
                String newUnit = weiSpinner2.getSelectedItem().toString().toLowerCase();

                Double num1;
                if (weiVal.getText().toString().matches("")){
                   num1=1.0;
                }else{
                    num1 = Double.parseDouble(weiVal.getText().toString());
                }

                Log.d(TAG,"num1 value "+num1+" original unit :"+originalUnit+" New unit ::"+newUnit);
                switch (originalUnit){
                    case "gram":
                        switch (newUnit){
                            case "gram":
                                num2 = num1;
                                break;
                            case "kilogram":
                                num2 = num1*1000;
                                break;
                            case "quintal":
                                num2 = num1*100000;
                                break;
                            case "tonne":
                                num2 = num1*1e+6;
                                break;
                                }
                                break;
                    case "kilogram":
                        switch (newUnit){
                            case "gram":
                                num2 = num1*1000;
                                break;
                            case "kilogram":
                                num2 = num1;
                                break;
                            case "quintal":
                                num2 = num1*100;
                                break;
                            case "tonne":
                                num2 = num1*1000;
                                break;
                        }
                        break;
                    case "quintal":
                        switch (newUnit){
                            case "gram":
                                num2 = num1*1e-5;
                                break;
                            case "kilogram":
                                num2 = num1*0.001;
                                break;
                            case "quintal":
                                num2 = num1;
                                break;
                            case "tonne":
                                num2 = num1*1e-6;
                                break;
                        }
                        break;
                    case "tonne":
                        switch (newUnit){
                            case "gram":
                                num2 = num1*1e+6;
                                break;
                            case "kilogram":
                                num2 = num1*1000;
                                break;
                            case "quintal":
                                num2 = num1*10;
                                break;
                            case "tonne":
                                num2 = num1;
                                break;
                        }
                        break;
                }
                Log.d(TAG,num2+" mum 2 value");
                weiResultView.setText(num2.toString()+" "+newUnit);
            }
        });

    }

    private void LiquidUnitCalculatator() {
        liqSpinner1 = findViewById(R.id.liqSpring1);
        liqSpinner2 = findViewById(R.id.liqSpring2);
        liqCalc = findViewById(R.id.liqCalcBtn);
        liqVal = findViewById(R.id.liqVal);
        liqResultView = findViewById(R.id.liqResult);

        // calculate value
        liqCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String originalUnit = liqSpinner1.getSelectedItem().toString().toLowerCase();
                String newUnit = liqSpinner2.getSelectedItem().toString().toLowerCase();

                Double num1;
                if (liqVal.getText().toString().matches("")){
                    num1=1.0;
                }else{
                    num1 = Double.parseDouble(liqVal.getText().toString());
                }

                switch (originalUnit){
                    case "liter":
                        switch (newUnit){
                            case "liter":
                                num2 = num1;
                                break;
                            case "milliliter":
                                num2 = num1*1000;
                                break;
                        }
                        break;
                    case "milliliter":
                        switch (newUnit){
                            case "milliliter":
                                num2 = num1;
                                break;
                            case "liter":
                                num2 = num1/1000;
                                break;
                        }
                        break;

                }
                liqResultView.setText(num2.toString());
            }
        });

    }

    private void distanceUnitCalculator() {
        distSpinner1 = findViewById(R.id.distSpring1);
        distSpinner2 = findViewById(R.id.distSpring2);
        distCalc = findViewById(R.id.distCalcBtn);
        distVal = findViewById(R.id.distVal);
        distResultView = findViewById(R.id.distResult);

        // unit to uits


//        get select drop down list value

        distCalc.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                String originalUnit = distSpinner1.getSelectedItem().toString();
                String original = originalUnit.toLowerCase();
                String newU = distSpinner2.getSelectedItem().toString().toLowerCase();
//                Double num1 = Double.parseDouble(distVal.getText().toString());

                Double num1;
                if (distVal.getText().toString().matches("")){
                    num1=1.0;
                }else{
                    num1 = Double.parseDouble(distVal.getText().toString());
                }

                Log.d(TAG,newU);
                switch(original)
                {
                    case "inches":
                    {
                        switch(newU)
                        {
                            case "inches":
                                num2 = num1;
                                break;
                            case "feet":

                                num2 = num1 / 12.0d;
                                break;
                            case "yards":

                                num2 = num1 / 36.0d;
                                break;
                            case "miles":

                                num2 = num1 / 63360.0d;
                                break;
                            case "millimeters":

                                num2 = num1 * 25.4d;
                                break;
                            case "centimeters":

                                num2 = num1 * 2.54d;
                                break;
                            case "meters":

                                num2 = num1 * 0.0254d;
                                break;
                            case "kilometers":

                                num2 = num1 * 0.0000254d;
                                break;
                        }
                        break;
                    }
                    case "feet":
                    {
                        switch(newU)
                        {
                            case "inches":

                                num2 = num1*12.0d;
                                break;
                            case "feet":
                                num2 = num1;
                                break;
                            case "yards":

                                num2 = num1/3.0d;
                                break;
                            case "miles":

                                num2 = num1/5280.0d;
                                break;
                            case "millimeters":

                                num2 = num1*304.8d;
                                break;
                            case "centimeters":

                                num2 = num1*30.48d;
                                break;
                            case "meters":

                                num2 = num1*0.3048d;
                                break;
                            case "kilometers":

                                num2 = num1*0.0003048d;
                                break;
                        }
                        break;
                    }
                    case "yards":
                    {
                        switch(newU) {
                            case "inches":

                                num2 = num1 * 36.0d;
                                break;
                            case "feet":

                                num2 = num1 * 3.0d;
                                break;
                            case "yards":
                                num2 = num1;
                                break;
                            case "miles":

                                num2 = num1 / 1760.0d;
                                break;
                            case "millimeters":

                                num2 = num1 * 914.4d;
                                break;
                            case "centimeters":

                                num2 = num1*91.44d;
                                break;
                            case "meters":
                                num2 = num1*0.9144d;
                                break;
                            case "kilometers":

                                num2 = num1/1093.61d;
                                break;
                        }
                        break;
                    }
                    case "miles":
                    {
                        switch(newU)
                        {
                            case "inches":

                                num2 = num1*6330.0d;
                                break;
                            case "feet":

                                num2 = num1*5280.0d;
                                break;
                            case "yards":

                                num2 = num1*1760.0d;
                                break;
                            case "miles":
                                num2 = num1;
                                break;
                            case "millimeters":

                                num2 = num1*1609340.0d;
                                break;
                            case "centimeters":

                                num2 = num1*160934.0d;
                                break;
                            case "meters":

                                num2 = num1*1609.34d;
                                break;
                            case "kilometers":

                                num2 = num1*1.60934d;
                                break;
                        }
                        break;
                    }
                    case "millimeters":
                    {
                        switch(newU)
                        {
                            case "inches":
                                num2 = num1*25.4d;
                                break;
                            case "feet":
                                num2 = num1/304.8d;
                                break;
                            case "yards":
                                num2 = num1/914.4d;
                                break;
                            case "miles":
                                num2 = num1/1609000.0d;
                                break;
                            case "millimeters":
                                num2 = num1;
                                break;
                            case "centimeters":
                                num2 = num1/10;
                                break;
                            case "meters":
                                num2 = num1/1000;
                                break;
                            case "kilometers":
                                num2 = num1/100000;
                                break;
                        }
                        break;
                    }

                    case "centimeters":
                    {
                        switch(newU)
                        {
                            case "inches":
                                num2 = num1 / 2.54d;
                                break;
                            case "feet":
                                num2 = num1 / 30.48d;
                                break;
                            case "yards":
                                num2 = num1 / 91.44d;
                                break;
                            case "miles":
                                num2 = num1/160934.0d;
                                break;
                            case "millimeters":
                                num2 = num1*10;
                                break;
                            case "centimeters":
                                num2 = num1;
                                break;
                            case "meters":
                                num2 = num1*100;
                                break;
                            case "kilometers":
                                num2 = num1*10000;
                                break;
                        }
                        break;
                    }
                    case "meters":
                    {
                        switch(newU) {
                            case "inches":
                                num2 = num1 * 39.3701d;
                                break;
                            case "feet":
                                num2 = num1 * 3.28084d;
                                break;
                            case "yards":
                                num2 = num1*1.09361d;
                                break;
                            case "miles":
                                num2 = num1/1609.34d;
                                break;
                            case "millimeters":
                                num2 = num1*1000;
                                break;
                            case "centimeters":
                                num2 = num1*100;
                                break;
                            case "meters":
                                num2 = num1;
                                break;
                            case "kilometers":
                                num2 = num1/1000;
                                break;
                        }
                        break;
                    }
                    case "kilometers":
                    {
                        switch(newU)
                        {
                            case "inches":
                                num2 = num1*39370.1d;
                                break;
                            case "feet":
                                num2 = num1*3280.84d;
                                break;
                            case "yards":
                                num2 = num1*1093.61d;
                                break;
                            case "miles":
                                num2 = num1/1.60934d;
                                break;
                            case "millimeters":
                                num2 = num1*1e+6;
                                break;
                            case "centimeters":
                                num2 =num1*100000;
                                break;
                            case "meters":
                                num2 = num1*1000;
                                break;
                            case "kilometers":
                                num2 = num1;
                                break;
                        }
                        break;
                    }
                }

                distResultView.setText(num2.toString());
            }
            });
        }
}

