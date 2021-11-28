package com.example.fafij.presentation.login;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface LoginContract {

    interface LoginViewInterface {
        void showToastDataError();
        void showToastConnectionError();
        void goToChangeJournal();
        void testSuccessMessage(int code);
        void testFailMessage(String exception);
        void saveData(String login, String jwtToken);
        void testtest(String s);
    }

    interface LoginPresenterInterface {
        void onAuthorizationClick(String login, String password) throws JSONException, NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeySpecException;
    }

}
