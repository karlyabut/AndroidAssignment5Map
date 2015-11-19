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

public class ChineseActivity extends AppCompatActivity {

    static final LatLng LAIWAHHEEN = new LatLng(43.65467,-79.38617);
    static final LatLng LEEGARDEN = new LatLng(43.65466, -79.39843);
    static final LatLng LUCKYCHINESE = new LatLng(43.76228, -79.21389);
    static final LatLng SWATOW = new LatLng(43.65384, -79.39811);

    private GoogleMap map;

    String[] chineseActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese);

        ListView lvItalian = (ListView) findViewById(R.id.chinese_list);
        chineseActivity = getResources().getStringArray(R.array.chineseList);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, chineseActivity);

        lvItalian.setAdapter(adapter);
        

        lvItalian.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;

                switch (itemPosition) {
                    case 0:
                        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
                        map.setMapType((GoogleMap.MAP_TYPE_SATELLITE));
                        Marker LaiWahHeen = map.addMarker(new MarkerOptions().position(LAIWAHHEEN).title("Lai Wah Heen"));
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(LAIWAHHEEN, 15));
                        map.animateCamera(CameraUpdateFactory.zoomTo(17), 5000, null);
                        break;
                    case 1:
                        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
                        map.setMapType((GoogleMap.MAP_TYPE_SATELLITE));
                        Marker LeeGarden = map.addMarker(new MarkerOptions().position(LEEGARDEN).title("Lee Garden"));
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(LEEGARDEN, 15));
                        map.animateCamera(CameraUpdateFactory.zoomTo(17), 5000, null);
                        break;
                    case 2:
                        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
                        map.setMapType((GoogleMap.MAP_TYPE_SATELLITE));
                        Marker LuckyChinese = map.addMarker(new MarkerOptions().position(LUCKYCHINESE).title("Lucky Chinese"));
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(LUCKYCHINESE, 15));
                        map.animateCamera(CameraUpdateFactory.zoomTo(17), 5000, null);
                        break;
                    case 3:
                        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
                        map.setMapType((GoogleMap.MAP_TYPE_SATELLITE));
                        Marker Swatow = map.addMarker(new MarkerOptions().position(SWATOW).title("Swatow"));
                        map.moveCamera(CameraUpdateFactory.newLatLngZoom(SWATOW, 15));
                        map.animateCamera(CameraUpdateFactory.zoomTo(17), 5000, null);
                        break;
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chinese, menu);
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
