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
import android.widget.TextView;
import com.teamtasticoapp.util.SFDSBTextView;

public abstract class ActivityAboutUsBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout bottomMenu;

  @NonNull
  public final ImageView ivChat;

  @NonNull
  public final ImageView ivMail;

  @NonNull
  public final ImageView ivProfile;

  @NonNull
  public final ImageView ivTeam;

  @NonNull
  public final LinearLayout llAboutUs;

  @NonNull
  public final LinearLayout llAboutUsContent;

  @NonNull
  public final LinearLayout llChat;

  @NonNull
  public final LinearLayout llMail;

  @NonNull
  public final LinearLayout llProfile;

  @NonNull
  public final LinearLayout llTeam;

  @NonNull
  public final LinearLayout topBarLayout;

  @NonNull
  public final TextView tvAboutUs;

  @NonNull
  public final SFDSBTextView tvChangePwd;

  protected ActivityAboutUsBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout bottomMenu, ImageView ivChat, ImageView ivMail,
      ImageView ivProfile, ImageView ivTeam, LinearLayout llAboutUs, LinearLayout llAboutUsContent,
      LinearLayout llChat, LinearLayout llMail, LinearLayout llProfile, LinearLayout llTeam,
      LinearLayout topBarLayout, TextView tvAboutUs, SFDSBTextView tvChangePwd) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bottomMenu = bottomMenu;
    this.ivChat = ivChat;
    this.ivMail = ivMail;
    this.ivProfile = ivProfile;
    this.ivTeam = ivTeam;
    this.llAboutUs = llAboutUs;
    this.llAboutUsContent = llAboutUsContent;
    this.llChat = llChat;
    this.llMail = llMail;
    this.llProfile = llProfile;
    this.llTeam = llTeam;
    this.topBarLayout = topBarLayout;
    this.tvAboutUs = tvAboutUs;
    this.tvChangePwd = tvChangePwd;
  }

  @NonNull
  public static ActivityAboutUsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityAboutUsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityAboutUsBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_about_us, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityAboutUsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityAboutUsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityAboutUsBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_about_us, null, false, component);
  }

  public static ActivityAboutUsBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityAboutUsBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityAboutUsBinding)bind(component, view, com.teamtasticoapp.R.layout.activity_about_us);
  }
}
