package com.example.micromanager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.ImageView;

        import java.util.List;

import static com.example.micromanager.Micromanager.MAIN_CHANNEL;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView logo = (ImageView) findViewById(R.id.logo);
        int logoRes = logo.getResources().getIdentifier("@drawable/logo", null,this.getPackageName());
        logo.setImageResource(logoRes);
        AssignmentViewModel assignmentViewModel = new ViewModelProvider(this).get(AssignmentViewModel.class);
        notificationManager = NotificationManagerCompat.from(this);
        Notification notification = new NotificationCompat.Builder(this, MAIN_CHANNEL).setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("Overdue Assignment(s)!").setContentText(" is overdue!").setPriority(NotificationCompat.PRIORITY_HIGH).build();
        notificationManager.notify(1, notification);

    }


    public void addAssignments(View view) {
        Intent intent = new Intent(this,Add_Screen.class);
        startActivity(intent);
    }

    public void goToAssignmentListScreen(View view) {
        Intent intent  = new Intent(this, Assignment_List.class);
        startActivity(intent);
    }

    public void goToHelpScreen(View view) {
        Intent intent = new Intent(this, Help_Page.class);
        startActivity(intent);
    }
    public void goToAboutPage(View view){
        Intent intent = new Intent(this, About_Page.class);
        startActivity(intent);
    }

}