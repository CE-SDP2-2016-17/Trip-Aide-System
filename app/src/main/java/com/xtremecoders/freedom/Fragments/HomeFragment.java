package com.xtremecoders.freedom.Fragments;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.test.mock.MockPackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.xtremecoders.freedom.Activities.HomePage;
import com.xtremecoders.freedom.Activities.LoginActivity;
import com.xtremecoders.freedom.Activities.MapActivity;
import com.xtremecoders.freedom.Activities.SessionManager;
import com.xtremecoders.freedom.Activities.WeatherActivity;
import com.xtremecoders.freedom.R;
import com.xtremecoders.freedom.mtplview.MtplButton;


public class HomeFragment extends Fragment {

    //Button btn_logout;
    SessionManager sessionManager;
    TextView tv_open_map;
    MtplButton btn_weather;
    private static final int REQUEST_CODE_PERMISSION = 2;
    String mPermission = Manifest.permission.ACCESS_FINE_LOCATION;
    MapActivity mapActivity;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      //  return super.onCreateView(inflater, container, savedInstanceState);
        view=inflater.inflate(R.layout.fragment_home,container,false);

        sessionManager=new SessionManager();
        try {
            if (ActivityCompat.checkSelfPermission(getActivity(), mPermission)
                    != MockPackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(getActivity(), new String[]{mPermission},
                        REQUEST_CODE_PERMISSION);

                // If any permission above not allowed by user, this condition will
                // execute every time, else your else part will work
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        btn_weather=(MtplButton)view.findViewById(R.id.btn_weather);
        btn_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent weather=new Intent(getContext(),WeatherActivity.class);
                startActivity(weather);
            }
        });

        tv_open_map=(TextView)view.findViewById(R.id.tv_open_map);

        tv_open_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent mapactivity=new Intent(getContext(),MapActivity.class);
                startActivity(mapactivity);

            }
        });

        return  view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
