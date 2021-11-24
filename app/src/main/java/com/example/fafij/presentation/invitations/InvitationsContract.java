package com.example.fafij.presentation.invitations;

import com.example.fafij.models.data.InvitationsList;

public interface InvitationsContract {

    interface InvitationsViewInterface {
        void showInvitations(InvitationsList invitationsList);
    }

    interface InvitationsPresenterInterface {
        void onAcceptClick(String journalName);
        void onRefuseClick(String journalName);
        void onLoad(String login);
    }

}
