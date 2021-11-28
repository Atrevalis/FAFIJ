package com.example.fafij.presentation.invitations;

import com.example.fafij.models.data.Invitation;


import java.util.ArrayList;

public interface InvitationsContract {

    interface InvitationsViewInterface {
        void showInvitations(ArrayList<Invitation> invitations);
        void showToast(int code);
        void showToastException(String e);
    }

    interface InvitationsPresenterInterface {
        void onAcceptClick(String journalName);
        void onRefuseClick(String journalName);
        void onLoad(String login);
    }

}
