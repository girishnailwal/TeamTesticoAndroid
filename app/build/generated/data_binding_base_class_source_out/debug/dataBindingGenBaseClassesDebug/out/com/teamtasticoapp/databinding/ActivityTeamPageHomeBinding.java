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
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.teamtasticoapp.util.SFDSBTextView;

public abstract class ActivityTeamPageHomeBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout bottomMenu;

  @NonNull
  public final FrameLayout container;

  @NonNull
  public final ImageView ivChat;

  @NonNull
  public final ImageView ivProfile;

  @NonNull
  public final ImageView ivTeam;

  @NonNull
  public final LinearLayout llAboutUs;

  @NonNull
  public final LinearLayout llChat;

  @NonNull
  public final LinearLayout llProfile;

  @NonNull
  public final LinearLayout llTeam;

  @NonNull
  public final LinearLayout topBarLayout;

  @NonNull
  public final SFDSBTextView tvFragmentListTitle;

  protected ActivityTeamPageHomeBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout bottomMenu, FrameLayout container, ImageView ivChat,
      ImageView ivProfile, ImageView ivTeam, LinearLayout llAboutUs, LinearLayout llChat,
      LinearLayout llProfile, LinearLayout llTeam, LinearLayout topBarLayout,
      SFDSBTextView tvFragmentListTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bottomMenu = bottomMenu;
    this.container = container;
    this.ivChat = ivChat;
    this.ivProfile = ivProfile;
    this.ivTeam = ivTeam;
    this.llAboutUs = llAboutUs;
    this.llChat = llChat;
    this.llProfile = llProfile;
    this.llTeam = llTeam;
    this.topBarLayout = topBarLayout;
    this.tvFragmentListTitle = tvFragmentListTitle;
  }

  @NonNull
  public static ActivityTeamPageHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityTeamPageHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityTeamPageHomeBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_team_page_home, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityTeamPageHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityTeamPageHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityTeamPageHomeBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_team_page_home, null, false, component);
  }

  public static ActivityTeamPageHomeBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityTeamPageHomeBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityTeamPageHomeBinding)bind(component, view, com.teamtasticoapp.R.layout.activity_team_page_home);
  }
}
