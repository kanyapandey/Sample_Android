package com.fayyaztech.calculateeverything;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Perimeter extends AppCompatActivity {


    Button cirBtn,triBtn,rectBtn, squBtn;
    CardView cirView, triView, recView, squView;
    Double PI = Math.PI;
    Double width,height,side1,side2,side3,side, radius;
    EditText widthVal,heightVal,side1Val,sideVal,side2Val,side3Val;

    // calc buttons
    Button calcCircle,calcRect,calcTri,calcSqu;
    private String TAG = "AREA CLASS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perimeter);

        // Assigning buttons by id
        cirBtn = findViewById(R.id.circleBtn);
        triBtn = findViewById(R.id.TriangleBtn);
        rectBtn = findViewById(R.id.rectangleBtn);
        squBtn = findViewById(R.id.squareBtn);

        // defining card views by id
        cirView = findViewById(R.id.circleView);
        triView = findViewById(R.id.triangleView);
        recView = findViewById(R.id.rectangleView);
        squView = findViewById(R.id.squareView);

        // show result buttons
        calcCircle = findViewById(R.id.calcCircleBtn);
        calcRect = findViewById(R.id.calcRectBtn);
        calcTri = findViewById(R.id.calcTriBtn);
        calcSqu = findViewById(R.id.calcSquBtn);

        // sides of rectangle
        widthVal = findViewById(R.id.WidthValueRec);
        heightVal = findViewById(R.id.heightValueRec);

        // side of tringle
        side1Val = findViewById(R.id.side1);
        side2Val = findViewById(R.id.side2);
        side3Val = findViewById(R.id.side3);

        //side of square
        sideVal = findViewById(R.id.sideValuesqu);

        // defining button click
        // when click on circle button Hide all views acept circle
        cirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cirView.setVisibility(View.VISIBLE);
                triView.setVisibility(View.GONE);
                recView.setVisibility(View.GONE);
                squView.setVisibility(View.GONE);
            }
        });

        // when click on triangle button

        triBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                triView.setVisibility(View.VISIBLE);
                cirView.setVisibility(View.GONE);
                recView.setVisibility(View.GONE);
                squView.setVisibility(View.GONE);
            }
        });

        // when click on rectriangle button
        rectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recView.setVisibility(View.VISIBLE);
                cirView.setVisibility(View.GONE);
                triView.setVisibility(View.GONE);
                squView.setVisibility(View.GONE);
            }
        });


        // when click on triangle button
        squBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                squView.setVisibility(View.VISIBLE);
                cirView.setVisibility(View.GONE);
                recView.setVisibility(View.GONE);
                triView.setVisibility(View.GONE);
            }
        });


        // perform mathematical operations

//        circle operation

        calcCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText radiusVal = findViewById(R.id.radiusValue);
                if (!radiusVal.getText().toString().matches("")) {
                    radius = Double.parseDouble(radiusVal.getText().toString());
                    double result = 2 * PI * radius;
                    TextView printRes = findViewById(R.id.areaOfCircleResult);

//                string format to print only 2 digit after decimal poing
                    printRes.setText(String.format("%.2f", result));
                }else {
                    Toast.makeText(getApplicationContext(),"Please Enter Radius Value",Toast.LENGTH_SHORT).show();
//                    Log.d(TAG,"Radius Value is empty");
                }

            }
        });

        calcRect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!widthVal.getText().toString().matches("")&&!heightVal.getText().toString().matches("")){
                    width = Double.parseDouble(widthVal.getText().toString());
                    height = Double.parseDouble(heightVal.getText().toString());

                    Double result = 2*(width+height);

                    TextView printRes = findViewById(R.id.areaOfRectangleResult);

                    printRes.setText(String.format("%.2f",result));
                }else{
                    Toast.makeText(getApplicationContext(),"Please Enter Width and Height",Toast.LENGTH_SHORT).show();
                }


            }
        });

        // triangle calculations

        calcTri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!side1Val.getText().toString().matches("")&&!side2Val.getText().toString().matches("")&&!side3Val.getText().toString().matches("")){
                    side1 = Double.parseDouble(side1Val.getText().toString());
                    side2 = Double.parseDouble(side2Val.getText().toString());
                    side3 = Double.parseDouble(side3Val.getText().toString());

                    Double result = side1+side2+side3;

                    TextView printRes = findViewById(R.id.areaOfTrangleResult);

                    printRes.setText(String.format("%.2f",result));
                }else{
                    Toast.makeText(getApplicationContext(),"Please Enter 3 sides of tringle",Toast.LENGTH_SHORT).show();
                }
            }
        });

        calcSqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!sideVal.getText().toString().matches("")){
                    side = Double.parseDouble(sideVal.getText().toString());

                    Double result = 4*side;

                    TextView printRes = findViewById(R.id.areaOfSquareResult);

                    printRes.setText(String.format("%.2f",result));
                }else{
                    Toast.makeText(getApplicationContext(),"Please Enter side of square",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
