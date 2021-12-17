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
import android.widget.TextView;
import net.grobas.view.PolygonImageView;

public abstract class ItemIndividualChatDetailBinding extends ViewDataBinding {
  @NonNull
  public final ImageView ivReceiver;

  @NonNull
  public final ImageView ivSender;

  @NonNull
  public final PolygonImageView ivTeamMemberReceiver;

  @NonNull
  public final PolygonImageView ivTeamMemberSender;

  @NonNull
  public final LinearLayout llChatDetail;

  @NonNull
  public final LinearLayout llChatRece;

  @NonNull
  public final LinearLayout llChatReceiver;

  @NonNull
  public final LinearLayout llChatSen;

  @NonNull
  public final LinearLayout llChatSender;

  @NonNull
  public final LinearLayout llSender;

  @NonNull
  public final TextView tvMessageReceiver;

  @NonNull
  public final TextView tvMessageSender;

  @NonNull
  public final TextView tvNameReceiver;

  @NonNull
  public final TextView tvNameSender;

  @NonNull
  public final TextView tvTimeReceiver;

  @NonNull
  public final TextView tvTimeSender;

  protected ItemIndividualChatDetailBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView ivReceiver, ImageView ivSender,
      PolygonImageView ivTeamMemberReceiver, PolygonImageView ivTeamMemberSender,
      LinearLayout llChatDetail, LinearLayout llChatRece, LinearLayout llChatReceiver,
      LinearLayout llChatSen, LinearLayout llChatSender, LinearLayout llSender,
      TextView tvMessageReceiver, TextView tvMessageSender, TextView tvNameReceiver,
      TextView tvNameSender, TextView tvTimeReceiver, TextView tvTimeSender) {
    super(_bindingComponent, _root, _localFieldCount);
    this.ivReceiver = ivReceiver;
    this.ivSender = ivSender;
    this.ivTeamMemberReceiver = ivTeamMemberReceiver;
    this.ivTeamMemberSender = ivTeamMemberSender;
    this.llChatDetail = llChatDetail;
    this.llChatRece = llChatRece;
    this.llChatReceiver = llChatReceiver;
    this.llChatSen = llChatSen;
    this.llChatSender = llChatSender;
    this.llSender = llSender;
    this.tvMessageReceiver = tvMessageReceiver;
    this.tvMessageSender = tvMessageSender;
    this.tvNameReceiver = tvNameReceiver;
    this.tvNameSender = tvNameSender;
    this.tvTimeReceiver = tvTimeReceiver;
    this.tvTimeSender = tvTimeSender;
  }

  @NonNull
  public static ItemIndividualChatDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemIndividualChatDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemIndividualChatDetailBinding>inflate(inflater, com.teamtasticoapp.R.layout.item_individual_chat_detail, root, attachToRoot, component);
  }

  @NonNull
  public static ItemIndividualChatDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemIndividualChatDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemIndividualChatDetailBinding>inflate(inflater, com.teamtasticoapp.R.layout.item_individual_chat_detail, null, false, component);
  }

  public static ItemIndividualChatDetailBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemIndividualChatDetailBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemIndividualChatDetailBinding)bind(component, view, com.teamtasticoapp.R.layout.item_individual_chat_detail);
  }
}
