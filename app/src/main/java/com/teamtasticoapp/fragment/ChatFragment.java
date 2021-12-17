package com.teamtasticoapp.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.FragmentChatBinding;

/**
 * Created by mobulous55 on 14/2/18.
 */

public class ChatFragment extends Fragment implements View.OnClickListener {
    FragmentChatBinding binding;
    View rootView;

    public static boolean isChatFragmentOnForeground = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat, container, false);
        rootView = binding.getRoot();

        isChatFragmentOnForeground = true;

        setClickListener();


        if (getArguments() != null) {
            Bundle bundle = getArguments();

            String from = bundle.getString("from");
            if ("fcm".equalsIgnoreCase(from)) {
                callGroupChatFragment();
            } else {
                //first time load IndividualChatFragment
                callIndividualChatFragment();
            }
        } else {
            //first time load IndividualChatFragment
            callIndividualChatFragment();
        }

        return rootView;
    }



    @Override
    public void onResume() {
        super.onResume();
        isChatFragmentOnForeground = true;

    }

    @Override
    public void onStop() {
        super.onStop();
        isChatFragmentOnForeground = false;

    }

    public void setClickListener() {
        binding.tvIndividualChat.setOnClickListener(this);
        binding.tvGroupChat.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == binding.tvIndividualChat) {
            callIndividualChatFragment();
        }

        if (view == binding.tvGroupChat) {
            callGroupChatFragment();
        }

    }


    public void callIndividualChatFragment() {
        // container.setVisibility(View.VISIBLE);
        binding.llTab.setBackground(getResources().getDrawable(R.drawable.drawable_rectangle_blue));

        binding.tvIndividualChat.setTextColor(getResources().getColor(R.color.colorRose));
        binding.tvIndividualChat.setBackgroundColor(getResources().getColor(R.color.colorBlue));

        binding.tvGroupChat.setTextColor(getResources().getColor(R.color.colorBlue));
        binding.tvGroupChat.setBackgroundColor(getResources().getColor(R.color.colorWhite));

        IndividualChatFragment fragment = new IndividualChatFragment();

        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }


    private void callGroupChatFragment() {
        // container.setVisibility(View.VISIBLE);
        binding.llTab.setBackground(getResources().getDrawable(R.drawable.drawable_rectangle_blue));

        binding.tvGroupChat.setTextColor(getResources().getColor(R.color.colorRose));
        binding.tvGroupChat.setBackgroundColor(getResources().getColor(R.color.colorBlue));

        binding.tvIndividualChat.setTextColor(getResources().getColor(R.color.colorBlue));
        binding.tvIndividualChat.setBackgroundColor(getResources().getColor(R.color.colorWhite));

        GroupChatFragment fragment = new GroupChatFragment();

        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

}



