package com.teamtasticoapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.teamtasticoapp.R;
import com.teamtasticoapp.bean.UserListModel;
import com.teamtasticoapp.bean.UserListResponse;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;
import com.teamtasticoapp.retrofit.ApiClient;
import com.teamtasticoapp.retrofit.ApiInterface;
import com.teamtasticoapp.retrofit.MyDialog;
import com.teamtasticoapp.util.FragmentUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by mobulous55 on 26/6/18.
 */

public class LineUpRootFragment extends Fragment {
    private List<UserListResponse> playerList;
    private boolean isLineUP = false;
    private String mType;
    private String mCoachId = "";
    private String mId = "";

    public static Fragment getFragment() {
        Fragment fragment = new LineUpRootFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //onCreate() method run one time,so create object one time.
        //no need to create object again and again by declare object above globally.
        playerList = new ArrayList<>();

        mType = SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.type);
        mCoachId = SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.team_code);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lineup_root, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadLineUpPlayerList();
    }

    private void loadLineUpPlayerList() {
        String Authorization = SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(getActivity()).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);


        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));


        Call<UserListModel> call = apiInterface.getLineupPlayerResult(map, mCoachId);

        call.enqueue(new Callback<UserListModel>() {
            @Override
            public void onResponse(Call<UserListModel> call, Response<UserListModel> response) {
                MyDialog.getInstance(getActivity()).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        if (response.body().getMessage() != null) {

                            if ("No Lineup Player".equalsIgnoreCase(response.body().getMessage())) {
                                List<UserListResponse> listResponses = new ArrayList<>();

                                for (int i = 0; i < 11; i++) {
                                    listResponses.add(new UserListResponse(("Player " + (i+1)),
                                                    "",
                                                    "" + i,
                                                    "0.0",
                                                    "0.0",
                                                    "#FFFFFF",
                                                    "1",
                                                    "false",
                                                    "",
                                                    "",
                                                    "",
                                                    "no",
                                                    ""));
                                }
                                playerList.clear();
                                playerList.addAll(listResponses);
                                isLineUP = false;
                                SharedPreferenceWriter.getInstance(getActivity())
                                        .writeStringValue(SharedPreferenceKey.firstTimeLineSetup, "yes");
                            } else {

                                if(response.body().getUserListResponses()!=null && response.body().getUserListResponses().size()>0) {
                                    playerList.clear();
                                    playerList.addAll(response.body().getUserListResponses());
                                }
                                else {

                                }

                                isLineUP = true;
                                SharedPreferenceWriter.getInstance(getActivity())
                                        .writeStringValue(SharedPreferenceKey.firstTimeLineSetup, "No");
                            }

                            toggleFragment(isLineUP);
                        }
                    } else {
                        Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<UserListModel> call, Throwable t) {
                MyDialog.getInstance(getContext()).hideDialog();
            }

        });

    }



    private void toggleFragment(boolean isLineUP) {
        if (mType.equalsIgnoreCase("Coach")) {
            if (isLineUP) {
                changeFragment(AddPlayerFragment.getFragment(playerList, playerList.size()));
            } else {
                changeFragment(LineupFragment.getFragment(playerList, lineUpInterface));
            }
        } else {
            changeFragment(LineUpForPlayerFragment.getFragment());
        }
    }

    /**
     * callback from LineupFragment after selecting num of players
     *
     * @param numberOfPlayer num of players
     */
    LineupFragment.LineUpInterface lineUpInterface = new LineupFragment.LineUpInterface() {
        @Override
        public void onPlayerSelected(List<UserListResponse> list, int numberOfPlayer) {

            playerList = list;
            SharedPreferenceWriter.getInstance(getActivity())
                    .writeStringValue(SharedPreferenceKey.firstTimeLineSetup, "yes");

            changeFragment(AddPlayerFragment.getFragment(playerList, numberOfPlayer));
        }
    };


    private void changeFragment(Fragment fragment) {
        FragmentUtil.changeFragment(getFragmentManager(), fragment,
                false, false);
    }
}
