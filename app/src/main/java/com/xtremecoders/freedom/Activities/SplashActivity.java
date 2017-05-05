package com.xtremecoders.freedom.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xtremecoders.freedom.R;

public class SplashActivity extends AppCompatActivity {

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sessionManager=new SessionManager();

        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for 3 seconds
                    sleep(3*1000);


                    String status=sessionManager.getPreferences(SplashActivity.this,"status");

                    if (status.equals("1")){
                        Intent i=new Intent(SplashActivity.this,BaseActivity.class);
                        startActivity(i);
                    }else{
                        Intent i=new Intent(SplashActivity.this,LoginActivity.class);
                        startActivity(i);
                    }

                    finish();

                } catch (Exception e) {

                }
            }
        };

        background.start();

    }


}
