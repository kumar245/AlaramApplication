package com.kumar.user.alaramapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
       if (intent.getAction().equalsIgnoreCase("com.alraby.alaram")){
           Bundle b=intent.getExtras();
           Toast.makeText(context, b.getString("MyMessage"), Toast.LENGTH_LONG).show();
       }
    }
}
