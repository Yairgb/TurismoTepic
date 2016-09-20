package com.example.ygb.turismotepic;

/**
 * Created by LAB-DES-05 on 20/09/2016.
 */
import android.location.LocationListener;
import com.wikitude.architect.ArchitectView.ArchitectUrlListener;
import com.wikitude.architect.ArchitectView.SensorAccuracyChangeListener;
//public
interface ArchitectViewHolderInterface {
    public static interface ILocationProvider {
        public void onResume();
        public void onPause();
    }
}