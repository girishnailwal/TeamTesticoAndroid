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
import android.widget.ImageView;
import android.widget.LinearLayout;

public abstract class DialogImageSelectBinding extends ViewDataBinding {
  @NonNull
  public final Button btnCancel;

  @NonNull
  public final Button btnSend;

  @NonNull
  public final ImageView iv;

  @NonNull
  public final LinearLayout llBottom;

  protected DialogImageSelectBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnCancel, Button btnSend, ImageView iv, LinearLayout llBottom) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnCancel = btnCancel;
    this.btnSend = btnSend;
    this.iv = iv;
    this.llBottom = llBottom;
  }

  @NonNull
  public static DialogImageSelectBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogImageSelectBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogImageSelectBinding>inflate(inflater, com.teamtasticoapp.R.layout.dialog_image_select, root, attachToRoot, component);
  }

  @NonNull
  public static DialogImageSelectBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogImageSelectBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogImageSelectBinding>inflate(inflater, com.teamtasticoapp.R.layout.dialog_image_select, null, false, component);
  }

  public static DialogImageSelectBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static DialogImageSelectBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (DialogImageSelectBinding)bind(component, view, com.teamtasticoapp.R.layout.dialog_image_select);
  }
}
