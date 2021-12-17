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

public abstract class ActivityEditProfileBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout bottomMenu;

  @NonNull
  public final Button btnUpdateProfile;

  @NonNull
  public final EditText edtEmail;

  @NonNull
  public final EditText edtName;

  @NonNull
  public final EditText edtPosition;

  @NonNull
  public final ImageView ivCamera;

  @NonNull
  public final ImageView ivChat;

  @NonNull
  public final PolygonImageView ivEditCoach;

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
  public final TextView tvChangePwd;

  @NonNull
  public final SFDSBTextView tvCreateTeam;

  protected ActivityEditProfileBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout bottomMenu, Button btnUpdateProfile, EditText edtEmail,
      EditText edtName, EditText edtPosition, ImageView ivCamera, ImageView ivChat,
      PolygonImageView ivEditCoach, ImageView ivProfile, ImageView ivTeam, LinearLayout llAboutUs,
      LinearLayout llChat, LinearLayout llProfile, LinearLayout llTeam, LinearLayout topBarLayout,
      TextView tvChangePwd, SFDSBTextView tvCreateTeam) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bottomMenu = bottomMenu;
    this.btnUpdateProfile = btnUpdateProfile;
    this.edtEmail = edtEmail;
    this.edtName = edtName;
    this.edtPosition = edtPosition;
    this.ivCamera = ivCamera;
    this.ivChat = ivChat;
    this.ivEditCoach = ivEditCoach;
    this.ivProfile = ivProfile;
    this.ivTeam = ivTeam;
    this.llAboutUs = llAboutUs;
    this.llChat = llChat;
    this.llProfile = llProfile;
    this.llTeam = llTeam;
    this.topBarLayout = topBarLayout;
    this.tvChangePwd = tvChangePwd;
    this.tvCreateTeam = tvCreateTeam;
  }

  @NonNull
  public static ActivityEditProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityEditProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityEditProfileBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_edit_profile, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityEditProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityEditProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityEditProfileBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_edit_profile, null, false, component);
  }

  public static ActivityEditProfileBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityEditProfileBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityEditProfileBinding)bind(component, view, com.teamtasticoapp.R.layout.activity_edit_profile);
  }
}
