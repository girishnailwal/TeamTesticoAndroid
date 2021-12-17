package com.teamtasticoapp.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public abstract class DialogselectnoofplayerBinding extends ViewDataBinding {
  @NonNull
  public final RelativeLayout selectDialog;

  protected DialogselectnoofplayerBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, RelativeLayout selectDialog) {
    super(_bindingComponent, _root, _localFieldCount);
    this.selectDialog = selectDialog;
  }

  @NonNull
  public static DialogselectnoofplayerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogselectnoofplayerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogselectnoofplayerBinding>inflate(inflater, com.teamtasticoapp.R.layout.dialogselectnoofplayer, root, attachToRoot, component);
  }

  @NonNull
  public static DialogselectnoofplayerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static DialogselectnoofplayerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<DialogselectnoofplayerBinding>inflate(inflater, com.teamtasticoapp.R.layout.dialogselectnoofplayer, null, false, component);
  }

  public static DialogselectnoofplayerBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static DialogselectnoofplayerBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (DialogselectnoofplayerBinding)bind(component, view, com.teamtasticoapp.R.layout.dialogselectnoofplayer);
  }
}
