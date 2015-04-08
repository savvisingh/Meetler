package co.in.meetler.meetup_fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import co.in.meetler.meetler.R;
import co.in.meetler.tabs.SlidingTabLayout;

/**
 * Created by savvi.singh on 4/6/2015.
 */
public class meetup_fragment extends Fragment {

    ViewPager mpager;
    meetup_fragment_pager_adapter TabAdapter;
    SlidingTabLayout mtabs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View meetup = inflater.inflate(R.layout.activity_meetler__home_, container, false);

        TabAdapter= new meetup_fragment_pager_adapter(getFragmentManager());
        mpager = (ViewPager)meetup.findViewById(R.id.pager);
        mtabs=(SlidingTabLayout) meetup.findViewById(R.id.tabs);
        mpager.setAdapter(TabAdapter);
        mtabs.setDistributeEvenly(true);
        mtabs.setBackgroundColor(Color.parseColor("#1A1A1A"));
        mtabs.setSelectedIndicatorColors(Color.parseColor("#FFFFFF"));
        mpager.setOnTouchListener( new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        mtabs.setViewPager(mpager);

        return meetup;
    }

}
