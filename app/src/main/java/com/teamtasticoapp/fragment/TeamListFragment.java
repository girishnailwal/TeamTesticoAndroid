package com.teamtasticoapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.teamtasticoapp.R;
import com.teamtasticoapp.activity.HomeLoginAll;
import com.teamtasticoapp.adapter.TeamListAdapter;
import com.teamtasticoapp.bean.AllResponse;
import com.teamtasticoapp.bean.CommonResponse;
import com.teamtasticoapp.bean.TeamMemberResponse;
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
 * Created by mobulous55 on 14/2/18.
 */

public class TeamListFragment extends Fragment {
    private View rootView;
    private RecyclerView recyclerView;

    //if we make List with new then we must have to use add or addAll() method
    //means if we make an object then we must have to put into it

    //if we take List it means we may typecast anything like ArrayList,LinkList etc.
    //but if we take an ArrayList it means we restrict, it will be only ArrayList
    //List is an interface but class is the implementation of an interface.

    //we should use ArrayList only for restricted type like string
    //  private ArrayList<String> bannerList;
    //not with model
    //  private List<HomeResponse> homeList;

    // Create the array list of to do items
    List<TeamMemberResponse> teamList = new ArrayList<>();
    // adapter, to bind the array to the recyclerView
    TeamListAdapter adapter;
    String Authorization = "";

    ImageView ivCoach;
    TextView tvCoachName;
    TextView tvCoachType;
    TextView tvAppear;
    LinearLayout llPlayerAppear;

    String coachName;
    String coachType;
    String coachImage;

    public TeamListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate your view
        rootView = inflater.inflate(R.layout.fragment_team_list, container, false);
        // Get references to UI widgets
        init();

        return rootView;
    }


    @Override
    public void onResume() {
        super.onResume();

        if (isNetworkAvailable() == true) {

            callTeamListApi();

        } else {
            Toast.makeText(getActivity(), "Internet Connection Lost!", Toast.LENGTH_LONG).show();
        }

    }

    public boolean isNetworkAvailable() {

        ConnectivityManager cm = (ConnectivityManager) getActivity()

                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {

            Log.e("Network Testing", "***Available***");

            return true;

        }

        Log.e("Network Testing", "***Not Available***");

        return false;

    }

    private void init() {
        ivCoach = rootView.findViewById(R.id.ivCoach);
        tvCoachName = rootView.findViewById(R.id.tvCoachName);
        tvCoachType = rootView.findViewById(R.id.tvCoachType);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        tvAppear = rootView.findViewById(R.id.tvAppear);
        llPlayerAppear = rootView.findViewById(R.id.llPlayerAppear);
    }

    private void callTeamListApi() {

        Authorization = SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(getActivity()).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

//        JSONObject jsonObject = new JSONObject();
//        try {
//            String token = Authorization;
//
//            jsonObject.put("Authorization", token);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));


//        RequestBody body = RequestBody
//                .create(MediaType.parse("application/json;charset=UTF-8"), jsonObject.toString());

        Call<CommonResponse> call = apiInterface.getTeamListResult(map);

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(getActivity()).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        // Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        teamList.clear();

                        //for coach
                        AllResponse allResponse = response.body().getAllResponse();

                        ivCoach.setVisibility(View.VISIBLE);
                        coachImage = allResponse.getImage();
                        if (!coachImage.isEmpty() && coachImage != null) {
                            Picasso.with(getActivity()).load(response.body().getAllResponse().getImage()).into(ivCoach);

                        }

                        coachName = allResponse.getName();
                        if (!coachName.isEmpty()) {
                            tvCoachName.setText(coachName);
                        }

                        coachType = allResponse.getType();
                        String upperString = coachType.substring(0, 1).toUpperCase() + coachType.substring(1);
                        if (!upperString.isEmpty()) {
                            tvCoachType.setText(upperString);
                        }


                        //for team member(player)
                        if (response.body().getAllResponse().getTeamMemberResponseList() != null &&
                                response.body().getAllResponse().getTeamMemberResponseList().size() > 0) {

                            teamList.addAll(response.body().getAllResponse().getTeamMemberResponseList());

                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                            recyclerView.setLayoutManager(linearLayoutManager);
                            // Bind the adapter to the recyclerView.
                            adapter = new TeamListAdapter(getActivity(), teamList);
                            recyclerView.setAdapter(adapter);

                            adapter.setOnTeamListItemClickListener(new TeamListAdapter.OnTeamListItemClickListener() {
                                @Override
                                public void onItemClick(View view, int pos) {
                                    TeamMemberResponse teamMemberResponse = teamList.get(pos);

                                    String type = teamMemberResponse.getType();
                                    String name = teamMemberResponse.getName();
                                    String position = teamMemberResponse.getPosition();
                                    String image = teamMemberResponse.getImage();
                                    String userId = teamMemberResponse.getUser_id();
                                }
                            });

                            //if player will be available
                            recyclerView.setVisibility(View.VISIBLE);
                            llPlayerAppear.setVisibility(View.GONE);

                        } else {
                            //first time,if player will not be available
                            recyclerView.setVisibility(View.GONE);
                            llPlayerAppear.setVisibility(View.VISIBLE);
                        }


                    } else {
                        Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else if (response.message().equalsIgnoreCase("Unauthorized")) {
                    Intent intent = new Intent(getActivity(), HomeLoginAll.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    SharedPreferenceWriter.getInstance(getActivity()).writeStringValue(SharedPreferenceKey.currentLogin, "false");
                    startActivity(intent);
                    getActivity().finishAffinity();
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(getActivity()).hideDialog();
            }
        });
    }


}
