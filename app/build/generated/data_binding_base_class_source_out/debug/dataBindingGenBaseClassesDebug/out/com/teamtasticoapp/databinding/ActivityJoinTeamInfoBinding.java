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

public abstract class ActivityJoinTeamInfoBinding extends ViewDataBinding {
  @NonNull
  public final EditText edtEmail;

  @NonNull
  public final EditText edtName;

  @NonNull
  public final EditText edtPosition;

  @NonNull
  public final ImageView ivProfile;

  @NonNull
  public final PolygonImageView ivUploadPhoto;

  @NonNull
  public final Button joinTeam;

  @NonNull
  public final LinearLayout llAboutUs;

  @NonNull
  public final LinearLayout llProfile;

  @NonNull
  public final LinearLayout llUploadPhoto;

  @NonNull
  public final EditText passwordEdt;

  @NonNull
  public final ImageView passwordOnOffImg;

  @NonNull
  public final TextView t;

  @NonNull
  public final LinearLayout topBarLayout;

  @NonNull
  public final SFDSBTextView tvJoinTeamInfoTitle;

  @NonNull
  public final TextView tvT;

  @NonNull
  public final TextView tvTeamName;

  @NonNull
  public final TextView tvvv;

  protected ActivityJoinTeamInfoBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, EditText edtEmail, EditText edtName, EditText edtPosition,
      ImageView ivProfile, PolygonImageView ivUploadPhoto, Button joinTeam, LinearLayout llAboutUs,
      LinearLayout llProfile, LinearLayout llUploadPhoto, EditText passwordEdt,
      ImageView passwordOnOffImg, TextView t, LinearLayout topBarLayout,
      SFDSBTextView tvJoinTeamInfoTitle, TextView tvT, TextView tvTeamName, TextView tvvv) {
    super(_bindingComponent, _root, _localFieldCount);
    this.edtEmail = edtEmail;
    this.edtName = edtName;
    this.edtPosition = edtPosition;
    this.ivProfile = ivProfile;
    this.ivUploadPhoto = ivUploadPhoto;
    this.joinTeam = joinTeam;
    this.llAboutUs = llAboutUs;
    this.llProfile = llProfile;
    this.llUploadPhoto = llUploadPhoto;
    this.passwordEdt = passwordEdt;
    this.passwordOnOffImg = passwordOnOffImg;
    this.t = t;
    this.topBarLayout = topBarLayout;
    this.tvJoinTeamInfoTitle = tvJoinTeamInfoTitle;
    this.tvT = tvT;
    this.tvTeamName = tvTeamName;
    this.tvvv = tvvv;
  }

  @NonNull
  public static ActivityJoinTeamInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityJoinTeamInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityJoinTeamInfoBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_join_team_info, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityJoinTeamInfoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityJoinTeamInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityJoinTeamInfoBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_join_team_info, null, false, component);
  }

  public static ActivityJoinTeamInfoBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityJoinTeamInfoBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityJoinTeamInfoBinding)bind(component, view, com.teamtasticoapp.R.layout.activity_join_team_info);
  }
}
