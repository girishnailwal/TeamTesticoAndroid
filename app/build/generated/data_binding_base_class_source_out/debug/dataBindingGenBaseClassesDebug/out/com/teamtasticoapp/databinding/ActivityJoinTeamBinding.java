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

public abstract class ActivityJoinTeamBinding extends ViewDataBinding {
  @NonNull
  public final EditText edtTeamCode;

  @NonNull
  public final ImageView imgChecked;

  @NonNull
  public final ImageView ivProfile;

  @NonNull
  public final LinearLayout llAboutUs;

  @NonNull
  public final LinearLayout llProfile;

  @NonNull
  public final LinearLayout llTermAndCondition;

  @NonNull
  public final Button next;

  @NonNull
  public final LinearLayout topBarLayout;

  @NonNull
  public final TextView tvAccept;

  @NonNull
  public final SFDSBTextView tvCreateTeam;

  @NonNull
  public final TextView tvPrivacyPolicies;

  @NonNull
  public final TextView tvT;

  @NonNull
  public final TextView tvTerms;

  protected ActivityJoinTeamBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, EditText edtTeamCode, ImageView imgChecked, ImageView ivProfile,
      LinearLayout llAboutUs, LinearLayout llProfile, LinearLayout llTermAndCondition, Button next,
      LinearLayout topBarLayout, TextView tvAccept, SFDSBTextView tvCreateTeam,
      TextView tvPrivacyPolicies, TextView tvT, TextView tvTerms) {
    super(_bindingComponent, _root, _localFieldCount);
    this.edtTeamCode = edtTeamCode;
    this.imgChecked = imgChecked;
    this.ivProfile = ivProfile;
    this.llAboutUs = llAboutUs;
    this.llProfile = llProfile;
    this.llTermAndCondition = llTermAndCondition;
    this.next = next;
    this.topBarLayout = topBarLayout;
    this.tvAccept = tvAccept;
    this.tvCreateTeam = tvCreateTeam;
    this.tvPrivacyPolicies = tvPrivacyPolicies;
    this.tvT = tvT;
    this.tvTerms = tvTerms;
  }

  @NonNull
  public static ActivityJoinTeamBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityJoinTeamBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityJoinTeamBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_join_team, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityJoinTeamBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityJoinTeamBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityJoinTeamBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_join_team, null, false, component);
  }

  public static ActivityJoinTeamBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityJoinTeamBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityJoinTeamBinding)bind(component, view, com.teamtasticoapp.R.layout.activity_join_team);
  }
}
