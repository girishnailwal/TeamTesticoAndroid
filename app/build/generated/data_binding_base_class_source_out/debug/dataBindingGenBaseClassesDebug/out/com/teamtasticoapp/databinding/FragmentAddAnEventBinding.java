package com.teamtasticoapp.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public abstract class FragmentAddAnEventBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivAddEvent;

  @NonNull
  public final RadioButton rbutton;

  @NonNull
  public final RadioButton rdbIncorrectFees;

  @NonNull
  public final RadioButton rdbLostItem;

  @NonNull
  public final TextView tvLocation;

  @NonNull
  public final TextView tvVS;

  @NonNull
  public final EditText txtChooseDate;

  @NonNull
  public final EditText txtChooseTime;

  @NonNull
  public final Button visitTeamPage;

  protected FragmentAddAnEventBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView ivAddEvent, RadioButton rbutton, RadioButton rdbIncorrectFees,
      RadioButton rdbLostItem, TextView tvLocation, TextView tvVS, EditText txtChooseDate,
      EditText txtChooseTime, Button visitTeamPage) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivAddEvent = ivAddEvent;
    this.rbutton = rbutton;
    this.rdbIncorrectFees = rdbIncorrectFees;
    this.rdbLostItem = rdbLostItem;
    this.tvLocation = tvLocation;
    this.tvVS = tvVS;
    this.txtChooseDate = txtChooseDate;
    this.txtChooseTime = txtChooseTime;
    this.visitTeamPage = visitTeamPage;
  }

  @NonNull
  public static FragmentAddAnEventBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentAddAnEventBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentAddAnEventBinding>inflate(inflater, com.teamtasticoapp.R.layout.fragment_add_an_event, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentAddAnEventBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentAddAnEventBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentAddAnEventBinding>inflate(inflater, com.teamtasticoapp.R.layout.fragment_add_an_event, null, false, component);
  }

  public static FragmentAddAnEventBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentAddAnEventBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentAddAnEventBinding)bind(component, view, com.teamtasticoapp.R.layout.fragment_add_an_event);
  }
}
