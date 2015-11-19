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

public class ItalianActivity extends AppCompatActivity {

    static final LatLng BUCA = new LatLng(43.64384,-79.39984);
    static final LatLng DONATELLO = new LatLng(43.65732, -79.38348);
    static final LatLng TERRONI = new LatLng(43.68004, -79.39052);
    static final LatLng MARINELLA = new LatLng(43.65496, -79.41551);

    private GoogleMap map;

    String[] italianActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_italian);

        ListView lvItalian = (ListView) findViewById(R.id.italian_list);
        italianActivity = getResources().getStringArray(R.array.italianList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, italianActivity);

        lvItalian.setAdapter(adapter);

        lvItalian.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;

                switch (itemPosition) {
                    case 0:
                        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
                        map.setMapType((GoogleMap.MAP_TYPE_SATELLITE));
                        Marker Buca = map.addMarker(new MarkerOptions().position(BUCA).title("Buca"));
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(BUCA, 15));
                        map.animateCamera(CameraUpdateFactory.zoomTo(17), 5000, null);
                        break;
                    case 1:
                        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
                        map.setMapType((GoogleMap.MAP_TYPE_SATELLITE));
                        Marker Donatello = map.addMarker(new MarkerOptions().position(DONATELLO).title("Donatello"));
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(DONATELLO, 15));
                        map.animateCamera(CameraUpdateFactory.zoomTo(17), 5000, null);
                        break;
                    case 2:
                        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
                        map.setMapType((GoogleMap.MAP_TYPE_SATELLITE));
                        Marker Terroni = map.addMarker(new MarkerOptions().position(TERRONI).title("Terroni"));
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(TERRONI, 15));
                        map.animateCamera(CameraUpdateFactory.zoomTo(17), 5000, null);
                        break;
                    case 3:
                        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
                        map.setMapType((GoogleMap.MAP_TYPE_SATELLITE));
                        Marker Marinella = map.addMarker(new MarkerOptions().position(MARINELLA).title("Marinella"));
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(MARINELLA, 15));
                        map.animateCamera(CameraUpdateFactory.zoomTo(17), 5000, null);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_italian, menu);
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
