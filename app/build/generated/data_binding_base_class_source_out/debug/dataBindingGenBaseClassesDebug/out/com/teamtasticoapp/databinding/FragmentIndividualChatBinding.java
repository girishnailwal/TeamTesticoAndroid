package com.teamtasticoapp.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class FragmentIndividualChatBinding extends ViewDataBinding {
  @NonNull
  public final FloatingActionButton fab;

  @NonNull
  public final RecyclerView recyclerView;

  protected FragmentIndividualChatBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, FloatingActionButton fab, RecyclerView recyclerView) {
    super(_bindingComponent, _root, _localFieldCount);
    this.fab = fab;
    this.recyclerView = recyclerView;
  }

  @NonNull
  public static FragmentIndividualChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentIndividualChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentIndividualChatBinding>inflate(inflater, com.teamtasticoapp.R.layout.fragment_individual_chat, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentIndividualChatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentIndividualChatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentIndividualChatBinding>inflate(inflater, com.teamtasticoapp.R.layout.fragment_individual_chat, null, false, component);
  }

  public static FragmentIndividualChatBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentIndividualChatBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentIndividualChatBinding)bind(component, view, com.teamtasticoapp.R.layout.fragment_individual_chat);
  }
}
