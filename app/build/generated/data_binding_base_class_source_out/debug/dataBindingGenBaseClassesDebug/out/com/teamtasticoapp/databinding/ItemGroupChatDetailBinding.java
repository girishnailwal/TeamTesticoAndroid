package com.teamtasticoapp.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import net.grobas.view.PolygonImageView;

public abstract class ItemGroupChatDetailBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout container;

  @NonNull
  public final PolygonImageView ivTeamMember;

  @NonNull
  public final LinearLayout llChat;

  @NonNull
  public final LinearLayout llChatGroup;

  @NonNull
  public final TextView tvMessage;

  @NonNull
  public final TextView tvTime;

  @NonNull
  public final TextView tvUserName;

  protected ItemGroupChatDetailBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout container, PolygonImageView ivTeamMember,
      LinearLayout llChat, LinearLayout llChatGroup, TextView tvMessage, TextView tvTime,
      TextView tvUserName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.container = container;
    this.ivTeamMember = ivTeamMember;
    this.llChat = llChat;
    this.llChatGroup = llChatGroup;
    this.tvMessage = tvMessage;
    this.tvTime = tvTime;
    this.tvUserName = tvUserName;
  }

  @NonNull
  public static ItemGroupChatDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemGroupChatDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemGroupChatDetailBinding>inflate(inflater, com.teamtasticoapp.R.layout.item_group_chat_detail, root, attachToRoot, component);
  }

  @NonNull
  public static ItemGroupChatDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemGroupChatDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemGroupChatDetailBinding>inflate(inflater, com.teamtasticoapp.R.layout.item_group_chat_detail, null, false, component);
  }

  public static ItemGroupChatDetailBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemGroupChatDetailBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemGroupChatDetailBinding)bind(component, view, com.teamtasticoapp.R.layout.item_group_chat_detail);
  }
}
