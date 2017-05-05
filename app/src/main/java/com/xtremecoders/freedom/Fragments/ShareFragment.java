package com.xtremecoders.freedom.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.model.LatLng;
import com.xtremecoders.freedom.Activities.MapActivity;
import com.xtremecoders.freedom.R;


public class ShareFragment extends Fragment {


    MapActivity mapActivity;
    public LatLng latLngn;
    public Double slatitude;
    public Double slongitude;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        view=inflater.inflate(R.layout.fragment_share,container,false);

        mapActivity=new MapActivity();
        latLngn=mapActivity.latLng;
        slatitude=mapActivity.latitude;
        slongitude=mapActivity.longitude;
        shareIt();
        return  view;
    }

    private void shareIt() {
//sharing implementation here
        String uri = "http://maps.google.com/maps?saddr=" +slatitude+","+slongitude;
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Current Location");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, uri);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    // https://maps.googleapis.com/maps/api/staticmap?center=C.U.Shah,Kothariya,+Surendranagar&zoom=13&scale=2&size=600x300&maptype=roadmap&format=png&visual_refresh=true&markers=size:mid%7Ccolor:0xff0000%7Clabel:1%7CC.U.Shah,Kothariya,+Surendranagar
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
