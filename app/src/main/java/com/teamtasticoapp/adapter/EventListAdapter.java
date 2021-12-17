package com.teamtasticoapp.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.teamtasticoapp.R;
import com.teamtasticoapp.bean.EventListResponse;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;
import com.teamtasticoapp.databinding.ItemEventListBinding;

import java.util.List;

/**
 * Created by mobulous55 on 8/6/18.
 */

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.ViewHolder> {
    List<EventListResponse> eventListResponseList;
    Context context;
    LayoutInflater inflater;
    String mType = "";
    OnEventItemDeleteListener eventItemDeleteListener;
    OnEventItemEditListener eventItemEditListener;

    String eventType = "";
    String opponentName = "";
    String date = "";
    String time = "";
    String location = "";
    String teamName = "";


    public EventListAdapter(Context context, List<EventListResponse> eventListResponseList) {
        this.context = context;
        this.eventListResponseList = eventListResponseList;
        mType = SharedPreferenceWriter.getInstance(context).getString(SharedPreferenceKey.type);

    }

    @Override
    public EventListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }
        ItemEventListBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_event_list, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final EventListAdapter.ViewHolder holder, final int position) {

        EventListResponse eventListResponse = eventListResponseList.get(position);

        eventType = eventListResponse.getEvent_type();
        opponentName = eventListResponse.getEvent_vs();
        date = eventListResponse.getEvent_date();
        time = eventListResponse.getEvent_time();
        location = eventListResponse.getLocation();
        teamName = eventListResponse.getTeam_name();

        if (eventType!= null && !eventType.isEmpty()) {
            if (eventType.equalsIgnoreCase("Game")) {
                holder.binding.llGame.setVisibility(View.VISIBLE);
                holder.binding.llPractice.setVisibility(View.GONE);
                holder.binding.llOther.setVisibility(View.GONE);
                holder.binding.tvGame.setText(eventType);

                if(opponentName !=null && !opponentName.isEmpty()) {
                    holder.binding.tvOpponentNameGame.setText(opponentName);
                    holder.binding.tvOpponentNameGame.setVisibility(View.VISIBLE);

                }else {
                    holder.binding.tvOpponentNameGame.setVisibility(View.GONE);
                }
                holder.binding.tvDateGame.setText(date);
                holder.binding.tvTimeGame.setText(time);
                holder.binding.tvTeamName.setText(teamName);

                if ( location !=null && !location.isEmpty() ) {
                   /* holder.binding.tvLocationGame.setVisibility(View.VISIBLE);
                    holder.binding.tvLocationGame.setText(location);
                    holder.binding.tvLocationSymbolGame.setVisibility(View.VISIBLE);  */
                   // holder.binding.tvLocationSymbolGame.setVisibility(View.GONE);
                    holder.binding.tvLocationGame.setText("@"+location+" (Location)");

                } else {
                   /* holder.binding.tvLocationSymbolGame.setVisibility(View.GONE);
                      // holder.binding.tvLocationSymbolGame.setVisibility(View.GONE);
                    holder.binding.tvLocationText.setVisibility(View.GONE);*/
                    holder.binding.tvLocationGame.setText("");
                    holder.binding.tvLocationGame.setVisibility(View.GONE);
                }


            } else if (eventType.equalsIgnoreCase("Practice")) {
                holder.binding.llPractice.setVisibility(View.VISIBLE);
                holder.binding.llGame.setVisibility(View.GONE);
                holder.binding.llOther.setVisibility(View.GONE);
                holder.binding.tvPractice.setText(eventType);

                if(opponentName !=null && !opponentName.isEmpty()) {
                    /*holder.binding.tvOpponentNamePractice.setVisibility(View.VISIBLE);
                    holder.binding.tvOpponentNamePractice.setText(opponentName);
                    holder.binding.tvOpponentLocationSymbolPractice.setVisibility(View.VISIBLE);*/
                    holder.binding.tvOpponentNamePractice.setText("@"+opponentName);


                }else{
                    /*holder.binding.tvOpponentLocationSymbolPractice.setVisibility(View.GONE);
                    holder.binding.tvOpponentNamePractice.setVisibility(View.GONE);*/
                    holder.binding.tvOpponentNamePractice.setText("");
                    holder.binding.tvOpponentNamePractice.setVisibility(View.GONE);
                }
                holder.binding.tvDatePractice.setText(date);
                holder.binding.tvTimePractice.setText(time);
                if (location != null && !location.isEmpty()  ) {
                    //holder.binding.tvLocationPractice.setVisibility(View.VISIBLE);
                    holder.binding.tvLocationPractice.setText("@"+location+" (Location)");
                    //holder.binding.tvLocationSymbolPractice.setVisibility(View.VISIBLE);                   // holder.binding.tvLocationSymbolGame.setVisibility(View.GONE);
                } else {
                    //holder.binding.tvLocationSymbolPractice.setVisibility(View.GONE);
                   // holder.binding.tvLocationText.setVisibility(View.GONE);
                    holder.binding.tvLocationPractice.setText("");
                    holder.binding.tvLocationPractice.setVisibility(View.GONE);

                }


            } else {
                holder.binding.llOther.setVisibility(View.VISIBLE);
                holder.binding.llPractice.setVisibility(View.GONE);
                holder.binding.llGame.setVisibility(View.GONE);
                holder.binding.tvOther.setText("OTHER");
                holder.binding.tvOtherEventTitle.setText(eventType);
                holder.binding.tvDateOther.setText(date);
                holder.binding.tvTimeOther.setText(time);
                if (location != null && !location.isEmpty()) {
                    //holder.binding.tvLocationOther.setVisibility(View.VISIBLE);
                   // holder.binding.tvLocationOther.setText(location);
                   // holder.binding.tvLocationSymbolOther.setVisibility(View.VISIBLE);                   // holder.binding.tvLocationSymbolGame.setVisibility(View.GONE);
                    holder.binding.tvLocationOther.setText("@"+location+" (Location)");

                } else {
                    // holder.binding.tvLocationSymbolOther.setVisibility(View.GONE);
                    // holder.binding.tvLocationOtherText.setVisibility(View.GONE);
                    holder.binding.tvLocationOther.setText("");
                    holder.binding.tvLocationOther.setVisibility(View.GONE);

                }

            }

        }


        //------ to check type of user(player/coach) and visible,gone edit/delete ------//
        if (mType != null && !mType.isEmpty()) {
            switch (mType) {

                case "Coach":
                case "coach":
                    holder.binding.tvEditGame.setVisibility(View.VISIBLE);
                    holder.binding.tvEditPractice.setVisibility(View.VISIBLE);
                    holder.binding.tvEditOther.setVisibility(View.VISIBLE);

                    holder.binding.tvDeleteGame.setVisibility(View.VISIBLE);
                    holder.binding.tvDeletePractice.setVisibility(View.VISIBLE);
                    holder.binding.tvDeleteOther.setVisibility(View.VISIBLE);

                    break;


                case "Player":
                case "player":
                    holder.binding.tvEditGame.setVisibility(View.GONE);
                    holder.binding.tvEditPractice.setVisibility(View.GONE);
                    holder.binding.tvEditOther.setVisibility(View.GONE);

                    holder.binding.tvDeleteGame.setVisibility(View.GONE);
                    holder.binding.tvDeletePractice.setVisibility(View.GONE);
                    holder.binding.tvDeleteOther.setVisibility(View.GONE);

                    break;

                default:
                    break;
            }
        } else {
            Toast.makeText(context, "Type Empty", Toast.LENGTH_SHORT).show();
        }
        //-------------to check type and visible,gone edit/delete-----------//


        //------------------------------- delete event---------------------------//
        holder.binding.tvDeleteGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventItemDeleteListener.onItemClick(view, position);
            }
        });

        holder.binding.tvDeletePractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventItemDeleteListener.onItemClick(view, position);
            }
        });

        holder.binding.tvDeleteOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventItemDeleteListener.onItemClick(view, position);
            }
        });


        //---------------------- edit event ------------------------//
        holder.binding.tvEditGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventItemEditListener.onItemClick(view, position);
            }
        });

        holder.binding.tvEditPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventItemEditListener.onItemClick(view, position);
            }
        });

        holder.binding.tvEditOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventItemEditListener.onItemClick(view, position);
            }
        });
    }


    public void deleteItem(int pos) {
        eventListResponseList.remove(pos); //-- delete event --//
        this.notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if (eventListResponseList != null) {
            return eventListResponseList.size();
        } else {
            return 0;
        }
    }


    public List<EventListResponse> getEventListResponseList() {
        return eventListResponseList;
    }

    public void setEventListResponseList(List<EventListResponse> eventListResponseList) {
        this.eventListResponseList = eventListResponseList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemEventListBinding binding;

        public ViewHolder(ItemEventListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


    //-------- delete event interface -----------//

    public interface OnEventItemDeleteListener {
        void onItemClick(View view, int pos);
    }

    public void setOnEventItemDeleteListener(EventListAdapter.OnEventItemDeleteListener listenerEventItemDelete) {
        this.eventItemDeleteListener = listenerEventItemDelete;
    }


    //-------- edit event interface -----------//

    public interface OnEventItemEditListener {
        void onItemClick(View view, int pos);
    }

    public void setOnEventItemEditListener(EventListAdapter.OnEventItemEditListener listenerEventItemEdit) {
        this.eventItemEditListener = listenerEventItemEdit;
    }


}
