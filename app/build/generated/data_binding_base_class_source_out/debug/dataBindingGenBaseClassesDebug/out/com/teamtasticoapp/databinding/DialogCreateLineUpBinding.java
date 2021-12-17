package com.teamtasticoapp.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class DialogCreateLineUpBinding extends ViewDataBinding {
  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final TextView tvNoOfPlayer;

  @NonNull
  public final TextView tvSelect;

  protected DialogCreateLineUpBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RelativeLayout relativeLayout, TextView tvNoOfPlayer,
      TextView tvSelect) {
    super(_bindingComponent, _root, _localFieldCount);
    this.relativeLayout = relativeLayout;
    this.tvNoOfPlayer = tvNoOfPlayer;
    this.tvSelect = tvSelect;
  }

  @NonNull
  public static DialogCreateLineUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogCreateLineUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogCreateLineUpBinding>inflate(inflater, com.teamtasticoapp.R.layout.dialog_create_line_up, root, attachToRoot, component);
  }

  @NonNull
  public static DialogCreateLineUpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogCreateLineUpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogCreateLineUpBinding>inflate(inflater, com.teamtasticoapp.R.layout.dialog_create_line_up, null, false, component);
  }

  public static DialogCreateLineUpBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static DialogCreateLineUpBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (DialogCreateLineUpBinding)bind(component, view, com.teamtasticoapp.R.layout.dialog_create_line_up);
  }
}
