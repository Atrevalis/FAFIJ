package com.example.fafij.presentation.inviteuser;

public class InviteUserPresenter implements InviteUserContract.InviteUserPresenterInterface {

    public InviteUserContract.InviteUserViewInterface view;

    public InviteUserPresenter(InviteUserContract.InviteUserViewInterface view) {
        this.view = view;
    }

}
