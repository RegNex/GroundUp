package io.github.regnex.groundup.Adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import io.github.regnex.groundup.Fragments.CategoryFragment;
import io.github.regnex.groundup.Fragments.PopularFragment;
import io.github.regnex.groundup.Fragments.RecentFragment;

/**
 * Created by HP on 18/02/2018.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {
private Context context;
    public MyFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
    if (position == 0)
        return CategoryFragment.getInstance();
        else if (position == 1)
    return PopularFragment.getIntance();
        else if (position == 2)
            return RecentFragment.getIntance();
    else
        return null;
        }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Category";

            case 1:
                return "Popular";

            case 2:
                return "Recent";
        }
        return "";
    }
}
