package com.mobileapps.w1d5hw_calculator;

import android.content.Context;
import android.util.Log;

public class Calculator {

    public static final String TAG = "CALCULATOR";

    private static final int NO_OP = 0;
    private static final int ADD_OP = 1;
    private static final int SUB_OP = 2;
    private static final int MUL_OP = 3;
    private static final int DIV_OP = 4;


    private int currOp = NO_OP;
    private double Entry = 0.0;
    private int DecPos = 0;
    private int zeroes = 0;
    private double Result = 0.0; //Holds current result
    private String key = "";
    private String lastKey = "";
    private int keyValue = 0;

    private int tmpCurrOp;
    private double tmpEntry;
    private int tmpDecPos;
    private double tmpResult;

    public Calculator() {
    }

    public void btnClick (String key) {
        Log.d(TAG, "btnClick: key: " + key);

        // Get current state of things
        tmpEntry = this.Entry;
        tmpResult = this.Result;
        tmpCurrOp = this.currOp;
        tmpDecPos = this.DecPos;

        switch (key) {
            case "C":
                Result = 0.0;
                currOp = 0;
            case "CE":
                Entry = 0.0;
                DecPos = 0;
                zeroes = 0;
                break;
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                if (tmpDecPos > 0) {
                    Entry = tmpEntry + (Double.parseDouble(key) * Math.pow(10, -tmpDecPos));
                    zeroes = 0;
                    DecPos++;
                    Log.d(TAG, "btnClick: Entry: " + Entry + "; DecPos: " + DecPos);
                } else {
                    Entry = (tmpEntry * 10.0) + Double.parseDouble(key);
                }
                Log.d(TAG, "btnClick (key: 1-9): Entry: " + Entry + "; DecPos: " + DecPos);
                break;
            case "0":
                if (tmpDecPos > 0) {
                    zeroes++;
                    DecPos++;
                    Log.d(TAG, "btnClick: Entry: " + Entry + "; DecPos: " + DecPos);
                } else {
                    Entry = (tmpEntry * 10.0);
                }
                Log.d(TAG, "btnClick (key=0): Entry: " + Entry + "; DecPos: " + DecPos);
                break;
            case ".":
                if (tmpDecPos == 0) DecPos++;
                break;
            case "+":
                if (Entry != 0.0){
                    if (currOp > 0) execute();
                    else {
                        setResult(getEntry());
                        setEntry(0.0);
                    }
                }
                currOp = ADD_OP;
                break;
            case "-":
                if (Entry != 0.0){
                    if (currOp > 0) execute();
                    else {
                        setResult(getEntry());
                        setEntry(0.0);
                    }
                }
                currOp = SUB_OP;
                break;
            case "x":
                if (Entry != 0.0){
                    if (currOp > 0) execute();
                    else {
                        setResult(getEntry());
                        setEntry(0.0);
                    }
                }
                currOp = MUL_OP;
                break;
            case "/":
                if (Entry != 0.0){
                    if (currOp > 0) execute();
                    else {
                        setResult(getEntry());
                        setEntry(0.0);
                    }
                }
                currOp = DIV_OP;
                break;
            case "=":
                if (currOp > 0) {
                    execute();
                }
                currOp = 0;
                //setEntry(getResult());
                DecPos = 0;
                zeroes = 0;
                break;
            case "+/-":
                setEntry(Entry * -1.0);
                break;
        }
        Log.d(TAG, "btnClick: Entry: " + Entry + "; Result: " + Result + "; CurrOp: " + currOp + "; DecPos: " + DecPos);
    }

    public void execute(){
        Log.d(TAG, "execute: CurrOp: " + currOp);
        switch (this.currOp){
            case ADD_OP:
                this.Result = this.Result + this.Entry;
                break;
            case SUB_OP:
                this.Result = this.Result - this.Entry;
                break;
            case MUL_OP:
                this.Result = this.Result * this.Entry;
                break;
            case DIV_OP:
                this.Result = this.Result / this.Entry;
        }
        this.Entry = 0.0;
        this.currOp = NO_OP;
    }

    public double getEntry() {
        return Entry;
    }

    public void setEntry(double entry) {
        Entry = entry;
    }

    public int getDecPos() {
        return DecPos;
    }

    public void setDecPos(int decPos) {
        DecPos = decPos;
    }

    public int getCurrOp() {
        return currOp;
    }

    public void setCurrOp(int currOp) {
        this.currOp = currOp;
    }

    public double getResult() {
        return Result;
    }

    public void setResult(double result) {
        Result = result;
    }

    public int getZeroes() {
        return zeroes;
    }

    public void setZeroes(int zeroes) {
        this.zeroes = zeroes;
    }
}
