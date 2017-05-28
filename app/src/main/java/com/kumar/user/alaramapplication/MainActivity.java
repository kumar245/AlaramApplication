package com.kumar.user.alaramapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.app.FragmentManager fragmentManager=getFragmentManager();
        Pop_TIme pop_tIme=new Pop_TIme();
        pop_tIme.show(fragmentManager,"Hello Fragment");
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    void SetTime(int Hour, int Min){
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR,Hour);
        calendar.set(Calendar.MINUTE,Min);
        calendar.set(Calendar.SECOND,0);
        AlarmManager alarmManager= (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent=new Intent(this,MyReceiver.class);
        intent.setAction("com.alraby.alaram");
        intent.putExtra("My Message","Hello From Alaram");
        PendingIntent pendingIntent=PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);

    }
}
