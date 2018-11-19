package com.mobileapps.w1d5hw_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.security.Key;

public class MainActivity extends AppCompatActivity {

    public TextView tvHead;
    public TextView tvDisp;
    private double tmpEntry;
    private int tmpDecPos;
    private double tmpResult;
    private Button btn;
    private String key;
    private int currOp;

    public static final int NO_OP = 0;
    public static final int ADD_OP = 1;
    public static final int SUB_OP = 2;
    public static final int MUL_OP = 3;
    public static final int DIV_OP = 4;

    Calculator calc = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHead = findViewById(R.id.tvHeader);
        tvDisp = findViewById(R.id.tvDisplay);

        calc.setEntry(0.0);
        calc.setResult(0.0);
        calc.setDecPos(0);
        calc.setCurrOp(NO_OP);

   }

    public void btnOnClick(View view) {

//        tmp = tvDisp.getText().toString();
        currOp = calc.getCurrOp();
        tmpEntry = calc.getEntry();
        tmpDecPos = calc.getDecPos();
        tmpResult = calc.getResult();
        btn = findViewById(view.getId());
        key = btn.getText().toString();

        //Log.d("TAG", "btnOnClick: R.id.btn1: " + R.id.btn1);
        Log.d("TAG", "btnOnClick: key: " + key);

        switch (key){

            case "1": case "2": case "3": case "4": case "5": case "6": case "7": case "8": case "9": case "0":
                if (tmpDecPos > 0) {
                    calc.setEntry((tmpEntry) + (Double.parseDouble(key) * Math.pow(10, -tmpDecPos)));
                    tmpDecPos++;
                    calc.setDecPos(tmpDecPos);
                } else {
                    calc.setEntry((tmpEntry * 10.0) + Double.parseDouble(key));
                }
                tvDisp.setText(calc.getEntry() + "");
                break;
            case ".":
                if (tmpDecPos == 0) calc.setDecPos(calc.getDecPos() + 1);
                tvDisp.setText(calc.getEntry() + "");
                break;
            case "+":
                tvHead.setText(key);
                if (currOp == 0){ // After Start Up OR  After "="
                    if (tmpEntry > 0) { // Entry in progress
                        if (tmpResult == 0){ // No Result yet
                            calc.setResult(tmpEntry);
                            calc.setEntry(0.0);
                            calc.setCurrOp(ADD_OP);
                            tvDisp.setText(calc.getResult() + "");
                        } else { // Existing Result
                            calc.setResult(tmpEntry);
                            calc.setEntry(0.0);
                            calc.setCurrOp(ADD_OP);
                            tvDisp.setText(calc.getResult() + "");
                        }
                    } else { // No Entry yet)
                        if (tmpResult > 0) { // Adding to existing Result
                            calc.setCurrOp(ADD_OP);
                        } // else since No Result AND No Entry, Do Nothing
                    }
                } else if (currOp > 0) { // Operation Key already Hit
                    if (tmpEntry > 0) { // Entry in progress
                        if (tmpResult == 0){ // No Result yet
                            calc.setResult(tmpEntry);
                            calc.setEntry(0.0);
                            calc.setCurrOp(ADD_OP);
                            tvDisp.setText(calc.getResult() + "");
                        } else { // Existing Result
                            calc.execute();
                            calc.setEntry(0.0);
                            calc.setCurrOp(ADD_OP);
                            tvDisp.setText(calc.getResult() + "");
                        }
                    } else { // No Entry yet)
                        if (tmpResult > 0) { // Adding to existing Result
                            calc.setCurrOp(ADD_OP);
                        } // else since No Result AND No Entry, Do Nothing
                    }
                }
                break;
            case "-":
                calc.setCurrOp(SUB_OP);
                calc.setResult(tmpResult - tmpEntry);
                break;
            case "x":
                calc.setCurrOp(MUL_OP);
                calc.setResult(tmpResult * tmpEntry);
                break;
            case "/":
                calc.setCurrOp(DIV_OP);
                calc.setResult(tmpResult / tmpEntry);
                break;
            case "=":
                calc.setCurrOp(NO_OP);

        }
    }
}
