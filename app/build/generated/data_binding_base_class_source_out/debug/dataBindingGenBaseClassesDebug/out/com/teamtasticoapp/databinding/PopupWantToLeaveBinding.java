package com.teamtasticoapp.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public abstract class PopupWantToLeaveBinding extends ViewDataBinding {
  @NonNull
  public final TextView txtNo;

  @NonNull
  public final TextView txtYes;

  protected PopupWantToLeaveBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView txtNo, TextView txtYes) {
    super(_bindingComponent, _root, _localFieldCount);
    this.txtNo = txtNo;
    this.txtYes = txtYes;
  }

  @NonNull
  public static PopupWantToLeaveBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PopupWantToLeaveBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PopupWantToLeaveBinding>inflate(inflater, com.teamtasticoapp.R.layout.popup_want_to_leave, root, attachToRoot, component);
  }

  @NonNull
  public static PopupWantToLeaveBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PopupWantToLeaveBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PopupWantToLeaveBinding>inflate(inflater, com.teamtasticoapp.R.layout.popup_want_to_leave, null, false, component);
  }

  public static PopupWantToLeaveBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static PopupWantToLeaveBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (PopupWantToLeaveBinding)bind(component, view, com.teamtasticoapp.R.layout.popup_want_to_leave);
  }
}
