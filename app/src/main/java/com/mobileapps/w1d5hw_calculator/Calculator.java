package com.mobileapps.w1d5hw_calculator;

import static com.mobileapps.w1d5hw_calculator.MainActivity.ADD_OP;
import static com.mobileapps.w1d5hw_calculator.MainActivity.NO_OP;
import static com.mobileapps.w1d5hw_calculator.MainActivity.SUB_OP;
import static com.mobileapps.w1d5hw_calculator.MainActivity.MUL_OP;
import static com.mobileapps.w1d5hw_calculator.MainActivity.DIV_OP;

public class Calculator {

//    private static final int NO_OP = 0;
//    private static final int ADD_OP = 1;
//    private static final int SUB_OP = 2;
//    private static final int MUL_OP = 3;
//    private static final int DIV_OP = 4;

    int currOp = 0;
    double Entry = 0.0;
    int DecPos = 0;
    double Result = 0.0; //Holds current result

    public void execute(){
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
}
