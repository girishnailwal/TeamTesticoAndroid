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

public abstract class PopDeleteOnlyCoachBinding extends ViewDataBinding {
  @NonNull
  public final Button btnNo;

  @NonNull
  public final Button btnYes;

  @NonNull
  public final LinearLayout llCoach;

  @NonNull
  public final LinearLayout llOk;

  protected PopDeleteOnlyCoachBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button btnNo, Button btnYes, LinearLayout llCoach, LinearLayout llOk) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnNo = btnNo;
    this.btnYes = btnYes;
    this.llCoach = llCoach;
    this.llOk = llOk;
  }

  @NonNull
  public static PopDeleteOnlyCoachBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PopDeleteOnlyCoachBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PopDeleteOnlyCoachBinding>inflate(inflater, com.teamtasticoapp.R.layout.pop_delete_only_coach, root, attachToRoot, component);
  }

  @NonNull
  public static PopDeleteOnlyCoachBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static PopDeleteOnlyCoachBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<PopDeleteOnlyCoachBinding>inflate(inflater, com.teamtasticoapp.R.layout.pop_delete_only_coach, null, false, component);
  }

  public static PopDeleteOnlyCoachBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static PopDeleteOnlyCoachBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (PopDeleteOnlyCoachBinding)bind(component, view, com.teamtasticoapp.R.layout.pop_delete_only_coach);
  }
}
