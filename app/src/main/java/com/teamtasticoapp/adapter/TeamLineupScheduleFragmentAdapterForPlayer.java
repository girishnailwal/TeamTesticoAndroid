package com.teamtasticoapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.teamtasticoapp.fragment.LineUpForPlayerFragment;
import com.teamtasticoapp.fragment.ScheduleFragment;
import com.teamtasticoapp.fragment.TeamListFragment;

/**
 * Created by mobulous55 on 6/6/18.
 */

public class TeamLineupScheduleFragmentAdapterForPlayer extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public TeamLineupScheduleFragmentAdapterForPlayer(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                TeamListFragment tab1 = new TeamListFragment();
                return tab1;
            case 1:
                LineUpForPlayerFragment tab2 = new LineUpForPlayerFragment();
                //AddedPlayer tab2=new AddedPlayer();
                return tab2;
            case 2:
                ScheduleFragment tab3 = new ScheduleFragment();
                return tab3;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
