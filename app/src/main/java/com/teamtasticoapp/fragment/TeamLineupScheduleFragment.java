package com.teamtasticoapp.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamtasticoapp.R;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;

/**
 * Created by mobulous55 on 6/6/18.
 */

public class TeamLineupScheduleFragment extends Fragment {

    private View rootView;
    private String mType = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate your view
        rootView = inflater.inflate(R.layout.fragment_team_lineup_schedule, container, false);

        //Initializing the tablayout
        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tab_layout);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Team"));
        tabLayout.addTab(tabLayout.newTab().setText("Lineup"));
        tabLayout.addTab(tabLayout.newTab().setText("Schedule"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initializing viewPager
        final ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.pager);

        //Creating our pager adapter
        mType = SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.type);

        final TeamLineupScheduleFragmentAdapter adapter = new TeamLineupScheduleFragmentAdapter(getActivity().getSupportFragmentManager(),
                tabLayout.getTabCount(), mType);

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setOffscreenPageLimit(0);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                if (position != 1) {
//                    saveLineUP(adapter);
//                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return rootView;
    }

//    private void saveLineUP(TeamLineupScheduleFragmentAdapter adapter) {
//        List<Fragment> fragments = getFragmentManager().getFragments();
//        for (Fragment fragment : fragments) {
//            if (fragment.getClass().equals(LineUpRootFragment.class)) {
//                ((LineUpRootFragment) fragment).saveLineup();
//            }
//        }
//    }


    class TeamLineupScheduleFragmentAdapter extends FragmentStatePagerAdapter {

        int mNumOfTabs;
        String mType  = "";

        public TeamLineupScheduleFragmentAdapter(FragmentManager fm, int NumOfTabs, String type) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
            mType = type;
        }


        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    TeamListFragment tab1 = new TeamListFragment();
                    return tab1;

                case 1:
                    Fragment fragment = new LineUpRootFragment();
                    return fragment;

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

}
