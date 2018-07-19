package com.msr.timeduration;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeDurationActivity extends AppCompatActivity {
    Button bt_hour_up, bt_hour_down, bt_minute_up, bt_minute_down;
    Button bt_hour_up1, bt_hour_down1, bt_minute_up1, bt_minute_down1;

    TextView tv_hour_in, tv_minute_in;
    TextView tv_hour_out, tv_minute_out;

    TextView tv_in_am, tv_in_pm;
    TextView tv_out_am, tv_out_pm;

    public static String formattedDate;

    Button bt_save;

    int counter_clock_in = 12;
    int counter_clock_out = 12;
    int counter_clock_in_min=0;
    int counter_clock_out_min=0;

    public static String InAMPM = "AM";
    public static String OutAMPM = "AM";
    public static String Time_Duration = " ";
    public static String st_difference_hour = "";
    public static String st_difference_minute = "";
    public static String TIME_START = " ";
    public static String TIME_END = " ";

    int button_counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_duration);
        ItemId();

        bt_save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TimeSet();
                Message.message(getApplicationContext(),Time_Duration+" hours");
                if(TimeSet()<0){
                    Message.message(getApplicationContext(),"Error!");
                }
                else if(TIME_START.equals(TIME_END)){
                    Message.message(getApplicationContext(),"Select different time!");
                }
                else{

                    if(TIME_START == null||TIME_START.equals("start_time")){
                        Message.message(getApplicationContext(), "Select Time");

                    }
                    else {
                        Calendar c = Calendar.getInstance();
                        System.out.println("Current time => " + c.getTime());

                        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                        formattedDate = df.format(c.getTime());
                        Log.d("Tested", formattedDate);
                    }
                }
            }
        });

        tv_in_am.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InAMPM = "AM";
                tv_in_am  .setTextColor(Color.parseColor("#009cff"));
                tv_in_pm.setTextColor(Color.parseColor("#d3d3d3"));
            }
        });
        tv_in_pm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InAMPM = "PM";
                tv_in_pm .setTextColor(Color.parseColor("#009cff"));
                tv_in_am  .setTextColor(Color.parseColor("#d3d3d3"));
            }
        });

        tv_out_am.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OutAMPM = "AM";
                tv_out_am.setTextColor(Color.parseColor("#009cff"));
                tv_out_pm.setTextColor(Color.parseColor("#d3d3d3"));
            }
        });
        tv_out_pm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OutAMPM = "PM";
                tv_out_pm.setTextColor(Color.parseColor("#009cff"));
                tv_out_am.setTextColor(Color.parseColor("#d3d3d3"));
            }
        });

        bt_hour_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counter_clock_in++;
                if(counter_clock_in>12){
                    counter_clock_in=1;
                }
                if(counter_clock_in==10||counter_clock_in==11||counter_clock_in==12){
                    tv_hour_in.setText(counter_clock_in+"");
                }else{
                    tv_hour_in.setText("0"+counter_clock_in+"");
                }

            }
        });
        bt_hour_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter_clock_in--;
                if(counter_clock_in<1){
                    counter_clock_in=12;
                }
                if(counter_clock_in==10||counter_clock_in==11||counter_clock_in==12){
                    tv_hour_in.setText(counter_clock_in+"");
                }else{
                    tv_hour_in.setText("0"+counter_clock_in+"");
                }
            }
        });

        bt_minute_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter_clock_in_min += 15;

                if(counter_clock_in_min>59){
                    counter_clock_in_min=0;
                }
                if(counter_clock_in_min==0){
                    tv_minute_in.setText("0"+counter_clock_in_min+"");
                }else {
                    tv_minute_in.setText(counter_clock_in_min + "");
                }
            }
        });

        bt_minute_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter_clock_in_min -= 15;
                if(counter_clock_in_min<0){
                    counter_clock_in_min=45;
                }
                if(counter_clock_in_min==0){
                    tv_minute_in.setText("0"+counter_clock_in_min+"");
                }else {
                    tv_minute_in.setText(counter_clock_in_min + "");
                }
            }
        });

        bt_hour_up1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter_clock_out++;

                if(counter_clock_out>12){
                    counter_clock_out=1;
                }
                if(counter_clock_out==10||counter_clock_out==11||counter_clock_out==12){
                    tv_hour_out.setText(counter_clock_out+"");
                }else{
                    tv_hour_out.setText("0"+counter_clock_out+"");
                }
            }
        });

        bt_hour_down1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter_clock_out--;
                if(counter_clock_out<1){
                    counter_clock_out=12;
                }
                if(counter_clock_out==10||counter_clock_out==11||counter_clock_out==12){
                    tv_hour_out.setText(counter_clock_out+"");
                }else{
                    tv_hour_out.setText("0"+counter_clock_out+"");
                }
            }
        });
        bt_minute_up1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter_clock_out_min += 15;

                if(counter_clock_out_min>59){
                    counter_clock_out_min=0;
                }
                if(counter_clock_out_min==0){
                    tv_minute_out.setText("0"+counter_clock_out_min+"");
                }else {
                    tv_minute_out.setText(counter_clock_out_min + "");
                }
            }
        });
        bt_minute_down1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter_clock_out_min -= 15;
                if(counter_clock_out_min<0){
                    counter_clock_out_min=45;
                }
                if(counter_clock_out_min==0){
                    tv_minute_out.setText("0"+counter_clock_out_min+"");
                }else {
                    tv_minute_out.setText(counter_clock_out_min + "");
                }
            }
        });

        button_counter++;
    }

    private int TimeSet() {
        TIME_START = tv_hour_in.getText().toString()+":"+tv_minute_in.getText().toString()+" "+ InAMPM;
        TIME_END = tv_hour_out.getText().toString()+":"+tv_minute_out.getText().toString()+" "+ OutAMPM;

        int time_hour_in = Integer.parseInt(tv_hour_in.getText().toString());
        int time_minute_in = Integer.parseInt(tv_minute_in.getText().toString());

        int time_hour_out = Integer.parseInt(tv_hour_out.getText().toString());
        int time_minute_out = Integer.parseInt(tv_minute_out.getText().toString());

        if(InAMPM.equals("PM")&&OutAMPM.equals("PM")&&time_hour_in==12&&time_hour_out==12){
            time_hour_in = 12;
            time_hour_out =12;
        }else {
            if (InAMPM.equals("PM") && time_hour_in != 12) {
                time_hour_in += 12;
            } else {
                time_hour_in = Integer.parseInt(tv_hour_in.getText().toString());
            }
            if (OutAMPM.equals("PM")) {
                time_hour_out += 12;
            } else {
                time_hour_out = Integer.parseInt(tv_hour_out.getText().toString());
            }

            if (time_minute_out == 0) {
                time_minute_out = 60;

                time_hour_out--;
            }
            /**=================29-08-2016===============*/
            if (time_minute_out < time_minute_in) {
                time_hour_out--;
            }
            //
            /**=================29-08-2016===============*/
        }


        int difference_hour = time_hour_out-time_hour_in;
        int difference_minute = time_minute_out-time_minute_in;

        if(difference_minute==60){
            difference_minute=0;
            difference_hour++;
        }
        if(difference_hour<0){
            Message.message(getApplicationContext(),"Choose Correct Time!");
        }else {

            if (difference_hour == 0 || difference_hour == 1 || difference_hour == 2 || difference_hour == 3 || difference_hour == 4 ||
                    difference_hour == 5 || difference_hour == 6 || difference_hour == 7 || difference_hour == 8 ||
                    difference_hour == 9) {

                st_difference_hour = "0" + difference_hour;
            } else {
                st_difference_hour = difference_hour + "";
            }
            if (difference_minute == 0) {
                st_difference_minute = "0" + difference_minute;
            } else {
                st_difference_minute = difference_minute + "";
            }
            if (difference_minute < 0) {
                st_difference_minute = Math.abs(difference_minute) + "";
            }
            Time_Duration =  st_difference_hour + ":" +  st_difference_minute;

        }
        return difference_hour;
    }


    private void ItemId() {
        bt_save = (Button)findViewById(R.id.save);

        bt_hour_up = (Button) findViewById(R.id.bt_hour_up);
        bt_hour_down = (Button) findViewById(R.id.bt_hour_down);
        bt_minute_up = (Button) findViewById(R.id.bt_minute_up);
        bt_minute_down = (Button) findViewById(R.id.bt_minute_down);

        bt_hour_up1 = (Button) findViewById(R.id.bt_hour_up1);
        bt_hour_down1 = (Button) findViewById(R.id.bt_hour_down1);
        bt_minute_up1 = (Button) findViewById(R.id.bt_minute_up1);
        bt_minute_down1 = (Button) findViewById(R.id.bt_minute_down1);

        tv_hour_in = (TextView) findViewById(R.id.tv_hour_in);
        tv_minute_in = (TextView) findViewById(R.id.tv_minute_in);
        tv_hour_out = (TextView) findViewById(R.id.tv_hour_out);
        tv_minute_out = (TextView) findViewById(R.id.tv_minute_out);

        tv_in_am = (TextView) findViewById(R.id.in_am);
        tv_in_pm = (TextView) findViewById(R.id.in_pm);
        tv_out_am = (TextView) findViewById(R.id.out_am);
        tv_out_pm = (TextView) findViewById(R.id.out_pm);
    }
}
