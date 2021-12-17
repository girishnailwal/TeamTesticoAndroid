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
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class PopUpDeletePlayerBinding extends ViewDataBinding {
  @NonNull
  public final Button btnYes;

  @NonNull
  public final LinearLayout llCoach;

  @NonNull
  public final TextView tvNo;

  protected PopUpDeletePlayerBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnYes, LinearLayout llCoach, TextView tvNo) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnYes = btnYes;
    this.llCoach = llCoach;
    this.tvNo = tvNo;
  }

  @NonNull
  public static PopUpDeletePlayerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PopUpDeletePlayerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PopUpDeletePlayerBinding>inflate(inflater, com.teamtasticoapp.R.layout.pop_up_delete_player, root, attachToRoot, component);
  }

  @NonNull
  public static PopUpDeletePlayerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PopUpDeletePlayerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PopUpDeletePlayerBinding>inflate(inflater, com.teamtasticoapp.R.layout.pop_up_delete_player, null, false, component);
  }

  public static PopUpDeletePlayerBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static PopUpDeletePlayerBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (PopUpDeletePlayerBinding)bind(component, view, com.teamtasticoapp.R.layout.pop_up_delete_player);
  }
}
