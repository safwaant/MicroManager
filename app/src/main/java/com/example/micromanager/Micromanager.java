package com.example.micromanager;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class Micromanager extends Application{
    public static final String MAIN_CHANNEL = "MainChannel";
    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    public void createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel MainChannel = new NotificationChannel(MAIN_CHANNEL, "MainChannel", NotificationManager.IMPORTANCE_HIGH);
            MainChannel.setDescription("This channel is used to send overdue assignment notifications");
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(MainChannel);
        }
    }
}
