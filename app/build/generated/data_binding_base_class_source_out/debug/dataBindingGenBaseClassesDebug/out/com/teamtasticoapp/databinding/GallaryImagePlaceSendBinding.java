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
import com.teamtasticoapp.util.SFDSBTextView;

public abstract class GallaryImagePlaceSendBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout bottomMenu;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final ImageView ivGallary;

  @NonNull
  public final ImageView ivProfile;

  @NonNull
  public final ImageView ivSend;

  @NonNull
  public final LinearLayout llSend;

  @NonNull
  public final LinearLayout topBarLayout;

  @NonNull
  public final SFDSBTextView tvToWhomeChatUserName;

  protected GallaryImagePlaceSendBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout bottomMenu, ImageView ivBackButton, ImageView ivGallary,
      ImageView ivProfile, ImageView ivSend, LinearLayout llSend, LinearLayout topBarLayout,
      SFDSBTextView tvToWhomeChatUserName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bottomMenu = bottomMenu;
    this.ivBackButton = ivBackButton;
    this.ivGallary = ivGallary;
    this.ivProfile = ivProfile;
    this.ivSend = ivSend;
    this.llSend = llSend;
    this.topBarLayout = topBarLayout;
    this.tvToWhomeChatUserName = tvToWhomeChatUserName;
  }

  @NonNull
  public static GallaryImagePlaceSendBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static GallaryImagePlaceSendBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<GallaryImagePlaceSendBinding>inflate(inflater, com.teamtasticoapp.R.layout.gallary_image_place_send, root, attachToRoot, component);
  }

  @NonNull
  public static GallaryImagePlaceSendBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static GallaryImagePlaceSendBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<GallaryImagePlaceSendBinding>inflate(inflater, com.teamtasticoapp.R.layout.gallary_image_place_send, null, false, component);
  }

  public static GallaryImagePlaceSendBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static GallaryImagePlaceSendBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (GallaryImagePlaceSendBinding)bind(component, view, com.teamtasticoapp.R.layout.gallary_image_place_send);
  }
}
