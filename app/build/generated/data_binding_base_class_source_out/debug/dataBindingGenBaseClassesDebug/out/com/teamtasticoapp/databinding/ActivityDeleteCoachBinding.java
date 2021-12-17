package com.teamtasticoapp.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.teamtasticoapp.util.SFDSBTextView;

public abstract class ActivityDeleteCoachBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout bottomMenu;

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
  public final RecyclerView rvContactlist;

  @NonNull
  public final LinearLayout topBarLayout;

  @NonNull
  public final SFDSBTextView tvDeleteTeam;

  protected ActivityDeleteCoachBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout bottomMenu, ImageView ivChat, ImageView ivProfile,
      ImageView ivTeam, LinearLayout llAboutUs, LinearLayout llChat, LinearLayout llProfile,
      LinearLayout llTeam, RecyclerView rvContactlist, LinearLayout topBarLayout,
      SFDSBTextView tvDeleteTeam) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bottomMenu = bottomMenu;
    this.ivChat = ivChat;
    this.ivProfile = ivProfile;
    this.ivTeam = ivTeam;
    this.llAboutUs = llAboutUs;
    this.llChat = llChat;
    this.llProfile = llProfile;
    this.llTeam = llTeam;
    this.rvContactlist = rvContactlist;
    this.topBarLayout = topBarLayout;
    this.tvDeleteTeam = tvDeleteTeam;
  }

  @NonNull
  public static ActivityDeleteCoachBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityDeleteCoachBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityDeleteCoachBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_delete_coach, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityDeleteCoachBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityDeleteCoachBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityDeleteCoachBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_delete_coach, null, false, component);
  }

  public static ActivityDeleteCoachBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityDeleteCoachBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityDeleteCoachBinding)bind(component, view, com.teamtasticoapp.R.layout.activity_delete_coach);
  }
}
