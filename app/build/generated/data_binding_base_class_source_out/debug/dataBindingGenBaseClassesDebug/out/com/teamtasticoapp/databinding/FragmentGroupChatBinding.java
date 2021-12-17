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
import android.widget.RelativeLayout;

public abstract class FragmentGroupChatBinding extends ViewDataBinding {
  @NonNull
  public final EditText edtMessage;

  @NonNull
  public final ImageView ivAttach;

  @NonNull
  public final ImageView ivSend;

  @NonNull
  public final RecyclerView recyclerView;

  @NonNull
  public final RelativeLayout rlChatSend;

  protected FragmentGroupChatBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, EditText edtMessage, ImageView ivAttach, ImageView ivSend,
      RecyclerView recyclerView, RelativeLayout rlChatSend) {
    super(_bindingComponent, _root, _localFieldCount);
    this.edtMessage = edtMessage;
    this.ivAttach = ivAttach;
    this.ivSend = ivSend;
    this.recyclerView = recyclerView;
    this.rlChatSend = rlChatSend;
  }

  @NonNull
  public static FragmentGroupChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentGroupChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentGroupChatBinding>inflate(inflater, com.teamtasticoapp.R.layout.fragment_group_chat, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentGroupChatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentGroupChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentGroupChatBinding>inflate(inflater, com.teamtasticoapp.R.layout.fragment_group_chat, null, false, component);
  }

  public static FragmentGroupChatBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentGroupChatBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentGroupChatBinding)bind(component, view, com.teamtasticoapp.R.layout.fragment_group_chat);
  }
}
