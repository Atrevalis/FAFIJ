package com.example.fafij.presentation.invitations;

public class InvitationsPresenter implements InvitationsContract.InvitationsPresenterInterface {

    public InvitationsContract.InvitationsViewInterface view;

    public InvitationsPresenter(InvitationsContract.InvitationsViewInterface view) {
        this.view = view;
    }

}
