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
import android.widget.TextView;

public abstract class ActivityForgotPasswordBinding extends ViewDataBinding {
  @NonNull
  public final EditText email;

  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final Button submit;

  @NonNull
  public final TextView tvFor;

  @NonNull
  public final TextView tvForgot;

  @NonNull
  public final TextView tvForgotPass;

  protected ActivityForgotPasswordBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, EditText email, ImageView ivBack, Button submit, TextView tvFor,
      TextView tvForgot, TextView tvForgotPass) {
    super(_bindingComponent, _root, _localFieldCount);
    this.email = email;
    this.ivBack = ivBack;
    this.submit = submit;
    this.tvFor = tvFor;
    this.tvForgot = tvForgot;
    this.tvForgotPass = tvForgotPass;
  }

  @NonNull
  public static ActivityForgotPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityForgotPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityForgotPasswordBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_forgot_password, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityForgotPasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityForgotPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityForgotPasswordBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_forgot_password, null, false, component);
  }

  public static ActivityForgotPasswordBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityForgotPasswordBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityForgotPasswordBinding)bind(component, view, com.teamtasticoapp.R.layout.activity_forgot_password);
  }
}
