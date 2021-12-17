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

public abstract class ActivityCreateTeamConfirmationBinding extends ViewDataBinding {
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
  public final TextView tvContu;

  @NonNull
  public final SFDSBTextView tvCreateTeamConfirmTitle;

  @NonNull
  public final TextView tvName;

  @NonNull
  public final TextView tvSendCode;

  @NonNull
  public final TextView tvTeamCode;

  @NonNull
  public final TextView tvTeamName;

  @NonNull
  public final Button visitTeamPage;

  protected ActivityCreateTeamConfirmationBinding(DataBindingComponent _bindingComponent,
      View _root, int _localFieldCount, LinearLayout bottomMenu, ImageView ivChat,
      ImageView ivProfile, ImageView ivTeam, LinearLayout llAboutUs, LinearLayout llChat,
      LinearLayout llProfile, LinearLayout llTeam, LinearLayout topBarLayout, TextView tvCongratu,
      TextView tvCongratulations, TextView tvContu, SFDSBTextView tvCreateTeamConfirmTitle,
      TextView tvName, TextView tvSendCode, TextView tvTeamCode, TextView tvTeamName,
      Button visitTeamPage) {
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
    this.tvContu = tvContu;
    this.tvCreateTeamConfirmTitle = tvCreateTeamConfirmTitle;
    this.tvName = tvName;
    this.tvSendCode = tvSendCode;
    this.tvTeamCode = tvTeamCode;
    this.tvTeamName = tvTeamName;
    this.visitTeamPage = visitTeamPage;
  }

  @NonNull
  public static ActivityCreateTeamConfirmationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityCreateTeamConfirmationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityCreateTeamConfirmationBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_create_team_confirmation, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityCreateTeamConfirmationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityCreateTeamConfirmationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityCreateTeamConfirmationBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_create_team_confirmation, null, false, component);
  }

  public static ActivityCreateTeamConfirmationBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityCreateTeamConfirmationBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityCreateTeamConfirmationBinding)bind(component, view, com.teamtasticoapp.R.layout.activity_create_team_confirmation);
  }
}
