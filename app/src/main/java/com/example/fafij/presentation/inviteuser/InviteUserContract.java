package com.example.fafij.presentation.inviteuser;

public interface InviteUserContract {

    interface InviteUserViewInterface {
        void showInviteSuccessToast();
        void showInviteFailToast();
    }

    interface InviteUserPresenterInterface {
        void onInviteClick(String login, boolean iAdult);
    }

}
