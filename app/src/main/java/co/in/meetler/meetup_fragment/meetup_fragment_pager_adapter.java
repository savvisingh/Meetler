package co.in.meetler.meetup_fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import co.in.meetler.meetup_fragment.Meetup_fragment_invites;

/**
 * Created by savvi.singh on 4/6/2015.
 */
public class meetup_fragment_pager_adapter extends FragmentPagerAdapter {
    public meetup_fragment_pager_adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new Meetup_fragment_invites();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0)
            return "Created";
        else
            return  "Invites";
    }
}
