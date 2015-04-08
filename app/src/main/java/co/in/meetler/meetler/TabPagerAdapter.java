package co.in.meetler.meetler;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import co.in.meetler.friends_fragment.friends_fragment;
import co.in.meetler.meetup_fragment.meetup_fragment;

/**
 * Created by savvi.singh on 4/1/2015.
 */
public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private String[] tabs = { "NextUp", "Notification", "MeetUp","Friends" };
    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        if (i==2)
            return new meetup_fragment();
        if(i==3)
            return new friends_fragment();

            return new nextup_fragment();

                   }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabs[position];
    }
}
