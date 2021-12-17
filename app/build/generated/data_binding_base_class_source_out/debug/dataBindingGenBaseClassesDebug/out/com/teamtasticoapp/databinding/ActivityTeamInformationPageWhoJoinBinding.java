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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class ActivityTeamInformationPageWhoJoinBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout bottomMenu;

  @NonNull
  public final ImageView ivProfile;

  @NonNull
  public final LinearLayout llProf;

  @NonNull
  public final LinearLayout llProfile;

  @NonNull
  public final TabLayout tabLayout;

  @NonNull
  public final LinearLayout topBarLayout;

  @NonNull
  public final TextView tvCreateTeam;

  @NonNull
  public final ViewPager viewPager;

  protected ActivityTeamInformationPageWhoJoinBinding(DataBindingComponent _bindingComponent,
      View _root, int _localFieldCount, LinearLayout bottomMenu, ImageView ivProfile,
      LinearLayout llProf, LinearLayout llProfile, TabLayout tabLayout, LinearLayout topBarLayout,
      TextView tvCreateTeam, ViewPager viewPager) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bottomMenu = bottomMenu;
    this.ivProfile = ivProfile;
    this.llProf = llProf;
    this.llProfile = llProfile;
    this.tabLayout = tabLayout;
    this.topBarLayout = topBarLayout;
    this.tvCreateTeam = tvCreateTeam;
    this.viewPager = viewPager;
  }

  @NonNull
  public static ActivityTeamInformationPageWhoJoinBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityTeamInformationPageWhoJoinBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityTeamInformationPageWhoJoinBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_team_information_page_who_join, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityTeamInformationPageWhoJoinBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityTeamInformationPageWhoJoinBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityTeamInformationPageWhoJoinBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_team_information_page_who_join, null, false, component);
  }

  public static ActivityTeamInformationPageWhoJoinBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityTeamInformationPageWhoJoinBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityTeamInformationPageWhoJoinBinding)bind(component, view, com.teamtasticoapp.R.layout.activity_team_information_page_who_join);
  }
}
