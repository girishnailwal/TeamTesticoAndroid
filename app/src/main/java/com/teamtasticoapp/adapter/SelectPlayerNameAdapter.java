package com.teamtasticoapp.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.teamtasticoapp.R;
import com.teamtasticoapp.bean.UserListResponse;
import com.teamtasticoapp.databinding.ItemPlayerNameBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mobulous55 on 22/6/18.
 */

public class SelectPlayerNameAdapter  extends RecyclerView.Adapter<SelectPlayerNameAdapter.ViewHolder> {

    List<UserListResponse> userList;
    Context context;
    LayoutInflater inflater;
    OnAllContactItemClickListener listener;


    public SelectPlayerNameAdapter(Context context, List<UserListResponse> userList) {
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
    public SelectPlayerNameAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        ItemPlayerNameBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_player_name, parent, false);
        return new ViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(SelectPlayerNameAdapter.ViewHolder holder, int position) {

        UserListResponse userListResponse = userList.get(position);
        if (userListResponse!=null){
            String name = userListResponse.getName();
            holder.binding.tvPlayerName.setText(name);
        }



    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemPlayerNameBinding binding;

        public ViewHolder(ItemPlayerNameBinding binding) {
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

    public void setOnAllContactItemClickListener(SelectPlayerNameAdapter.OnAllContactItemClickListener listener) {
        this.listener = listener;
    }
}
