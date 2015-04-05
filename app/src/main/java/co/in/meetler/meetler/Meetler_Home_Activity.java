package co.in.meetler.meetler;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import co.in.meetler.tabs.SlidingTabLayout;


public class Meetler_Home_Activity extends ActionBarActivity {

    ViewPager mpager;
    TabPagerAdapter TabAdapter;
    SlidingTabLayout mtabs;
    ActionBar actionBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetler__home_);
        TabAdapter = new TabPagerAdapter(getSupportFragmentManager());
        mpager = (ViewPager)findViewById(R.id.pager);
        mtabs=(SlidingTabLayout) findViewById(R.id.tabs);
        mpager.setAdapter(TabAdapter);
        mtabs.setDistributeEvenly(true);
        mtabs.setBackgroundColor(Color.parseColor("#1A1A1A"));
        mtabs.setSelectedIndicatorColors(Color.parseColor("#FFFFFF"));
        mtabs.setViewPager(mpager);









    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_meetler__home_, menu);
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
