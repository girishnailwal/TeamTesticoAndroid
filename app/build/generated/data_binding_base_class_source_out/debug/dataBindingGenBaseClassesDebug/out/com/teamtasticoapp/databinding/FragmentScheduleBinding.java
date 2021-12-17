package com.teamtasticoapp.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class FragmentScheduleBinding extends ViewDataBinding {
  @NonNull
  public final Button btnAdd;

  @NonNull
  public final Button btnAddEvent;

  @NonNull
  public final FrameLayout container;

  @NonNull
  public final EditText edtChooseDate;

  @NonNull
  public final EditText edtChooseTime;

  @NonNull
  public final EditText edtLocation;

  @NonNull
  public final EditText edtVS;

  @NonNull
  public final EditText etOtherEvent;

  @NonNull
  public final ImageView ivAddEvent;

  @NonNull
  public final ImageView ivAddEventClose;

  @NonNull
  public final ImageView ivAddEventList;

  @NonNull
  public final LinearLayout lLayoutAddEvent;

  @NonNull
  public final LinearLayout llDate;

  @NonNull
  public final LinearLayout llForPlayerMessage;

  @NonNull
  public final LinearLayout llLocation;

  @NonNull
  public final LinearLayout llTime;

  @NonNull
  public final LinearLayout llVs;

  @NonNull
  public final RelativeLayout rLayoutAddAnEvent;

  @NonNull
  public final RadioGroup radioGroup;

  @NonNull
  public final RadioButton rdbGame;

  @NonNull
  public final RadioButton rdbOther;

  @NonNull
  public final RadioButton rdbPractice;

  @NonNull
  public final RecyclerView recyclerView;

  @NonNull
  public final RelativeLayout rlOtherEvents;

  @NonNull
  public final RelativeLayout rlTop;

  @NonNull
  public final TextView tvAdd;

  @NonNull
  public final TextView tvCancel;

  @NonNull
  public final TextView tvForPlayer;

  @NonNull
  public final TextView tvForPlayerMessage;

  @NonNull
  public final TextView tvLocation;

  @NonNull
  public final TextView tvName;

  @NonNull
  public final TextView tvVS;

  @NonNull
  public final View view;

  @NonNull
  public final View view1;

  @NonNull
  public final View view2;

  protected FragmentScheduleBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnAdd, Button btnAddEvent, FrameLayout container,
      EditText edtChooseDate, EditText edtChooseTime, EditText edtLocation, EditText edtVS,
      EditText etOtherEvent, ImageView ivAddEvent, ImageView ivAddEventClose,
      ImageView ivAddEventList, LinearLayout lLayoutAddEvent, LinearLayout llDate,
      LinearLayout llForPlayerMessage, LinearLayout llLocation, LinearLayout llTime,
      LinearLayout llVs, RelativeLayout rLayoutAddAnEvent, RadioGroup radioGroup,
      RadioButton rdbGame, RadioButton rdbOther, RadioButton rdbPractice, RecyclerView recyclerView,
      RelativeLayout rlOtherEvents, RelativeLayout rlTop, TextView tvAdd, TextView tvCancel,
      TextView tvForPlayer, TextView tvForPlayerMessage, TextView tvLocation, TextView tvName,
      TextView tvVS, View view, View view1, View view2) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnAdd = btnAdd;
    this.btnAddEvent = btnAddEvent;
    this.container = container;
    this.edtChooseDate = edtChooseDate;
    this.edtChooseTime = edtChooseTime;
    this.edtLocation = edtLocation;
    this.edtVS = edtVS;
    this.etOtherEvent = etOtherEvent;
    this.ivAddEvent = ivAddEvent;
    this.ivAddEventClose = ivAddEventClose;
    this.ivAddEventList = ivAddEventList;
    this.lLayoutAddEvent = lLayoutAddEvent;
    this.llDate = llDate;
    this.llForPlayerMessage = llForPlayerMessage;
    this.llLocation = llLocation;
    this.llTime = llTime;
    this.llVs = llVs;
    this.rLayoutAddAnEvent = rLayoutAddAnEvent;
    this.radioGroup = radioGroup;
    this.rdbGame = rdbGame;
    this.rdbOther = rdbOther;
    this.rdbPractice = rdbPractice;
    this.recyclerView = recyclerView;
    this.rlOtherEvents = rlOtherEvents;
    this.rlTop = rlTop;
    this.tvAdd = tvAdd;
    this.tvCancel = tvCancel;
    this.tvForPlayer = tvForPlayer;
    this.tvForPlayerMessage = tvForPlayerMessage;
    this.tvLocation = tvLocation;
    this.tvName = tvName;
    this.tvVS = tvVS;
    this.view = view;
    this.view1 = view1;
    this.view2 = view2;
  }

  @NonNull
  public static FragmentScheduleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentScheduleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentScheduleBinding>inflate(inflater, com.teamtasticoapp.R.layout.fragment_schedule, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentScheduleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentScheduleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentScheduleBinding>inflate(inflater, com.teamtasticoapp.R.layout.fragment_schedule, null, false, component);
  }

  public static FragmentScheduleBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentScheduleBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentScheduleBinding)bind(component, view, com.teamtasticoapp.R.layout.fragment_schedule);
  }
}
