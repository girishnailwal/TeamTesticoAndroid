package com.teamtasticoapp.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import net.grobas.view.PolygonImageView;

public abstract class ItemFloatingActionMenuBinding extends ViewDataBinding {
  @NonNull
  public final PolygonImageView ivUser;

  @NonNull
  public final LinearLayout llTeamMember;

  @NonNull
  public final TextView tvUserName;

  protected ItemFloatingActionMenuBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, PolygonImageView ivUser, LinearLayout llTeamMember,
      TextView tvUserName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivUser = ivUser;
    this.llTeamMember = llTeamMember;
    this.tvUserName = tvUserName;
  }

  @NonNull
  public static ItemFloatingActionMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemFloatingActionMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemFloatingActionMenuBinding>inflate(inflater, com.teamtasticoapp.R.layout.item_floating_action_menu, root, attachToRoot, component);
  }

  @NonNull
  public static ItemFloatingActionMenuBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemFloatingActionMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemFloatingActionMenuBinding>inflate(inflater, com.teamtasticoapp.R.layout.item_floating_action_menu, null, false, component);
  }

  public static ItemFloatingActionMenuBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemFloatingActionMenuBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemFloatingActionMenuBinding)bind(component, view, com.teamtasticoapp.R.layout.item_floating_action_menu);
  }
}
