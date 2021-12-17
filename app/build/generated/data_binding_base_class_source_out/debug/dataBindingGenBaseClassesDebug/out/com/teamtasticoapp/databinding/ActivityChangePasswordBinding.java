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
import com.teamtasticoapp.util.SFDSBTextView;

public abstract class ActivityChangePasswordBinding extends ViewDataBinding {
  @NonNull
  public final Button btnChangePassword;

  @NonNull
  public final EditText edtNewPwd;

  @NonNull
  public final EditText edtOldPwd;

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

  @NonNull
  public final TextView tvNewPwd;

  @NonNull
  public final TextView tvOldPwd;

  protected ActivityChangePasswordBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnChangePassword, EditText edtNewPwd, EditText edtOldPwd,
      ImageView ivProfile, LinearLayout llAboutUs, LinearLayout llProfile,
      LinearLayout topBarLayout, SFDSBTextView tvChangePwd, TextView tvNewPwd, TextView tvOldPwd) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnChangePassword = btnChangePassword;
    this.edtNewPwd = edtNewPwd;
    this.edtOldPwd = edtOldPwd;
    this.ivProfile = ivProfile;
    this.llAboutUs = llAboutUs;
    this.llProfile = llProfile;
    this.topBarLayout = topBarLayout;
    this.tvChangePwd = tvChangePwd;
    this.tvNewPwd = tvNewPwd;
    this.tvOldPwd = tvOldPwd;
  }

  @NonNull
  public static ActivityChangePasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityChangePasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityChangePasswordBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_change_password, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityChangePasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityChangePasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityChangePasswordBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_change_password, null, false, component);
  }

  public static ActivityChangePasswordBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityChangePasswordBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityChangePasswordBinding)bind(component, view, com.teamtasticoapp.R.layout.activity_change_password);
  }
}
