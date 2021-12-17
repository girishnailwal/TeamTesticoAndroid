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

public abstract class ActivityCreateTeamInfoBinding extends ViewDataBinding {
  @NonNull
  public final Button creatTeam;

  @NonNull
  public final EditText edtEmail;

  @NonNull
  public final EditText edtName;

  @NonNull
  public final EditText edtPosition;

  @NonNull
  public final ImageView ivAboutUs;

  @NonNull
  public final ImageView ivProfile;

  @NonNull
  public final PolygonImageView ivUploadPhoto;

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
  public final TextView tsss;

  @NonNull
  public final SFDSBTextView tvCreateTeamInfoTitle;

  @NonNull
  public final TextView tvT;

  @NonNull
  public final TextView tvvv;

  @NonNull
  public final TextView tvvvcc;

  protected ActivityCreateTeamInfoBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, Button creatTeam, EditText edtEmail, EditText edtName,
      EditText edtPosition, ImageView ivAboutUs, ImageView ivProfile,
      PolygonImageView ivUploadPhoto, LinearLayout llAboutUs, LinearLayout llProfile,
      LinearLayout llUploadPhoto, EditText passwordEdt, ImageView passwordOnOffImg, TextView t,
      LinearLayout topBarLayout, TextView tsss, SFDSBTextView tvCreateTeamInfoTitle, TextView tvT,
      TextView tvvv, TextView tvvvcc) {
    super(_bindingComponent, _root, _localFieldCount);
    this.creatTeam = creatTeam;
    this.edtEmail = edtEmail;
    this.edtName = edtName;
    this.edtPosition = edtPosition;
    this.ivAboutUs = ivAboutUs;
    this.ivProfile = ivProfile;
    this.ivUploadPhoto = ivUploadPhoto;
    this.llAboutUs = llAboutUs;
    this.llProfile = llProfile;
    this.llUploadPhoto = llUploadPhoto;
    this.passwordEdt = passwordEdt;
    this.passwordOnOffImg = passwordOnOffImg;
    this.t = t;
    this.topBarLayout = topBarLayout;
    this.tsss = tsss;
    this.tvCreateTeamInfoTitle = tvCreateTeamInfoTitle;
    this.tvT = tvT;
    this.tvvv = tvvv;
    this.tvvvcc = tvvvcc;
  }

  @NonNull
  public static ActivityCreateTeamInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityCreateTeamInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityCreateTeamInfoBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_create_team_info, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityCreateTeamInfoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityCreateTeamInfoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityCreateTeamInfoBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_create_team_info, null, false, component);
  }

  public static ActivityCreateTeamInfoBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityCreateTeamInfoBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityCreateTeamInfoBinding)bind(component, view, com.teamtasticoapp.R.layout.activity_create_team_info);
  }
}
