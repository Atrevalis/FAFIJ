package com.example.fafij.presentation.login;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface LoginContract {

    interface LoginViewInterface {
        void goToChangeJournal();
        void showToast(int code);
        void showToastException(String exception);
        void saveData(String login, String jwtToken);
    }

    interface LoginPresenterInterface {
        void onAuthorizationClick(String login, String password) throws JSONException, NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeySpecException;
    }

}
