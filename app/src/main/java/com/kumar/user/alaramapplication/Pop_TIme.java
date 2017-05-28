package com.kumar.user.alaramapplication;

import android.app.DialogFragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

/**
 * Created by User on 5/28/2017.
 */

public class Pop_TIme extends DialogFragment implements View.OnClickListener{
    View view;
    TimePicker timePicker;
   Button buDone;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        view=inflater.inflate(R.layout.poptime,container,false);
        timePicker= (TimePicker) view.findViewById(R.id.tP);
        buDone= (Button) view.findViewById(R.id.buDone);
        buDone.setOnClickListener(this);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        this.dismiss();
        MainActivity mainActivity= (MainActivity) getActivity();
        if (Build.VERSION.SDK_INT>=23){
            if ((int) Build.VERSION.SDK_INT >= 23)
                mainActivity.SetTime(timePicker.getHour(),timePicker.getMinute());
            else
                mainActivity.SetTime(timePicker.getCurrentHour(),timePicker.getCurrentMinute());
        }
    }
}
