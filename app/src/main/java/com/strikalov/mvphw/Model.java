package com.strikalov.mvphw;

import android.util.Log;

public class Model {

    private StringBuilder stringResult;

    public Model(){
        stringResult = new StringBuilder();
    }

    public String add(String string){
        stringResult.append(string);
        return stringResult.toString();
    }

    public String getResult(){
        return stringResult.toString();
    }

}
