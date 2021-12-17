package com.teamtasticoapp.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class FragmentTeamLineupScheduleBinding extends ViewDataBinding {
  @NonNull
  public final ViewPager pager;

  @NonNull
  public final TabLayout tabLayout;

  protected FragmentTeamLineupScheduleBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ViewPager pager, TabLayout tabLayout) {
    super(_bindingComponent, _root, _localFieldCount);
    this.pager = pager;
    this.tabLayout = tabLayout;
  }

  @NonNull
  public static FragmentTeamLineupScheduleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentTeamLineupScheduleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentTeamLineupScheduleBinding>inflate(inflater, com.teamtasticoapp.R.layout.fragment_team_lineup_schedule, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentTeamLineupScheduleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentTeamLineupScheduleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentTeamLineupScheduleBinding>inflate(inflater, com.teamtasticoapp.R.layout.fragment_team_lineup_schedule, null, false, component);
  }

  public static FragmentTeamLineupScheduleBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentTeamLineupScheduleBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentTeamLineupScheduleBinding)bind(component, view, com.teamtasticoapp.R.layout.fragment_team_lineup_schedule);
  }
}
