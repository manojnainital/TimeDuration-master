package com.msr.timeduration;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by LoopinTechies on 3/7/2017.
 */

public class Message {

    public static void message(Context context , String message){

        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
