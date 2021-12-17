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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.teamtasticoapp.util.SFDSBTextView;
import net.grobas.view.PolygonImageView;

public abstract class ActivityLeaveTeamBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout bottomMenu;

  @NonNull
  public final Button btnNext;

  @NonNull
  public final EditText edtTeamCode;

  @NonNull
  public final ImageView ivChat;

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
  public final LinearLayout llName;

  @NonNull
  public final LinearLayout llProfile;

  @NonNull
  public final LinearLayout llTeam;

  @NonNull
  public final LinearLayout topBarLayout;

  @NonNull
  public final SFDSBTextView tvCreateTeam;

  @NonNull
  public final TextView tvTeamName;

  @NonNull
  public final TextView tvUserEmail;

  @NonNull
  public final TextView tvUserName;

  @NonNull
  public final TextView tvUserPosition;

  @NonNull
  public final TextView tvessage;

  protected ActivityLeaveTeamBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout bottomMenu, Button btnNext, EditText edtTeamCode,
      ImageView ivChat, PolygonImageView ivPlayer, ImageView ivProfile, ImageView ivTeam,
      LinearLayout llAboutUs, LinearLayout llChat, LinearLayout llName, LinearLayout llProfile,
      LinearLayout llTeam, LinearLayout topBarLayout, SFDSBTextView tvCreateTeam,
      TextView tvTeamName, TextView tvUserEmail, TextView tvUserName, TextView tvUserPosition,
      TextView tvessage) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bottomMenu = bottomMenu;
    this.btnNext = btnNext;
    this.edtTeamCode = edtTeamCode;
    this.ivChat = ivChat;
    this.ivPlayer = ivPlayer;
    this.ivProfile = ivProfile;
    this.ivTeam = ivTeam;
    this.llAboutUs = llAboutUs;
    this.llChat = llChat;
    this.llName = llName;
    this.llProfile = llProfile;
    this.llTeam = llTeam;
    this.topBarLayout = topBarLayout;
    this.tvCreateTeam = tvCreateTeam;
    this.tvTeamName = tvTeamName;
    this.tvUserEmail = tvUserEmail;
    this.tvUserName = tvUserName;
    this.tvUserPosition = tvUserPosition;
    this.tvessage = tvessage;
  }

  @NonNull
  public static ActivityLeaveTeamBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityLeaveTeamBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityLeaveTeamBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_leave_team, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityLeaveTeamBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityLeaveTeamBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityLeaveTeamBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_leave_team, null, false, component);
  }

  public static ActivityLeaveTeamBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityLeaveTeamBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityLeaveTeamBinding)bind(component, view, com.teamtasticoapp.R.layout.activity_leave_team);
  }
}
