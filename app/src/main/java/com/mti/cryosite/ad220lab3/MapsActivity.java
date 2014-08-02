package com.mti.cryosite.ad220lab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
    }//onCreate(Bundle savedInstanceState)

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }//onResume()

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }//endif - (mMap != null)
        }//endif - (mMap == null)
    }//setUpMapIfNeeded()

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }//setUpMap()

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }//onCreateOptionsMenu(Menu menu)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //launch settings or about fragment.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent openSettings = new Intent(MapsActivity.this, SettingsActivity.class);

            Bundle myBundle = new Bundle();
            openSettings.putExtras(myBundle);

            MapsActivity.this.startActivity(openSettings);
            return true;
        }//endif - (id == R.id.action_settings)
        if (id == R.id.action_about) {
            Intent openAbout = new Intent(MapsActivity.this, AboutActivity.class);

            Bundle myBundle = new Bundle();
            openAbout.putExtras(myBundle);

            MapsActivity.this.startActivity(openAbout);
            return true;
        }//endif - (id == R.id.action_about)
        return super.onOptionsItemSelected(item);
    }//onOptionsItemSelected(MenuItem item)
}//class
