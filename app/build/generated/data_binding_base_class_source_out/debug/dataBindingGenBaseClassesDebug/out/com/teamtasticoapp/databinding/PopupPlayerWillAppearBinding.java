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

public abstract class PopupPlayerWillAppearBinding extends ViewDataBinding {
  @NonNull
  public final Button btnOk;

  @NonNull
  public final LinearLayout llOk;

  protected PopupPlayerWillAppearBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnOk, LinearLayout llOk) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnOk = btnOk;
    this.llOk = llOk;
  }

  @NonNull
  public static PopupPlayerWillAppearBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PopupPlayerWillAppearBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PopupPlayerWillAppearBinding>inflate(inflater, com.teamtasticoapp.R.layout.popup_player_will_appear, root, attachToRoot, component);
  }

  @NonNull
  public static PopupPlayerWillAppearBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PopupPlayerWillAppearBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PopupPlayerWillAppearBinding>inflate(inflater, com.teamtasticoapp.R.layout.popup_player_will_appear, null, false, component);
  }

  public static PopupPlayerWillAppearBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static PopupPlayerWillAppearBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (PopupPlayerWillAppearBinding)bind(component, view, com.teamtasticoapp.R.layout.popup_player_will_appear);
  }
}
