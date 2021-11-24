package com.example.fafij.presentation.invitations;

public class InvitationsPresenter implements InvitationsContract.InvitationsPresenterInterface {

    public InvitationsContract.InvitationsViewInterface view;

    public InvitationsPresenter(InvitationsContract.InvitationsViewInterface view) {
        this.view = view;
    }

    @Override
    public void onAcceptClick(String journalName) {

    }

    @Override
    public void onRefuseClick(String journalName) {

    }

    @Override
    public void onLoad(String login) {

    }
}
