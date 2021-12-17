package com.teamtasticoapp.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.InviteFrndLayoutBinding;
import com.teamtasticoapp.bean.FrndJson;

import java.util.ArrayList;

/**
 * Created by mobulous06 on 9/1/18.
 */

public class InviteFriendAdapter extends RecyclerView.Adapter<InviteFriendAdapter.InviteViewHolder> {
    ArrayList<FrndJson> frndJsonArrayList;
    Context context;
    LayoutInflater inflater;
    private OnContactItemClickListener listener;

    public InviteFriendAdapter(Context context, ArrayList<FrndJson> frndJsonArrayList) {
        this.context = context;
        this.frndJsonArrayList = frndJsonArrayList;
        setHasStableIds(true);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void setFrndJsonArrayList(ArrayList<FrndJson> frndJsonArrayList) {
        this.frndJsonArrayList = frndJsonArrayList;
        notifyDataSetChanged();
    }

    @Override
    public InviteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }

        InviteFrndLayoutBinding binding = DataBindingUtil.inflate(inflater, R.layout.invite_frnd_layout, parent, false);
        return new InviteViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final InviteViewHolder holder, int position) {
        FrndJson frndJson = frndJsonArrayList.get(position);

        holder.binding.name.setText(frndJson.getName());
        holder.binding.tvNumber.setText(frndJson.getNumber());

    }

    @Override
    public int getItemCount() {
        if (frndJsonArrayList != null)
            return frndJsonArrayList.size();
        else
            return 0;
    }

    public class InviteViewHolder extends RecyclerView.ViewHolder {
        InviteFrndLayoutBinding binding;

        public InviteViewHolder(InviteFrndLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null)
                        listener.onItemClick(view, getAdapterPosition());
                }
            });
        }
    }

    public interface OnContactItemClickListener {
        void onItemClick(View view, int pos);
    }

    public void setOnContactItemClickListener(OnContactItemClickListener listener) {
        this.listener = listener;
    }


}

