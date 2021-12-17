package com.teamtasticoapp.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import net.grobas.view.PolygonImageView;

public abstract class ActivityProfileTeamPlayerBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout bottomMenu;

  @NonNull
  public final ImageView ivChat;

  @NonNull
  public final ImageView ivDeletePlayer;

  @NonNull
  public final ImageView ivEdtPlayer;

  @NonNull
  public final ImageView ivLeaveTeam;

  @NonNull
  public final PolygonImageView ivPlayer;

  @NonNull
  public final ImageView ivProfile;

  @NonNull
  public final ImageView ivTeam;

  @NonNull
  public final LinearLayout llAboutUs;

  @NonNull
  public final LinearLayout llChat;

  @NonNull
  public final LinearLayout llDeletePlayer;

  @NonNull
  public final LinearLayout llLeaveTeam;

  @NonNull
  public final LinearLayout llLogOutTeam;

  @NonNull
  public final LinearLayout llName;

  @NonNull
  public final LinearLayout llProfile;

  @NonNull
  public final LinearLayout llTeam;

  @NonNull
  public final RelativeLayout rLayoutTeamPlayer;

  @NonNull
  public final LinearLayout topBarLayout;

  @NonNull
  public final TextView tvCreateTeam;

  @NonNull
  public final TextView tvDeletePlayer;

  @NonNull
  public final TextView tvForward;

  @NonNull
  public final TextView tvGmail;

  @NonNull
  public final TextView tvLeaveTeam;

  @NonNull
  public final TextView tvTeamCode;

  @NonNull
  public final TextView tvTeamName;

  @NonNull
  public final TextView tvUserName;

  @NonNull
  public final TextView tvessage;

  protected ActivityProfileTeamPlayerBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout bottomMenu, ImageView ivChat, ImageView ivDeletePlayer,
      ImageView ivEdtPlayer, ImageView ivLeaveTeam, PolygonImageView ivPlayer, ImageView ivProfile,
      ImageView ivTeam, LinearLayout llAboutUs, LinearLayout llChat, LinearLayout llDeletePlayer,
      LinearLayout llLeaveTeam, LinearLayout llLogOutTeam, LinearLayout llName,
      LinearLayout llProfile, LinearLayout llTeam, RelativeLayout rLayoutTeamPlayer,
      LinearLayout topBarLayout, TextView tvCreateTeam, TextView tvDeletePlayer, TextView tvForward,
      TextView tvGmail, TextView tvLeaveTeam, TextView tvTeamCode, TextView tvTeamName,
      TextView tvUserName, TextView tvessage) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bottomMenu = bottomMenu;
    this.ivChat = ivChat;
    this.ivDeletePlayer = ivDeletePlayer;
    this.ivEdtPlayer = ivEdtPlayer;
    this.ivLeaveTeam = ivLeaveTeam;
    this.ivPlayer = ivPlayer;
    this.ivProfile = ivProfile;
    this.ivTeam = ivTeam;
    this.llAboutUs = llAboutUs;
    this.llChat = llChat;
    this.llDeletePlayer = llDeletePlayer;
    this.llLeaveTeam = llLeaveTeam;
    this.llLogOutTeam = llLogOutTeam;
    this.llName = llName;
    this.llProfile = llProfile;
    this.llTeam = llTeam;
    this.rLayoutTeamPlayer = rLayoutTeamPlayer;
    this.topBarLayout = topBarLayout;
    this.tvCreateTeam = tvCreateTeam;
    this.tvDeletePlayer = tvDeletePlayer;
    this.tvForward = tvForward;
    this.tvGmail = tvGmail;
    this.tvLeaveTeam = tvLeaveTeam;
    this.tvTeamCode = tvTeamCode;
    this.tvTeamName = tvTeamName;
    this.tvUserName = tvUserName;
    this.tvessage = tvessage;
  }

  @NonNull
  public static ActivityProfileTeamPlayerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityProfileTeamPlayerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityProfileTeamPlayerBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_profile_team_player, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityProfileTeamPlayerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityProfileTeamPlayerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityProfileTeamPlayerBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_profile_team_player, null, false, component);
  }

  public static ActivityProfileTeamPlayerBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityProfileTeamPlayerBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityProfileTeamPlayerBinding)bind(component, view, com.teamtasticoapp.R.layout.activity_profile_team_player);
  }
}
