package com.example.ygb.turismotepic;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ygb.turismotepic.rc.rc_init;

import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends Activity {
    // Set the duration of the splash screen
    private static final long SPLASH_SCREEN_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        init_DB();


        TimerTask task = new TimerTask() {
            @Override
            public void run() {

               /* // Start the next activity
                Intent mainIntent = new Intent().setClass(SplashScreen.this, Login.class);
                startActivity(mainIntent);

                // Close the activity so the user won't able to go back this
                finish();*/
                Intent Intent1 = new Intent().setClass(SplashScreen.this, SplashScreen2.class);
                startActivity(Intent1);

                // Close the activity so the user won't able to go back this
                finish();
            }
        };

        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
    private void init_DB() {
        rc_init database = new rc_init(getApplicationContext());
        database.open();
        database.close();
        //Log.i(TAG,"INIT_DB");
    }
}
