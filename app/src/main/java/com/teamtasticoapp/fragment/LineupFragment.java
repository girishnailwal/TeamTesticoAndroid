package com.teamtasticoapp.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListPopupWindow;

import com.teamtasticoapp.R;
import com.teamtasticoapp.bean.UserListResponse;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;
import com.teamtasticoapp.databinding.FragmentCreateLineupBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static com.teamtasticoapp.constants.Constants.kPlayers;

/**
 * Created by mobulous55 on 19/6/18.
 */

public class LineupFragment extends Fragment implements View.OnClickListener {

    View rootView;
    FragmentCreateLineupBinding binding;
    String mType = "";

    List<UserListResponse> playerList = new ArrayList<>();
    private static LineUpInterface lineUpListener;
    private boolean isFirstTime = true;

    public static Fragment getFragment(List<UserListResponse> playerList, LineUpInterface lineUpInterface) {

        Fragment fragment = new LineupFragment();
        lineUpListener = lineUpInterface;

        Bundle bundle = new Bundle();
        bundle.putSerializable(kPlayers, (Serializable) playerList);
        fragment.setArguments(bundle);

        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            playerList= (List<UserListResponse>) bundle.getSerializable(kPlayers);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_lineup, container, false);
        rootView = binding.getRoot();

        mType = SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.type);

        final List<String> spinnerPlayerList = new ArrayList<>();
        spinnerPlayerList.add("None");
        for (int i = 0; i < 11; i++) {
            int sum = i + 1;
            spinnerPlayerList.add("" + sum);
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, spinnerPlayerList);
        binding.spinner.setAdapter(arrayAdapter);

        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (isFirstTime) {
                    isFirstTime = false;
                    return;
                }

                int numberOfPlayer;
                if (i == 0) {
                    binding.tvSelect.setText("Select");
                    numberOfPlayer = 0;
                } else {
                    binding.tvSelect.setText(spinnerPlayerList.get(i));
                    numberOfPlayer = Integer.parseInt(spinnerPlayerList.get(i));
                }


                if (lineUpListener != null) {
                    int m = Integer.parseInt(spinnerPlayerList.get(i));

                    for (int k = 0; k < 11; k++) {
                        if (k <= m) {
                            playerList.get(k).setLineup_status("yes");
                        } else {
                            playerList.get(k).setLineup_status("no");
                        }
                    }

                    lineUpListener.onPlayerSelected(playerList, numberOfPlayer);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.tvSelect.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        if (view == binding.tvSelect) {
            binding.spinner.performClick();
        }
    }

    public interface LineUpInterface {
        void onPlayerSelected(List<UserListResponse> list, int numberOfPlayer);
    }
}
