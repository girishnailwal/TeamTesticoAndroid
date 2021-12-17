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
import android.widget.TextView;

public abstract class ActivityHomeLoginAllBinding extends ViewDataBinding {
  @NonNull
  public final Button createTeam;

  @NonNull
  public final Button joinTeam;

  @NonNull
  public final TextView tvLogin;

  protected ActivityHomeLoginAllBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button createTeam, Button joinTeam, TextView tvLogin) {
    super(_bindingComponent, _root, _localFieldCount);
    this.createTeam = createTeam;
    this.joinTeam = joinTeam;
    this.tvLogin = tvLogin;
  }

  @NonNull
  public static ActivityHomeLoginAllBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityHomeLoginAllBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityHomeLoginAllBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_home_login_all, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityHomeLoginAllBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityHomeLoginAllBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityHomeLoginAllBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_home_login_all, null, false, component);
  }

  public static ActivityHomeLoginAllBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityHomeLoginAllBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityHomeLoginAllBinding)bind(component, view, com.teamtasticoapp.R.layout.activity_home_login_all);
  }
}
