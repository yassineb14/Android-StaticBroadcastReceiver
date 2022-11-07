package com.sinoo.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    ImageView imageView;
    TextView textView;

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            if (isOnline(context)){
                imageView.findViewById(R.id.imageView);
                textView.findViewById(R.id.textView);
                imageView.setImageResource(R.drawable.coz);
                textView.setText("Connected");



            }
            else {
                imageView.findViewById(R.id.imageView);
                textView.findViewById(R.id.textView);
                imageView.setImageResource(R.drawable.pr);
                textView.setText("Not Connected");
            }


        }catch (NullPointerException e){
            e.printStackTrace();
        }


    }

    public boolean isOnline(Context context){
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return (networkInfo != null && networkInfo.isConnected());

        }catch (NullPointerException e){
            e.printStackTrace();
            return false;

        }
    }
}
