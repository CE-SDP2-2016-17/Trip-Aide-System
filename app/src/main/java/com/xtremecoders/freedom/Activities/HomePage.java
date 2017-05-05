package com.xtremecoders.freedom.Activities;

import android.Manifest;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.test.mock.MockPackageManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.MapFragment;
import com.xtremecoders.freedom.R;

public class HomePage extends AppCompatActivity{

    Button btn_logout;
    SessionManager sessionManager;
    TextView tv_open_map;
    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;
    MapActivity mapActivity;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

      sessionManager=new SessionManager();
        try {
            if (ActivityCompat.checkSelfPermission(this, mPermission)
                    != MockPackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this, new String[]{mPermission},
                        REQUEST_CODE_PERMISSION);

                // If any permission above not allowed by user, this condition will
               // execute every time, else your else part will work
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
      btn_logout=(Button)findViewById(R.id.btn_logout);


        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                sessionManager.setPreferences(HomePage.this, "status", "0");
                String STATUS = sessionManager.getPreferences(HomePage.this, "status");
                Toast.makeText(getApplicationContext(), "LogOut Success", Toast.LENGTH_SHORT).show();
                Intent ne=new Intent(HomePage.this,LoginActivity.class);
                startActivity(ne);
            }
        });

        tv_open_map=(TextView)findViewById(R.id.tv_open_map);

        tv_open_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent mapactivity=new Intent(HomePage.this,MapActivity.class);
                startActivity(mapactivity);
              /*  mapActivity=new MapActivity();
                Fragment fragment = null;
                fragment=new MapFragment();

                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.content_frame,fragment);
                ft.commit();*/

            }
        });


    }
}
