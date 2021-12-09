package com.example.fafij.presentation.inviteuser;

public interface InviteUserContract {

    interface InviteUserViewInterface {
        void showToast(int code);
        void showToastException(String e);
        String getLogin();
    }

    interface InviteUserPresenterInterface {
        void onInviteClick(String journalName, String login, boolean iAdult);
    }

}
