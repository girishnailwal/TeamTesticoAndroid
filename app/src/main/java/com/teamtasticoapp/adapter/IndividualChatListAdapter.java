package com.teamtasticoapp.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.ItemIndividualChatBinding;
import com.teamtasticoapp.bean.IndividualMessageListResponse;

import java.util.List;

/**
 * Created by mobulous55 on 14/2/18.
 */

public class IndividualChatListAdapter extends RecyclerView.Adapter<IndividualChatListAdapter.ViewHolder> {

    Context context;
    LayoutInflater inflater;
    List<IndividualMessageListResponse> individualMessageList;
    private OnIndividualChatListItemClickListener listener;


    public IndividualChatListAdapter(Context context, List<IndividualMessageListResponse> individualMessageList) {
        this.context = context;
        this.individualMessageList = individualMessageList;
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

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }

        ItemIndividualChatBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_individual_chat, parent, false);
        return new ViewHolder(binding);


    }

    @Override
    public void onBindViewHolder(IndividualChatListAdapter.ViewHolder holder, int position) {

        IndividualMessageListResponse individualMessageListResponse = individualMessageList.get(position);

        holder.binding.tvName.setText(individualMessageListResponse.getName());
        holder.binding.tvMessage.setText(individualMessageListResponse.getMessage());
        holder.binding.tvTime.setText(individualMessageListResponse.getDate());

        String imgUrl = individualMessageListResponse.getImage();
        if (imgUrl != null && imgUrl.length() > 0) {
            Picasso.with(context).load(imgUrl).into(holder.binding.ivChatMember);

        }
    }

    @Override
    public int getItemCount() {
        return individualMessageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemIndividualChatBinding binding;


        public ViewHolder(ItemIndividualChatBinding binding) {
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

    public interface OnIndividualChatListItemClickListener {
        void onItemClick(View view, int pos);
    }

    public void setOnIndividualChatListClickListener(IndividualChatListAdapter.OnIndividualChatListItemClickListener listener) {
        this.listener = listener;
    }

}



