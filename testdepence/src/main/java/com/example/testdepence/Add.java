package com.example.testdepence;

import android.util.Log;

public class Add {
    private final static String TAG = "Add";
    private static Add add = null;
    static {
        System.loadLibrary("anclivejni");
    }

    public static Add getInstance(){
        Log.d(TAG, "getInstance: ");
        if (add == null){
            add = new Add();
        }
        return add;
    }
    
    public native void init(byte[] data);


}
