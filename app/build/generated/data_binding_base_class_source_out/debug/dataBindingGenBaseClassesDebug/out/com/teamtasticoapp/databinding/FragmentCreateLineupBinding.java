package com.teamtasticoapp.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public abstract class FragmentCreateLineupBinding extends ViewDataBinding {
  @NonNull
  public final FrameLayout container;

  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final Spinner spinner;

  @NonNull
  public final TextView tvNoOfPlayer;

  @NonNull
  public final TextView tvSelect;

  protected FragmentCreateLineupBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, FrameLayout container, RelativeLayout relativeLayout, Spinner spinner,
      TextView tvNoOfPlayer, TextView tvSelect) {
    super(_bindingComponent, _root, _localFieldCount);
    this.container = container;
    this.relativeLayout = relativeLayout;
    this.spinner = spinner;
    this.tvNoOfPlayer = tvNoOfPlayer;
    this.tvSelect = tvSelect;
  }

  @NonNull
  public static FragmentCreateLineupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentCreateLineupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentCreateLineupBinding>inflate(inflater, com.teamtasticoapp.R.layout.fragment_create_lineup, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentCreateLineupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentCreateLineupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentCreateLineupBinding>inflate(inflater, com.teamtasticoapp.R.layout.fragment_create_lineup, null, false, component);
  }

  public static FragmentCreateLineupBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentCreateLineupBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentCreateLineupBinding)bind(component, view, com.teamtasticoapp.R.layout.fragment_create_lineup);
  }
}
