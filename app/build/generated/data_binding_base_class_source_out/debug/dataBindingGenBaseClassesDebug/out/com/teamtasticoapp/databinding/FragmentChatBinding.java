package com.teamtasticoapp.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public abstract class FragmentChatBinding extends ViewDataBinding {
  @NonNull
  public final FrameLayout container;

  @NonNull
  public final LinearLayout llTab;

  @NonNull
  public final TextView tvGroupChat;

  @NonNull
  public final TextView tvIndividualChat;

  protected FragmentChatBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, FrameLayout container, LinearLayout llTab, TextView tvGroupChat,
      TextView tvIndividualChat) {
    super(_bindingComponent, _root, _localFieldCount);
    this.container = container;
    this.llTab = llTab;
    this.tvGroupChat = tvGroupChat;
    this.tvIndividualChat = tvIndividualChat;
  }

  @NonNull
  public static FragmentChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentChatBinding>inflate(inflater, com.teamtasticoapp.R.layout.fragment_chat, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentChatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentChatBinding>inflate(inflater, com.teamtasticoapp.R.layout.fragment_chat, null, false, component);
  }

  public static FragmentChatBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentChatBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentChatBinding)bind(component, view, com.teamtasticoapp.R.layout.fragment_chat);
  }
}
