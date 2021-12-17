package com.teamtasticoapp.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import net.grobas.view.PolygonImageView;

public abstract class InviteFrndLayoutBinding extends ViewDataBinding {
  @NonNull
  public final PolygonImageView ivTeamMember;

  @NonNull
  public final TextView name;

  @NonNull
  public final TextView tvNumber;

  protected InviteFrndLayoutBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, PolygonImageView ivTeamMember, TextView name, TextView tvNumber) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivTeamMember = ivTeamMember;
    this.name = name;
    this.tvNumber = tvNumber;
  }

  @NonNull
  public static InviteFrndLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static InviteFrndLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<InviteFrndLayoutBinding>inflate(inflater, com.teamtasticoapp.R.layout.invite_frnd_layout, root, attachToRoot, component);
  }

  @NonNull
  public static InviteFrndLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static InviteFrndLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<InviteFrndLayoutBinding>inflate(inflater, com.teamtasticoapp.R.layout.invite_frnd_layout, null, false, component);
  }

  public static InviteFrndLayoutBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static InviteFrndLayoutBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (InviteFrndLayoutBinding)bind(component, view, com.teamtasticoapp.R.layout.invite_frnd_layout);
  }
}
