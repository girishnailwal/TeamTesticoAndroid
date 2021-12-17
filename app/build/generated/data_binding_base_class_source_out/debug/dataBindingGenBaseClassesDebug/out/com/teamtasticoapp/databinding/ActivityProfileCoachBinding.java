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
import android.widget.ScrollView;
import android.widget.TextView;
import com.teamtasticoapp.util.SFDSBTextView;
import net.grobas.view.PolygonImageView;

public abstract class ActivityProfileCoachBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout bottomMenu;

  @NonNull
  public final ImageView ivChat;

  @NonNull
  public final PolygonImageView ivCoach;

  @NonNull
  public final ImageView ivDeleteTeam;

  @NonNull
  public final ImageView ivEdtCoach;

  @NonNull
  public final ImageView ivProfile;

  @NonNull
  public final ImageView ivTeam;

  @NonNull
  public final LinearLayout llAboutUs;

  @NonNull
  public final LinearLayout llChat;

  @NonNull
  public final LinearLayout llDeleteTeam;

  @NonNull
  public final LinearLayout llLogOutTeam;

  @NonNull
  public final LinearLayout llName;

  @NonNull
  public final LinearLayout llProfile;

  @NonNull
  public final LinearLayout llTeam;

  @NonNull
  public final RelativeLayout rLayoutCoach;

  @NonNull
  public final ScrollView scrollView;

  @NonNull
  public final LinearLayout topBarLayout;

  @NonNull
  public final SFDSBTextView tvCreateTeam;

  @NonNull
  public final TextView tvDeleteTeam;

  @NonNull
  public final TextView tvForward;

  @NonNull
  public final TextView tvGmail;

  @NonNull
  public final TextView tvMessage;

  @NonNull
  public final TextView tvTeamCode;

  @NonNull
  public final TextView tvTeamName;

  @NonNull
  public final TextView tvUserName;

  @NonNull
  public final TextView tvessage;

  protected ActivityProfileCoachBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout bottomMenu, ImageView ivChat, PolygonImageView ivCoach,
      ImageView ivDeleteTeam, ImageView ivEdtCoach, ImageView ivProfile, ImageView ivTeam,
      LinearLayout llAboutUs, LinearLayout llChat, LinearLayout llDeleteTeam,
      LinearLayout llLogOutTeam, LinearLayout llName, LinearLayout llProfile, LinearLayout llTeam,
      RelativeLayout rLayoutCoach, ScrollView scrollView, LinearLayout topBarLayout,
      SFDSBTextView tvCreateTeam, TextView tvDeleteTeam, TextView tvForward, TextView tvGmail,
      TextView tvMessage, TextView tvTeamCode, TextView tvTeamName, TextView tvUserName,
      TextView tvessage) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bottomMenu = bottomMenu;
    this.ivChat = ivChat;
    this.ivCoach = ivCoach;
    this.ivDeleteTeam = ivDeleteTeam;
    this.ivEdtCoach = ivEdtCoach;
    this.ivProfile = ivProfile;
    this.ivTeam = ivTeam;
    this.llAboutUs = llAboutUs;
    this.llChat = llChat;
    this.llDeleteTeam = llDeleteTeam;
    this.llLogOutTeam = llLogOutTeam;
    this.llName = llName;
    this.llProfile = llProfile;
    this.llTeam = llTeam;
    this.rLayoutCoach = rLayoutCoach;
    this.scrollView = scrollView;
    this.topBarLayout = topBarLayout;
    this.tvCreateTeam = tvCreateTeam;
    this.tvDeleteTeam = tvDeleteTeam;
    this.tvForward = tvForward;
    this.tvGmail = tvGmail;
    this.tvMessage = tvMessage;
    this.tvTeamCode = tvTeamCode;
    this.tvTeamName = tvTeamName;
    this.tvUserName = tvUserName;
    this.tvessage = tvessage;
  }

  @NonNull
  public static ActivityProfileCoachBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityProfileCoachBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityProfileCoachBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_profile_coach, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityProfileCoachBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityProfileCoachBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityProfileCoachBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_profile_coach, null, false, component);
  }

  public static ActivityProfileCoachBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityProfileCoachBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityProfileCoachBinding)bind(component, view, com.teamtasticoapp.R.layout.activity_profile_coach);
  }
}
