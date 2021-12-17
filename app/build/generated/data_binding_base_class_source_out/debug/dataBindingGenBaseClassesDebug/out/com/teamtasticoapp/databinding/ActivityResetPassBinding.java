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
import com.teamtasticoapp.util.SFDSBTextView;

public abstract class ActivityResetPassBinding extends ViewDataBinding {
  @NonNull
  public final Button btnChangePassword;

  @NonNull
  public final EditText edtConfirmPass;

  @NonNull
  public final EditText edtNewPass;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final ImageView ivProfile;

  @NonNull
  public final LinearLayout llAboutUs;

  @NonNull
  public final LinearLayout llProfile;

  @NonNull
  public final LinearLayout topBarLayout;

  @NonNull
  public final SFDSBTextView tvChangePwd;

  protected ActivityResetPassBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnChangePassword, EditText edtConfirmPass, EditText edtNewPass,
      ImageView ivBackButton, ImageView ivProfile, LinearLayout llAboutUs, LinearLayout llProfile,
      LinearLayout topBarLayout, SFDSBTextView tvChangePwd) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnChangePassword = btnChangePassword;
    this.edtConfirmPass = edtConfirmPass;
    this.edtNewPass = edtNewPass;
    this.ivBackButton = ivBackButton;
    this.ivProfile = ivProfile;
    this.llAboutUs = llAboutUs;
    this.llProfile = llProfile;
    this.topBarLayout = topBarLayout;
    this.tvChangePwd = tvChangePwd;
  }

  @NonNull
  public static ActivityResetPassBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityResetPassBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityResetPassBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_reset_pass, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityResetPassBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityResetPassBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityResetPassBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_reset_pass, null, false, component);
  }

  public static ActivityResetPassBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityResetPassBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityResetPassBinding)bind(component, view, com.teamtasticoapp.R.layout.activity_reset_pass);
  }
}
