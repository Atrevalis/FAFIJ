package com.example.fafij.presentation.registration;

public interface RegistrationContract {

    interface RegistrationViewInterface {
        void showToastDuplicateError();
        void showToastDataError();
        void showToastConnectionError();
        void goToAddJournal();
    }

    interface RegistrationPresenterInterface {
        void onRegistrationClick(String login, String password);
    }

}
