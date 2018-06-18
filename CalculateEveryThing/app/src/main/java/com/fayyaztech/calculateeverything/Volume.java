package com.fayyaztech.calculateeverything;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Volume extends AppCompatActivity{

    private static final String TAG = "VOLUME ACTIVITY";
    CardView cubeView, coneView, cylindarView, pyramidView, sphereView;
    Button cubeBtn,coneBtn,cylBtn,sphareBtn,pyrBtn;
    Button cubeCalc,coneCalc,cylCalc,sphareCalc,pyrCalc;
    EditText cubeSide,coneRadius,coneHeight,pyrLen,pyrHei,pyrWid,cylHei,cylRad,sphRad;
    TextView cubeRes,coneRes,pyrRes,cylRes,sphRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

        //print result text views
        cubeRes = findViewById(R.id.cubeResult);
        coneRes = findViewById(R.id.coneResult);
        pyrRes = findViewById(R.id.pyramidResult);
        cylRes = findViewById(R.id.cylinderResult);
        sphRes = findViewById(R.id.sphareResult);

        //edit text value
        cubeSide = findViewById(R.id.cubeRadius);
        coneRadius = findViewById(R.id.coneRadius);
        coneHeight = findViewById(R.id.coneHeight);
        pyrLen = findViewById(R.id.pyramidLength);
        pyrHei = findViewById(R.id.pyramidHeight);
        pyrWid = findViewById(R.id.pyramidWidth);
        cylHei = findViewById(R.id.cylinderHeight);
        cylRad = findViewById(R.id.cylinderRadius);
        sphRad = findViewById(R.id.sphareRadius);


        //card views
        cubeView = findViewById(R.id.cubeView);
        coneView = findViewById(R.id.coneView);
        cylindarView = findViewById(R.id.cylinderView);
        sphereView = findViewById(R.id.sphereView);
        pyramidView = findViewById(R.id.pyramidView);

        //menu buttons
        cubeBtn = findViewById(R.id.cubeBtn);
        coneBtn = findViewById(R.id.coneBtn);
        cylBtn = findViewById(R.id.cylinderBtn);
        sphareBtn = findViewById(R.id.sphereBtn);
        pyrBtn = findViewById(R.id.pyramidBtn);

        // calculation buttons

        cubeCalc = findViewById(R.id.cubeCalc);
        coneCalc = findViewById(R.id.coneCalc);
        cylCalc = findViewById(R.id.cylCalc);
        sphareCalc = findViewById(R.id.sphareCalc);
        pyrCalc = findViewById(R.id.pyrCalc);

        // onclick view cards
        // cube on click
        cubeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cubeView.setVisibility(View.VISIBLE);
                coneView.setVisibility(View.GONE);
                cylindarView.setVisibility(View.GONE);
                sphereView.setVisibility(View.GONE);
                pyramidView.setVisibility(View.GONE);
            }
        });

        //cone button click
        coneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cubeView.setVisibility(View.GONE);
                coneView.setVisibility(View.VISIBLE);
                cylindarView.setVisibility(View.GONE);
                sphereView.setVisibility(View.GONE);
                pyramidView.setVisibility(View.GONE);
            }
        });

        //cylinder click

        cylBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cubeView.setVisibility(View.GONE);
                coneView.setVisibility(View.GONE);
                cylindarView.setVisibility(View.VISIBLE);
                sphereView.setVisibility(View.GONE);
                pyramidView.setVisibility(View.GONE);
            }
        });

        //sphare button on clicked
        sphareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cubeView.setVisibility(View.GONE);
                coneView.setVisibility(View.GONE);
                cylindarView.setVisibility(View.GONE);
                sphereView.setVisibility(View.VISIBLE);
                pyramidView.setVisibility(View.GONE);
            }
        });

        //pyramid button clicked
        pyrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cubeView.setVisibility(View.GONE);
                coneView.setVisibility(View.GONE);
                cylindarView.setVisibility(View.GONE);
                sphereView.setVisibility(View.GONE);
                pyramidView.setVisibility(View.VISIBLE);
            }
        });



        // mathematical oprations

        //cube calculation
        cubeCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cubeSide.getText().toString().matches("")) {
                    Double side = Double.parseDouble(cubeSide.getText().toString());
                    Double result = side * side * side;
                    Log.d(TAG, "result is =" + result);
                    cubeRes.setText(String.format("%.2f", result));
                }else{
                    Toast.makeText(getApplicationContext(),"Please enter side value",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //cone calculation
        coneCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!coneHeight.getText().toString().matches("")&&!coneRadius.getText().toString().matches("")) {
                    Double height = Double.parseDouble(coneHeight.getText().toString());
                    Double radius = Double.parseDouble(coneRadius.getText().toString());
                    Double result = Math.PI*radius*radius*height/3;
                    Log.d(TAG, "result is =" + result);
                    coneRes.setText(String.format("%.2f", result));
                }else{
                    Toast.makeText(getApplicationContext(),"Please enter value in all fields",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //cube calculation
        pyrCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!pyrHei.getText().toString().matches("")&&!pyrLen.getText().toString().matches("")&&!pyrWid.getText().toString().matches("")) {
                    Double height = Double.parseDouble(pyrHei.getText().toString());
                    Double length = Double.parseDouble(pyrLen.getText().toString());
                    Double width = Double.parseDouble(pyrWid.getText().toString());
                    Double result = height*length*width/3;
                    Log.d(TAG, "result is =" + result);
                    pyrRes.setText(String.format("%.2f", result));
                }else{
                    Toast.makeText(getApplicationContext(),"Please enter side value",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //cube calculation
        cylCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!cylHei.getText().toString().matches("")&&!cylRad.getText().toString().matches("")) {
                    Double height = Double.parseDouble(cylHei.getText().toString());
                    Double radius = Double.parseDouble(cylRad.getText().toString());
                    Double result = Math.PI*radius*radius*height;
                    Log.d(TAG, "result is =" + result);
                    cylRes.setText(String.format("%.2f", result));
                }else{
                    Toast.makeText(getApplicationContext(),"Please enter side value",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //cube calculation
        sphareCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!sphRad.getText().toString().matches("")) {
                    Double radius = Double.parseDouble(sphRad.getText().toString());
                    Double result = 4*Math.PI*radius*radius*radius/3;
                    Log.d(TAG, "result is =" + result);
                    sphRes.setText(String.format("%.2f", result));
                }else{
                    Toast.makeText(getApplicationContext(),"Please enter side value",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
