package com.teamtasticoapp.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.teamtasticoapp.util.SFDSBTextView;

public abstract class ActivityGroupChatDetailBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout bottomMenu;

  @NonNull
  public final EditText edtMessage;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final ImageView ivPlusButton;

  @NonNull
  public final ImageView ivProfile;

  @NonNull
  public final ImageView ivSend;

  @NonNull
  public final LinearLayout llAttach;

  @NonNull
  public final LinearLayout llProf;

  @NonNull
  public final LinearLayout llProfile;

  @NonNull
  public final LinearLayout llSend;

  @NonNull
  public final LinearLayout topBarLayout;

  @NonNull
  public final SFDSBTextView tvCreateTeam;

  protected ActivityGroupChatDetailBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout bottomMenu, EditText edtMessage, ImageView ivBackButton,
      ImageView ivPlusButton, ImageView ivProfile, ImageView ivSend, LinearLayout llAttach,
      LinearLayout llProf, LinearLayout llProfile, LinearLayout llSend, LinearLayout topBarLayout,
      SFDSBTextView tvCreateTeam) {
    super(_bindingComponent, _root, _localFieldCount);
    this.bottomMenu = bottomMenu;
    this.edtMessage = edtMessage;
    this.ivBackButton = ivBackButton;
    this.ivPlusButton = ivPlusButton;
    this.ivProfile = ivProfile;
    this.ivSend = ivSend;
    this.llAttach = llAttach;
    this.llProf = llProf;
    this.llProfile = llProfile;
    this.llSend = llSend;
    this.topBarLayout = topBarLayout;
    this.tvCreateTeam = tvCreateTeam;
  }

  @NonNull
  public static ActivityGroupChatDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityGroupChatDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityGroupChatDetailBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_group_chat_detail, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityGroupChatDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityGroupChatDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityGroupChatDetailBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_group_chat_detail, null, false, component);
  }

  public static ActivityGroupChatDetailBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityGroupChatDetailBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityGroupChatDetailBinding)bind(component, view, com.teamtasticoapp.R.layout.activity_group_chat_detail);
  }
}
