package com.teamtasticoapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.FragmentIndividualChatBinding;
import com.teamtasticoapp.activity.AllUserFloatingActionMenuActivity;
import com.teamtasticoapp.activity.IndividualChatDetail;
import com.teamtasticoapp.adapter.IndividualChatListAdapter;
import com.teamtasticoapp.bean.IndividualMessageListModel;
import com.teamtasticoapp.bean.IndividualMessageListResponse;
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
 * Created by mobulous55 on 13/2/18.
 */

public class IndividualChatFragment extends Fragment implements View.OnClickListener {
    FragmentIndividualChatBinding binding;
    View rootView;
    String Authorization;
    List<IndividualMessageListResponse> individualMessageList = new ArrayList<>();
    IndividualChatListAdapter individualChatListAdapter;

    public IndividualChatFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_individual_chat, container, false);
        rootView = binding.getRoot();

        binding.fab.setOnClickListener(this);

        return rootView;

    }

    @Override
    public void onResume() {
        super.onResume();
        if (isNetworkAvailable() == true) {

            callIndividualMessageListApi();

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

    private void callIndividualMessageListApi() {

        Authorization = SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(getActivity()).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);


        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));


        Call<IndividualMessageListModel> call = apiInterface.getIndividualMessageTeamListResult(map);

        call.enqueue(new Callback<IndividualMessageListModel>() {
            @Override
            public void onResponse(Call<IndividualMessageListModel> call, final Response<IndividualMessageListModel> response) {
                MyDialog.getInstance(getActivity()).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        // Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                        //to get all response here,

                        individualMessageList.clear();

                        if (response.body().getIndividualMessageListResponses() != null &&
                                response.body().getIndividualMessageListResponses().size() > 0) {

                            individualMessageList.addAll(response.body().getIndividualMessageListResponses());

                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                            binding.recyclerView.setLayoutManager(linearLayoutManager);

                            individualChatListAdapter = new IndividualChatListAdapter(getActivity(), individualMessageList);
                            binding.recyclerView.setAdapter(individualChatListAdapter);

                            individualChatListAdapter.setOnIndividualChatListClickListener(new IndividualChatListAdapter.OnIndividualChatListItemClickListener() {
                                @Override
                                public void onItemClick(View view, int pos) {
                                    IndividualMessageListResponse individualMessageListResponse = individualMessageList.get(pos);

                                    Intent intent = new Intent(getActivity(), IndividualChatDetail.class);
                                    intent.putExtra("name", individualMessageListResponse.getName());
                                    intent.putExtra("chatId", individualMessageListResponse.getChat_id());
                                    intent.putExtra("receiverId", individualMessageListResponse.getReceiver_id());
                                    startActivity(intent);

                                }
                            });

                        } else {

                            // Toast.makeText(getActivity(), "No data found.", Toast.LENGTH_SHORT).show();
                        }


                    } else {

                       // Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<IndividualMessageListModel> call, Throwable t) {
                MyDialog.getInstance(getActivity()).hideDialog();
            }
        });
    }


    @Override
    public void onClick(View view) {

        if (view == binding.fab) {
            Intent intent = new Intent(getActivity(), AllUserFloatingActionMenuActivity.class);
            startActivity(intent);
        }

    }


}

