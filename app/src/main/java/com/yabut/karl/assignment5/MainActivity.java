package com.yabut.karl.assignment5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final RadioGroup group = (RadioGroup) findViewById(R.id.RadioGroup);

        final Intent italianIntent = new Intent(this, ItalianActivity.class);
        final Intent greekIntent = new Intent(this, GreekActivity.class);
        final Intent chineseIntent = new Intent(this, ChineseActivity.class);
        final Intent philippineIntent = new Intent(this, PhilippineActivity.class);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != -1) {
                    RadioButton rb = (RadioButton) findViewById(checkedId);
                    if (rb != null) {
                        RadioButton btn = (RadioButton) group.getChildAt(group.indexOfChild(rb));
                        Log.d("Debug", (String) btn.getText());
                        switch ((String) btn.getText()) {
                            case "Italian":
                                //stuff
                                startActivity(italianIntent);
                                break;
                            case "Greek":
                                //so on
                                startActivity(greekIntent);
                                break;
                            case "Chinese":
                                startActivity(chineseIntent);
                                break;
                            case "Philippine":
                                startActivity(philippineIntent);
                                break;
                        }
                    }
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
