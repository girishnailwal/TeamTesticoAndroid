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

public abstract class ItemPlayerNameBinding extends ViewDataBinding {
  @NonNull
  public final TextView tvPlayerName;

  protected ItemPlayerNameBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, TextView tvPlayerName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.tvPlayerName = tvPlayerName;
  }

  @NonNull
  public static ItemPlayerNameBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemPlayerNameBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemPlayerNameBinding>inflate(inflater, com.teamtasticoapp.R.layout.item_player_name, root, attachToRoot, component);
  }

  @NonNull
  public static ItemPlayerNameBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemPlayerNameBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemPlayerNameBinding>inflate(inflater, com.teamtasticoapp.R.layout.item_player_name, null, false, component);
  }

  public static ItemPlayerNameBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemPlayerNameBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemPlayerNameBinding)bind(component, view, com.teamtasticoapp.R.layout.item_player_name);
  }
}
