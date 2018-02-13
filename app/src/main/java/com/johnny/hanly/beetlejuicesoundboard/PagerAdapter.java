package com.johnny.hanly.beetlejuicesoundboard;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Johnny Hanly on 1/21/2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int tabs;

    public PagerAdapter(FragmentManager fragmentManager, int tabs) {
        super(fragmentManager);
        this.tabs = tabs;
    }

    @Override
    public Fragment getItem(int position) {


        switch (position) {
            case 0:
                ClassicFragment tab1 = new ClassicFragment();
                return tab1;
            case 1:
                InsultsFragment tab2 = new InsultsFragment();
                return tab2;
            case 2:
                HateFragment tab3 = new HateFragment();
                return tab3;
            case 3:
                MiscFragment tab4= new MiscFragment();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabs;
    }
}
