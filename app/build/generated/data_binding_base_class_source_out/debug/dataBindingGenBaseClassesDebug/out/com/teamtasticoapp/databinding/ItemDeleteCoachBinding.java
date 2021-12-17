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

public abstract class ItemDeleteCoachBinding extends ViewDataBinding {
  @NonNull
  public final PolygonImageView ivTeamMember;

  @NonNull
  public final LinearLayout llTeamMember;

  @NonNull
  public final TextView tvTeamMemberName;

  @NonNull
  public final TextView tvTeamMemberType;

  protected ItemDeleteCoachBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, PolygonImageView ivTeamMember, LinearLayout llTeamMember,
      TextView tvTeamMemberName, TextView tvTeamMemberType) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivTeamMember = ivTeamMember;
    this.llTeamMember = llTeamMember;
    this.tvTeamMemberName = tvTeamMemberName;
    this.tvTeamMemberType = tvTeamMemberType;
  }

  @NonNull
  public static ItemDeleteCoachBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemDeleteCoachBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemDeleteCoachBinding>inflate(inflater, com.teamtasticoapp.R.layout.item_delete_coach, root, attachToRoot, component);
  }

  @NonNull
  public static ItemDeleteCoachBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemDeleteCoachBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemDeleteCoachBinding>inflate(inflater, com.teamtasticoapp.R.layout.item_delete_coach, null, false, component);
  }

  public static ItemDeleteCoachBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemDeleteCoachBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemDeleteCoachBinding)bind(component, view, com.teamtasticoapp.R.layout.item_delete_coach);
  }
}
