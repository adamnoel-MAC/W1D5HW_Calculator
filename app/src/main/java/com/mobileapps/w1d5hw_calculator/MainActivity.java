package com.mobileapps.w1d5hw_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.security.Key;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MAIN ACTIVITY";

    public TextView tvHead;
    public TextView tvDisp;
    private Button btn;
    private String key;
    String tmpzeroes = "";
    int numZeroes = 0;
    String tmpResults = "";

    Calculator calc = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHead = findViewById(R.id.tvHeader);
        tvDisp = findViewById(R.id.tvDisplay);
    }

    public void btnOnClick(View view) {

        Log.d(TAG, "btnOnClick:");
        btn = findViewById(view.getId());
        key = btn.getText().toString();

        // send button to calculator
        calc.btnClick(key);

        // refresh display with calculator states
        numZeroes = calc.getZeroes();
        tmpzeroes = "";        for (int i = 0; i < numZeroes; i++){
            tmpzeroes = tmpzeroes + "0";
        }
        tvDisp.setText(calc.getEntry() + tmpzeroes);


        switch (key) {
            case "+":
            case "-":
            case "x":
            case "/":
                tmpResults = key;
                break;
            default:
                tmpResults = "";
        }
        tvHead.setText(calc.getResult() + tmpResults);


//        tmp = tvDisp.getText().toString();
//        currOp = calc.getCurrOp();
//        tmpEntry = calc.getEntry();
//        tmpDecPos = calc.getDecPos();
//        tmpResult = calc.getResult();
//
//        //Log.d("TAG", "btnOnClick: R.id.btn1: " + R.id.btn1);
//
//        switch (key){
//
//            case "1": case "2": case "3": case "4": case "5": case "6": case "7": case "8": case "9": case "0":
//                if (tmpDecPos > 0) {
//                    calc.setEntry((tmpEntry) + (Double.parseDouble(key) * Math.pow(10, -tmpDecPos)));
//                    tmpDecPos++;
//                    calc.setDecPos(tmpDecPos);
//                } else {
//                    calc.setEntry((tmpEntry * 10.0) + Double.parseDouble(key));
//                }
//                tvDisp.setText(calc.getEntry() + "");
//                break;
//            case ".":
//                if (tmpDecPos == 0) calc.setDecPos(calc.getDecPos() + 1);
//                tvDisp.setText(calc.getEntry() + "");
//                break;
//            case "+":
//                tvHead.setText(key);
//                if (currOp == 0){ // After Start Up OR  After "="
//                    if (tmpEntry > 0) { // Entry in progress
//                        if (tmpResult == 0){ // No Result yet
//                            calc.setResult(tmpEntry);
//                            calc.setEntry(0.0);
//                            calc.setCurrOp(ADD_OP);
//                            tvDisp.setText(calc.getResult() + "");
//                        } else { // Existing Result
//                            calc.setResult(tmpEntry);
//                            calc.setEntry(0.0);
//                            calc.setCurrOp(ADD_OP);
//                            tvDisp.setText(calc.getResult() + "");
//                        }
//                    } else { // No Entry yet)
//                        if (tmpResult > 0) { // Adding to existing Result
//                            calc.setCurrOp(ADD_OP);
//                        } // else since No Result AND No Entry, Do Nothing
//                    }
//                } else if (currOp > 0) { // Operation Key already Hit
//                    if (tmpEntry > 0) { // Entry in progress
//                        if (tmpResult == 0){ // No Result yet
//                            calc.setResult(tmpEntry);
//                            calc.setEntry(0.0);
//                            calc.setCurrOp(ADD_OP);
//                            tvDisp.setText(calc.getResult() + "");
//                        } else { // Existing Result
//                            calc.execute();
//                            calc.setEntry(0.0);
//                            calc.setCurrOp(ADD_OP);
//                            tvDisp.setText(calc.getResult() + "");
//                        }
//                    } else { // No Entry yet)
//                        if (tmpResult > 0) { // Adding to existing Result
//                            calc.setCurrOp(ADD_OP);
//                        } // else since No Result AND No Entry, Do Nothing
//                    }
//                }
//                break;
//            case "-":
//                calc.setCurrOp(SUB_OP);
//                calc.setResult(tmpResult - tmpEntry);
//                break;
//            case "x":
//                calc.setCurrOp(MUL_OP);
//                calc.setResult(tmpResult * tmpEntry);
//                break;
//            case "/":
//                calc.setCurrOp(DIV_OP);
//                calc.setResult(tmpResult / tmpEntry);
//                break;
//            case "=":
//                calc.setCurrOp(NO_OP);
//
//        }
    }
}
