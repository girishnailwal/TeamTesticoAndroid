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

public abstract class PopupDeleteProceedBinding extends ViewDataBinding {
  @NonNull
  public final Button btnProceed;

  @NonNull
  public final LinearLayout llProceed;

  @NonNull
  public final TextView tvName;

  protected PopupDeleteProceedBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnProceed, LinearLayout llProceed, TextView tvName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnProceed = btnProceed;
    this.llProceed = llProceed;
    this.tvName = tvName;
  }

  @NonNull
  public static PopupDeleteProceedBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PopupDeleteProceedBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PopupDeleteProceedBinding>inflate(inflater, com.teamtasticoapp.R.layout.popup_delete_proceed, root, attachToRoot, component);
  }

  @NonNull
  public static PopupDeleteProceedBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PopupDeleteProceedBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PopupDeleteProceedBinding>inflate(inflater, com.teamtasticoapp.R.layout.popup_delete_proceed, null, false, component);
  }

  public static PopupDeleteProceedBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static PopupDeleteProceedBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (PopupDeleteProceedBinding)bind(component, view, com.teamtasticoapp.R.layout.popup_delete_proceed);
  }
}
