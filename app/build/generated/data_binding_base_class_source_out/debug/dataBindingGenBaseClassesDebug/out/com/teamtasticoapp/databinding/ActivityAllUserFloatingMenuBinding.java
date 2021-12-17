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

public abstract class ActivityAllUserFloatingMenuBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout bottomMenu;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final ImageView ivChat;

  @NonNull
  public final ImageView ivProfile;

  @NonNull
  public final ImageView ivTeam;

  @NonNull
  public final LinearLayout llBack;

  @NonNull
  public final LinearLayout llChat;

  @NonNull
  public final LinearLayout llProfile;

  @NonNull
  public final LinearLayout llTeam;

  @NonNull
  public final RecyclerView recyclerViewAllContactlist;

  @NonNull
  public final LinearLayout topBarLayout;

  @NonNull
  public final SFDSBTextView tvCreateTeam;

  protected ActivityAllUserFloatingMenuBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout bottomMenu, ImageView ivBackButton, ImageView ivChat,
      ImageView ivProfile, ImageView ivTeam, LinearLayout llBack, LinearLayout llChat,
      LinearLayout llProfile, LinearLayout llTeam, RecyclerView recyclerViewAllContactlist,
      LinearLayout topBarLayout, SFDSBTextView tvCreateTeam) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bottomMenu = bottomMenu;
    this.ivBackButton = ivBackButton;
    this.ivChat = ivChat;
    this.ivProfile = ivProfile;
    this.ivTeam = ivTeam;
    this.llBack = llBack;
    this.llChat = llChat;
    this.llProfile = llProfile;
    this.llTeam = llTeam;
    this.recyclerViewAllContactlist = recyclerViewAllContactlist;
    this.topBarLayout = topBarLayout;
    this.tvCreateTeam = tvCreateTeam;
  }

  @NonNull
  public static ActivityAllUserFloatingMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityAllUserFloatingMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityAllUserFloatingMenuBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_all_user_floating_menu, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityAllUserFloatingMenuBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityAllUserFloatingMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityAllUserFloatingMenuBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_all_user_floating_menu, null, false, component);
  }

  public static ActivityAllUserFloatingMenuBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityAllUserFloatingMenuBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityAllUserFloatingMenuBinding)bind(component, view, com.teamtasticoapp.R.layout.activity_all_user_floating_menu);
  }
}
