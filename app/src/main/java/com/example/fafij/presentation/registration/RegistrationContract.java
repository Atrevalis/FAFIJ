package com.example.fafij.presentation.registration;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface RegistrationContract {

    interface RegistrationViewInterface {
        void showToastDuplicateError();
        void showToastDataError();
        void showToastConnectionError();
        void goToAddJournal();
        void testSuccessMessage(int code);
        void testFailMessage(String exception);
        void testtest(String s);
    }

    interface RegistrationPresenterInterface {
        void onRegistrationClick(String login, String password) throws JSONException, NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException;
    }

}
