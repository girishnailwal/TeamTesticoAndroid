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
import android.widget.RelativeLayout;

public abstract class ActivityAddedPlayerBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivPlayer1;

  @NonNull
  public final ImageView ivPlayer10;

  @NonNull
  public final ImageView ivPlayer11;

  @NonNull
  public final ImageView ivPlayer2;

  @NonNull
  public final ImageView ivPlayer3;

  @NonNull
  public final ImageView ivPlayer4;

  @NonNull
  public final ImageView ivPlayer5;

  @NonNull
  public final ImageView ivPlayer6;

  @NonNull
  public final ImageView ivPlayer7;

  @NonNull
  public final ImageView ivPlayer8;

  @NonNull
  public final ImageView ivPlayer9;

  @NonNull
  public final LinearLayout ll1;

  @NonNull
  public final LinearLayout ll10;

  @NonNull
  public final LinearLayout ll11;

  @NonNull
  public final LinearLayout ll2;

  @NonNull
  public final LinearLayout ll3;

  @NonNull
  public final LinearLayout ll4;

  @NonNull
  public final LinearLayout ll5;

  @NonNull
  public final LinearLayout ll6;

  @NonNull
  public final LinearLayout ll7;

  @NonNull
  public final LinearLayout ll8;

  @NonNull
  public final LinearLayout ll9;

  @NonNull
  public final LinearLayout llPlayer1;

  @NonNull
  public final LinearLayout llPlayer10;

  @NonNull
  public final LinearLayout llPlayer11;

  @NonNull
  public final LinearLayout llPlayer2;

  @NonNull
  public final LinearLayout llPlayer3;

  @NonNull
  public final LinearLayout llPlayer4;

  @NonNull
  public final LinearLayout llPlayer5;

  @NonNull
  public final LinearLayout llPlayer6;

  @NonNull
  public final LinearLayout llPlayer7;

  @NonNull
  public final LinearLayout llPlayer8;

  @NonNull
  public final LinearLayout llPlayer9;

  @NonNull
  public final RelativeLayout rLayout1;

  @NonNull
  public final RelativeLayout rLayout2;

  @NonNull
  public final RelativeLayout rLayout3;

  @NonNull
  public final RelativeLayout rLayout4;

  protected ActivityAddedPlayerBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView ivPlayer1, ImageView ivPlayer10, ImageView ivPlayer11,
      ImageView ivPlayer2, ImageView ivPlayer3, ImageView ivPlayer4, ImageView ivPlayer5,
      ImageView ivPlayer6, ImageView ivPlayer7, ImageView ivPlayer8, ImageView ivPlayer9,
      LinearLayout ll1, LinearLayout ll10, LinearLayout ll11, LinearLayout ll2, LinearLayout ll3,
      LinearLayout ll4, LinearLayout ll5, LinearLayout ll6, LinearLayout ll7, LinearLayout ll8,
      LinearLayout ll9, LinearLayout llPlayer1, LinearLayout llPlayer10, LinearLayout llPlayer11,
      LinearLayout llPlayer2, LinearLayout llPlayer3, LinearLayout llPlayer4,
      LinearLayout llPlayer5, LinearLayout llPlayer6, LinearLayout llPlayer7,
      LinearLayout llPlayer8, LinearLayout llPlayer9, RelativeLayout rLayout1,
      RelativeLayout rLayout2, RelativeLayout rLayout3, RelativeLayout rLayout4) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivPlayer1 = ivPlayer1;
    this.ivPlayer10 = ivPlayer10;
    this.ivPlayer11 = ivPlayer11;
    this.ivPlayer2 = ivPlayer2;
    this.ivPlayer3 = ivPlayer3;
    this.ivPlayer4 = ivPlayer4;
    this.ivPlayer5 = ivPlayer5;
    this.ivPlayer6 = ivPlayer6;
    this.ivPlayer7 = ivPlayer7;
    this.ivPlayer8 = ivPlayer8;
    this.ivPlayer9 = ivPlayer9;
    this.ll1 = ll1;
    this.ll10 = ll10;
    this.ll11 = ll11;
    this.ll2 = ll2;
    this.ll3 = ll3;
    this.ll4 = ll4;
    this.ll5 = ll5;
    this.ll6 = ll6;
    this.ll7 = ll7;
    this.ll8 = ll8;
    this.ll9 = ll9;
    this.llPlayer1 = llPlayer1;
    this.llPlayer10 = llPlayer10;
    this.llPlayer11 = llPlayer11;
    this.llPlayer2 = llPlayer2;
    this.llPlayer3 = llPlayer3;
    this.llPlayer4 = llPlayer4;
    this.llPlayer5 = llPlayer5;
    this.llPlayer6 = llPlayer6;
    this.llPlayer7 = llPlayer7;
    this.llPlayer8 = llPlayer8;
    this.llPlayer9 = llPlayer9;
    this.rLayout1 = rLayout1;
    this.rLayout2 = rLayout2;
    this.rLayout3 = rLayout3;
    this.rLayout4 = rLayout4;
  }

  @NonNull
  public static ActivityAddedPlayerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityAddedPlayerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityAddedPlayerBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_added_player, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityAddedPlayerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityAddedPlayerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityAddedPlayerBinding>inflate(inflater, com.teamtasticoapp.R.layout.activity_added_player, null, false, component);
  }

  public static ActivityAddedPlayerBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityAddedPlayerBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityAddedPlayerBinding)bind(component, view, com.teamtasticoapp.R.layout.activity_added_player);
  }
}
