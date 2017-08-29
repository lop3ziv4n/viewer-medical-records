package ar.org.fleni.viewermedicalrecords.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iv4nlop3z on 29/09/16.
 */
public class SectionPagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> titleFragment = new ArrayList<>();

    /**
     * @param fragmentManager type FragmentManager
     */
    public SectionPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    /**
     * @param position type int
     * @return Fragment
     */
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    /**
     * @return int
     */
    @Override
    public int getCount() {
        return fragmentList.size();
    }

    /**
     * @param fragment type Fragment
     * @param title    type String
     */
    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        titleFragment.add(title);
    }

    /**
     * @param position type int
     * @return CharSequence
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return titleFragment.get(position);
    }
}
