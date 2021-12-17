package com.teamtasticoapp.retrofit;

import com.teamtasticoapp.bean.CommonResponse;
import com.teamtasticoapp.bean.EventListModel;
import com.teamtasticoapp.bean.GroupChatListModel;
import com.teamtasticoapp.bean.IndividualMessageDetailsModel;
import com.teamtasticoapp.bean.IndividualMessageListModel;
import com.teamtasticoapp.bean.LineUpModel;
import com.teamtasticoapp.bean.PlayerLineupModel;
import com.teamtasticoapp.bean.SendGroupChatModel;
import com.teamtasticoapp.bean.SendIndividualChatModel;
import com.teamtasticoapp.bean.UserListModel;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;


/**
 * Created by mobua06 on 16/6/17.
 */

public interface ApiInterface {

    //after login api we must have to send token in header
    @Multipart
    @POST("create_team")
    Call<CommonResponse> getCreateTeamResult(@PartMap Map<String, RequestBody> partMapData,
                                             @Part MultipartBody.Part profile);

   /* @FormUrlEncoded
    @POST("response")
    Call<CommonResponse> getCreateTeamResult(@Field("name") String name,
                                             @Field("email") String email,
                                             @Field("password") String password,
                                             @Field("team_name") String team_name,
                                             @Field("device_id") String device_id,
                                             @Field("device_type") String device_type,
                                             @Field("position") String position,
                                             @Field("image")String image );*/

  /*  @POST("team_list")
    Call<CommonResponse> getTeamListResult(@Header("Token") String token);*/

    //when we have to send only header use only @POST
    @POST("team_list")
    Call<CommonResponse> getTeamListResult(@HeaderMap Map<String, String> headers);


   /* @Multipart
    @POST("team_list")
    Call<CommonResponse> getTeamListResult(@HeaderMap Map<String,String> h_map,
                                           @PartMap Map<String, RequestBody> partMapData);*/

    @FormUrlEncoded
    @POST("login")
    Call<CommonResponse> getLoginResult(@Field("email") String email,
                                        @Field("password") String password,
                                        @Field("device_id") String device_id,
                                        @Field("device_type") String device_type);

    @FormUrlEncoded
    @POST("logout")
    Call<CommonResponse> getLogoutResult(@HeaderMap Map<String, String> headers,
                                         @Field("device_id") String device_id,
                                         @Field("device_type") String device_type);


    @FormUrlEncoded
    @POST("forgot_password")
    Call<CommonResponse> getForgotPasswordResult(@Field("email") String email);

    @FormUrlEncoded
    @POST("check_team_code")
    Call<CommonResponse> getCheckTeamCodeResult(@Field("team_code") String team_code);


    @Multipart
    @POST("join_team")
    Call<CommonResponse> getJoinTeamResult(@PartMap Map<String, RequestBody> partMapData,
                                           @Part MultipartBody.Part profile);

    @POST("profile")
    Call<CommonResponse> getProfileResult(@HeaderMap Map<String, String> headers);

/*
    @POST("edit_profile")
    Call<CommonResponse> getEditProfileResult(@HeaderMap Map<String, String> headers,
                                              @Field("name") String name,
                                              @Field("email") String email,
                                              @Field("position") String position,
                                              @Field("image") String image);*/

    @Multipart
    @POST("edit_profile")
    Call<CommonResponse> getEditProfileResult(@HeaderMap Map<String, String> headers,
                                              @PartMap Map<String, RequestBody> partMapData,
                                              @Part MultipartBody.Part profileImage);

    @FormUrlEncoded
    @POST("send_team_request")
    Call<CommonResponse> getSendTeamCodeResult(@Field("contact_number") String contact_number,
                                               @Field("team_code") String team_code);

    @FormUrlEncoded
    @POST("delete_team")
    Call<CommonResponse> getDeleteCoachResult(@HeaderMap Map<String, String> headers,
                                              @Field("user_id") String user_id);

    @FormUrlEncoded
    @POST("leave_team")
    Call<CommonResponse> getLeavePlayerResult(@HeaderMap Map<String, String> headers,
                                              @Field("team_id") String team_id);

    @FormUrlEncoded
    @POST("change_password")
    Call<CommonResponse> getChangePasswordResult(@HeaderMap Map<String, String> headers,
                                                 @Field("old_password") String old_password,
                                                 @Field("new_password") String new_password);

    @POST("player_list")
    Call<CommonResponse> getPlayerListResult(@HeaderMap Map<String, String> headers);

    @POST("individual_message_list")
    Call<IndividualMessageListModel> getIndividualMessageTeamListResult(@HeaderMap Map<String, String> headers);

    @POST("player_in_team")
    Call<UserListModel> getUserListResult(@HeaderMap Map<String, String> headers);

    @POST("group_message_list")
    Call<GroupChatListModel> getGroupMessageTeamListResult(@HeaderMap Map<String, String> headers);

    @FormUrlEncoded
    @POST("individual_message_details")
    Call<IndividualMessageDetailsModel> getIndividualMessageDetailsResult(@HeaderMap Map<String, String> headers,
                                                                          @Field("chat_id") String chat_id);

    /* @FormUrlEncoded
     @POST("send_individual_message")
     Call<SendIndividualChatModel> getSendIndividualMessageResult(@HeaderMap Map<String, String> headers,
                                                                  @Field("message") String message,
                                                                  @Field("receiver_id") String receiver_id,
                                                                  @Field("chat_id") String chat_id);*/
    @Multipart
    @POST("send_individual_message")
    Call<SendIndividualChatModel> getSendIndividualMessageResult(@HeaderMap Map<String, String> headers,
                                                                 @PartMap Map<String, RequestBody> partMapData,
                                                                 @Part MultipartBody.Part profileImage);

   /* @FormUrlEncoded
    @POST("send_group_message")
    Call<SendGroupChatModel> getSendGroupMessageResult(@HeaderMap Map<String, String> headers,
                                                       @Field("message") String message);*/

    @Multipart
    @POST("send_group_message")
    Call<SendGroupChatModel> getSendGroupMessageResult(@HeaderMap Map<String, String> headers,
                                                       @PartMap Map<String, RequestBody> partMapData,
                                                       @Part MultipartBody.Part profileImage);

    @FormUrlEncoded
    @POST("delete_message")
    Call<CommonResponse> getDeleteChatItemResult(@HeaderMap Map<String, String> headers,
                                                 @Field("message_id") String message_id);

    @FormUrlEncoded
    @POST("delete_groupmessage")
    Call<CommonResponse> getDeleteGroupChatItemResult(@HeaderMap Map<String, String> headers,
                                                      @Field("message_id") String message_id);

    @POST("delete_account")
    Call<CommonResponse> getDeletePlayerResult(@HeaderMap Map<String, String> headers);

    @FormUrlEncoded
    @POST("change_password_otp")
    Call<CommonResponse> getChangePasswordOtpResult(@Field("email") String email,
                                                    @Field("password") String password);


    @FormUrlEncoded
    @POST("create_event")
    Call<CommonResponse> getAddAnEventResult(@HeaderMap Map<String, String> headers,
                                             @Field("event_type") String event_type,
                                             @Field("event_date") String event_date,
                                             @Field("event_time") String event_time,
                                             @Field("event_vs") String event_vs,
                                             @Field("location") String location);

    @POST("event_list")
    Call<EventListModel> getEventListResult(@HeaderMap Map<String, String> headers);

    @FormUrlEncoded
    @POST("delete_event")
    Call<CommonResponse> getDeleteEventItemResult(@HeaderMap Map<String, String> headers,
                                                  @Field("event_id") String event_id);


    @FormUrlEncoded
    @POST("edit_event")
    Call<CommonResponse> getEditAnEventResult(@HeaderMap Map<String, String> headers,
                                              @Field("event_type") String event_type,
                                              @Field("event_date") String event_date,
                                              @Field("event_time") String event_time,
                                              @Field("event_vs") String event_vs,
                                              @Field("location") String location,
                                              @Field("event_id") String event_id);
    @Multipart
    @POST("edit_lineup")
    Call<UserListModel> getEditPlayerListResult(@HeaderMap Map<String, String> headers,
                                                @PartMap Map<String, RequestBody> partMapData);

    @FormUrlEncoded
    @POST("player_in_lineup")
    Call<PlayerLineupModel> getPlayerInLineupResult(@HeaderMap Map<String, String> headers,
                                                    @Field("team_code") String team_code);
//
//    @FormUrlEncoded
//    @POST("get_lineup_player")
//    Call<PlayerLineupModel> getLineupPlayerResult(@HeaderMap Map<String, String> headers,
//                                            @Field("coach_id") String coach_id);

    @FormUrlEncoded
    @POST("get_lineup_player")
    Call<UserListModel> getLineupPlayerResult(@HeaderMap Map<String, String> headers,
                                            @Field("coach_id") String coach_id);


    @Multipart
    @POST("edit_lineup_player")
    Call<UserListModel> getEditLineupPlayerResult(@HeaderMap Map<String, String> headers,
                                                      @PartMap Map<String, RequestBody> partMapData);

}
