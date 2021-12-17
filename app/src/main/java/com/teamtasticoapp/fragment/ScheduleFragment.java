package com.teamtasticoapp.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.databinding.DataBindingUtil;
import android.net.ParseException;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

import com.teamtasticoapp.R;
import com.teamtasticoapp.adapter.EventListAdapter;
import com.teamtasticoapp.bean.CommonResponse;
import com.teamtasticoapp.bean.EventListModel;
import com.teamtasticoapp.bean.EventListResponse;
import com.teamtasticoapp.database.SharedPreferenceKey;
import com.teamtasticoapp.database.SharedPreferenceWriter;
import com.teamtasticoapp.databinding.FragmentScheduleBinding;
import com.teamtasticoapp.databinding.PopUpDeleteEventBinding;
import com.teamtasticoapp.databinding.PopupWantToDeleteChatBinding;
import com.teamtasticoapp.retrofit.ApiClient;
import com.teamtasticoapp.retrofit.ApiInterface;
import com.teamtasticoapp.retrofit.MyDialog;
import com.teamtasticoapp.util.HelperClass;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by mobulous55 on 6/6/18.
 */

public class ScheduleFragment extends Fragment implements View.OnClickListener {
    View rootView;
    FragmentScheduleBinding binding;

    String Authorization = "";
    String mType = "";
    String mVs;
    String mLocation;
    String mDate;
    String mTime;

    private String event_type = "";
    private int event_type_code = -1;   // 0: game, 1: practice, 2: other
    List<EventListResponse> eventListResponseList = new ArrayList<>();
    EventListAdapter eventListAdapter;

    String eventId = "";
    String eventType = "";
    String opponentName = "";
    String date = "";
    String time = "";
    String location = "";
    String eventIdEdit = "";

    public ScheduleFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate your view
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_schedule, container, false);
        rootView = binding.getRoot();

        mType = SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.type);


        if (!mType.isEmpty()) {
            switch (mType) {

                case "Coach":
                case "coach":
                    binding.ivAddEvent.setVisibility(View.VISIBLE);
                    binding.lLayoutAddEvent.setVisibility(View.VISIBLE);

                    binding.btnAdd.setOnClickListener(this);
                    binding.tvCancel.setOnClickListener(this);

                    binding.ivAddEventList.setOnClickListener(this);
                    binding.ivAddEvent.setOnClickListener(this);
                    binding.btnAddEvent.setOnClickListener(this);
                    binding.ivAddEventClose.setOnClickListener(this);

                    break;

                case "Player":
                case "player":
                    binding.ivAddEvent.setVisibility(View.GONE);
                    binding.ivAddEventList.setVisibility(View.GONE);
                    binding.lLayoutAddEvent.setVisibility(View.GONE);

                    binding.llForPlayerMessage.setVisibility(View.VISIBLE);

                    break;

                default:
                    break;
            }
        } else {
            Toast.makeText(getActivity(), "Type Empty", Toast.LENGTH_SHORT).show();
        }


        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                int c_id = radioGroup.getCheckedRadioButtonId();
                Log.v("radioGroup", "c_id: " + c_id);

                int game_id = binding.rdbGame.getId();
                int practice_id = binding.rdbPractice.getId();
                int other_id = binding.rdbOther.getId();


                if (c_id == game_id) {
                    Log.w("radioGroup", "game_id: " + game_id);
                    binding.etOtherEvent.setVisibility(View.GONE);
                    event_type = "Game";
                    // 0: game, 1: practice, 2: other
                    event_type_code = 0;
                }

                if (c_id == practice_id) {
                    Log.w("radioGroup", "practice_id: " + practice_id);
                    binding.etOtherEvent.setVisibility(View.GONE);
                    event_type = "Practice";
                    // 0: game, 1: practice, 2: other
                    event_type_code = 1;
                }

                if (c_id == other_id) {
                    Log.w("radioGroup", "other_id: " + other_id);
                    binding.etOtherEvent.setVisibility(View.VISIBLE);
                    event_type = String.valueOf(binding.etOtherEvent.getText());
                    // 0: game, 1: practice, 2: other
                    event_type_code = 2;
                }

            }
        });

        binding.etOtherEvent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence != null && charSequence.length() > 0) {
                    event_type = charSequence.toString();
                }

                else {
                    event_type = "";
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        binding.edtChooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                final Calendar calendar = Calendar.getInstance();
                int yy = calendar.get(Calendar.YEAR);
                int mm = calendar.get(Calendar.MONTH);
                int dd = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        /*String date = String.valueOf(dayOfMonth) + "/" + String.valueOf(monthOfYear+1)
                                + "/" + String.valueOf(year);*/

                        String date = String.valueOf(year) + "-" + String.valueOf(monthOfYear + 1)
                                + "-" + String.valueOf(dayOfMonth);
                        binding.edtChooseDate.setText(date);
                    }
                }, yy, mm, dd);
                datePicker.show();

            }
        });


        binding.edtChooseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        binding.edtChooseTime.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });

///////////////////////////////////////////////////////////////////////////////

        callEventListApi();//to view event list always if anyone event is created

////////////////////////////////////////////////////////////////////////////////


        return rootView;
    }


    private boolean validateForm() {
        boolean validate = true;
        mVs = binding.edtVS.getText().toString().trim();
        mLocation = binding.edtLocation.getText().toString().trim();
        mDate = binding.edtChooseDate.getText().toString().trim();
        mTime = binding.edtChooseTime.getText().toString().trim();
        String event_name = binding.etOtherEvent.getText().toString().trim();


        if (!validateEvent()) {
            return false;
        }

       /* if (mVs.length() == 0) {
            Toast.makeText(getActivity(), "Please Enter Opponent Team Name", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (mLocation.length() == 0) {
            Toast.makeText(getActivity(), "Please Enter Location", Toast.LENGTH_SHORT).show();
            return false;
        }*/

        if (mDate.length() == 0) {
            Toast.makeText(getActivity(), "Please Enter Date", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (mTime.length() == 0) {
            Toast.makeText(getActivity(), "Please Enter Time", Toast.LENGTH_SHORT).show();
            return false;
        }

        return validate;
    }

    private boolean validateEvent() {

        if (event_type_code == -1) {
            Toast.makeText(getActivity(), "Please Add An Event", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (event_type_code == 2 && event_type.isEmpty()) {
            Toast.makeText(getActivity(), "Please enter an Event Name", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.ivAddEvent:
                binding.rLayoutAddAnEvent.setVisibility(View.VISIBLE);
                binding.ivAddEvent.setVisibility(View.GONE);
                binding.recyclerView.setVisibility(View.GONE);
                break;

            case R.id.btnAddEvent:
                binding.rLayoutAddAnEvent.setVisibility(View.VISIBLE);
                binding.ivAddEvent.setVisibility(View.GONE);

                break;

            case R.id.ivAddEventClose:
                binding.rLayoutAddAnEvent.setVisibility(View.GONE);
                binding.ivAddEvent.setVisibility(View.VISIBLE);

                break;

            case R.id.btnAdd:

                if (validateForm()) {
                    callAddAnEventApi();
                }

                break;

            case R.id.tvCancel:
                binding.rLayoutAddAnEvent.setVisibility(View.GONE);
                binding.ivAddEventClose.setVisibility(View.GONE);
                binding.ivAddEvent.setVisibility(View.VISIBLE);

                //binding.ivAddEventList.setVisibility(View.VISIBLE);
                //binding.recyclerView.setVisibility(View.VISIBLE);

                break;

            case R.id.ivAddEventList:

                binding.rLayoutAddAnEvent.setVisibility(View.VISIBLE);
                binding.recyclerView.setVisibility(View.GONE);
                binding.ivAddEvent.setVisibility(View.GONE);
                binding.ivAddEventList.setVisibility(View.GONE);
                binding.ivAddEventClose.setVisibility(View.VISIBLE);
                binding.ivAddEventClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        binding.rLayoutAddAnEvent.setVisibility(View.GONE);
                        binding.recyclerView.setVisibility(View.VISIBLE);
                        binding.ivAddEventList.setVisibility(View.VISIBLE);
                    }
                });


                binding.tvAdd.setText("Add an Event");
                binding.btnAdd.setText("ADD");

                binding.edtVS.setText("");
                binding.edtChooseDate.setText("");
                binding.edtChooseTime.setText("");
                binding.edtLocation.setText("");
                binding.etOtherEvent.setText("");

                binding.rdbGame.setChecked(false);
                binding.rdbPractice.setChecked(false);
                binding.rdbOther.setChecked(false);

                binding.btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (validateForm()) {
                            callAddAnEventApi();
                        }

                    }
                });

                binding.tvCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        binding.recyclerView.setVisibility(View.VISIBLE);
                        binding.rLayoutAddAnEvent.setVisibility(View.GONE);
                        binding.ivAddEventList.setVisibility(View.VISIBLE);

                    }
                });

                break;

        }

    }

    private void callAddAnEventApi() {

        //start for header
        Authorization = SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(getActivity()).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));
        //end header

        Call<CommonResponse> call = apiInterface.getAddAnEventResult(map, event_type, mDate, mTime, mVs, mLocation);

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(getActivity()).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        binding.ivAddEvent.setVisibility(View.GONE);
                        binding.rLayoutAddAnEvent.setVisibility(View.GONE);
                        binding.recyclerView.setVisibility(View.VISIBLE);
                        setEventListDataInAdapter();

                    } else {
                        Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(getActivity()).hideDialog();
            }
        });
    }

    private void setEventListDataInAdapter() {
        callEventListApi();
        HelperClass.hideSoftKeyBoard(getActivity());
    }

    private void callEventListApi() {

        Authorization = SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(getActivity()).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));


        Call<EventListModel> call = apiInterface.getEventListResult(map);

        call.enqueue(new Callback<EventListModel>() {
            @Override
            public void onResponse(Call<EventListModel> call, Response<EventListModel> response) {
                MyDialog.getInstance(getActivity()).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        //Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_LONG).show();

                        binding.btnAddEvent.setVisibility(View.GONE);
                        binding.lLayoutAddEvent.setVisibility(View.GONE);
                        binding.recyclerView.setVisibility(View.VISIBLE);
                        if (!mType.isEmpty()) {
                            switch (mType) {

                                case "Coach":
                                case "coach":
                                    binding.ivAddEventList.setVisibility(View.VISIBLE);
                                    break;

                                case "Player":
                                case "player":
                                    binding.ivAddEventList.setVisibility(View.GONE);
                                    binding.llForPlayerMessage.setVisibility(View.GONE);
                                    break;

                                default:
                                    break;
                            }
                        } else {
                            Toast.makeText(getActivity(), "Type Empty", Toast.LENGTH_SHORT).show();
                        }

                        eventListResponseList.clear();

                        if (response.body().getEventListResponses() != null &&
                                response.body().getEventListResponses().size() > 0) {

                            eventListResponseList.addAll(response.body().getEventListResponses());

                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                            binding.recyclerView.setLayoutManager(linearLayoutManager);

                            eventListAdapter = new EventListAdapter(getActivity(), eventListResponseList);
                            binding.recyclerView.setAdapter(eventListAdapter);

                            eventListAdapter.setOnEventItemDeleteListener(new EventListAdapter.OnEventItemDeleteListener() {
                                @Override
                                public void onItemClick(View view, int pos) {

                                    eventId = eventListResponseList.get(pos).getEvent_id();
                                    openWantToDeletePopup(pos);

                                }
                            });


                            eventListAdapter.setOnEventItemEditListener(new EventListAdapter.OnEventItemEditListener() {
                                @Override
                                public void onItemClick(View view, int pos) {
                                    binding.rLayoutAddAnEvent.setVisibility(View.VISIBLE);
                                    binding.recyclerView.setVisibility(View.GONE);
                                    binding.ivAddEventList.setVisibility(View.GONE);
                                    binding.ivAddEventClose.setVisibility(View.GONE);


                                    EventListResponse eventListResponse = eventListResponseList.get(pos);

                                    eventType = eventListResponse.getEvent_type();
                                    opponentName = eventListResponse.getEvent_vs();
                                    date = eventListResponse.getEvent_date();
                                    time = eventListResponse.getEvent_time();
                                    location = eventListResponse.getLocation();
                                    eventIdEdit = eventListResponse.getEvent_id();

                                   /* Calendar cal = new GregorianCalendar(TimeZone.getTimeZone(date));
                                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                                    date = df.format(cal.getTime());*/
                                    //"event_date":"Tuesday, June 19, 2018"//

                                    try {
                                        String dateParts[] = date.split(",");
                                        String day = dateParts[0];
                                        String month = dateParts[1];
                                        String year = dateParts[2];

                                        String the_date = month.trim() + ", " + year.trim();
                                        Log.w("the_date", "the_date:" + the_date);

                                        DateFormat originalFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
                                        DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                                        Date dateNew = null;

                                        dateNew = originalFormat.parse(String.valueOf(the_date));
                                        Log.w("dateNew", "dateNew: " + dateNew);

                                        String formattedDate = targetFormat.format(dateNew);  // 20120821
                                        Log.w("formattedDate", "formattedDate: " + formattedDate);

                                        date = formattedDate;

                                    } catch (java.text.ParseException e) {
                                        e.printStackTrace();
                                    }


                                    SimpleDateFormat inFormat = new SimpleDateFormat("hh:mm aa");
                                    SimpleDateFormat outFormat = new SimpleDateFormat("HH:mm");

                                    //String time24 = null;
                                    try {
                                        time = outFormat.format(inFormat.parse(time));
                                    } catch (java.text.ParseException e) {
                                        e.printStackTrace();
                                    }


                                    if (eventType != null && !eventType.isEmpty()) {
                                        if (eventType.equalsIgnoreCase("Game")) {
                                            binding.rdbGame.setChecked(true);

                                            binding.edtVS.setText(opponentName);
                                            binding.edtChooseDate.setText(date);
                                            binding.edtChooseTime.setText(time);
                                            binding.edtLocation.setText(location);
                                            binding.etOtherEvent.setText("");

                                        } else if (eventType.equalsIgnoreCase("Practice")) {
                                            binding.rdbPractice.setChecked(true);

                                            binding.edtVS.setText(opponentName);
                                            binding.edtChooseDate.setText(date);
                                            binding.edtChooseTime.setText(time);
                                            binding.edtLocation.setText(location);
                                            binding.etOtherEvent.setText("");

                                        } else {
                                            binding.rdbOther.setChecked(true);

                                            binding.edtVS.setText(opponentName);
                                            binding.edtChooseDate.setText(date);
                                            binding.edtChooseTime.setText(time);
                                            binding.edtLocation.setText(location);
                                            binding.etOtherEvent.setText(eventType);

                                        }

                                    }


                                    binding.tvAdd.setText("Edit Event");
                                    binding.btnAdd.setText("Save");
                                    binding.btnAdd.setClickable(true);

                                    binding.btnAdd.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {

                                            callEditListApi();

                                        }
                                    });

                                    binding.tvCancel.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            binding.recyclerView.setVisibility(View.VISIBLE);
                                            binding.rLayoutAddAnEvent.setVisibility(View.GONE);
                                            binding.ivAddEventList.setVisibility(View.VISIBLE);


                                        }
                                    });


                                }

                            });


                        } else {

                            Toast.makeText(getActivity(), "No data found.", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        // Toast.makeText(AllUserFloatingActionMenuActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<EventListModel> call, Throwable t) {
                MyDialog.getInstance(getActivity()).hideDialog();
            }

        });

    }

    private void callEditListApi() {

        //start for header
        Authorization = SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(getActivity()).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));
        //end header
        Call<CommonResponse> call = apiInterface.getEditAnEventResult(map, event_type,
                binding.edtChooseDate.getText().toString(), binding.edtChooseTime.getText().toString(),
                binding.edtVS.getText().toString(), binding.edtLocation.getText().toString(),
                eventIdEdit);

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(getActivity()).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        binding.ivAddEvent.setVisibility(View.GONE);
                        binding.rLayoutAddAnEvent.setVisibility(View.GONE);
                        binding.recyclerView.setVisibility(View.VISIBLE);
                        setEventListDataInAdapter();

                    } else {
                        Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(getActivity()).hideDialog();
            }
        });

    }


    private void openWantToDeletePopup(final int pos) {

        PopUpDeleteEventBinding binding;

        final Dialog dialog = new Dialog(getActivity(), R.style.ThemeDialogCustom);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        binding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.pop_up_delete_event, null, false);
        dialog.setContentView(binding.getRoot());

        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);

        binding.btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                callDeleteEventItemApi(pos);

            }
        });

        binding.tvNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        dialog.show();

    }

    private void callDeleteEventItemApi(final int pos) {

        //start for header
        Authorization = SharedPreferenceWriter.getInstance(getActivity()).getString(SharedPreferenceKey.token);

        MyDialog.getInstance(getActivity()).showDialog();
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Map<String, String> map = new HashMap<>();
        map.put("Authorization", String.valueOf(Authorization));
        //end header

        Call<CommonResponse> call = apiInterface.getDeleteEventItemResult(map, eventId);

        call.enqueue(new Callback<CommonResponse>() {
            @Override
            public void onResponse(Call<CommonResponse> call, Response<CommonResponse> response) {
                MyDialog.getInstance(getActivity()).hideDialog();
                if (response.isSuccessful()) {
                    if (response.body().getStatus().equals("SUCCESS")) {
                        Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();

                        eventListAdapter.deleteItem(pos);
                        eventListResponseList = eventListAdapter.getEventListResponseList();
                        if (eventListResponseList != null && eventListResponseList.size() == 0) {
                            binding.lLayoutAddEvent.setVisibility(View.VISIBLE);
                            binding.ivAddEvent.setVisibility(View.VISIBLE);
                            binding.btnAddEvent.setVisibility(View.VISIBLE);
                            binding.btnAddEvent.setClickable(true);
                        }
                    } else {
                        Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommonResponse> call, Throwable t) {
                MyDialog.getInstance(getActivity()).hideDialog();
            }
        });
    }
}
