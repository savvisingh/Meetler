package co.in.meetler.friends_fragment;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by savvi.singh on 4/8/2015.
 */
public class friends_fragment_pager_adapter extends FragmentPagerAdapter {

    public friends_fragment_pager_adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new Friends_fragment_allcontacts();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==1)
            return "All Contacts";
        else return "Favourite";
    }
}
