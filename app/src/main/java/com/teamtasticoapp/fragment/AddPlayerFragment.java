package com.teamtasticoapp.fragment;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ClipData;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Transformation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.teamtasticoapp.R;
import com.teamtasticoapp.activity.JoinTeam;
import com.teamtasticoapp.activity.JoinTeamInfo;
import com.teamtasticoapp.adapter.SelectPlayerNameAdapter;
import com.teamtasticoapp.bean.CommonResponse;
import com.teamtasticoapp.bean.UserListModel;
import com.teamtasticoapp.bean.UserListResponse;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;
import com.teamtasticoapp.dialogs.SelectPlayerNameDialog;
import com.teamtasticoapp.retrofit.ApiClient;
import com.teamtasticoapp.retrofit.ApiInterface;
import com.teamtasticoapp.retrofit.MyDialog;
import com.teamtasticoapp.util.CircleTransform;
import com.teamtasticoapp.util.ColorPicker;
import com.teamtasticoapp.util.HelperClass;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import yuku.ambilwarna.AmbilWarnaDialog;

import static com.teamtasticoapp.constants.Constants.DPlayers;
import static com.teamtasticoapp.constants.Constants.kNumPlayers;
import static com.teamtasticoapp.constants.Constants.kPlayers;


/**
 * Created by mobulous55 on 21/6/18.
 */

public class AddPlayerFragment extends android.support.v4.app.Fragment implements View.OnTouchListener, View.OnClickListener, View.OnLongClickListener {

    private int mPickedColor = Color.WHITE;
    int DefaultColor = Color.WHITE;

    String playerInvisible = "";
    String profileImage = "";
    String p1 = "", p2 = "", p3 = "", p4 = "", p5 = "", p6 = "", p7 = "", p8 = "", p9 = "", p10 = "", p11 = "";
    String n1 = "", n2 = "", n3 = "", n4 = "", n5 = "", n6 = "", n7 = "", n8 = "", n9 = "", n10 = "", n11 = "";


    private ConstraintLayout rootFieldView;
    private int mNumOfPlayers;
    private View vPlayer1;
    private View vPlayer2;
    private View vPlayer3;
    private View vPlayer4;
    private View vPlayer5;
    private View vPlayer6;
    private View vPlayer7;
    private View vPlayer8;
    private View vPlayer9;
    private View vPlayer10;
    private View vPlayer11;

    private ScrollView scrollViewSettings;

    private TextView tvPlayer1;
    private TextView tvPlayer2;
    private TextView tvPlayer3;
    private TextView tvPlayer4;
    private TextView tvPlayer5;
    private TextView tvPlayer6;
    private TextView tvPlayer7;
    private TextView tvPlayer8;
    private TextView tvPlayer9;
    private TextView tvPlayer10;
    private TextView tvPlayer11;

    private ImageView ivSettingOpen;
    private ImageView ivSettingClose;
    private RelativeLayout rlSetting;
    private TextView tvChooseColor;
    private ImageView ivTshirt;
    private ImageView ivProfile;

    private ImageView ivPlayer1;
    private ImageView ivPlayer2;
    private ImageView ivPlayer3;
    private ImageView ivPlayer4;
    private ImageView ivPlayer5;
    private ImageView ivPlayer6;
    private ImageView ivPlayer7;

    private ImageView ivPlayer8;
    private ImageView ivPlayer9;
    private ImageView ivPlayer10;
    private ImageView ivPlayer11;

    private TextView tvSelect;
    TextView tvSaveLineUp;

    private String mNo = "";

    private UserListResponse player1;
    private UserListResponse player2;
    private UserListResponse player3;
    private UserListResponse player4;
    private UserListResponse player5;
    private UserListResponse player6;
    private UserListResponse player7;
    private UserListResponse player8;
    private UserListResponse player9;
    private UserListResponse player10;
    private UserListResponse player11;
    private UserListResponse selectedPlayer;

    String mTAG = "";
    private int mSelectedID;
    String Authorization;
    List<UserListResponse> playerList;
    String noOfSelectedPlayer;
    private TextView tvApply;
    private TextView tvCords;
    private RadioGroup radioGroup;
    private RadioButton rdbutton1;
    private RadioButton rdbutton2;
    String profileSelected = "";
    String jerseySelected = "";
    String hexColor;
    int selectViewTAG = 0;
    private int changed_selectedNumPlayer = 0;
    private boolean isFirstTime = false;
    List<UserListResponse> userList;


    public static Fragment getFragment(List<UserListResponse> playerList, int numberOfPlayers) {
        Fragment fragment = new AddPlayerFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(kPlayers, (Serializable) playerList);
        bundle.putInt(kNumPlayers, numberOfPlayers);
        fragment.setArguments(bundle);
        return fragment;
    }

    public AddPlayerFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            mNumOfPlayers = bundle.getInt(kNumPlayers);
            playerList = (List<UserListResponse>) bundle.getSerializable(kPlayers);
        }

        String firstTime = SharedPreferenceWriter.getInstance(getActivity())
                .getString(SharedPreferenceKey.firstTimeLineSetup);
        if (!firstTime.isEmpty() && firstTime.equalsIgnoreCase("yes")) {
            isFirstTime = true;
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add_player_new, container, false);
        rootFieldView = view.findViewById(R.id.root_view);
        tvSaveLineUp = view.findViewById(R.id.tvSaveLineUp);
        initViews(view);
        initPlayers();

        tvSaveLineUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveLineup();
            }
        });

        rootFieldView.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                if (event.getAction() == DragEvent.ACTION_DROP) {

                    Log.v(getClass().getSimpleName(), "drop");

                    positionView(event);
                    showView(v);
                }
                positionView(event);

                return true;
            }
        });


        if (playerList != null && playerList.size() > 0) {
            String firstTime = SharedPreferenceWriter
                    .getInstance(getActivity()).getString(SharedPreferenceKey.firstTimeLineSetup);
            if (!firstTime.isEmpty() && firstTime.equalsIgnoreCase("yes")) {

                showEmptyPlayers(mNumOfPlayers);
            } else {
                showPlayers(mNumOfPlayers);
            }

        } else {

        }

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (isFirstTime) {
            firstTimeEditPlayers();
        }

    }


    void showPlayers(int mNumOfPlayers) {

        switch (mNumOfPlayers) {

            case 11:
                if (playerList.get(10).getLineup_status().equalsIgnoreCase("yes")) {
                    vPlayer11.setVisibility(View.VISIBLE);
                    setupPlayer(playerList.get(10), tvPlayer11, ivPlayer11);
                    setPosition(vPlayer11, 10);
                }


            case 10:
                if (playerList.get(9).getLineup_status().equalsIgnoreCase("yes")) {
                    vPlayer10.setVisibility(View.VISIBLE);
                    setupPlayer(playerList.get(9), tvPlayer10, ivPlayer10);
                    setPosition(vPlayer10, 9);
                }

            case 9:
                if (playerList.get(8).getLineup_status().equalsIgnoreCase("yes")) {
                    vPlayer9.setVisibility(View.VISIBLE);
                    setupPlayer(playerList.get(8), tvPlayer9, ivPlayer9);
                    setPosition(vPlayer9, 8);
                }

            case 8:
                if (playerList.get(7).getLineup_status().equalsIgnoreCase("yes")) {
                    vPlayer8.setVisibility(View.VISIBLE);
                    setupPlayer(playerList.get(7), tvPlayer8, ivPlayer8);
                    setPosition(vPlayer8, 7);
                }

            case 7:
                if (playerList.get(6).getLineup_status().equalsIgnoreCase("yes")) {
                    vPlayer7.setVisibility(View.VISIBLE);
                    setupPlayer(playerList.get(6), tvPlayer7, ivPlayer7);
                    setPosition(vPlayer7, 6);
                }

            case 6:
                if (playerList.get(5).getLineup_status().equalsIgnoreCase("yes")) {
                    vPlayer6.setVisibility(View.VISIBLE);
                    setupPlayer(playerList.get(5), tvPlayer6, ivPlayer6);
                    setPosition(vPlayer6, 5);
                }

            case 5:
                if (playerList.get(4).getLineup_status().equalsIgnoreCase("yes")) {
                    vPlayer5.setVisibility(View.VISIBLE);
                    setupPlayer(playerList.get(4), tvPlayer5, ivPlayer5);
                    setPosition(vPlayer5, 4);
                }

            case 4:
                if (playerList.get(3).getLineup_status().equalsIgnoreCase("yes")) {
                    vPlayer4.setVisibility(View.VISIBLE);
                    setupPlayer(playerList.get(3), tvPlayer4, ivPlayer4);
                    setPosition(vPlayer4, 3);
                }

            case 3:
                if (playerList.get(2).getLineup_status().equalsIgnoreCase("yes")) {
                    vPlayer3.setVisibility(View.VISIBLE);
                    setupPlayer(playerList.get(2), tvPlayer3, ivPlayer3);
                    setPosition(vPlayer3, 2);
                }

            case 2:
                if (playerList.get(1).getLineup_status().equalsIgnoreCase("yes")) {
                    vPlayer2.setVisibility(View.VISIBLE);
                    setupPlayer(playerList.get(1), tvPlayer2, ivPlayer2);
                    setPosition(vPlayer2, 1);
                }

            case 1:
                if (playerList.get(0).getLineup_status().equalsIgnoreCase("yes")) {
                    vPlayer1.setVisibility(View.VISIBLE);
                    setupPlayer(playerList.get(0), tvPlayer1, ivPlayer1);
                    setPosition(vPlayer1, 0);
                }


        }

    }

    void showEmptyPlayers(int mNumOfPlayers) {
        switch (mNumOfPlayers) {
            case 11:
                vPlayer11.setVisibility(View.VISIBLE);

            case 10:
                vPlayer10.setVisibility(View.VISIBLE);

            case 9:
                vPlayer9.setVisibility(View.VISIBLE);

            case 8:
                vPlayer8.setVisibility(View.VISIBLE);

            case 7:
                vPlayer7.setVisibility(View.VISIBLE);

            case 6:
                vPlayer6.setVisibility(View.VISIBLE);

            case 5:
                vPlayer5.setVisibility(View.VISIBLE);

            case 4:
                vPlayer4.setVisibility(View.VISIBLE);

            case 3:
                vPlayer3.setVisibility(View.VISIBLE);

            case 2:
                vPlayer2.setVisibility(View.VISIBLE);

            case 1:
                vPlayer1.setVisibility(View.VISIBLE);

        }

    }

    private boolean positionView(DragEvent event) {
        float x = event.getX();
        float y = event.getY();
        Log.v("DRAG", "x cords " + x + " y cords " + y);

        if (x == 0.0 || y == 0.0) {
            return true;
        }
        String cords = String.valueOf(x) + " " + String.valueOf(y);
        tvCords.setText(cords);

        String userId = selectedPlayer.getId();
        x = x - 70;
        y = y - 70;

        selectedPlayer.setxCords(String.valueOf(x));
        selectedPlayer.setyCords(String.valueOf(y));

        View view = getView(userId);
        if (view != null) {
            view.setX(x);
            view.setY(y);
        }

        return true;
    }

    private void showView(View view) {
        switch (selectViewTAG) {
            case 1:
                vPlayer1.setVisibility(View.VISIBLE);
                break;
            case 2:
                vPlayer2.setVisibility(View.VISIBLE);
                break;
            case 3:
                vPlayer3.setVisibility(View.VISIBLE);
                break;
            case 4:
                vPlayer4.setVisibility(View.VISIBLE);
                break;
            case 5:
                vPlayer5.setVisibility(View.VISIBLE);
                break;
            case 6:
                vPlayer6.setVisibility(View.VISIBLE);
                break;
            case 7:
                vPlayer7.setVisibility(View.VISIBLE);
                break;
            case 8:
                vPlayer8.setVisibility(View.VISIBLE);
                break;
            case 9:
                vPlayer9.setVisibility(View.VISIBLE);
                break;
            case 10:
                vPlayer10.setVisibility(View.VISIBLE);
                break;
            case 11:
                vPlayer11.setVisibility(View.VISIBLE);
                break;

        }
    }

    private void firstTimeEditPlayers() {

        rootFieldView.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        // Layout has happened here.

                        saveFirstLineup();

                        // Don't forget to remove your listener when you are done with it.
                        rootFieldView.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                    }
                });

    }

    private void showDialogColorPicker(boolean AlphaSupport) {

      /*  // Get a GridView object from ColorPicker class
        GridView gv = (GridView) ColorPicker.getColorPicker(getActivity());

        // Initialize a new AlertDialog.Builder object
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Set the alert dialog content to GridView (color picker)
        builder.setView(gv);

        // Initialize a new AlertDialog object
        final AlertDialog dialog = builder.create();

        // Show the color picker window
        dialog.show();


        // Set an item click listener for GridView widget
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the pickedColor from AdapterView
                mPickedColor = (int) parent.getItemAtPosition(position);
                // Set the layout background color as picked color
                // binding.chooseColor.setBackgroundColor(mPickedColor);
                // binding.llTShirt.setBackgroundColor(mPickedColor);
                hexColor = String.format("#%06X", (0xFFFFFF & mPickedColor));
                ivTshirt.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(hexColor)));

                // close the color picker
                dialog.dismiss();
            }


        });*/

        DefaultColor = ContextCompat.getColor(getActivity(), R.color.colorPrimary);

        AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(getActivity(), DefaultColor, AlphaSupport, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onOk(AmbilWarnaDialog ambilWarnaDialog, int color) {

                DefaultColor = color;

                hexColor = String.format("#%06X", (0xFFFFFF & DefaultColor));
                ivTshirt.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(hexColor)));
            }

            @Override
            public void onCancel(AmbilWarnaDialog ambilWarnaDialog) {

                Toast.makeText(getActivity(), "Color Picker Closed", Toast.LENGTH_SHORT).show();
            }
        });
        ambilWarnaDialog.show();


    }

    private View getView(String userid) {
        if (userid.equals(vPlayer1.getTag())) {
            return vPlayer1;
        } else if (userid.equals(vPlayer2.getTag())) {
            return vPlayer2;
        } else if (userid.equals(vPlayer3.getTag())) {
            return vPlayer3;
        } else if (userid.equals(vPlayer4.getTag())) {
            return vPlayer4;
        } else if (userid.equals(vPlayer5.getTag())) {
            return vPlayer5;
        } else if (userid.equals(vPlayer6.getTag())) {
            return vPlayer6;
        } else if (userid.equals(vPlayer7.getTag())) {
            return vPlayer7;
        } else if (userid.equals(vPlayer8.getTag())) {
            return vPlayer8;
        } else if (userid.equals(vPlayer9.getTag())) {
            return vPlayer9;
        } else if (userid.equals(vPlayer10.getTag())) {
            return vPlayer10;
        } else if (userid.equals(vPlayer11.getTag())) {
            return vPlayer11;
        }

        return null;
    }

    private void initPlayers() {
        switch (mNumOfPlayers) {
            case 11:
                player11 = playerList.get(10);
                vPlayer11.setTag(playerList.get(10).getId());
            case 10:
                player10 = playerList.get(9);
                vPlayer10.setTag(playerList.get(9).getId());
            case 9:
                player9 = playerList.get(8);
                vPlayer9.setTag(playerList.get(8).getId());
            case 8:
                player8 = playerList.get(7);
                vPlayer8.setTag(playerList.get(7).getId());
            case 7:
                player7 = playerList.get(6);
                vPlayer7.setTag(playerList.get(6).getId());
            case 6:
                player6 = playerList.get(5);
                vPlayer6.setTag(playerList.get(5).getId());
            case 5:
                player5 = playerList.get(4);
                vPlayer5.setTag(playerList.get(4).getId());
            case 4:
                player4 = playerList.get(3);
                vPlayer4.setTag(playerList.get(3).getId());
            case 3:
                player3 = playerList.get(2);
                vPlayer3.setTag(playerList.get(2).getId());
            case 2:
                player2 = playerList.get(1);
                vPlayer2.setTag(playerList.get(1).getId());
            case 1:
                player1 = playerList.get(0);
                vPlayer1.setTag(playerList.get(0).getId());
        }


    }

    private void initViews(final View view) {
        vPlayer1 = view.findViewById(R.id.vPlayer1);
        vPlayer2 = view.findViewById(R.id.vPlayer2);
        vPlayer3 = view.findViewById(R.id.vPlayer3);
        vPlayer4 = view.findViewById(R.id.vPlayer4);
        vPlayer5 = view.findViewById(R.id.vPlayer5);
        vPlayer6 = view.findViewById(R.id.vPlayer6);
        vPlayer7 = view.findViewById(R.id.vPlayer7);
        vPlayer8 = view.findViewById(R.id.vPlayer8);
        vPlayer9 = view.findViewById(R.id.vPlayer9);
        vPlayer10 = view.findViewById(R.id.vPlayer10);
        vPlayer11 = view.findViewById(R.id.vPlayer11);

        tvPlayer1 = view.findViewById(R.id.tvPlayer1);
        tvPlayer2 = view.findViewById(R.id.tvPlayer2);
        tvPlayer3 = view.findViewById(R.id.tvPlayer3);
        tvPlayer4 = view.findViewById(R.id.tvPlayer4);
        tvPlayer5 = view.findViewById(R.id.tvPlayer5);
        tvPlayer6 = view.findViewById(R.id.tvPlayer6);
        tvPlayer7 = view.findViewById(R.id.tvPlayer7);
        tvPlayer8 = view.findViewById(R.id.tvPlayer8);
        tvPlayer9 = view.findViewById(R.id.tvPlayer9);
        tvPlayer10 = view.findViewById(R.id.tvPlayer10);
        tvPlayer11 = view.findViewById(R.id.tvPlayer11);

        tvCords = view.findViewById(R.id.tvCords);

        ivSettingOpen = view.findViewById(R.id.ivSettingOpen);
        ivSettingClose = view.findViewById(R.id.ivSettingClose);
        rlSetting = view.findViewById(R.id.rlSetting);
        scrollViewSettings = view.findViewById(R.id.scrollViewSettings);
        tvChooseColor = view.findViewById(R.id.tvChooseColor);
        ivTshirt = view.findViewById(R.id.ivTshirt);
        tvApply = view.findViewById(R.id.tvApply);
        radioGroup = view.findViewById(R.id.radioGroup);
        rdbutton1 = view.findViewById(R.id.rdbutton1);  //Profile picture
        rdbutton2 = view.findViewById(R.id.rdbutton2);  //Change Jersey Color
        ivProfile = view.findViewById(R.id.ivProfile);

        tvSelect = view.findViewById(R.id.tvSelect);


        ivPlayer1 = view.findViewById(R.id.ivPlayer1);
        ivPlayer2 = view.findViewById(R.id.ivPlayer2);
        ivPlayer3 = view.findViewById(R.id.ivPlayer3);
        ivPlayer4 = view.findViewById(R.id.ivPlayer4);
        ivPlayer5 = view.findViewById(R.id.ivPlayer5);
        ivPlayer6 = view.findViewById(R.id.ivPlayer6);
        ivPlayer7 = view.findViewById(R.id.ivPlayer7);
        ivPlayer8 = view.findViewById(R.id.ivPlayer8);
        ivPlayer9 = view.findViewById(R.id.ivPlayer9);
        ivPlayer10 = view.findViewById(R.id.ivPlayer10);
        ivPlayer11 = view.findViewById(R.id.ivPlayer11);


        rdbutton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    profileSelected = "yes";
                    tvChooseColor.setClickable(false);
                } else {
                    profileSelected = "no";
                    tvChooseColor.setClickable(true);
                }
            }
        });

        rdbutton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    profileSelected = "no";
                    tvChooseColor.setClickable(true);

                } else {
                    profileSelected = "yes";
                    tvChooseColor.setClickable(false);
                }
            }
        });


        tvApply.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (profileSelected.equals("yes")) {

                    setDressType();
                    switch (mNumOfPlayers) {
                        case 11:

                            ivPlayer11.setVisibility(View.VISIBLE);

                            if (p11 != null && !p11.isEmpty()) {
                                Picasso.with(getActivity()).load(p11).transform(new CircleTransform()).resize(150, 150).into(ivPlayer11);
                            } else {
                                ivPlayer11.setImageResource(R.drawable.app_logo);
                            }
                            // tvPlayer11.setText(n11);

                            ivPlayer11.setColorFilter(null);
                            ivSettingClose.setVisibility(View.GONE);

                        case 10:
                            ivPlayer10.setVisibility(View.VISIBLE);
                            ivPlayer10.setColorFilter(null);


                            if (p10 != null && !p10.isEmpty()) {
                                Picasso.with(getActivity()).load(p10).transform(new CircleTransform()).resize(150, 150).into(ivPlayer10);
                            } else {
                                ivPlayer10.setImageResource(R.drawable.app_logo);
                            }
                            // tvPlayer10.setText(n10);

                            ivPlayer10.setColorFilter(null);
                            ivSettingClose.setVisibility(View.GONE);


                        case 9:
                            ivPlayer9.setVisibility(View.VISIBLE);

                            if (p9 != null && !p9.isEmpty()) {
                                Picasso.with(getActivity()).load(p9).transform(new CircleTransform()).resize(150, 150).into(ivPlayer9);
                            } else {
                                ivPlayer9.setImageResource(R.drawable.app_logo);
                            }
                            // tvPlayer9.setText(n9);

                            ivPlayer9.setColorFilter(null);
                            ivSettingClose.setVisibility(View.GONE);

                        case 8:
                            ivPlayer8.setVisibility(View.VISIBLE);

                            if (p8 != null && !p8.isEmpty()) {
                                Picasso.with(getActivity()).load(p8).transform(new CircleTransform()).resize(150, 150).into(ivPlayer8);
                            } else {
                                ivPlayer8.setImageResource(R.drawable.app_logo);
                            }
                            // tvPlayer8.setText(n8);

                            ivPlayer8.setColorFilter(null);
                            ivSettingClose.setVisibility(View.GONE);


                        case 7:
                            ivPlayer7.setVisibility(View.VISIBLE);

                            if (p7 != null && !p7.isEmpty()) {
                                Picasso.with(getActivity()).load(p7).transform(new CircleTransform()).resize(150, 150).into(ivPlayer7);
                            } else {
                                ivPlayer7.setImageResource(R.drawable.app_logo);
                            }
                            //  tvPlayer7.setText(n7);

                            ivPlayer7.setColorFilter(null);
                            ivSettingClose.setVisibility(View.GONE);


                        case 6:
                            ivPlayer6.setVisibility(View.VISIBLE);

                            if (p6 != null && !p6.isEmpty()) {
                                Picasso.with(getActivity()).load(p6).transform(new CircleTransform()).resize(150, 150).into(ivPlayer6);
                            } else {
                                ivPlayer6.setImageResource(R.drawable.app_logo);
                            }
                            // tvPlayer6.setText(n6);

                            ivPlayer6.setColorFilter(null);
                            ivSettingClose.setVisibility(View.GONE);


                        case 5:
                            ivPlayer5.setVisibility(View.VISIBLE);

                            if (p5 != null && !p5.isEmpty()) {
                                Picasso.with(getActivity()).load(p5).transform(new CircleTransform()).resize(150, 150).into(ivPlayer5);
                            } else {
                                ivPlayer5.setImageResource(R.drawable.app_logo);
                            }
                            // tvPlayer5.setText(n5);

                            ivPlayer5.setColorFilter(null);
                            ivSettingClose.setVisibility(View.GONE);


                        case 4:
                            ivPlayer4.setVisibility(View.VISIBLE);

                            if (p4 != null && !p4.isEmpty()) {
                                Picasso.with(getActivity()).load(p4).transform(new CircleTransform()).resize(150, 150).into(ivPlayer4);
                            } else {
                                ivPlayer4.setImageResource(R.drawable.app_logo);
                            }
                            // tvPlayer4.setText(n4);

                            ivPlayer4.setColorFilter(null);
                            ivSettingClose.setVisibility(View.GONE);


                        case 3:
                            ivPlayer3.setVisibility(View.VISIBLE);

                            if (p3 != null && !p3.isEmpty()) {
                                Picasso.with(getActivity()).load(p3).transform(new CircleTransform()).resize(150, 150).into(ivPlayer3);
                            } else {
                                ivPlayer3.setImageResource(R.drawable.app_logo);
                            }
                            // tvPlayer3.setText(n3);

                            ivPlayer3.setColorFilter(null);
                            ivSettingClose.setVisibility(View.GONE);


                        case 2:
                            ivPlayer2.setVisibility(View.VISIBLE);

                            if (p2 != null && !p2.isEmpty()) {
                                Picasso.with(getActivity()).load(p2).transform(new CircleTransform()).resize(150, 150).into(ivPlayer2);
                            } else {
                                ivPlayer2.setImageResource(R.drawable.app_logo);
                            }
                            // tvPlayer2.setText(n2);

                            ivPlayer2.setColorFilter(null);
                            ivSettingClose.setVisibility(View.GONE);


                        case 1:
                            ivPlayer1.setVisibility(View.VISIBLE);

                            if (p1 != null && !p1.isEmpty()) {

                                Picasso.with(getActivity()).load(p1).transform(new CircleTransform()).resize(150, 150).into(ivPlayer1);
                            } else {
                                ivPlayer1.setImageResource(R.drawable.app_logo);
                            }
                            // tvPlayer1.setText(n1);

                            ivPlayer1.setColorFilter(null);
                            ivSettingClose.setVisibility(View.GONE);

                    }

                    // showPlayers(mNumOfPlayers);

                } else {
                    hexColor = String.format("#%06X", (0xFFFFFF & DefaultColor));
                    switch (mNumOfPlayers) {
                        case 11: {
                            ivPlayer11.setVisibility(View.VISIBLE);
                            ivPlayer11.setColorFilter(Color.parseColor(hexColor), android.graphics.PorterDuff.Mode.MULTIPLY);
                            playerList.get(10).setDressColor(hexColor);
                            playerList.get(10).setDressType("1");
                            ivSettingClose.setVisibility(View.GONE);

                        }

                        case 10: {
                            ivPlayer10.setVisibility(View.VISIBLE);
                            ivPlayer10.setColorFilter(Color.parseColor(hexColor), android.graphics.PorterDuff.Mode.MULTIPLY);
                            playerList.get(9).setDressColor(hexColor);
                            playerList.get(9).setDressType("1");
                            ivSettingClose.setVisibility(View.GONE);

                        }

                        case 9: {
                            ivPlayer9.setVisibility(View.VISIBLE);
                            ivPlayer9.setColorFilter(Color.parseColor(hexColor), android.graphics.PorterDuff.Mode.MULTIPLY);
                            playerList.get(8).setDressColor(hexColor);
                            playerList.get(8).setDressType("1");
                            ivSettingClose.setVisibility(View.GONE);

                        }

                        case 8: {
                            ivPlayer8.setVisibility(View.VISIBLE);
                            ivPlayer8.setColorFilter(Color.parseColor(hexColor), android.graphics.PorterDuff.Mode.MULTIPLY);
                            playerList.get(7).setDressColor(hexColor);
                            playerList.get(7).setDressType("1");
                            ivSettingClose.setVisibility(View.GONE);

                        }

                        case 7: {
                            ivPlayer7.setVisibility(View.VISIBLE);
                            ivPlayer7.setColorFilter(Color.parseColor(hexColor), android.graphics.PorterDuff.Mode.MULTIPLY);
                            playerList.get(6).setDressColor(hexColor);
                            playerList.get(6).setDressType("1");
                            ivSettingClose.setVisibility(View.GONE);

                        }

                        case 6: {
                            ivPlayer6.setVisibility(View.VISIBLE);
                            ivPlayer6.setColorFilter(Color.parseColor(hexColor), android.graphics.PorterDuff.Mode.MULTIPLY);
                            playerList.get(5).setDressColor(hexColor);
                            playerList.get(5).setDressType("1");
                            ivSettingClose.setVisibility(View.GONE);

                        }

                        case 5: {
                            ivPlayer5.setVisibility(View.VISIBLE);
                            ivPlayer5.setColorFilter(Color.parseColor(hexColor), android.graphics.PorterDuff.Mode.MULTIPLY);
                            playerList.get(4).setDressColor(hexColor);
                            playerList.get(4).setDressType("1");
                            ivSettingClose.setVisibility(View.GONE);

                        }

                        case 4: {
                            ivPlayer4.setVisibility(View.VISIBLE);
                            ivPlayer4.setColorFilter(Color.parseColor(hexColor), android.graphics.PorterDuff.Mode.MULTIPLY);
                            playerList.get(3).setDressColor(hexColor);
                            playerList.get(3).setDressType("1");
                            ivSettingClose.setVisibility(View.GONE);

                        }

                        case 3: {
                            ivPlayer3.setVisibility(View.VISIBLE);
                            ivPlayer3.setColorFilter(Color.parseColor(hexColor), android.graphics.PorterDuff.Mode.MULTIPLY);
                            playerList.get(2).setDressColor(hexColor);
                            playerList.get(2).setDressType("1");
                            ivSettingClose.setVisibility(View.GONE);

                        }

                        case 2: {
                            ivPlayer2.setVisibility(View.VISIBLE);
                            ivPlayer2.setColorFilter(Color.parseColor(hexColor), android.graphics.PorterDuff.Mode.MULTIPLY);
                            playerList.get(1).setDressColor(hexColor);
                            playerList.get(1).setDressType("1");
                            ivSettingClose.setVisibility(View.GONE);

                        }

                        case 1: {
                            ivPlayer1.setVisibility(View.VISIBLE);
                            ivPlayer1.setColorFilter(Color.parseColor(hexColor), android.graphics.PorterDuff.Mode.MULTIPLY);
                            playerList.get(0).setDressColor(hexColor);
                            playerList.get(0).setDressType("1");
                            ivSettingClose.setVisibility(View.GONE);

                        }

                    }

                }

                scrollViewSettings.setVisibility(View.GONE);
                ivSettingClose.setVisibility(View.GONE);
                ivSettingOpen.setVisibility(View.VISIBLE);
                tvSaveLineUp.setVisibility(View.VISIBLE);

                if (changed_selectedNumPlayer == -1) {
                    tvSaveLineUp.setVisibility(View.GONE);
                }

                // showPlayers(mNumOfPlayers);
                showApplyPlayers(mNumOfPlayers);

            }
        });


        ivSettingOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollViewSettings.setVisibility(View.VISIBLE);
                ivSettingClose.setVisibility(View.VISIBLE);
                ivSettingOpen.setVisibility(View.GONE);
                tvSaveLineUp.setVisibility(View.GONE);

                setVisibilityAsPerNumPlayer(mNumOfPlayers, false);

            }
        });

        ivSettingClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                rlSetting.setVisibility(View.GONE);
                scrollViewSettings.setVisibility(View.GONE);
                ivSettingClose.setVisibility(View.GONE);
                ivSettingOpen.setVisibility(View.VISIBLE);
                tvSaveLineUp.setVisibility(View.VISIBLE);

                showPlayers(mNumOfPlayers);
            }
        });

        tvChooseColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showDialogColorPicker();
                showDialogColorPicker(false);
            }
        });

        tvSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleDropDownIcon();
                openDropDownNoOfPlayer();
            }
        });


        vPlayer1.setOnTouchListener(this);
        vPlayer2.setOnTouchListener(this);
        vPlayer3.setOnTouchListener(this);
        vPlayer4.setOnTouchListener(this);
        vPlayer5.setOnTouchListener(this);
        vPlayer6.setOnTouchListener(this);
        vPlayer7.setOnTouchListener(this);
        vPlayer8.setOnTouchListener(this);
        vPlayer9.setOnTouchListener(this);
        vPlayer10.setOnTouchListener(this);
        vPlayer11.setOnTouchListener(this);


        view.findViewById(R.id.ivRed1).setOnClickListener(this);
        view.findViewById(R.id.ivRed2).setOnClickListener(this);
        view.findViewById(R.id.ivRed3).setOnClickListener(this);
        view.findViewById(R.id.ivRed4).setOnClickListener(this);
        view.findViewById(R.id.ivRed5).setOnClickListener(this);
        view.findViewById(R.id.ivRed6).setOnClickListener(this);
        view.findViewById(R.id.ivRed7).setOnClickListener(this);
        view.findViewById(R.id.ivRed8).setOnClickListener(this);
        view.findViewById(R.id.ivRed9).setOnClickListener(this);
        view.findViewById(R.id.ivRed10).setOnClickListener(this);
        view.findViewById(R.id.ivRed11).setOnClickListener(this);


        view.findViewById(R.id.ivGreen1).setOnClickListener(this);
        view.findViewById(R.id.ivGreen2).setOnClickListener(this);
        view.findViewById(R.id.ivGreen3).setOnClickListener(this);
        view.findViewById(R.id.ivGreen4).setOnClickListener(this);
        view.findViewById(R.id.ivGreen5).setOnClickListener(this);
        view.findViewById(R.id.ivGreen6).setOnClickListener(this);
        view.findViewById(R.id.ivGreen7).setOnClickListener(this);
        view.findViewById(R.id.ivGreen8).setOnClickListener(this);
        view.findViewById(R.id.ivGreen9).setOnClickListener(this);
        view.findViewById(R.id.ivGreen10).setOnClickListener(this);
        view.findViewById(R.id.ivGreen11).setOnClickListener(this);

        view.findViewById(R.id.tvPlayer1).setOnLongClickListener(this);
        view.findViewById(R.id.tvPlayer2).setOnLongClickListener(this);
        view.findViewById(R.id.tvPlayer3).setOnLongClickListener(this);
        view.findViewById(R.id.tvPlayer4).setOnLongClickListener(this);
        view.findViewById(R.id.tvPlayer5).setOnLongClickListener(this);
        view.findViewById(R.id.tvPlayer6).setOnLongClickListener(this);
        view.findViewById(R.id.tvPlayer7).setOnLongClickListener(this);
        view.findViewById(R.id.tvPlayer8).setOnLongClickListener(this);
        view.findViewById(R.id.tvPlayer9).setOnLongClickListener(this);
        view.findViewById(R.id.tvPlayer10).setOnLongClickListener(this);
        view.findViewById(R.id.tvPlayer11).setOnLongClickListener(this);

        resetPlayers();
    }

    private void showApplyPlayers(int mNumOfPlayers) {

        switch (mNumOfPlayers) {

            case 11:
                if (playerList.get(10).getLineup_status().equalsIgnoreCase("yes")) {
                    vPlayer11.setVisibility(View.VISIBLE);
                    setupPlayerImage(playerList.get(10), tvPlayer11, ivPlayer11);
                    setPosition(vPlayer11, 10);
                }


            case 10:
                if (playerList.get(9).getLineup_status().equalsIgnoreCase("yes")) {
                    vPlayer10.setVisibility(View.VISIBLE);
                    setupPlayerImage(playerList.get(9), tvPlayer10, ivPlayer10);
                    setPosition(vPlayer10, 9);
                }

            case 9:
                if (playerList.get(8).getLineup_status().equalsIgnoreCase("yes")) {
                    vPlayer9.setVisibility(View.VISIBLE);
                    setupPlayerImage(playerList.get(8), tvPlayer9, ivPlayer9);
                    setPosition(vPlayer9, 8);
                }

            case 8:
                if (playerList.get(7).getLineup_status().equalsIgnoreCase("yes")) {
                    vPlayer8.setVisibility(View.VISIBLE);
                    setupPlayerImage(playerList.get(7), tvPlayer8, ivPlayer8);
                    setPosition(vPlayer8, 7);
                }

            case 7:
                if (playerList.get(6).getLineup_status().equalsIgnoreCase("yes")) {
                    vPlayer7.setVisibility(View.VISIBLE);
                    setupPlayerImage(playerList.get(6), tvPlayer7, ivPlayer7);
                    setPosition(vPlayer7, 6);
                }

            case 6:
                if (playerList.get(5).getLineup_status().equalsIgnoreCase("yes")) {
                    vPlayer6.setVisibility(View.VISIBLE);
                    setupPlayerImage(playerList.get(5), tvPlayer6, ivPlayer6);
                    setPosition(vPlayer6, 5);
                }

            case 5:
                if (playerList.get(4).getLineup_status().equalsIgnoreCase("yes")) {
                    vPlayer5.setVisibility(View.VISIBLE);
                    setupPlayerImage(playerList.get(4), tvPlayer5, ivPlayer5);
                    setPosition(vPlayer5, 4);
                }

            case 4:
                if (playerList.get(3).getLineup_status().equalsIgnoreCase("yes")) {
                    vPlayer4.setVisibility(View.VISIBLE);
                    setupPlayerImage(playerList.get(3), tvPlayer4, ivPlayer4);
                    setPosition(vPlayer4, 3);
                }

            case 3:
                if (playerList.get(2).getLineup_status().equalsIgnoreCase("yes")) {
                    vPlayer3.setVisibility(View.VISIBLE);
                    setupPlayerImage(playerList.get(2), tvPlayer3, ivPlayer3);
                    setPosition(vPlayer3, 2);
                }

            case 2:
                if (playerList.get(1).getLineup_status().equalsIgnoreCase("yes")) {
                    vPlayer2.setVisibility(View.VISIBLE);
                    setupPlayerImage(playerList.get(1), tvPlayer2, ivPlayer2);
                    setPosition(vPlayer2, 1);
                }

            case 1:
                if (playerList.get(0).getLineup_status().equalsIgnoreCase("yes")) {
                    vPlayer1.setVisibility(View.VISIBLE);
                    setupPlayerImage(playerList.get(0), tvPlayer1, ivPlayer1);
                    setPosition(vPlayer1, 0);
                }


        }

    }

    private void setupPlayerImage(UserListResponse userListResponse, TextView tvPlayer, ImageView ivPlayer) {

        // dress_type 1 for profile pic and dress_type 2 for dress color
        if (userListResponse.getDressType().equalsIgnoreCase("2")) {

            if (userListResponse.getpImage().contains("https:")) {
                Picasso.with(getContext()).load(userListResponse.getpImage()).transform(new
                        CircleTransform()).resize(150, 150).into(ivPlayer);
            }

        } else {
            String hexcolor = userListResponse.getDressColor();
            if (!hexcolor.isEmpty()) {
                hexcolor = (hexcolor != null) ? hexcolor : "#FFFFFF";
                int c = Color.parseColor(hexcolor);
                ivPlayer.setImageDrawable(getResources().getDrawable(R.drawable.player_tshirt));
                ivPlayer.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(hexcolor)));
                ivPlayer.setColorFilter(c, PorterDuff.Mode.MULTIPLY);
            }

        }
    }

    void makeAllTouchable() {

        vPlayer1.setOnTouchListener(this);
        vPlayer2.setOnTouchListener(this);
        vPlayer3.setOnTouchListener(this);
        vPlayer4.setOnTouchListener(this);
        vPlayer5.setOnTouchListener(this);
        vPlayer6.setOnTouchListener(this);
        vPlayer7.setOnTouchListener(this);
        vPlayer8.setOnTouchListener(this);
        vPlayer9.setOnTouchListener(this);
        vPlayer10.setOnTouchListener(this);
        vPlayer11.setOnTouchListener(this);
    }

    private void setVisibilityAsPerNumPlayer(int mNumOfPlayers, boolean isVisible) {
        int makeVisible = 0;

        if (isVisible)
            makeVisible = View.VISIBLE;
        else
            makeVisible = View.GONE;

        switch (mNumOfPlayers) {
            case 11:
                vPlayer11.setVisibility(makeVisible);

            case 10:
                vPlayer10.setVisibility(makeVisible);

            case 9:
                vPlayer9.setVisibility(makeVisible);

            case 8:
                vPlayer8.setVisibility(makeVisible);

            case 7:
                vPlayer7.setVisibility(makeVisible);

            case 6:
                vPlayer6.setVisibility(makeVisible);

            case 5:
                vPlayer5.setVisibility(makeVisible);

            case 4:
                vPlayer4.setVisibility(makeVisible);

            case 3:
                vPlayer3.setVisibility(makeVisible);

            case 2:
                vPlayer2.setVisibility(makeVisible);

            case 1:
                vPlayer1.setVisibility(makeVisible);

        }
    }

    private void toggleDropDownIcon() {
        tvSelect.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null,
                getResources().getDrawable(R.drawable.uparrow), null);
    }

    private void resetPlayers() {
        vPlayer1.setVisibility(View.INVISIBLE);
        vPlayer2.setVisibility(View.INVISIBLE);
        vPlayer3.setVisibility(View.INVISIBLE);
        vPlayer4.setVisibility(View.INVISIBLE);
        vPlayer5.setVisibility(View.INVISIBLE);
        vPlayer6.setVisibility(View.INVISIBLE);
        vPlayer7.setVisibility(View.INVISIBLE);
        vPlayer8.setVisibility(View.INVISIBLE);
        vPlayer9.setVisibility(View.INVISIBLE);
        vPlayer10.setVisibility(View.INVISIBLE);
        vPlayer11.setVisibility(View.INVISIBLE);

        makeAllTouchable();
    }


    /* Dress type 1 for jersey and i =2 for logo */
    private void setDressType() {
        for (UserListResponse player : playerList) {
            player.setDressType("2");
            player.setDressColor("#ffffff");
        }
    }


    private void openDropDownNoOfPlayer() {

        final List<String> NoOfPlayerList = new ArrayList<>();
        NoOfPlayerList.add("None");

        for (int i = 0; i < playerList.size(); i++) {
            int sum = i + 1;
            NoOfPlayerList.add("" + sum);
        }


        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item, NoOfPlayerList);
        final ListPopupWindow listPopupWindow = new ListPopupWindow(getActivity());
        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedNoOfPlayer = NoOfPlayerList.get(i);
                tvSelect.setText(selectedNoOfPlayer);
                if (selectedNoOfPlayer.equalsIgnoreCase("None")) {

                    listPopupWindow.dismiss();

                    changed_selectedNumPlayer = -1;
                    mNumOfPlayers = changed_selectedNumPlayer;

                    if (-1 == Integer.parseInt(String.valueOf(Integer.parseInt(String.valueOf(mNumOfPlayers))))) {
                        vPlayer1.setVisibility(View.GONE);
                        vPlayer2.setVisibility(View.GONE);
                        vPlayer3.setVisibility(View.GONE);
                        vPlayer4.setVisibility(View.GONE);
                        vPlayer5.setVisibility(View.GONE);
                        vPlayer6.setVisibility(View.GONE);
                        vPlayer7.setVisibility(View.GONE);
                        vPlayer8.setVisibility(View.GONE);
                        vPlayer9.setVisibility(View.GONE);
                        vPlayer10.setVisibility(View.GONE);
                        vPlayer11.setVisibility(View.GONE);
                    }

                    return;
                } else {

                    if (0 == Integer.parseInt(selectedNoOfPlayer)) {
                        changed_selectedNumPlayer = 0;
                    } else {
                        changed_selectedNumPlayer = Integer.parseInt(selectedNoOfPlayer);
                    }

                    mNumOfPlayers = changed_selectedNumPlayer;

                    try {
                        int m = Integer.parseInt(selectedNoOfPlayer);

                        for (int k = 0; k < playerList.size(); k++) {
                            if (k <= m) {
                                playerList.get(k).setLineup_status("yes");
                            } else {
                                playerList.get(k).setLineup_status("no");
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                listPopupWindow.dismiss();
            }
        });
        listPopupWindow.setAnchorView(tvSelect);
        listPopupWindow.setHeight(600);
        listPopupWindow.setAdapter(arrayAdapter);
        listPopupWindow.show();

    }

    @Override
    public boolean onTouch(View v, MotionEvent motionEvent) {

        switch (v.getId()) {

            case R.id.vPlayer1: {
                if (player1 != null) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                    v.startDrag(data, shadowBuilder, v, 0);
                    player1.setxCords(String.valueOf(v.getX()));
                    player1.setyCords(String.valueOf(v.getY()));
                    selectedPlayer = playerList.get(0);
                    mTAG = selectedPlayer.getId();
                    vPlayer1.setTag(mTAG);
                    vPlayer1.setVisibility(View.GONE);
                    selectViewTAG = 1;
                }
            }
            break;

            case R.id.vPlayer2: {
                if (player2 != null) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                    v.startDrag(data, shadowBuilder, v, 0);
                    player2.setxCords(String.valueOf(v.getX()));
                    player2.setyCords(String.valueOf(v.getY()));
                    selectedPlayer = playerList.get(1);
                    mTAG = selectedPlayer.getId();
                    vPlayer2.setTag(mTAG);
                    vPlayer2.setVisibility(View.GONE);
                    selectViewTAG = 2;
                }
            }
            break;

            case R.id.vPlayer3: {
                if (player3 != null) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                    v.startDrag(data, shadowBuilder, v, 0);
                    player3.setxCords(String.valueOf(v.getX()));
                    player3.setyCords(String.valueOf(v.getY()));
                    selectedPlayer = playerList.get(2);
                    mTAG = selectedPlayer.getId();
                    vPlayer3.setTag(mTAG);
                    vPlayer3.setVisibility(View.GONE);
                    selectViewTAG = 3;
                }
            }
            break;

            case R.id.vPlayer4: {
                if (player4 != null) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                    v.startDrag(data, shadowBuilder, v, 0);
                    player4.setxCords(String.valueOf(v.getX()));
                    player4.setyCords(String.valueOf(v.getY()));
                    selectedPlayer = playerList.get(3);
                    mTAG = selectedPlayer.getId();
                    vPlayer4.setTag(mTAG);
                    vPlayer4.setVisibility(View.GONE);
                    selectViewTAG = 4;
                }
            }

            break;
            case R.id.vPlayer5: {
                if (player5 != null) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                    v.startDrag(data, shadowBuilder, v, 0);
                    player5.setxCords(String.valueOf(v.getX()));
                    player5.setyCords(String.valueOf(v.getY()));
                    selectedPlayer = playerList.get(4);
                    mTAG = selectedPlayer.getId();
                    vPlayer5.setTag(mTAG);
                    vPlayer5.setVisibility(View.GONE);
                    selectViewTAG = 5;
                }
            }
            break;

            case R.id.vPlayer6: {
                if (player6 != null) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                    v.startDrag(data, shadowBuilder, v, 0);
                    player6.setxCords(String.valueOf(v.getX()));
                    player6.setyCords(String.valueOf(v.getY()));
                    selectedPlayer = playerList.get(5);
                    mTAG = selectedPlayer.getId();
                    vPlayer6.setTag(mTAG);
                    vPlayer6.setVisibility(View.GONE);
                    selectViewTAG = 6;
                }
            }
            break;

            case R.id.vPlayer7: {
                if (player7 != null) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                    v.startDrag(data, shadowBuilder, v, 0);
                    player7.setxCords(String.valueOf(v.getX()));
                    player7.setyCords(String.valueOf(v.getY()));
                    selectedPlayer = playerList.get(6);
                    mTAG = selectedPlayer.getId();
                    vPlayer7.setTag(mTAG);
                    vPlayer7.setVisibility(View.GONE);
                    selectViewTAG = 7;
                }
            }

            break;

            case R.id.vPlayer8: {
                if (player8 != null) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                    v.startDrag(data, shadowBuilder, v, 0);
                    player8.setxCords(String.valueOf(v.getX()));
                    player8.setyCords(String.valueOf(v.getY()));
                    selectedPlayer = playerList.get(7);
                    mTAG = selectedPlayer.getId();
                    vPlayer8.setTag(mTAG);
                    vPlayer8.setVisibility(View.GONE);
                    selectViewTAG = 8;
                }
            }
            break;

            case R.id.vPlayer9: {
                if (player9 != null) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                    v.startDrag(data, shadowBuilder, v, 0);
                    player9.setxCords(String.valueOf(v.getX()));
                    player9.setyCords(String.valueOf(v.getY()));
                    selectedPlayer = playerList.get(8);
                    mTAG = selectedPlayer.getId();
                    vPlayer9.setTag(mTAG);
                    vPlayer9.setVisibility(View.GONE);
                    selectViewTAG = 9;
                }
            }
            break;

            case R.id.vPlayer10: {
                if (player10 != null) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                    v.startDrag(data, shadowBuilder, v, 0);
                    player10.setxCords(String.valueOf(v.getX()));
                    player10.setyCords(String.valueOf(v.getY()));
                    selectedPlayer = playerList.get(9);
                    mTAG = selectedPlayer.getId();
                    vPlayer10.setTag(mTAG);
                    vPlayer10.setVisibility(View.GONE);
                    selectViewTAG = 10;
                }
            }
            break;

            case R.id.vPlayer11: {
                if (player11 != null) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                    v.startDrag(data, shadowBuilder, v, 0);
                    player11.setxCords(String.valueOf(v.getX()));
                    player11.setyCords(String.valueOf(v.getY()));
                    selectedPlayer = playerList.get(10);
                    mTAG = selectedPlayer.getId();
                    vPlayer11.setTag(mTAG);
                    vPlayer11.setVisibility(View.GONE);
                    selectViewTAG = 11;
                }
            }
            break;

            default:
                selectViewTAG = 0;
        }
        return true;
    }


    @Override
    public void onClick(View view) {

        String tag = (String) view.getTag();

        if (tag.equals("r1")) {
            // Toast.makeText(getContext(), "r1", Toast.LENGTH_SHORT).show();
            playerInvisible = "r1";
            showWantToDeletePopUp(tag);

        } else if (tag.equals("r2")) {
            // Toast.makeText(getContext(), "r2", Toast.LENGTH_SHORT).show();
            playerInvisible = "r2";
            showWantToDeletePopUp(tag);

        } else if (tag.equals("r3")) {
            // Toast.makeText(getContext(), "r3", Toast.LENGTH_SHORT).show();
            playerInvisible = "r3";
            showWantToDeletePopUp(tag);

        } else if (tag.equals("r4")) {
            // Toast.makeText(getContext(), "r4", Toast.LENGTH_SHORT).show();
            playerInvisible = "r4";
            showWantToDeletePopUp(tag);

        } else if (tag.equals("r5")) {
            // Toast.makeText(getContext(), "r5", Toast.LENGTH_SHORT).show();
            playerInvisible = "r5";
            showWantToDeletePopUp(tag);

        } else if (tag.equals("r6")) {
            // Toast.makeText(getContext(), "r6", Toast.LENGTH_SHORT).show();
            playerInvisible = "r6";
            showWantToDeletePopUp(tag);

        } else if (tag.equals("r7")) {
            // Toast.makeText(getContext(), "r7", Toast.LENGTH_SHORT).show();
            playerInvisible = "r7";
            showWantToDeletePopUp(tag);

        } else if (tag.equals("r8")) {
            // Toast.makeText(getContext(), "r8", Toast.LENGTH_SHORT).show();
            playerInvisible = "r8";
            showWantToDeletePopUp(tag);

        } else if (tag.equals("r9")) {
            // Toast.makeText(getContext(), "r9", Toast.LENGTH_SHORT).show();
            playerInvisible = "r9";
            showWantToDeletePopUp(tag);

        } else if (tag.equals("r10")) {
            // Toast.makeText(getContext(), "r10", Toast.LENGTH_SHORT).show();
            playerInvisible = "r10";
            showWantToDeletePopUp(tag);

        } else if (tag.equals("r11")) {
            // Toast.makeText(getContext(), "r11", Toast.LENGTH_SHORT).show();
            playerInvisible = "r11";
            showWantToDeletePopUp(tag);


        } else if (tag.equals("g1")) {
            // Toast.makeText(getContext(), "g1", Toast.LENGTH_SHORT).show();
            showGreenDialog(tag);
        } else if (tag.equals("g2")) {
            // Toast.makeText(getContext(), "g2", Toast.LENGTH_SHORT).show();
            showGreenDialog(tag);
        } else if (tag.equals("g3")) {
            // Toast.makeText(getContext(), "g3", Toast.LENGTH_SHORT).show();
            showGreenDialog(tag);
        } else if (tag.equals("g4")) {
            // Toast.makeText(getContext(), "g4", Toast.LENGTH_SHORT).show();
            showGreenDialog(tag);
        } else if (tag.equals("g5")) {
            // Toast.makeText(getContext(), "g5", Toast.LENGTH_SHORT).show();
            showGreenDialog(tag);
        } else if (tag.equals("g6")) {
            // Toast.makeText(getContext(), "g6", Toast.LENGTH_SHORT).show();
            showGreenDialog(tag);
        } else if (tag.equals("g7")) {
            // Toast.makeText(getContext(), "g7", Toast.LENGTH_SHORT).show();
            showGreenDialog(tag);
        } else if (tag.equals("g8")) {
            // Toast.makeText(getContext(), "g8", Toast.LENGTH_SHORT).show();
            showGreenDialog(tag);
        } else if (tag.equals("g9")) {
            // Toast.makeText(getContext(), "g9", Toast.LENGTH_SHORT).show();
            showGreenDialog(tag);
        } else if (tag.equals("g10")) {
            // Toast.makeText(getContext(), "g10", Toast.LENGTH_SHORT).show();
            showGreenDialog(tag);
        } else if (tag.equals("g11")) {
            // Toast.makeText(getContext(), "g11", Toast.LENGTH_SHORT).show();
            showGreenDialog(tag);
        }
    }

    private void showWantToDeletePopUp(final String tag) {

        final Dialog dialog = new Dialog(getActivity(), R.style.ThemeDialogCustom);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //binding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.pop_up_delete_player, null, false);
        dialog.setContentView(R.layout.pop_up_delete_player);

        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);
        Button btnYes = dialog.findViewById(R.id.btnYes);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

                if (playerInvisible.equals("r1")) {
                    vPlayer1.setVisibility(View.INVISIBLE);
                } else if (playerInvisible.equals("r2")) {
                    vPlayer2.setVisibility(View.INVISIBLE);
                } else if (playerInvisible.equals("r3")) {
                    vPlayer3.setVisibility(View.INVISIBLE);
                } else if (playerInvisible.equals("r4")) {
                    vPlayer4.setVisibility(View.INVISIBLE);
                } else if (playerInvisible.equals("r5")) {
                    vPlayer5.setVisibility(View.INVISIBLE);
                } else if (playerInvisible.equals("r6")) {
                    vPlayer6.setVisibility(View.INVISIBLE);
                } else if (playerInvisible.equals("r7")) {
                    vPlayer7.setVisibility(View.INVISIBLE);
                } else if (playerInvisible.equals("r8")) {
                    vPlayer8.setVisibility(View.INVISIBLE);
                } else if (playerInvisible.equals("r9")) {
                    vPlayer9.setVisibility(View.INVISIBLE);
                } else if (playerInvisible.equals("r10")) {
                    vPlayer10.setVisibility(View.INVISIBLE);
                } else if (playerInvisible.equals("r11")) {
                    vPlayer11.setVisibility(View.INVISIBLE);
                }

            }
        });
        TextView tvNo = dialog.findViewById(R.id.tvNo);

        tvNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }

    private void showGreenDialog(String tag) {
        new SelectPlayerNameDialog(getActivity(), onPlayerListener, tag).show();
    }

    SelectPlayerNameDialog.PlayerInterface onPlayerListener = new SelectPlayerNameDialog.PlayerInterface() {

        @Override
        public void onPlayerSelect(UserListResponse userListResponse, Bundle bundle, String tag) {
            if (bundle != null) {
                userList = (List<UserListResponse>) bundle.getSerializable(DPlayers);
            }

            if (tag.equals("g1")) {

                tvPlayer1.setText(userListResponse.getName());
                p1 = userListResponse.getImage();
                // Picasso.with(getActivity()).load(profileImage).transform(new CircleTransform()).resize(150, 150).into(ivPlayer1);


            } else if (tag.equals("g2")) {

                tvPlayer2.setText(userListResponse.getName());
                p2 = userListResponse.getImage();
                // Picasso.with(getActivity()).load(profileImage).transform(new CircleTransform()).resize(150, 150).into(ivPlayer2);


            } else if (tag.equals("g3")) {

                tvPlayer3.setText(userListResponse.getName());
                p3 = userListResponse.getImage();
                // Picasso.with(getActivity()).load(profileImage).transform(new CircleTransform()).resize(150, 150).into(ivPlayer3);


            } else if (tag.equals("g4")) {

                tvPlayer4.setText(userListResponse.getName());
                p4 = userListResponse.getImage();
                //  Picasso.with(getActivity()).load(profileImage).transform(new CircleTransform()).resize(150, 150).into(ivPlayer4);


            } else if (tag.equals("g5")) {
                tvPlayer5.setText(userListResponse.getName());
                p5 = userListResponse.getImage();
                //  Picasso.with(getActivity()).load(profileImage).transform(new CircleTransform()).resize(150, 150).into(ivPlayer5);


            } else if (tag.equals("g6")) {
                tvPlayer6.setText(userListResponse.getName());
                p6 = userListResponse.getImage();
                // Picasso.with(getActivity()).load(profileImage).transform(new CircleTransform()).resize(150, 150).into(ivPlayer6);


            } else if (tag.equals("g7")) {
                tvPlayer7.setText(userListResponse.getName());
                p7 = userListResponse.getImage();
                // Picasso.with(getActivity()).load(profileImage).transform(new CircleTransform()).resize(150, 150).into(ivPlayer7);


            } else if (tag.equals("g8")) {
                tvPlayer8.setText(userListResponse.getName());
                p8 = userListResponse.getImage();
                //  Picasso.with(getActivity()).load(profileImage).transform(new CircleTransform()).resize(150, 150).into(ivPlayer8);


            } else if (tag.equals("g9")) {
                tvPlayer9.setText(userListResponse.getName());
                p9 = userListResponse.getImage();
                // Picasso.with(getActivity()).load(profileImage).transform(new CircleTransform()).resize(150, 150).into(ivPlayer9);


            } else if (tag.equals("g10")) {
                tvPlayer10.setText(userListResponse.getName());
                p10 = userListResponse.getImage();
                // Picasso.with(getActivity()).load(profileImage).transform(new CircleTransform()).resize(150, 150).into(ivPlayer10);


            } else if (tag.equals("g11")) {
                tvPlayer11.setText(userListResponse.getName());
                p11 = userListResponse.getImage();
                // Picasso.with(getActivity()).load(profileImage).transform(new CircleTransform()).resize(150, 150).into(ivPlayer11);


            } else if (tag.equals("t1")) {
                // tvPlayer1.setText(name);
                tvPlayer1.setText(userListResponse.getName());

            } else if (tag.equals("t2")) {
                // tvPlayer2.setText(name);
                tvPlayer2.setText(userListResponse.getName());

            } else if (tag.equals("t3")) {
                //  tvPlayer3.setText(name);
                tvPlayer3.setText(userListResponse.getName());

            } else if (tag.equals("t4")) {
                //  tvPlayer4.setText(name);
                tvPlayer4.setText(userListResponse.getName());

            } else if (tag.equals("t5")) {
                //  tvPlayer5.setText(name);
                tvPlayer5.setText(userListResponse.getName());

            } else if (tag.equals("t6")) {
                // tvPlayer6.setText(name);
                tvPlayer6.setText(userListResponse.getName());

            } else if (tag.equals("t7")) {
                //  tvPlayer7.setText(name);
                tvPlayer7.setText(userListResponse.getName());

            } else if (tag.equals("t8")) {
                // tvPlayer8.setText(name);
                tvPlayer8.setText(userListResponse.getName());

            } else if (tag.equals("t9")) {
                // tvPlayer9.setText(name);
                tvPlayer9.setText(userListResponse.getName());

            } else if (tag.equals("t10")) {
                // tvPlayer10.setText(name);
                tvPlayer10.setText(userListResponse.getName());

            } else if (tag.equals("t11")) {
                // tvPlayer11.setText(name);
                tvPlayer11.setText(userListResponse.getName());

            }
        }
    };



       /* @Override
        public void onPlayerSelect(String name, String img, String tag) {

            Bundle bundle = getArguments();
            if (bundle != null) {
                userList = (List<UserListResponse>) bundle.getSerializable(kPlayers);
            }

            if (tag.equals("g1")) {

                tvPlayer1.setText(userList.get(0).getName());
                p1 = img;

            } else if (tag.equals("g2")) {

                tvPlayer2.setText(userList.get(1).getName());
                p2 = img;

            } else if (tag.equals("g3")) {

                tvPlayer3.setText(userList.get(2).getName());
                p3 = img;


            } else if (tag.equals("g4")) {

                tvPlayer4.setText(userList.get(3).getName());
                p4 = img;

            } else if (tag.equals("g5")) {
                tvPlayer5.setText(userList.get(4).getName());
                p5 = img;

            } else if (tag.equals("g6")) {
                tvPlayer6.setText(userList.get(5).getName());
                p6 = img;

            } else if (tag.equals("g7")) {
                tvPlayer7.setText(userList.get(6).getName());
                p7 = img;

            } else if (tag.equals("g8")) {
                tvPlayer8.setText(userList.get(7).getName());
                p8 = img;

            } else if (tag.equals("g9")) {
                tvPlayer9.setText(userList.get(8).getName());
                p9 = img;

            } else if (tag.equals("g10")) {
                tvPlayer10.setText(userList.get(9).getName());
                p10 = img;

            } else if (tag.equals("g11")) {
                tvPlayer11.setText(userList.get(10).getName());
                p11 = img;

            } else if (tag.equals("t1")) {
                tvPlayer1.setText(name);
            } else if (tag.equals("t2")) {
                tvPlayer2.setText(name);
            } else if (tag.equals("t3")) {
                tvPlayer3.setText(name);
            } else if (tag.equals("t4")) {
                tvPlayer4.setText(name);
            } else if (tag.equals("t5")) {
                tvPlayer5.setText(name);
            } else if (tag.equals("t6")) {
                tvPlayer6.setText(name);
            } else if (tag.equals("t7")) {
                tvPlayer7.setText(name);
            } else if (tag.equals("t8")) {
                tvPlayer8.setText(name);
            } else if (tag.equals("t9")) {
                tvPlayer9.setText(name);
            } else if (tag.equals("t10")) {
                tvPlayer10.setText(name);
            } else if (tag.equals("t11")) {
                tvPlayer11.setText(name);
            }
        }
    };*/


    private String getP(int i) {
        switch (i) {
            case 0:
                return p1;

            case 1:
                return p2;

            case 2:
                return p3;

            case 3:
                return p4;

            case 4:
                return p5;

            case 5:
                return p6;

            case 6:
                return p7;

            case 7:
                return p8;

            case 8:
                return p9;

            case 9:
                return p10;

            case 10:
                return p11;

            default:
                return null;
        }

    }


    @Override
    public boolean onLongClick(View view) {
        String tag = (String) view.getTag();
        if (tag.equals("t1")) {
            // Toast.makeText(getContext(), "t1", Toast.LENGTH_SHORT).show();
            showGreenDialog(tag);

        } else if (tag.equals("t2")) {
            // Toast.makeText(getContext(), "t2", Toast.LENGTH_SHORT).show();
            showGreenDialog(tag);

        } else if (tag.equals("t3")) {
            // Toast.makeText(getContext(), "t3", Toast.LENGTH_SHORT).show();
            showGreenDialog(tag);

        } else if (tag.equals("t4")) {
            // Toast.makeText(getContext(), "t4", Toast.LENGTH_SHORT).show();
            showGreenDialog(tag);

        } else if (tag.equals("t5")) {
            // Toast.makeText(getContext(), "t5", Toast.LENGTH_SHORT).show();
            showGreenDialog(tag);

        } else if (tag.equals("t6")) {
            // Toast.makeText(getContext(), "t6", Toast.LENGTH_SHORT).show();
            showGreenDialog(tag);

        } else if (tag.equals("t7")) {
            // Toast.makeText(getContext(), "t7", Toast.LENGTH_SHORT).show();
            showGreenDialog(tag);

        } else if (tag.equals("t8")) {
            // Toast.makeText(getContext(), "t8", Toast.LENGTH_SHORT).show();
            showGreenDialog(tag);

        } else if (tag.equals("t9")) {
            // Toast.makeText(getContext(), "t9", Toast.LENGTH_SHORT).show();
            showGreenDialog(tag);

        } else if (tag.equals("t10")) {
            // Toast.makeText(getContext(), "t10", Toast.LENGTH_SHORT).show();
            showGreenDialog(tag);

        } else if (tag.equals("t11")) {
            // Toast.makeText(getContext(), "t11", Toast.LENGTH_SHORT).show();
            showGreenDialog(tag);
        }

        return false;
    }

    //LINE UP
    public void saveLineup() {
        Map<String, RequestBody> fields = setUpMapDataIds();

        callEditUserListApi(fields);    // for LINE UP
    }

    private Map<String, RequestBody> setUpMapDataIds() {  //for edit
        // RequestBody finalLineupStatus_body;
        String finalPIds = "", finalXIds = "", finalYIds = "", finalDressTIds = "",
                finalDColorIds = "", finalNames = "", finalLineupStatus = "", finalImage = "";

        String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "", s6 = "", s7 = "", s8 = "";

        Map<String, RequestBody> fields = new HashMap<>();
        if (playerList != null && playerList.size() > 0) {

            for (int i = 0; i < playerList.size(); i++) {
                boolean isVisible = getCorrespondingView(i).getVisibility() == View.VISIBLE;
                String visibility = (isVisible) ? "yes" : "no";

                TextView tv = getCorrespondingTextView(i);
                String name = tv.getText().toString();

                if (playerList.get(i) != null) {
                    s1 = s1 + playerList.get(i).getId() + "@";
                    s2 = s2 + playerList.get(i).getxCords() + "@";
                    s3 = s3 + playerList.get(i).getyCords() + "@";
                    s4 = s4 + playerList.get(i).getDressType() + "@";
                    s5 = s5 + playerList.get(i).getDressColor() + "@";
                    s6 = s6 + name + "@";
                    s7 = s7 + visibility + "@";

                    if (playerList.get(i).getpImage().contains("http")) {
                        s8 = s8 + playerList.get(i).getpImage() + "@";
                    } else {
                        if (getP(i).isEmpty()) {
                            s8 = s8 + "noimage" + "@";
                        } else {
                            s8 = s8 + getP(i) + "@";
                        }
                    }

                }
            }

            finalPIds = s1.substring(0,s1.length()-1);// + playerList.get(playerList.size() - 1).getId();
            finalXIds = s2.substring(0,s2.length()-1) ;//+ playerList.get(playerList.size() - 1).getxCords();
            finalYIds = s3.substring(0,s3.length()-1) ;//+ playerList.get(playerList.size() - 1).getyCords();
            finalDressTIds = s4.substring(0,s4.length()-1) ;//+ playerList.get(playerList.size() - 1).getDressType();
            finalDColorIds = s5.substring(0,s5.length()-1) ;//+ playerList.get(playerList.size() - 1).getDressColor();
            finalNames = s6.substring(0,s6.length()-1) ;//+ playerList.get(playerList.size() - 1).getName();
            finalLineupStatus = s7.substring(0,s7.length()-1) ;//+ playerList.get(playerList.size() - 1).getLineup_status();

//            if (playerList.get(playerList.size() - 1).getpImage().isEmpty()) {
//                s8 = s8 + "noimage";
//            } else {
//                s8 = s8 + playerList.get(playerList.size() - 1).getpImage();
//            }

            finalImage = s8.substring(0,s8.length()-1) ;;


        } else {
            finalPIds = "";
            finalXIds = "";
            finalYIds = "";
            finalDressTIds = "";
            finalDColorIds = "";
            finalNames = "";
            finalLineupStatus = "";
            finalImage = "";
        }

        // keys - name,xcords,ycords,dress_type,dress_color,
        // coach_id,id(optional use for edit)  --  seprated with @ sign

        //firstTimeLineSetup


        String coach_id = SharedPreferenceWriter.
                getInstance(getActivity()).getString(SharedPreferenceKey.team_code);

        RequestBody coach_ids_body = RequestBody.create(MediaType.parse("text/plain"), coach_id);
        RequestBody finalNames_body = RequestBody.create(MediaType.parse("text/plain"), finalNames);
        RequestBody finalXIds_body = RequestBody.create(MediaType.parse("text/plain"), finalXIds);
        RequestBody finalYIds_body = RequestBody.create(MediaType.parse("text/plain"), finalYIds);
        RequestBody finalDressTIds_body = RequestBody.create(MediaType.parse("text/plain"), finalDressTIds);
        RequestBody finalDColorIds_body = RequestBody.create(MediaType.parse("text/plain"), finalDColorIds);
        RequestBody finalLineupStatus_body = RequestBody.create(MediaType.parse("text/plain"), finalLineupStatus);
        RequestBody finalImage_body = RequestBody.create(MediaType.parse("text/plain"), finalImage);


        String firstTimeLineSetup = SharedPreferenceWriter.
                getInstance(getActivity()).getString(SharedPreferenceKey.firstTimeLineSetup);

        RequestBody finalPIds_body;

        if (!firstTimeLineSetup.isEmpty() && firstTimeLineSetup.equalsIgnoreCase("yes")) {

            finalPIds_body = RequestBody.create(MediaType.parse("text/plain"), "");
            fields.put("id", finalPIds_body);

        } else {

            finalPIds_body = RequestBody.create(MediaType.parse("text/plain"), finalPIds);
            fields.put("id", finalPIds_body);
        }


        fields.put("name", finalNames_body);
        fields.put("xcords", finalXIds_body);
        fields.put("ycords", finalYIds_body);
        fields.put("dress_type", finalDressTIds_body);
        fields.put("dress_color", finalDColorIds_body);
        fields.put("coach_id", coach_ids_body);
        fields.put("lineup_status", finalLineupStatus_body);
        fields.put("pimage", finalImage_body);


        return fields;
    }


    private TextView getCorrespondingTextView(int i) {
        switch (i) {
            case 0:
                return vPlayer1.findViewById(R.id.tvPlayer1);
            case 1:
                return vPlayer2.findViewById(R.id.tvPlayer2);
            case 2:
                return vPlayer3.findViewById(R.id.tvPlayer3);
            case 3:
                return vPlayer4.findViewById(R.id.tvPlayer4);
            case 4:
                return vPlayer5.findViewById(R.id.tvPlayer5);
            case 5:
                return vPlayer6.findViewById(R.id.tvPlayer6);
            case 6:
                return vPlayer7.findViewById(R.id.tvPlayer7);
            case 7:
                return vPlayer8.findViewById(R.id.tvPlayer8);
            case 8:
                return vPlayer9.findViewById(R.id.tvPlayer9);
            case 9:
                return vPlayer10.findViewById(R.id.tvPlayer10);
            case 10:
                return vPlayer11.findViewById(R.id.tvPlayer11);
            default:
                return null;
        }
    }

    //FIRST TIME LINE UP
    public void saveFirstLineup() {
        Map<String, RequestBody> fields = setUpMapDataIdsFirstTime();
        callEditUserListApi(fields);    // for FIRST TIME LINE UP
    }

    private Map<String, RequestBody> setUpMapDataIdsFirstTime() {
        // RequestBody finalLineupStatus_body;

        String finalPIds = "", finalXIds = "", finalYIds = "",
                finalDressTIds = "", finalDColorIds = "", finalNames = "", finalLineupStatus, finalImage = "";
        String s1 = "", s2 = "", s3 = "", s4 = "", s5 = "", s6 = "", s7 = "", s8 = "";

        Map<String, RequestBody> fields = new HashMap<>();
        if (playerList != null && playerList.size() > 0) {

            for (int i = 0; i < playerList.size() - 1; i++) {

                boolean isVisible = getCorrespondingView(i).getVisibility() == View.VISIBLE;
                String visibility = (isVisible) ? "yes" : "no";

                TextView tv = getCorrespondingTextView(i);
                String name = tv.getText().toString();

                if (playerList.get(i) != null) {
                    s1 = s1 + playerList.get(i).getId() + "@";

                    if (getCorrespondingView(i) != null)
                        s2 = s2 + getCorrespondingView(i).getLeft() + "@";
                    else
                        s2 = s2 + 0.0 + "@";

                    if (getCorrespondingView(i) != null)
                        s3 = s3 + getCorrespondingView(i).getTop() + "@";
                    else
                        s3 = s3 + 0.0 + "@";

                    s4 = s4 + playerList.get(i).getDressType() + "@";
                    s5 = s5 + playerList.get(i).getDressColor() + "@";
                    //s6 = s6 + playerList.get(i).getName() + "@";
                    s6 = s6 + name + "@";
                    s7 = s7 + visibility + "@";

                    if (playerList.get(i).getpImage().contains("https:")) {
                        s8 = s8 + playerList.get(i).getpImage() + "@";
                    } else {
                        if (getP(i).isEmpty()) {
                            s8 = s8 + "noimage" + "@";
                        } else {
                            s8 = s8 + getP(i) + "@";
                        }
                    }

                }
            }

            finalPIds = s1 + playerList.get(playerList.size() - 1).getId();

            if (getCorrespondingView(playerList.size() - 1) != null)
                finalXIds = s2 + getCorrespondingView(playerList.size() - 1).getLeft();
            else
                finalXIds = s2 + 0.0;

            if (getCorrespondingView(playerList.size() - 1) != null)
                finalYIds = s3 + getCorrespondingView(playerList.size() - 1).getTop();
            else
                finalYIds = s3 + 0.0;

            finalDressTIds = s4 + playerList.get(playerList.size() - 1).getDressType();
            finalDColorIds = s5 + playerList.get(playerList.size() - 1).getDressColor();
            finalNames = s6 + playerList.get(playerList.size() - 1).getName();
            finalLineupStatus = s7 + playerList.get(playerList.size() - 1).getLineup_status();

            if (playerList.get(playerList.size() - 1).getpImage().isEmpty()) {
                s8 = s8 + "noimage";
            } else {
                s8 = s8 + playerList.get(playerList.size() - 1).getpImage();
            }

            finalImage = s8;

        } else {
            finalPIds = "";
            finalXIds = "";
            finalYIds = "";
            finalDressTIds = "";
            finalDColorIds = "";
            finalNames = "";
            finalLineupStatus = "";
            finalImage = "";
        }

        // keys - name,xcords,ycords,dress_type,dress_color,
        // coach_id,id(optional use for edit)  --  seprated with @ sign

        //firstTimeLineSetup


        String coach_id = SharedPreferenceWriter.
                getInstance(getActivity()).getString(SharedPreferenceKey.team_code);

        RequestBody coach_ids_body = RequestBody.create(MediaType.parse("text/plain"), coach_id);
        RequestBody finalNames_body = RequestBody.create(MediaType.parse("text/plain"), finalNames);
        RequestBody finalXIds_body = RequestBody.create(MediaType.parse("text/plain"), finalXIds);
        RequestBody finalYIds_body = RequestBody.create(MediaType.parse("text/plain"), finalYIds);
        RequestBody finalDressTIds_body = RequestBody.create(MediaType.parse("text/plain"), finalDressTIds);
        RequestBody finalDColorIds_body = RequestBody.create(MediaType.parse("text/plain"), finalDColorIds);
        RequestBody finalLineupStatus_body = RequestBody.create(MediaType.parse("text/plain"), finalLineupStatus);
        RequestBody finalImage_body = RequestBody.create(MediaType.parse("text/plain"), finalImage);


        String firstTimeLineSetup = SharedPreferenceWriter.
                getInstance(getActivity()).getString(SharedPreferenceKey.firstTimeLineSetup);

        RequestBody finalPIds_body;

        if (!firstTimeLineSetup.isEmpty() && firstTimeLineSetup.equalsIgnoreCase("yes")) {

            finalPIds_body = RequestBody.create(MediaType.parse("text/plain"), "");
            fields.put("id", finalPIds_body);

        } else {

            finalPIds_body = RequestBody.create(MediaType.parse("text/plain"), finalPIds);
            fields.put("id", finalPIds_body);
        }


        fields.put("name", finalNames_body);
        fields.put("xcords", finalXIds_body);
        fields.put("ycords", finalYIds_body);
        fields.put("dress_type", finalDressTIds_body);
        fields.put("dress_color", finalDColorIds_body);
        fields.put("coach_id", coach_ids_body);
        fields.put("lineup_status", finalLineupStatus_body);
        fields.put("pimage", finalImage_body);

        return fields;
    }


    private View getCorrespondingView(int i) {
        switch (i) {
            case 0:
                return vPlayer1;
            case 1:
                return vPlayer2;
            case 2:
                return vPlayer3;
            case 3:
                return vPlayer4;
            case 4:
                return vPlayer5;
            case 5:
                return vPlayer6;
            case 6:
                return vPlayer7;
            case 7:
                return vPlayer8;
            case 8:
                return vPlayer9;
            case 9:
                return vPlayer10;
            case 10:
                return vPlayer11;
            default:
                return null;
        }
    }


    private void callEditUserListApi(Map<String, RequestBody> fields) {
        if (getActivity() != null) {

            try {

                Authorization = SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.token);

                Retrofit retrofit = ApiClient.getClient();
                ApiInterface apiInterface = retrofit.create(ApiInterface.class);

                Map<String, String> map = new HashMap<>();
                map.put("Authorization", String.valueOf(Authorization));


                Call<UserListModel> call = apiInterface.getEditLineupPlayerResult(map, fields);

                MyDialog.getInstance(getActivity()).showDialog();

                call.enqueue(new Callback<UserListModel>() {
                    @Override
                    public void onResponse(Call<UserListModel> call,
                                           Response<UserListModel> response) {
                        if (getActivity() != null) {
                            MyDialog.getInstance(getActivity()).hideDialog();
                            if (response.isSuccessful()) {
                                if (response.body().getStatus().equals("SUCCESS")) {
                                    isFirstTime = false;
                                    SharedPreferenceWriter.getInstance(getActivity())
                                            .writeStringValue(SharedPreferenceKey.firstTimeLineSetup, "No");


                                    Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                                    //tvSaveLineUp.setVisibility(View.GONE);

                                } else {

                                    //Toast.makeText(getActivity(), "No data found.", Toast.LENGTH_SHORT).show();
                                }

                            } else {

                                // Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                        makeAllTouchable();
                    }

                    @Override
                    public void onFailure(Call<UserListModel> call, Throwable t) {
                        if (getActivity() != null) {
                            MyDialog.getInstance(getActivity()).hideDialog();
                        }
                        t.printStackTrace();
                    }

                });

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }


    public void setPosition(View view, int i) {
        try {

            ConstraintLayout layout = rootFieldView;
            ConstraintLayout.LayoutParams params =
                    (ConstraintLayout.LayoutParams) view.getLayoutParams();


            ConstraintLayout.LayoutParams newParams = new ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.MATCH_PARENT,
                    ConstraintLayout.LayoutParams.MATCH_PARENT);

            newParams.leftToLeft = params.leftToLeft;
            newParams.topToTop = params.topToTop;
            newParams.leftMargin = params.leftMargin;
            newParams.topMargin = params.topMargin;


            view.setX(Float.parseFloat(playerList.get(i).getxCords()));
            view.setY(Float.parseFloat(playerList.get(i).getyCords()));

            layout.removeView(view);

            layout.addView(view, newParams);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void setupPlayer(UserListResponse upPlayer, TextView tvPlayer, ImageView ivPlayer) {
        tvPlayer.setText(upPlayer.getName());

        // dress_type 1 for profile pic and dress_type 2 for dress color
        if (upPlayer.getDressType().equalsIgnoreCase("2")) {
            ivPlayer.setColorFilter(Color.TRANSPARENT);
            if (upPlayer.getpImage().contains("https:")) {
                Picasso.with(getContext()).load(upPlayer.getpImage()).transform(new
                        CircleTransform()).resize(150, 150).into(ivPlayer);
            } else {
                Picasso.with(getContext()).load(R.drawable.app_logo).resize(150, 150).into(ivPlayer);
            }

        } else {
            String hexcolor = upPlayer.getDressColor();
            if (!hexcolor.isEmpty()) {
                hexcolor = (hexcolor != null) ? hexcolor : "#FFFFFF";
                int c = Color.parseColor(hexcolor);
                ivPlayer.setImageDrawable(getResources().getDrawable(R.drawable.player_tshirt));
                ivPlayer.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(hexcolor)));
                ivPlayer.setColorFilter(c, PorterDuff.Mode.MULTIPLY);
            }

        }
    }


}













