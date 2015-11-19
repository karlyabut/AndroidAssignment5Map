package com.yabut.karl.assignment5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

//map imports
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class PhilippineActivity extends AppCompatActivity {

    static final LatLng JESSEJR = new LatLng(43.78734,-79.26925);
    static final LatLng CASAMANILA = new LatLng(43.75498, -79.34893);
    private GoogleMap map;

    String[] phActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_philippine);

        //final Intent phIntent = new Intent(PhilippineActivity.this, MapsActivity.class);

        ListView lvPhilippine = (ListView) findViewById(R.id.philipine_list);
        phActivity = getResources().getStringArray(R.array.philippineList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, phActivity);

        lvPhilippine.setAdapter(adapter);

        lvPhilippine.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;

                switch (itemPosition){
                    case 0:
                        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
                        map.setMapType((GoogleMap.MAP_TYPE_SATELLITE));
                        Marker JesseJr = map.addMarker(new MarkerOptions().position(JESSEJR).title("Jesse Jr."));
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(JESSEJR, 15));
                        map.animateCamera(CameraUpdateFactory.zoomTo(17), 5000, null);

                        break;
                    case 1:
                        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
                        map.setMapType((GoogleMap.MAP_TYPE_SATELLITE));
                        Marker CasaManila = map.addMarker(new MarkerOptions().position(CASAMANILA).title("Casa Manila"));
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(CASAMANILA, 15));
                        map.animateCamera(CameraUpdateFactory.zoomTo(17), 5000, null);
                        break;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_philippine, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
