package com.yabut.karl.assignment5;

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

public class GreekActivity extends AppCompatActivity {

    static final LatLng MEZES = new LatLng(43.67800,-79.35021);
    static final LatLng MRGREEK = new LatLng(43.80014, -79.19868);
    static final LatLng PANTHEON = new LatLng(43.67755, -79.35133);

    private GoogleMap map;

    String[] greekActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greek);

        ListView lvPhilippine = (ListView) findViewById(R.id.greek_list);
        greekActivity = getResources().getStringArray(R.array.greekList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, greekActivity);

        lvPhilippine.setAdapter(adapter);

        lvPhilippine.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;

                switch (itemPosition) {
                    case 0:
                        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
                        map.setMapType((GoogleMap.MAP_TYPE_SATELLITE));
                        Marker Mezes = map.addMarker(new MarkerOptions().position(MEZES).title("Mezes"));
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(MEZES, 15));
                        map.animateCamera(CameraUpdateFactory.zoomTo(17), 5000, null);

                        break;
                    case 1:
                        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
                        map.setMapType((GoogleMap.MAP_TYPE_SATELLITE));
                        Marker MrGreek = map.addMarker(new MarkerOptions().position(MRGREEK).title("Mr. Greek"));
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(MRGREEK, 15));
                        map.animateCamera(CameraUpdateFactory.zoomTo(17), 5000, null);
                        break;

                    case 2:
                        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
                        map.setMapType((GoogleMap.MAP_TYPE_SATELLITE));
                        Marker Pantheon = map.addMarker(new MarkerOptions().position(PANTHEON).title("Pantheon"));
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(PANTHEON, 15));
                        map.animateCamera(CameraUpdateFactory.zoomTo(17), 5000, null);
                        break;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_greek, menu);
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
