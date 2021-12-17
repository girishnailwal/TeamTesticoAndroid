package com.teamtasticoapp.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.teamtasticoapp.util.SFDSBTextView;

public abstract class ActivityJoinTeamConfirmationBinding extends ViewDataBinding {
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
  public final LinearLayout topBarLayout;

  @NonNull
  public final TextView tvCongratu;

  @NonNull
  public final TextView tvCongratulations;

  @NonNull
  public final SFDSBTextView tvJoinTeamConfirmTitle;

  @NonNull
  public final TextView tvPlayerName;

  @NonNull
  public final TextView tvSendCode;

  @NonNull
  public final TextView tvTeamCode;

  @NonNull
  public final TextView tvTeamName;

  @NonNull
  public final Button visitTeamPages;

  protected ActivityJoinTeamConfirmationBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout bottomMenu, ImageView ivChat, ImageView ivProfile,
      ImageView ivTeam, LinearLayout llAboutUs, LinearLayout llChat, LinearLayout llProfile,
      LinearLayout llTeam, LinearLayout topBarLayout, TextView tvCongratu,
      TextView tvCongratulations, SFDSBTextView tvJoinTeamConfirmTitle, TextView tvPlayerName,
      TextView tvSendCode, TextView tvTeamCode, TextView tvTeamName, Button visitTeamPages) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bottomMenu = bottomMenu;
    this.ivChat = ivChat;
    this.ivProfile = ivProfile;
    this.ivTeam = ivTeam;
    this.llAboutUs = llAboutUs;
    this.llChat = llChat;
    this.llProfile = llProfile;
    this.llTeam = llTeam;
    this.topBarLayout = topBarLayout;
    this.tvCongratu = tvCongratu;
    this.tvCongratulations = tvCongratulations;
    this.tvJoinTeamConfirmTitle = tvJoinTeamConfirmTitle;
    this.tvPlayerName = tvPlayerName;
    this.tvSendCode = tvSendCode;
    this.tvTeamCode = tvTeamCode;
    this.tvTeamName = tvTeamName;
    this.visitTeamPages = visitTeamPages;
  }

  @NonNull
  public static ActivityJoinTeamConfirmationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityJoinTeamConfirmationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityJoinTeamConfirmationBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_join_team_confirmation, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityJoinTeamConfirmationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityJoinTeamConfirmationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityJoinTeamConfirmationBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_join_team_confirmation, null, false, component);
  }

  public static ActivityJoinTeamConfirmationBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityJoinTeamConfirmationBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityJoinTeamConfirmationBinding)bind(component, view, com.teamtasticoapp.R.layout.activity_join_team_confirmation);
  }
}
