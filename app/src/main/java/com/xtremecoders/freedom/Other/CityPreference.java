package com.xtremecoders.freedom.Other;

import android.app.Activity;
import android.content.SharedPreferences;

import com.xtremecoders.freedom.Fragments.WeatherFragment;



public class CityPreference {

    WeatherFragment weatherFragment=new WeatherFragment();
    public static String searched_city;
    SharedPreferences prefs;


    public CityPreference(Activity activity){
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    // If the user has not chosen a city yet, return
    // Surendranagar as the default city
    public String getCity(){

        searched_city=weatherFragment.searched_city;
        if(searched_city==null) {
            return prefs.getString("city", "Nadiad, IND");
        }
        else{
            return prefs.getString("city", searched_city + ", IND");
        }
    }

    public void setCity(String city){

        prefs.edit().putString("city", city).commit();
    }
}
