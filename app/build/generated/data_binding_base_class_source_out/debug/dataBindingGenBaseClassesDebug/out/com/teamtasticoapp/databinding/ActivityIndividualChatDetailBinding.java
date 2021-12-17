package com.teamtasticoapp.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.teamtasticoapp.util.SFDSBTextView;

public abstract class ActivityIndividualChatDetailBinding extends ViewDataBinding {
  @NonNull
  public final EditText edtMessage;

  @NonNull
  public final ImageView ivAttach;

  @NonNull
  public final ImageView ivBackButton;

  @NonNull
  public final ImageView ivProfile;

  @NonNull
  public final ImageView ivSend;

  @NonNull
  public final RecyclerView recyclerViewSenderReceiver;

  @NonNull
  public final RelativeLayout rlChatSend;

  @NonNull
  public final LinearLayout topBarLayout;

  @NonNull
  public final SFDSBTextView tvToWhomChatUserName;

  protected ActivityIndividualChatDetailBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, EditText edtMessage, ImageView ivAttach, ImageView ivBackButton,
      ImageView ivProfile, ImageView ivSend, RecyclerView recyclerViewSenderReceiver,
      RelativeLayout rlChatSend, LinearLayout topBarLayout, SFDSBTextView tvToWhomChatUserName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.edtMessage = edtMessage;
    this.ivAttach = ivAttach;
    this.ivBackButton = ivBackButton;
    this.ivProfile = ivProfile;
    this.ivSend = ivSend;
    this.recyclerViewSenderReceiver = recyclerViewSenderReceiver;
    this.rlChatSend = rlChatSend;
    this.topBarLayout = topBarLayout;
    this.tvToWhomChatUserName = tvToWhomChatUserName;
  }

  @NonNull
  public static ActivityIndividualChatDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityIndividualChatDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityIndividualChatDetailBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_individual_chat_detail, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityIndividualChatDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityIndividualChatDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityIndividualChatDetailBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_individual_chat_detail, null, false, component);
  }

  public static ActivityIndividualChatDetailBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityIndividualChatDetailBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityIndividualChatDetailBinding)bind(component, view, com.teamtasticoapp.R.layout.activity_individual_chat_detail);
  }
}
