package com.example.fafij.presentation.login;

public interface LoginContract {

    interface LoginViewInterface {
        void showToastDataError();
        void showToastConnectionError();
        void goToAddJournal();
    }

    interface LoginPresenterInterface {
        void onAuthorizationClick(String login, String password);
    }

}
