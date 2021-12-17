package com.teamtasticoapp;

import android.databinding.DataBinderMapper;
import android.databinding.DataBindingComponent;
import android.databinding.ViewDataBinding;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import com.teamtasticoapp.databinding.ActivityAboutUsBindingImpl;
import com.teamtasticoapp.databinding.ActivityAddedPlayerBindingImpl;
import com.teamtasticoapp.databinding.ActivityAllUserFloatingMenuBindingImpl;
import com.teamtasticoapp.databinding.ActivityChangePasswordBindingImpl;
import com.teamtasticoapp.databinding.ActivityCreateTeamBindingImpl;
import com.teamtasticoapp.databinding.ActivityCreateTeamConfirmationBindingImpl;
import com.teamtasticoapp.databinding.ActivityCreateTeamInfoBindingImpl;
import com.teamtasticoapp.databinding.ActivityDeleteCoachBindingImpl;
import com.teamtasticoapp.databinding.ActivityEditProfileBindingImpl;
import com.teamtasticoapp.databinding.ActivityForgotPasswordBindingImpl;
import com.teamtasticoapp.databinding.ActivityGroupChatDetailBindingImpl;
import com.teamtasticoapp.databinding.ActivityHomeLoginAllBindingImpl;
import com.teamtasticoapp.databinding.ActivityIndividualChatDetailBindingImpl;
import com.teamtasticoapp.databinding.ActivityInviteFriendsBindingImpl;
import com.teamtasticoapp.databinding.ActivityJoinTeamBindingImpl;
import com.teamtasticoapp.databinding.ActivityJoinTeamConfirmationBindingImpl;
import com.teamtasticoapp.databinding.ActivityJoinTeamInfoBindingImpl;
import com.teamtasticoapp.databinding.ActivityLeaveTeamBindingImpl;
import com.teamtasticoapp.databinding.ActivityLoginBindingImpl;
import com.teamtasticoapp.databinding.ActivityProfileCoachBindingImpl;
import com.teamtasticoapp.databinding.ActivityProfileTeamPlayerBindingImpl;
import com.teamtasticoapp.databinding.ActivityResetPassBindingImpl;
import com.teamtasticoapp.databinding.ActivitySplashBindingImpl;
import com.teamtasticoapp.databinding.ActivityTeamInformationPageWhoJoinBindingImpl;
import com.teamtasticoapp.databinding.ActivityTeamPageHomeBindingImpl;
import com.teamtasticoapp.databinding.DialogCreateLineUpBindingImpl;
import com.teamtasticoapp.databinding.DialogImageSelectBindingImpl;
import com.teamtasticoapp.databinding.DialogSelectPlayerNameBindingImpl;
import com.teamtasticoapp.databinding.DialogselectnoofplayerBindingImpl;
import com.teamtasticoapp.databinding.FragmentAddAnEventBindingImpl;
import com.teamtasticoapp.databinding.FragmentAddPlayerBindingImpl;
import com.teamtasticoapp.databinding.FragmentChatBindingImpl;
import com.teamtasticoapp.databinding.FragmentCreateLineupBindingImpl;
import com.teamtasticoapp.databinding.FragmentGroupChatBindingImpl;
import com.teamtasticoapp.databinding.FragmentIndividualChatBindingImpl;
import com.teamtasticoapp.databinding.FragmentScheduleBindingImpl;
import com.teamtasticoapp.databinding.FragmentSelectPlayerFromTeamBindingImpl;
import com.teamtasticoapp.databinding.FragmentTeamLineupScheduleBindingImpl;
import com.teamtasticoapp.databinding.GallaryImagePlaceSendBindingImpl;
import com.teamtasticoapp.databinding.InviteFrndLayoutBindingImpl;
import com.teamtasticoapp.databinding.ItemDeleteCoachBindingImpl;
import com.teamtasticoapp.databinding.ItemEventListBindingImpl;
import com.teamtasticoapp.databinding.ItemFloatingActionMenuBindingImpl;
import com.teamtasticoapp.databinding.ItemGroupChatBindingImpl;
import com.teamtasticoapp.databinding.ItemGroupChatDetailBindingImpl;
import com.teamtasticoapp.databinding.ItemIndividualChatBindingImpl;
import com.teamtasticoapp.databinding.ItemIndividualChatDetailBindingImpl;
import com.teamtasticoapp.databinding.ItemPlayerNameBindingImpl;
import com.teamtasticoapp.databinding.OtpdailogueBindingImpl;
import com.teamtasticoapp.databinding.PopDeleteOnlyCoachBindingImpl;
import com.teamtasticoapp.databinding.PopUpDeleteEventBindingImpl;
import com.teamtasticoapp.databinding.PopUpDeletePlayerBindingImpl;
import com.teamtasticoapp.databinding.PopupDeleteBindingImpl;
import com.teamtasticoapp.databinding.PopupDeleteProceedBindingImpl;
import com.teamtasticoapp.databinding.PopupPlayerWillAppearBindingImpl;
import com.teamtasticoapp.databinding.PopupWantToDeleteBindingImpl;
import com.teamtasticoapp.databinding.PopupWantToDeleteChatBindingImpl;
import com.teamtasticoapp.databinding.PopupWantToLeaveBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYABOUTUS = 1;

  private static final int LAYOUT_ACTIVITYADDEDPLAYER = 2;

  private static final int LAYOUT_ACTIVITYALLUSERFLOATINGMENU = 3;

  private static final int LAYOUT_ACTIVITYCHANGEPASSWORD = 4;

  private static final int LAYOUT_ACTIVITYCREATETEAM = 5;

  private static final int LAYOUT_ACTIVITYCREATETEAMCONFIRMATION = 6;

  private static final int LAYOUT_ACTIVITYCREATETEAMINFO = 7;

  private static final int LAYOUT_ACTIVITYDELETECOACH = 8;

  private static final int LAYOUT_ACTIVITYEDITPROFILE = 9;

  private static final int LAYOUT_ACTIVITYFORGOTPASSWORD = 10;

  private static final int LAYOUT_ACTIVITYGROUPCHATDETAIL = 11;

  private static final int LAYOUT_ACTIVITYHOMELOGINALL = 12;

  private static final int LAYOUT_ACTIVITYINDIVIDUALCHATDETAIL = 13;

  private static final int LAYOUT_ACTIVITYINVITEFRIENDS = 14;

  private static final int LAYOUT_ACTIVITYJOINTEAM = 15;

  private static final int LAYOUT_ACTIVITYJOINTEAMCONFIRMATION = 16;

  private static final int LAYOUT_ACTIVITYJOINTEAMINFO = 17;

  private static final int LAYOUT_ACTIVITYLEAVETEAM = 18;

  private static final int LAYOUT_ACTIVITYLOGIN = 19;

  private static final int LAYOUT_ACTIVITYPROFILECOACH = 20;

  private static final int LAYOUT_ACTIVITYPROFILETEAMPLAYER = 21;

  private static final int LAYOUT_ACTIVITYRESETPASS = 22;

  private static final int LAYOUT_ACTIVITYSPLASH = 23;

  private static final int LAYOUT_ACTIVITYTEAMINFORMATIONPAGEWHOJOIN = 24;

  private static final int LAYOUT_ACTIVITYTEAMPAGEHOME = 25;

  private static final int LAYOUT_DIALOGCREATELINEUP = 26;

  private static final int LAYOUT_DIALOGIMAGESELECT = 27;

  private static final int LAYOUT_DIALOGSELECTPLAYERNAME = 28;

  private static final int LAYOUT_DIALOGSELECTNOOFPLAYER = 29;

  private static final int LAYOUT_FRAGMENTADDANEVENT = 30;

  private static final int LAYOUT_FRAGMENTADDPLAYER = 31;

  private static final int LAYOUT_FRAGMENTCHAT = 32;

  private static final int LAYOUT_FRAGMENTCREATELINEUP = 33;

  private static final int LAYOUT_FRAGMENTGROUPCHAT = 34;

  private static final int LAYOUT_FRAGMENTINDIVIDUALCHAT = 35;

  private static final int LAYOUT_FRAGMENTSCHEDULE = 36;

  private static final int LAYOUT_FRAGMENTSELECTPLAYERFROMTEAM = 37;

  private static final int LAYOUT_FRAGMENTTEAMLINEUPSCHEDULE = 38;

  private static final int LAYOUT_GALLARYIMAGEPLACESEND = 39;

  private static final int LAYOUT_INVITEFRNDLAYOUT = 40;

  private static final int LAYOUT_ITEMDELETECOACH = 41;

  private static final int LAYOUT_ITEMEVENTLIST = 42;

  private static final int LAYOUT_ITEMFLOATINGACTIONMENU = 43;

  private static final int LAYOUT_ITEMGROUPCHAT = 44;

  private static final int LAYOUT_ITEMGROUPCHATDETAIL = 45;

  private static final int LAYOUT_ITEMINDIVIDUALCHAT = 46;

  private static final int LAYOUT_ITEMINDIVIDUALCHATDETAIL = 47;

  private static final int LAYOUT_ITEMPLAYERNAME = 48;

  private static final int LAYOUT_OTPDAILOGUE = 49;

  private static final int LAYOUT_POPDELETEONLYCOACH = 50;

  private static final int LAYOUT_POPUPDELETEEVENT = 51;

  private static final int LAYOUT_POPUPDELETEPLAYER = 52;

  private static final int LAYOUT_POPUPDELETE = 53;

  private static final int LAYOUT_POPUPDELETEPROCEED = 54;

  private static final int LAYOUT_POPUPPLAYERWILLAPPEAR = 55;

  private static final int LAYOUT_POPUPWANTTODELETE = 56;

  private static final int LAYOUT_POPUPWANTTODELETECHAT = 57;

  private static final int LAYOUT_POPUPWANTTOLEAVE = 58;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(58);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_about_us, LAYOUT_ACTIVITYABOUTUS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_added_player, LAYOUT_ACTIVITYADDEDPLAYER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_all_user_floating_menu, LAYOUT_ACTIVITYALLUSERFLOATINGMENU);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_change_password, LAYOUT_ACTIVITYCHANGEPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_create_team, LAYOUT_ACTIVITYCREATETEAM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_create_team_confirmation, LAYOUT_ACTIVITYCREATETEAMCONFIRMATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_create_team_info, LAYOUT_ACTIVITYCREATETEAMINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_delete_coach, LAYOUT_ACTIVITYDELETECOACH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_edit_profile, LAYOUT_ACTIVITYEDITPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_forgot_password, LAYOUT_ACTIVITYFORGOTPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_group_chat_detail, LAYOUT_ACTIVITYGROUPCHATDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_home_login_all, LAYOUT_ACTIVITYHOMELOGINALL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_individual_chat_detail, LAYOUT_ACTIVITYINDIVIDUALCHATDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_invite_friends, LAYOUT_ACTIVITYINVITEFRIENDS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_join_team, LAYOUT_ACTIVITYJOINTEAM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_join_team_confirmation, LAYOUT_ACTIVITYJOINTEAMCONFIRMATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_join_team_info, LAYOUT_ACTIVITYJOINTEAMINFO);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_leave_team, LAYOUT_ACTIVITYLEAVETEAM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_login, LAYOUT_ACTIVITYLOGIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_profile_coach, LAYOUT_ACTIVITYPROFILECOACH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_profile_team_player, LAYOUT_ACTIVITYPROFILETEAMPLAYER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_reset_pass, LAYOUT_ACTIVITYRESETPASS);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_splash, LAYOUT_ACTIVITYSPLASH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_team_information_page_who_join, LAYOUT_ACTIVITYTEAMINFORMATIONPAGEWHOJOIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.activity_team_page_home, LAYOUT_ACTIVITYTEAMPAGEHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.dialog_create_line_up, LAYOUT_DIALOGCREATELINEUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.dialog_image_select, LAYOUT_DIALOGIMAGESELECT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.dialog_select_player_name, LAYOUT_DIALOGSELECTPLAYERNAME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.dialogselectnoofplayer, LAYOUT_DIALOGSELECTNOOFPLAYER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.fragment_add_an_event, LAYOUT_FRAGMENTADDANEVENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.fragment_add_player, LAYOUT_FRAGMENTADDPLAYER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.fragment_chat, LAYOUT_FRAGMENTCHAT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.fragment_create_lineup, LAYOUT_FRAGMENTCREATELINEUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.fragment_group_chat, LAYOUT_FRAGMENTGROUPCHAT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.fragment_individual_chat, LAYOUT_FRAGMENTINDIVIDUALCHAT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.fragment_schedule, LAYOUT_FRAGMENTSCHEDULE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.fragment_select_player_from_team, LAYOUT_FRAGMENTSELECTPLAYERFROMTEAM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.fragment_team_lineup_schedule, LAYOUT_FRAGMENTTEAMLINEUPSCHEDULE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.gallary_image_place_send, LAYOUT_GALLARYIMAGEPLACESEND);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.invite_frnd_layout, LAYOUT_INVITEFRNDLAYOUT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.item_delete_coach, LAYOUT_ITEMDELETECOACH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.item_event_list, LAYOUT_ITEMEVENTLIST);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.item_floating_action_menu, LAYOUT_ITEMFLOATINGACTIONMENU);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.item_group_chat, LAYOUT_ITEMGROUPCHAT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.item_group_chat_detail, LAYOUT_ITEMGROUPCHATDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.item_individual_chat, LAYOUT_ITEMINDIVIDUALCHAT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.item_individual_chat_detail, LAYOUT_ITEMINDIVIDUALCHATDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.item_player_name, LAYOUT_ITEMPLAYERNAME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.otpdailogue, LAYOUT_OTPDAILOGUE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.pop_delete_only_coach, LAYOUT_POPDELETEONLYCOACH);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.pop_up_delete_event, LAYOUT_POPUPDELETEEVENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.pop_up_delete_player, LAYOUT_POPUPDELETEPLAYER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.popup_delete, LAYOUT_POPUPDELETE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.popup_delete_proceed, LAYOUT_POPUPDELETEPROCEED);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.popup_player_will_appear, LAYOUT_POPUPPLAYERWILLAPPEAR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.popup_want_to_delete, LAYOUT_POPUPWANTTODELETE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.popup_want_to_delete_chat, LAYOUT_POPUPWANTTODELETECHAT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.teamtasticoapp.R.layout.popup_want_to_leave, LAYOUT_POPUPWANTTOLEAVE);
  }

  private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_ACTIVITYABOUTUS: {
        if ("layout/activity_about_us_0".equals(tag)) {
          return new ActivityAboutUsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_about_us is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYADDEDPLAYER: {
        if ("layout/activity_added_player_0".equals(tag)) {
          return new ActivityAddedPlayerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_added_player is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYALLUSERFLOATINGMENU: {
        if ("layout/activity_all_user_floating_menu_0".equals(tag)) {
          return new ActivityAllUserFloatingMenuBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_all_user_floating_menu is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCHANGEPASSWORD: {
        if ("layout/activity_change_password_0".equals(tag)) {
          return new ActivityChangePasswordBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_change_password is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCREATETEAM: {
        if ("layout/activity_create_team_0".equals(tag)) {
          return new ActivityCreateTeamBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_create_team is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCREATETEAMCONFIRMATION: {
        if ("layout/activity_create_team_confirmation_0".equals(tag)) {
          return new ActivityCreateTeamConfirmationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_create_team_confirmation is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYCREATETEAMINFO: {
        if ("layout/activity_create_team_info_0".equals(tag)) {
          return new ActivityCreateTeamInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_create_team_info is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYDELETECOACH: {
        if ("layout/activity_delete_coach_0".equals(tag)) {
          return new ActivityDeleteCoachBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_delete_coach is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYEDITPROFILE: {
        if ("layout/activity_edit_profile_0".equals(tag)) {
          return new ActivityEditProfileBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_edit_profile is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYFORGOTPASSWORD: {
        if ("layout/activity_forgot_password_0".equals(tag)) {
          return new ActivityForgotPasswordBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_forgot_password is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYGROUPCHATDETAIL: {
        if ("layout/activity_group_chat_detail_0".equals(tag)) {
          return new ActivityGroupChatDetailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_group_chat_detail is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYHOMELOGINALL: {
        if ("layout/activity_home_login_all_0".equals(tag)) {
          return new ActivityHomeLoginAllBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_home_login_all is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYINDIVIDUALCHATDETAIL: {
        if ("layout/activity_individual_chat_detail_0".equals(tag)) {
          return new ActivityIndividualChatDetailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_individual_chat_detail is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYINVITEFRIENDS: {
        if ("layout/activity_invite_friends_0".equals(tag)) {
          return new ActivityInviteFriendsBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_invite_friends is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYJOINTEAM: {
        if ("layout/activity_join_team_0".equals(tag)) {
          return new ActivityJoinTeamBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_join_team is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYJOINTEAMCONFIRMATION: {
        if ("layout/activity_join_team_confirmation_0".equals(tag)) {
          return new ActivityJoinTeamConfirmationBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_join_team_confirmation is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYJOINTEAMINFO: {
        if ("layout/activity_join_team_info_0".equals(tag)) {
          return new ActivityJoinTeamInfoBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_join_team_info is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYLEAVETEAM: {
        if ("layout/activity_leave_team_0".equals(tag)) {
          return new ActivityLeaveTeamBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_leave_team is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYLOGIN: {
        if ("layout/activity_login_0".equals(tag)) {
          return new ActivityLoginBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_login is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPROFILECOACH: {
        if ("layout/activity_profile_coach_0".equals(tag)) {
          return new ActivityProfileCoachBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_profile_coach is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYPROFILETEAMPLAYER: {
        if ("layout/activity_profile_team_player_0".equals(tag)) {
          return new ActivityProfileTeamPlayerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_profile_team_player is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYRESETPASS: {
        if ("layout/activity_reset_pass_0".equals(tag)) {
          return new ActivityResetPassBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_reset_pass is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYSPLASH: {
        if ("layout/activity_splash_0".equals(tag)) {
          return new ActivitySplashBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_splash is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYTEAMINFORMATIONPAGEWHOJOIN: {
        if ("layout/activity_team_information_page_who_join_0".equals(tag)) {
          return new ActivityTeamInformationPageWhoJoinBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_team_information_page_who_join is invalid. Received: " + tag);
      }
      case  LAYOUT_ACTIVITYTEAMPAGEHOME: {
        if ("layout/activity_team_page_home_0".equals(tag)) {
          return new ActivityTeamPageHomeBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for activity_team_page_home is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGCREATELINEUP: {
        if ("layout/dialog_create_line_up_0".equals(tag)) {
          return new DialogCreateLineUpBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_create_line_up is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGIMAGESELECT: {
        if ("layout/dialog_image_select_0".equals(tag)) {
          return new DialogImageSelectBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_image_select is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGSELECTPLAYERNAME: {
        if ("layout/dialog_select_player_name_0".equals(tag)) {
          return new DialogSelectPlayerNameBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialog_select_player_name is invalid. Received: " + tag);
      }
      case  LAYOUT_DIALOGSELECTNOOFPLAYER: {
        if ("layout/dialogselectnoofplayer_0".equals(tag)) {
          return new DialogselectnoofplayerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for dialogselectnoofplayer is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTADDANEVENT: {
        if ("layout/fragment_add_an_event_0".equals(tag)) {
          return new FragmentAddAnEventBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_add_an_event is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTADDPLAYER: {
        if ("layout/fragment_add_player_0".equals(tag)) {
          return new FragmentAddPlayerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_add_player is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCHAT: {
        if ("layout/fragment_chat_0".equals(tag)) {
          return new FragmentChatBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_chat is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTCREATELINEUP: {
        if ("layout/fragment_create_lineup_0".equals(tag)) {
          return new FragmentCreateLineupBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_create_lineup is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTGROUPCHAT: {
        if ("layout/fragment_group_chat_0".equals(tag)) {
          return new FragmentGroupChatBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_group_chat is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTINDIVIDUALCHAT: {
        if ("layout/fragment_individual_chat_0".equals(tag)) {
          return new FragmentIndividualChatBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_individual_chat is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSCHEDULE: {
        if ("layout/fragment_schedule_0".equals(tag)) {
          return new FragmentScheduleBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_schedule is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTSELECTPLAYERFROMTEAM: {
        if ("layout/fragment_select_player_from_team_0".equals(tag)) {
          return new FragmentSelectPlayerFromTeamBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_select_player_from_team is invalid. Received: " + tag);
      }
      case  LAYOUT_FRAGMENTTEAMLINEUPSCHEDULE: {
        if ("layout/fragment_team_lineup_schedule_0".equals(tag)) {
          return new FragmentTeamLineupScheduleBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for fragment_team_lineup_schedule is invalid. Received: " + tag);
      }
      case  LAYOUT_GALLARYIMAGEPLACESEND: {
        if ("layout/gallary_image_place_send_0".equals(tag)) {
          return new GallaryImagePlaceSendBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for gallary_image_place_send is invalid. Received: " + tag);
      }
      case  LAYOUT_INVITEFRNDLAYOUT: {
        if ("layout/invite_frnd_layout_0".equals(tag)) {
          return new InviteFrndLayoutBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for invite_frnd_layout is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMDELETECOACH: {
        if ("layout/item_delete_coach_0".equals(tag)) {
          return new ItemDeleteCoachBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_delete_coach is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMEVENTLIST: {
        if ("layout/item_event_list_0".equals(tag)) {
          return new ItemEventListBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_event_list is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMFLOATINGACTIONMENU: {
        if ("layout/item_floating_action_menu_0".equals(tag)) {
          return new ItemFloatingActionMenuBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_floating_action_menu is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMGROUPCHAT: {
        if ("layout/item_group_chat_0".equals(tag)) {
          return new ItemGroupChatBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_group_chat is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMGROUPCHATDETAIL: {
        if ("layout/item_group_chat_detail_0".equals(tag)) {
          return new ItemGroupChatDetailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_group_chat_detail is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMINDIVIDUALCHAT: {
        if ("layout/item_individual_chat_0".equals(tag)) {
          return new ItemIndividualChatBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_individual_chat is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMINDIVIDUALCHATDETAIL: {
        if ("layout/item_individual_chat_detail_0".equals(tag)) {
          return new ItemIndividualChatDetailBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_individual_chat_detail is invalid. Received: " + tag);
      }
      case  LAYOUT_ITEMPLAYERNAME: {
        if ("layout/item_player_name_0".equals(tag)) {
          return new ItemPlayerNameBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for item_player_name is invalid. Received: " + tag);
      }
      case  LAYOUT_OTPDAILOGUE: {
        if ("layout/otpdailogue_0".equals(tag)) {
          return new OtpdailogueBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for otpdailogue is invalid. Received: " + tag);
      }
      case  LAYOUT_POPDELETEONLYCOACH: {
        if ("layout/pop_delete_only_coach_0".equals(tag)) {
          return new PopDeleteOnlyCoachBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for pop_delete_only_coach is invalid. Received: " + tag);
      }
    }
    return null;
  }

  private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent component,
      View view, int internalId, Object tag) {
    switch(internalId) {
      case  LAYOUT_POPUPDELETEEVENT: {
        if ("layout/pop_up_delete_event_0".equals(tag)) {
          return new PopUpDeleteEventBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for pop_up_delete_event is invalid. Received: " + tag);
      }
      case  LAYOUT_POPUPDELETEPLAYER: {
        if ("layout/pop_up_delete_player_0".equals(tag)) {
          return new PopUpDeletePlayerBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for pop_up_delete_player is invalid. Received: " + tag);
      }
      case  LAYOUT_POPUPDELETE: {
        if ("layout/popup_delete_0".equals(tag)) {
          return new PopupDeleteBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for popup_delete is invalid. Received: " + tag);
      }
      case  LAYOUT_POPUPDELETEPROCEED: {
        if ("layout/popup_delete_proceed_0".equals(tag)) {
          return new PopupDeleteProceedBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for popup_delete_proceed is invalid. Received: " + tag);
      }
      case  LAYOUT_POPUPPLAYERWILLAPPEAR: {
        if ("layout/popup_player_will_appear_0".equals(tag)) {
          return new PopupPlayerWillAppearBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for popup_player_will_appear is invalid. Received: " + tag);
      }
      case  LAYOUT_POPUPWANTTODELETE: {
        if ("layout/popup_want_to_delete_0".equals(tag)) {
          return new PopupWantToDeleteBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for popup_want_to_delete is invalid. Received: " + tag);
      }
      case  LAYOUT_POPUPWANTTODELETECHAT: {
        if ("layout/popup_want_to_delete_chat_0".equals(tag)) {
          return new PopupWantToDeleteChatBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for popup_want_to_delete_chat is invalid. Received: " + tag);
      }
      case  LAYOUT_POPUPWANTTOLEAVE: {
        if ("layout/popup_want_to_leave_0".equals(tag)) {
          return new PopupWantToLeaveBindingImpl(component, view);
        }
        throw new IllegalArgumentException("The tag for popup_want_to_leave is invalid. Received: " + tag);
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      // find which method will have it. -1 is necessary becausefirst id starts with 1;
      int methodIndex = (localizedLayoutId - 1) / 50;
      switch(methodIndex) {
        case 0: {
          return internalGetViewDataBinding0(component, view, localizedLayoutId, tag);
        }
        case 1: {
          return internalGetViewDataBinding1(component, view, localizedLayoutId, tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new com.android.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(2);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(58);

    static {
      sKeys.put("layout/activity_about_us_0", com.teamtasticoapp.R.layout.activity_about_us);
      sKeys.put("layout/activity_added_player_0", com.teamtasticoapp.R.layout.activity_added_player);
      sKeys.put("layout/activity_all_user_floating_menu_0", com.teamtasticoapp.R.layout.activity_all_user_floating_menu);
      sKeys.put("layout/activity_change_password_0", com.teamtasticoapp.R.layout.activity_change_password);
      sKeys.put("layout/activity_create_team_0", com.teamtasticoapp.R.layout.activity_create_team);
      sKeys.put("layout/activity_create_team_confirmation_0", com.teamtasticoapp.R.layout.activity_create_team_confirmation);
      sKeys.put("layout/activity_create_team_info_0", com.teamtasticoapp.R.layout.activity_create_team_info);
      sKeys.put("layout/activity_delete_coach_0", com.teamtasticoapp.R.layout.activity_delete_coach);
      sKeys.put("layout/activity_edit_profile_0", com.teamtasticoapp.R.layout.activity_edit_profile);
      sKeys.put("layout/activity_forgot_password_0", com.teamtasticoapp.R.layout.activity_forgot_password);
      sKeys.put("layout/activity_group_chat_detail_0", com.teamtasticoapp.R.layout.activity_group_chat_detail);
      sKeys.put("layout/activity_home_login_all_0", com.teamtasticoapp.R.layout.activity_home_login_all);
      sKeys.put("layout/activity_individual_chat_detail_0", com.teamtasticoapp.R.layout.activity_individual_chat_detail);
      sKeys.put("layout/activity_invite_friends_0", com.teamtasticoapp.R.layout.activity_invite_friends);
      sKeys.put("layout/activity_join_team_0", com.teamtasticoapp.R.layout.activity_join_team);
      sKeys.put("layout/activity_join_team_confirmation_0", com.teamtasticoapp.R.layout.activity_join_team_confirmation);
      sKeys.put("layout/activity_join_team_info_0", com.teamtasticoapp.R.layout.activity_join_team_info);
      sKeys.put("layout/activity_leave_team_0", com.teamtasticoapp.R.layout.activity_leave_team);
      sKeys.put("layout/activity_login_0", com.teamtasticoapp.R.layout.activity_login);
      sKeys.put("layout/activity_profile_coach_0", com.teamtasticoapp.R.layout.activity_profile_coach);
      sKeys.put("layout/activity_profile_team_player_0", com.teamtasticoapp.R.layout.activity_profile_team_player);
      sKeys.put("layout/activity_reset_pass_0", com.teamtasticoapp.R.layout.activity_reset_pass);
      sKeys.put("layout/activity_splash_0", com.teamtasticoapp.R.layout.activity_splash);
      sKeys.put("layout/activity_team_information_page_who_join_0", com.teamtasticoapp.R.layout.activity_team_information_page_who_join);
      sKeys.put("layout/activity_team_page_home_0", com.teamtasticoapp.R.layout.activity_team_page_home);
      sKeys.put("layout/dialog_create_line_up_0", com.teamtasticoapp.R.layout.dialog_create_line_up);
      sKeys.put("layout/dialog_image_select_0", com.teamtasticoapp.R.layout.dialog_image_select);
      sKeys.put("layout/dialog_select_player_name_0", com.teamtasticoapp.R.layout.dialog_select_player_name);
      sKeys.put("layout/dialogselectnoofplayer_0", com.teamtasticoapp.R.layout.dialogselectnoofplayer);
      sKeys.put("layout/fragment_add_an_event_0", com.teamtasticoapp.R.layout.fragment_add_an_event);
      sKeys.put("layout/fragment_add_player_0", com.teamtasticoapp.R.layout.fragment_add_player);
      sKeys.put("layout/fragment_chat_0", com.teamtasticoapp.R.layout.fragment_chat);
      sKeys.put("layout/fragment_create_lineup_0", com.teamtasticoapp.R.layout.fragment_create_lineup);
      sKeys.put("layout/fragment_group_chat_0", com.teamtasticoapp.R.layout.fragment_group_chat);
      sKeys.put("layout/fragment_individual_chat_0", com.teamtasticoapp.R.layout.fragment_individual_chat);
      sKeys.put("layout/fragment_schedule_0", com.teamtasticoapp.R.layout.fragment_schedule);
      sKeys.put("layout/fragment_select_player_from_team_0", com.teamtasticoapp.R.layout.fragment_select_player_from_team);
      sKeys.put("layout/fragment_team_lineup_schedule_0", com.teamtasticoapp.R.layout.fragment_team_lineup_schedule);
      sKeys.put("layout/gallary_image_place_send_0", com.teamtasticoapp.R.layout.gallary_image_place_send);
      sKeys.put("layout/invite_frnd_layout_0", com.teamtasticoapp.R.layout.invite_frnd_layout);
      sKeys.put("layout/item_delete_coach_0", com.teamtasticoapp.R.layout.item_delete_coach);
      sKeys.put("layout/item_event_list_0", com.teamtasticoapp.R.layout.item_event_list);
      sKeys.put("layout/item_floating_action_menu_0", com.teamtasticoapp.R.layout.item_floating_action_menu);
      sKeys.put("layout/item_group_chat_0", com.teamtasticoapp.R.layout.item_group_chat);
      sKeys.put("layout/item_group_chat_detail_0", com.teamtasticoapp.R.layout.item_group_chat_detail);
      sKeys.put("layout/item_individual_chat_0", com.teamtasticoapp.R.layout.item_individual_chat);
      sKeys.put("layout/item_individual_chat_detail_0", com.teamtasticoapp.R.layout.item_individual_chat_detail);
      sKeys.put("layout/item_player_name_0", com.teamtasticoapp.R.layout.item_player_name);
      sKeys.put("layout/otpdailogue_0", com.teamtasticoapp.R.layout.otpdailogue);
      sKeys.put("layout/pop_delete_only_coach_0", com.teamtasticoapp.R.layout.pop_delete_only_coach);
      sKeys.put("layout/pop_up_delete_event_0", com.teamtasticoapp.R.layout.pop_up_delete_event);
      sKeys.put("layout/pop_up_delete_player_0", com.teamtasticoapp.R.layout.pop_up_delete_player);
      sKeys.put("layout/popup_delete_0", com.teamtasticoapp.R.layout.popup_delete);
      sKeys.put("layout/popup_delete_proceed_0", com.teamtasticoapp.R.layout.popup_delete_proceed);
      sKeys.put("layout/popup_player_will_appear_0", com.teamtasticoapp.R.layout.popup_player_will_appear);
      sKeys.put("layout/popup_want_to_delete_0", com.teamtasticoapp.R.layout.popup_want_to_delete);
      sKeys.put("layout/popup_want_to_delete_chat_0", com.teamtasticoapp.R.layout.popup_want_to_delete_chat);
      sKeys.put("layout/popup_want_to_leave_0", com.teamtasticoapp.R.layout.popup_want_to_leave);
    }
  }
}
