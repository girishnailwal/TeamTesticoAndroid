package com.teamtasticoapp.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.ItemIndividualChatDetailBinding;
import com.teamtasticoapp.bean.IndividualMessageDetailsResponse;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;

import java.util.List;

/**
 * Created by mobulous55 on 15/3/18.
 */

public class IndividualChatDetailAdapter extends RecyclerView.Adapter<IndividualChatDetailAdapter.ViewHolder> {
    Context context;
    List<IndividualMessageDetailsResponse> senderReceiverList;
    LayoutInflater inflater;
    String userLoginId = "";
    String senderId = "";

    OnImageItemClickListener listener;
    OnChatItemDeleteListener listenerChatItemDelete;


    public IndividualChatDetailAdapter(Context context, List<IndividualMessageDetailsResponse> senderReceiverList) {
        this.context = context;
        this.senderReceiverList = senderReceiverList;
        userLoginId = SharedPreferenceWriter.getInstance(context).getString(SharedPreferenceKey.id);
        setHasStableIds(true);//it doesn't take cache data while scrolling.
        // sometimes while scrolling,images don't come refresh.
        // load refreshed data.not taking cache data on that implemented method position
    }

    //method of setHasStableIds
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
    //

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        ItemIndividualChatDetailBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_individual_chat_detail, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        IndividualMessageDetailsResponse individualMessageDetailsResponse = senderReceiverList.get(position);
        senderId = individualMessageDetailsResponse.getSender_id();
        String sender = individualMessageDetailsResponse.getSender_id();
        String type = individualMessageDetailsResponse.getType();

        if (userLoginId.equalsIgnoreCase(sender)) {

            holder.binding.llChatSender.setVisibility(View.VISIBLE);
            holder.binding.llChatReceiver.setVisibility(View.GONE);

            holder.binding.ivSender.setVisibility(View.VISIBLE);
            holder.binding.ivReceiver.setVisibility(View.GONE);

            holder.binding.tvNameSender.setText(individualMessageDetailsResponse.getSender_name());
            holder.binding.tvTimeSender.setText(individualMessageDetailsResponse.getMessage_time());
            //user image
            String imgUrlSender = individualMessageDetailsResponse.getSender_image();
            if (imgUrlSender != null && imgUrlSender.length() > 0) {
                Picasso.with(context).load(imgUrlSender).into(holder.binding.ivTeamMemberSender);
            }


            String msg = individualMessageDetailsResponse.getMessage();
            if (msg != null && !msg.isEmpty()) {
                holder.binding.tvMessageSender.setVisibility(View.VISIBLE);
                holder.binding.ivSender.setVisibility(View.GONE);

                holder.binding.tvMessageSender.setText(individualMessageDetailsResponse.getMessage());

            } else {
                //attachment
                holder.binding.tvMessageSender.setVisibility(View.GONE);
                holder.binding.ivSender.setVisibility(View.VISIBLE);

                String ivUrlSender = individualMessageDetailsResponse.getAttachment();
                if (ivUrlSender != null && ivUrlSender.length() > 0) {
                    Picasso.with(context).load(ivUrlSender).into(holder.binding.ivSender);
                }
            }


        } else {
            holder.binding.llChatReceiver.setVisibility(View.VISIBLE);
            holder.binding.llChatSender.setVisibility(View.GONE);

            holder.binding.ivReceiver.setVisibility(View.VISIBLE);
            holder.binding.ivSender.setVisibility(View.GONE);

            holder.binding.tvNameReceiver.setText(individualMessageDetailsResponse.getSender_name());
            holder.binding.tvTimeReceiver.setText(individualMessageDetailsResponse.getMessage_time());

            //user image
            String imgUrlReceiver = individualMessageDetailsResponse.getSender_image();
            if (imgUrlReceiver != null && imgUrlReceiver.length() > 0) {
                Picasso.with(context).load(imgUrlReceiver).into(holder.binding.ivTeamMemberReceiver);
            }

            String msg = individualMessageDetailsResponse.getMessage();
            if (msg != null && !msg.isEmpty()) {

                holder.binding.tvMessageReceiver.setVisibility(View.VISIBLE);
                holder.binding.ivReceiver.setVisibility(View.GONE);

                holder.binding.tvMessageReceiver.setText(individualMessageDetailsResponse.getMessage());

            } else {
                holder.binding.tvMessageReceiver.setVisibility(View.GONE);
                holder.binding.ivReceiver.setVisibility(View.VISIBLE);

                //attachment
                String ivUrlReceiver = individualMessageDetailsResponse.getAttachment();
                if (ivUrlReceiver != null && ivUrlReceiver.length() > 0) {
                    Picasso.with(context).load(ivUrlReceiver).into(holder.binding.ivReceiver);
                }
            }

        }


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
                listenerChatItemDelete.onItemClick(view, position);
                return true;
            }
        });*/

        holder.binding.llChatSender.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listenerChatItemDelete.onItemClick(view, position);
                return true;
            }
        });

    }

    public void deleteItem(int pos) {
        senderReceiverList.remove(pos);
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return senderReceiverList.size();
    }

    public List<IndividualMessageDetailsResponse> getArrayList() {
        return this.senderReceiverList;
    }

    public void addItem(IndividualMessageDetailsResponse bean) {
        senderReceiverList.add(bean);
        this.notifyItemInserted(senderReceiverList.size());
        this.notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemIndividualChatDetailBinding binding;

        public ViewHolder(ItemIndividualChatDetailBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

           /* binding.getRoot().setOnClickListener(new View.OnClickListener() {
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

    public void setOnImageItemClickListener(OnImageItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnChatItemDeleteListener {
        void onItemClick(View view, int pos);
    }

    public void setOnChatItemDeleteListener(OnChatItemDeleteListener listenerChatItemDelete) {
        this.listenerChatItemDelete = listenerChatItemDelete;
    }

}
