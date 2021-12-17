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
import android.widget.TextView;

public abstract class FragmentSelectPlayerFromTeamBinding extends ViewDataBinding {
  @NonNull
  public final FrameLayout container;

  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final TextView tvSelectPlayer;

  protected FragmentSelectPlayerFromTeamBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, FrameLayout container, RelativeLayout relativeLayout,
      TextView tvSelectPlayer) {
    super(_bindingComponent, _root, _localFieldCount);
    this.container = container;
    this.relativeLayout = relativeLayout;
    this.tvSelectPlayer = tvSelectPlayer;
  }

  @NonNull
  public static FragmentSelectPlayerFromTeamBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentSelectPlayerFromTeamBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentSelectPlayerFromTeamBinding>inflate(inflater, com.teamtasticoapp.R.layout.fragment_select_player_from_team, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSelectPlayerFromTeamBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentSelectPlayerFromTeamBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentSelectPlayerFromTeamBinding>inflate(inflater, com.teamtasticoapp.R.layout.fragment_select_player_from_team, null, false, component);
  }

  public static FragmentSelectPlayerFromTeamBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentSelectPlayerFromTeamBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentSelectPlayerFromTeamBinding)bind(component, view, com.teamtasticoapp.R.layout.fragment_select_player_from_team);
  }
}
