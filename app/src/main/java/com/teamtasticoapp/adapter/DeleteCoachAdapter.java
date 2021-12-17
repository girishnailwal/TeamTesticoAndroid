package com.teamtasticoapp.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.teamtasticoapp.R;
import com.teamtasticoapp.databinding.ItemDeleteCoachBinding;
import com.teamtasticoapp.bean.TeamMemberResponse;

import java.util.List;

/**
 * Created by mobulous55 on 5/3/18.
 */

public class DeleteCoachAdapter extends RecyclerView.Adapter<DeleteCoachAdapter.ViewHolder> {
    ItemDeleteCoachBinding binding;

    Context context;
    LayoutInflater inflater;
    List<TeamMemberResponse> teamList;

    private OnContactItemClickListener listener;

    public DeleteCoachAdapter(Context context, List<TeamMemberResponse> teamList) {
        this.context = context;
        this.teamList = teamList;
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
        // return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_delete_coach, parent, false));
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        binding = DataBindingUtil.inflate(inflater, R.layout.item_delete_coach, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        TeamMemberResponse teamMemberResponse = teamList.get(position);

        String imgUrl = teamMemberResponse.getImage();
        if (imgUrl != null && imgUrl.length() > 0) {
            Picasso.with(context).load(imgUrl).into(holder.binding.ivTeamMember);
        }

        holder.binding.tvTeamMemberName.setText(teamMemberResponse.getName());
        holder.binding.tvTeamMemberType.setText(teamMemberResponse.getType());
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemDeleteCoachBinding binding;

      /*  ImageView ivTeamMember;
          TextView tvTeamMemberType;
          TextView tvTeamMemberName;*/

        public ViewHolder(ItemDeleteCoachBinding binding) {
            super(binding.getRoot());

           /* ivTeamMember = (ImageView) itemView.findViewById(R.id.ivTeamMember);
            tvTeamMemberName = (TextView) itemView.findViewById(R.id.tvTeamMemberName);
            tvTeamMemberType = (TextView) itemView.findViewById(R.id.tvTeamMemberType);*/

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
