package com.teamtasticoapp.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.teamtasticoapp.R;
import com.teamtasticoapp.adapter.SelectPlayerNameAdapter;

import com.teamtasticoapp.bean.UserListModel;
import com.teamtasticoapp.bean.UserListResponse;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;
import com.teamtasticoapp.databinding.DialogSelectPlayerNameBinding;
import com.teamtasticoapp.retrofit.ApiClient;
import com.teamtasticoapp.retrofit.ApiInterface;
import com.teamtasticoapp.retrofit.MyDialog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.teamtasticoapp.constants.Constants.DPlayers;
import static com.teamtasticoapp.constants.Constants.kPlayers;

/**
 * Created by mobulous55 on 22/6/18.
 */

public class SelectPlayerNameDialog extends Dialog implements View.OnClickListener {

    private Context context;

    private LayoutInflater inflater;
    DialogSelectPlayerNameBinding binding;
    String Authorization;
    List<UserListResponse> userList = new ArrayList<>();
    //List<UserListResponse> userListDeleted = new ArrayList<>();
    SelectPlayerNameAdapter selectPlayerNameAdapter;
    PlayerInterface onPlayerListener;
    String mTag = "";


    public SelectPlayerNameDialog(@NonNull Context context, PlayerInterface onPlayerListener, String tag) {
        super(context);
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.onPlayerListener = onPlayerListener;
        mTag = tag;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().getAttributes().windowAnimations = R.style.PauseDialogAnimation;
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_select_player_name, null, false);
        setContentView(binding.getRoot());
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        //dialog dismiss on outside touch
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
                WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);//
        setCancelable(false);

        binding.tvCancel.setOnClickListener(this);
        callAllUserListApi();

    }

    private void callAllUserListApi() {

        Authorization = SharedPreferenceWriter.getInstance(context).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(context).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);


        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));


        Call<UserListModel> call = apiInterface.getUserListResult(map);

        call.enqueue(new Callback<UserListModel>() {
            @Override
            public void onResponse(Call<UserListModel> call, Response<UserListModel> response) {
                //  HashMap<String,Object> playerPosition=new HashMap<>();
                MyDialog.getInstance(context).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        // Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_LONG).show();

                        userList.clear();

                        if (response.body().getUserListResponses() != null &&
                                response.body().getUserListResponses().size() > 0) {

                            userList.addAll(response.body().getUserListResponses());

                           /* for(int i=0;i<userList.size();i++){
                                playerPosition.put("p"+i,userList.get(i));
                            }*/


                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                            binding.recyclerView.setLayoutManager(linearLayoutManager);

                          /*  if(!SharedPreferenceWriter.getInstance(context).getString("p0").isEmpty()){
                                playerPosition.remove("p0");
                            }
                            if(!SharedPreferenceWriter.getInstance(context).getString("p1").isEmpty()){
                                playerPosition.remove("p1");
                            }
                            if(!SharedPreferenceWriter.getInstance(context).getString("p2").isEmpty()){
                                playerPosition.remove("p2");
                            }
                            if(!SharedPreferenceWriter.getInstance(context).getString("p3").isEmpty()){
                                playerPosition.remove("p3");
                            }
                            if(!SharedPreferenceWriter.getInstance(context).getString("p4").isEmpty()){
                                playerPosition.remove("p4");
                            }
                            if(!SharedPreferenceWriter.getInstance(context).getString("p5").isEmpty()){
                                playerPosition.remove("p5");
                            }
                            if(!SharedPreferenceWriter.getInstance(context).getString("p6").isEmpty()){
                                playerPosition.remove("p6");
                            }
                            if(!SharedPreferenceWriter.getInstance(context).getString("p7").isEmpty()){
                                playerPosition.remove("p7");
                            }
                            if(!SharedPreferenceWriter.getInstance(context).getString("p8").isEmpty()){
                                playerPosition.remove("p8");

                            } if(!SharedPreferenceWriter.getInstance(context).getString("p9").isEmpty()){
                                playerPosition.remove("p9");

                            } if(!SharedPreferenceWriter.getInstance(context).getString("p10").isEmpty()){
                                playerPosition.remove("p10");
                            }*/


                          /*  userListDeleted.clear();
                            for(int i=0;i<playerPosition.size();i++){
                                userListDeleted.add(i, (UserListResponse) playerPosition.get("p"+i));
                            }*/

                            //  selectPlayerNameAdapter = new SelectPlayerNameAdapter(context, userListDeleted);

                            selectPlayerNameAdapter = new SelectPlayerNameAdapter(context, userList);
                            binding.recyclerView.setAdapter(selectPlayerNameAdapter);


                            selectPlayerNameAdapter.setOnAllContactItemClickListener(new SelectPlayerNameAdapter.OnAllContactItemClickListener() {
                                @Override
                                public void onItemClick(View view, int pos) {
                                    // SharedPreferenceWriter.getInstance(context).writeStringValue("p"+pos,String.valueOf(pos));


                                    try {
                                        // String player = userListDeleted.get(pos).getName();
                                        // String playerImg=userListDeleted.get(pos).getImage();

                                        String playerName = userList.get(pos).getName();
                                        String playerImg = userList.get(pos).getImage();

                                        Bundle bundle = new Bundle();
                                        bundle.putSerializable(DPlayers, (Serializable) userList);

                                        if (onPlayerListener != null) {
                                            onPlayerListener.onPlayerSelect(userList.get(pos),bundle, mTag);
                                        }

                                    } catch (Exception e) {

                                    }


                                    dismiss();

                                }
                            });
                        } else {

                            // Toast.makeText(getActivity(), "No data found.", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        // Toast.makeText(AllUserFloatingActionMenuActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<UserListModel> call, Throwable t) {
                MyDialog.getInstance(context).hideDialog();
            }

        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        dismiss();
    }

    @Override
    public void onClick(View view) {
        if (view == binding.tvCancel) {
            dismiss();
        }

    }

    public interface PlayerInterface {
        void onPlayerSelect(UserListResponse userListResponse, Bundle bundle, String tag);
    }
}
