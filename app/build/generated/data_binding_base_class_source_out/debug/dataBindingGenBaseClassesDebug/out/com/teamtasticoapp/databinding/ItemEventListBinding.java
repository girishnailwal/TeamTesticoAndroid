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

public abstract class ItemEventListBinding extends ViewDataBinding {
  @NonNull
  public final LinearLayout llEditDeleteGame;

  @NonNull
  public final LinearLayout llEditDeleteOther;

  @NonNull
  public final LinearLayout llEditDeletePractice;

  @NonNull
  public final LinearLayout llGame;

  @NonNull
  public final LinearLayout llOther;

  @NonNull
  public final LinearLayout llPractice;

  @NonNull
  public final TextView tvDateGame;

  @NonNull
  public final TextView tvDateOther;

  @NonNull
  public final TextView tvDatePractice;

  @NonNull
  public final TextView tvDeleteGame;

  @NonNull
  public final TextView tvDeleteOther;

  @NonNull
  public final TextView tvDeletePractice;

  @NonNull
  public final TextView tvEditGame;

  @NonNull
  public final TextView tvEditOther;

  @NonNull
  public final TextView tvEditPractice;

  @NonNull
  public final TextView tvGame;

  @NonNull
  public final TextView tvLocationGame;

  @NonNull
  public final TextView tvLocationOther;

  @NonNull
  public final TextView tvLocationPractice;

  @NonNull
  public final TextView tvOpponentNameGame;

  @NonNull
  public final TextView tvOpponentNamePractice;

  @NonNull
  public final TextView tvOther;

  @NonNull
  public final TextView tvOtherEventTitle;

  @NonNull
  public final TextView tvPractice;

  @NonNull
  public final TextView tvTeamName;

  @NonNull
  public final TextView tvTimeGame;

  @NonNull
  public final TextView tvTimeOther;

  @NonNull
  public final TextView tvTimePractice;

  protected ItemEventListBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, LinearLayout llEditDeleteGame, LinearLayout llEditDeleteOther,
      LinearLayout llEditDeletePractice, LinearLayout llGame, LinearLayout llOther,
      LinearLayout llPractice, TextView tvDateGame, TextView tvDateOther, TextView tvDatePractice,
      TextView tvDeleteGame, TextView tvDeleteOther, TextView tvDeletePractice, TextView tvEditGame,
      TextView tvEditOther, TextView tvEditPractice, TextView tvGame, TextView tvLocationGame,
      TextView tvLocationOther, TextView tvLocationPractice, TextView tvOpponentNameGame,
      TextView tvOpponentNamePractice, TextView tvOther, TextView tvOtherEventTitle,
      TextView tvPractice, TextView tvTeamName, TextView tvTimeGame, TextView tvTimeOther,
      TextView tvTimePractice) {
    super(_bindingComponent, _root, _localFieldCount);
    this.llEditDeleteGame = llEditDeleteGame;
    this.llEditDeleteOther = llEditDeleteOther;
    this.llEditDeletePractice = llEditDeletePractice;
    this.llGame = llGame;
    this.llOther = llOther;
    this.llPractice = llPractice;
    this.tvDateGame = tvDateGame;
    this.tvDateOther = tvDateOther;
    this.tvDatePractice = tvDatePractice;
    this.tvDeleteGame = tvDeleteGame;
    this.tvDeleteOther = tvDeleteOther;
    this.tvDeletePractice = tvDeletePractice;
    this.tvEditGame = tvEditGame;
    this.tvEditOther = tvEditOther;
    this.tvEditPractice = tvEditPractice;
    this.tvGame = tvGame;
    this.tvLocationGame = tvLocationGame;
    this.tvLocationOther = tvLocationOther;
    this.tvLocationPractice = tvLocationPractice;
    this.tvOpponentNameGame = tvOpponentNameGame;
    this.tvOpponentNamePractice = tvOpponentNamePractice;
    this.tvOther = tvOther;
    this.tvOtherEventTitle = tvOtherEventTitle;
    this.tvPractice = tvPractice;
    this.tvTeamName = tvTeamName;
    this.tvTimeGame = tvTimeGame;
    this.tvTimeOther = tvTimeOther;
    this.tvTimePractice = tvTimePractice;
  }

  @NonNull
  public static ItemEventListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemEventListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemEventListBinding>inflate(inflater, com.teamtasticoapp.R.layout.item_event_list, root, attachToRoot, component);
  }

  @NonNull
  public static ItemEventListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemEventListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemEventListBinding>inflate(inflater, com.teamtasticoapp.R.layout.item_event_list, null, false, component);
  }

  public static ItemEventListBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemEventListBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemEventListBinding)bind(component, view, com.teamtasticoapp.R.layout.item_event_list);
  }
}
