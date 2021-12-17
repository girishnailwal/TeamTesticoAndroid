package com.teamtasticoapp.fragment;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.teamtasticoapp.R;

import com.teamtasticoapp.bean.UserListModel;
import com.teamtasticoapp.bean.UserListResponse;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;
import com.teamtasticoapp.retrofit.ApiClient;
import com.teamtasticoapp.retrofit.ApiInterface;
import com.teamtasticoapp.retrofit.MyDialog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by mobulous55 on 25/6/18.
 */

public class LineUpForPlayerFragment extends Fragment {
    private String mTeamCode;
    private String mCoachId;
    private CoordinatorLayout rootView;
    ImageView ivPlayer;
    private List<UserListResponse> playerList = new ArrayList<>();

    public static Fragment getFragment() {
        Fragment fragment = new LineUpForPlayerFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate your view
        View view = inflater.inflate(R.layout.fragment_lineup_player, container, false);
        rootView = view.findViewById(R.id.root_view);
        ivPlayer = view.findViewById(R.id.ivPlayer);


        mTeamCode = SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.team_code);
        mCoachId = SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.team_code);

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
                        playerList.clear();
                        if (response.body().getUserListResponses() != null &&
                                response.body().getUserListResponses().size() > 0) {

                            playerList.addAll(response.body().getUserListResponses());


                            updateUI(playerList);
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


    private void updateUI(List<UserListResponse> playerList) {

        for (UserListResponse player : playerList) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.custom_player_layout, null);
            TextView tvPlayer = view.findViewById(R.id.tvPlayer);
            ImageView ivPlayer = view.findViewById(R.id.ivPlayer);
            tvPlayer.setText(player.getName());

            if (player.getLineup_status().equalsIgnoreCase("yes")) {
                setUpPlayerDressColor(player, ivPlayer);

                float x = Float.parseFloat(player.getxCords());
                float y = Float.parseFloat(player.getyCords());
                view.setX(x + 60);
                view.setY(y + 40);

                rootView.addView(view);
            }
        }

    }


    private void setUpPlayerDressColor(UserListResponse player, ImageView ivPlayer) {
        if (player.getDressType().equalsIgnoreCase("2")) {
            ivPlayer.setColorFilter(Color.TRANSPARENT);
            if (player.getpImage().contains("https:")) {
              Picasso.with(getActivity()).load(player.getpImage()).into(ivPlayer);
            }else{
                Picasso.with(getContext()).load(R.drawable.app_logo).resize(150, 150).into(ivPlayer);
            }

        } else {
            String hexcolor = player.getDressColor();
            hexcolor = (hexcolor != null) ? hexcolor : "#FFFFFF";
            int c = Color.parseColor(hexcolor);
            ivPlayer.setImageDrawable(getResources().getDrawable(R.drawable.player_tshirt));
            ivPlayer.setColorFilter(c, PorterDuff.Mode.MULTIPLY);
        }
    }

}
