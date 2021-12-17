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

public abstract class ItemIndividualChatBinding extends ViewDataBinding {
  @NonNull
  public final PolygonImageView ivChatMember;

  @NonNull
  public final LinearLayout ll;

  @NonNull
  public final LinearLayout llChat;

  @NonNull
  public final TextView tvMessage;

  @NonNull
  public final TextView tvName;

  @NonNull
  public final TextView tvTime;

  protected ItemIndividualChatBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, PolygonImageView ivChatMember, LinearLayout ll, LinearLayout llChat,
      TextView tvMessage, TextView tvName, TextView tvTime) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivChatMember = ivChatMember;
    this.ll = ll;
    this.llChat = llChat;
    this.tvMessage = tvMessage;
    this.tvName = tvName;
    this.tvTime = tvTime;
  }

  @NonNull
  public static ItemIndividualChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemIndividualChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemIndividualChatBinding>inflate(inflater, com.teamtasticoapp.R.layout.item_individual_chat, root, attachToRoot, component);
  }

  @NonNull
  public static ItemIndividualChatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemIndividualChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemIndividualChatBinding>inflate(inflater, com.teamtasticoapp.R.layout.item_individual_chat, null, false, component);
  }

  public static ItemIndividualChatBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemIndividualChatBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemIndividualChatBinding)bind(component, view, com.teamtasticoapp.R.layout.item_individual_chat);
  }
}
