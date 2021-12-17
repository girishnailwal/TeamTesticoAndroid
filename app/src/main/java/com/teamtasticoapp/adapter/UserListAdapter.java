package com.teamtasticoapp.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.ItemFloatingActionMenuBinding;
import com.teamtasticoapp.bean.UserListResponse;

import java.util.List;

/**
 * Created by mobulous55 on 13/3/18.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    List<UserListResponse> userList;
    Context context;
    LayoutInflater inflater;
    OnAllContactItemClickListener listener;


    public UserListAdapter(Context context, List<UserListResponse> userList) {
        this.context = context;
        this.userList = userList;
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
    public UserListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        ItemFloatingActionMenuBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_floating_action_menu, parent, false);
        return new ViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(UserListAdapter.ViewHolder holder, int position) {

        UserListResponse userListResponse = userList.get(position);

        holder.binding.tvUserName.setText(userListResponse.getName());

        String imgUrl = userListResponse.getImage();
        if (imgUrl != null && imgUrl.length() > 0) {
            Picasso.with(context).load(imgUrl).into(holder.binding.ivUser);

        }
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemFloatingActionMenuBinding binding;

        public ViewHolder(ItemFloatingActionMenuBinding binding) {
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

    public interface OnAllContactItemClickListener {
        void onItemClick(View view, int pos);
    }

    public void setOnAllContactItemClickListener(UserListAdapter.OnAllContactItemClickListener listener) {
        this.listener = listener;
    }

}
