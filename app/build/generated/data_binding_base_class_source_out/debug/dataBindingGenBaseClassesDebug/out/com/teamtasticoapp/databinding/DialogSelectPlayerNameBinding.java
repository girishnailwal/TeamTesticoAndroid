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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class DialogSelectPlayerNameBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout llRecyclerView;

  @NonNull
  public final RecyclerView recyclerView;

  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final RelativeLayout rlSelectPlayer;

  @NonNull
  public final TextView tvCancel;

  @NonNull
  public final TextView tvSelectPlayer;

  protected DialogSelectPlayerNameBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout llRecyclerView, RecyclerView recyclerView,
      RelativeLayout relativeLayout, RelativeLayout rlSelectPlayer, TextView tvCancel,
      TextView tvSelectPlayer) {
    super(_bindingComponent, _root, _localFieldCount);
    this.llRecyclerView = llRecyclerView;
    this.recyclerView = recyclerView;
    this.relativeLayout = relativeLayout;
    this.rlSelectPlayer = rlSelectPlayer;
    this.tvCancel = tvCancel;
    this.tvSelectPlayer = tvSelectPlayer;
  }

  @NonNull
  public static DialogSelectPlayerNameBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogSelectPlayerNameBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogSelectPlayerNameBinding>inflate(inflater, com.teamtasticoapp.R.layout.dialog_select_player_name, root, attachToRoot, component);
  }

  @NonNull
  public static DialogSelectPlayerNameBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogSelectPlayerNameBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogSelectPlayerNameBinding>inflate(inflater, com.teamtasticoapp.R.layout.dialog_select_player_name, null, false, component);
  }

  public static DialogSelectPlayerNameBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static DialogSelectPlayerNameBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (DialogSelectPlayerNameBinding)bind(component, view, com.teamtasticoapp.R.layout.dialog_select_player_name);
  }
}
