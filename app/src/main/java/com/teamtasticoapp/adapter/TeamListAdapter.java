package com.teamtasticoapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.teamtasticoapp.R;
import com.teamtasticoapp.bean.TeamMemberResponse;

import java.util.List;

/**
 * Created by mobulous55 on 14/2/18.
 */

public class TeamListAdapter extends RecyclerView.Adapter<TeamListAdapter.ViewHolder> {
    Context context;//The first parameter is used to pass the context means the reference of current class
    List<TeamMemberResponse> teamList;
    private OnTeamListItemClickListener listener;


    public TeamListAdapter(Context context, List<TeamMemberResponse> teamList) {
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
    public TeamListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_team_member, parent, false));
    }

    @Override
    public void onBindViewHolder(TeamListAdapter.ViewHolder holder, int position) {

        TeamMemberResponse teamMemberResponse = teamList.get(position);

        String TeamMemberName = teamMemberResponse.getName();
        holder.tvTeamMemberName.setText(TeamMemberName);

        String TeamMemberType = teamMemberResponse.getType();
        String upperString = TeamMemberType.substring(0, 1).toUpperCase() + TeamMemberType.substring(1);
        holder.tvTeamMemberType.setText(upperString);

        String imgUrl = teamMemberResponse.getImage();
        if (imgUrl != null && imgUrl.length() > 0) {
            Picasso.with(context).load(imgUrl).into(holder.ivTeamMember);
            //holder.ivTeamMember.setBackground(getResources().getDrawable(R.drawable.profile_pic));
        }

    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivTeamMember;
        TextView tvTeamMemberType;
        TextView tvTeamMemberName;

        public ViewHolder(View itemView) {
            super(itemView);

            ivTeamMember = (ImageView) itemView.findViewById(R.id.ivTeamMember);
            tvTeamMemberName = (TextView) itemView.findViewById(R.id.tvTeamMemberName);
            tvTeamMemberType = (TextView) itemView.findViewById(R.id.tvTeamMemberType);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null)
                        listener.onItemClick(view, getAdapterPosition());
                }
            });


        }
    }

    public interface OnTeamListItemClickListener {
        void onItemClick(View view, int pos);
    }

    public void setOnTeamListItemClickListener(OnTeamListItemClickListener listener) {
        this.listener = listener;
    }
}
