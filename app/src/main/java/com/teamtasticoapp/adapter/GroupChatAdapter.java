package com.teamtasticoapp.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.ItemGroupChatBinding;
import com.teamtasticoapp.bean.GroupChatListResponse;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;

import java.util.List;

/**
 * Created by mobulous55 on 14/2/18.
 */

public class GroupChatAdapter extends RecyclerView.Adapter<GroupChatAdapter.ViewHolder> {
    Context context;
    List<GroupChatListResponse> groupChatListResponseList;
    LayoutInflater inflater;
    String userLoginId = "";
    String senderId = "";
    OnImageItemClickListener listener;
    OnGroupChatItemDeleteListener listenerGroupChatItemDelete;


    public GroupChatAdapter(Context context, List<GroupChatListResponse> groupChatListResponseList) {
        this.context = context;
        this.groupChatListResponseList = groupChatListResponseList;
        userLoginId = SharedPreferenceWriter.getInstance(context).getString(SharedPreferenceKey.id);
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

        ItemGroupChatBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_group_chat, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(GroupChatAdapter.ViewHolder holder, final int position) {
        GroupChatListResponse groupChatListResponse = groupChatListResponseList.get(position);
        senderId = groupChatListResponse.getUser_id();
        String sender = groupChatListResponse.getUser_id();

        if (userLoginId.equalsIgnoreCase(sender)) {

            holder.binding.llChatSender.setVisibility(View.VISIBLE);
            holder.binding.llChatReceiver.setVisibility(View.GONE);

            holder.binding.ivSender.setVisibility(View.VISIBLE);
            holder.binding.ivReceiver.setVisibility(View.GONE);

            holder.binding.tvNameSender.setText(groupChatListResponse.getName());
            holder.binding.tvTimeSender.setText(groupChatListResponse.getDate());
            //user Image
            String imgUrlSender = groupChatListResponse.getImage();
            if (imgUrlSender != null && imgUrlSender.length() > 0) {
                Picasso.with(context).load(imgUrlSender).into(holder.binding.ivTeamMemberSender);
            }

            String msg = groupChatListResponse.getMessage();
            if (msg != null && !msg.isEmpty()) {
                holder.binding.tvMessageSender.setVisibility(View.VISIBLE);
                holder.binding.ivSender.setVisibility(View.GONE);

                holder.binding.tvMessageSender.setText(groupChatListResponse.getMessage());

            } else {
                //attachment
                holder.binding.tvMessageSender.setVisibility(View.GONE);
                holder.binding.ivSender.setVisibility(View.VISIBLE);

                String ivUrlSender = groupChatListResponse.getAttachment();
                if (ivUrlSender != null && ivUrlSender.length() > 0) {
                    Picasso.with(context).load(ivUrlSender).into(holder.binding.ivSender);
                }
            }
        } else {
            holder.binding.llChatReceiver.setVisibility(View.VISIBLE);
            holder.binding.llChatSender.setVisibility(View.GONE);

            holder.binding.ivReceiver.setVisibility(View.VISIBLE);
            holder.binding.ivSender.setVisibility(View.GONE);

            holder.binding.tvNameReceiver.setText(groupChatListResponse.getName());
            holder.binding.tvTimeReceiver.setText(groupChatListResponse.getDate());
            //user image
            String imgUrlReceiver = groupChatListResponse.getImage();
            if (imgUrlReceiver != null && imgUrlReceiver.length() > 0) {
                Picasso.with(context).load(imgUrlReceiver).into(holder.binding.ivTeamMemberReceiver);
            }
            String msg = groupChatListResponse.getMessage();
            if (msg != null && !msg.isEmpty()) {
                holder.binding.tvMessageReceiver.setVisibility(View.VISIBLE);
                holder.binding.ivReceiver.setVisibility(View.GONE);

                holder.binding.tvMessageReceiver.setText(groupChatListResponse.getMessage());
            } else {
                holder.binding.tvMessageReceiver.setVisibility(View.GONE);
                holder.binding.ivReceiver.setVisibility(View.VISIBLE);

                //attachment
                String ivUrlReceiver = groupChatListResponse.getAttachment();
                if (ivUrlReceiver != null && ivUrlReceiver.length() > 0) {
                    Picasso.with(context).load(ivUrlReceiver).into(holder.binding.ivReceiver);
                }
            }
        }

      /*  holder.binding.tvUserName.setText(groupChatListResponse.getName());
        holder.binding.tvTime.setText(groupChatListResponse.getDate());
        holder.binding.tvMessage.setText(groupChatListResponse.getMessage());

        String imgUrl = groupChatListResponse.getImage();
        if (imgUrl != null && imgUrl.length() > 0) {
            Picasso.with(context).load(imgUrl).into(holder.binding.ivTeamMember);

        }*/

        holder.binding.ivSender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onItemClick(view, position);
            }
        });

        holder.binding.ivReceiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listener.onItemClick(view, position);
            }
        });

       /* holder.binding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                listenerGroupChatItemDelete.onItemClick(view, position);

                return true;
            }
        });*/

        holder.binding.llChatSender.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                listenerGroupChatItemDelete.onItemClick(view, position);

                return true;
            }
        });
    }


    public void deleteItem(int pos) {
        groupChatListResponseList.remove(pos);
        this.notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return groupChatListResponseList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemGroupChatBinding binding;

        public ViewHolder(ItemGroupChatBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

          /*  binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null)
                        listener.onItemClick(view, getAdapterPosition());
                }
            });*/
        }
    }

    public interface OnImageItemClickListener {
        void onItemClick(View view, int pos);
    }

    public void setOnImageItemClickListener(GroupChatAdapter.OnImageItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnGroupChatItemDeleteListener {
        void onItemClick(View view, int pos);
    }

    public void setOnGroupChatItemDeleteListener(OnGroupChatItemDeleteListener listenerGroupChatItemDelete) {
        this.listenerGroupChatItemDelete = listenerGroupChatItemDelete;
    }
}
