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
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class ActivityLoginBinding extends ViewDataBinding {
  @NonNull
  public final EditText edtEmail;

  @NonNull
  public final EditText edtPass;

  @NonNull
  public final ImageView ivBack;

  @NonNull
  public final ImageView ivRemember;

  @NonNull
  public final LinearLayout llRemember;

  @NonNull
  public final Button loginButton;

  @NonNull
  public final TextView tvForgotPass;

  @NonNull
  public final TextView tvx;

  protected ActivityLoginBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, EditText edtEmail, EditText edtPass, ImageView ivBack,
      ImageView ivRemember, LinearLayout llRemember, Button loginButton, TextView tvForgotPass,
      TextView tvx) {
    super(_bindingComponent, _root, _localFieldCount);
    this.edtEmail = edtEmail;
    this.edtPass = edtPass;
    this.ivBack = ivBack;
    this.ivRemember = ivRemember;
    this.llRemember = llRemember;
    this.loginButton = loginButton;
    this.tvForgotPass = tvForgotPass;
    this.tvx = tvx;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityLoginBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_login, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityLoginBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_login, null, false, component);
  }

  public static ActivityLoginBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityLoginBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityLoginBinding)bind(component, view, com.teamtasticoapp.R.layout.activity_login);
  }
}
