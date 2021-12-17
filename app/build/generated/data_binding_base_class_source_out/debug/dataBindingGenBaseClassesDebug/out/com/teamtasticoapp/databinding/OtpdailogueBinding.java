package com.teamtasticoapp.databinding;

import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public abstract class OtpdailogueBinding extends ViewDataBinding {
  @NonNull
  public final EditText edtCode;

  @NonNull
  public final TextView titleTv;

  @NonNull
  public final TextView tvCancel;

  @NonNull
  public final TextView tvSubmit;

  protected OtpdailogueBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, EditText edtCode, TextView titleTv, TextView tvCancel,
      TextView tvSubmit) {
    super(_bindingComponent, _root, _localFieldCount);
    this.edtCode = edtCode;
    this.titleTv = titleTv;
    this.tvCancel = tvCancel;
    this.tvSubmit = tvSubmit;
  }

  @NonNull
  public static OtpdailogueBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static OtpdailogueBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<OtpdailogueBinding>inflate(inflater, com.teamtasticoapp.R.layout.otpdailogue, root, attachToRoot, component);
  }

  @NonNull
  public static OtpdailogueBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static OtpdailogueBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<OtpdailogueBinding>inflate(inflater, com.teamtasticoapp.R.layout.otpdailogue, null, false, component);
  }

  public static OtpdailogueBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static OtpdailogueBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (OtpdailogueBinding)bind(component, view, com.teamtasticoapp.R.layout.otpdailogue);
  }
}
