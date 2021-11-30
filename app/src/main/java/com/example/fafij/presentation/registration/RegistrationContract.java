package com.example.fafij.presentation.registration;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface RegistrationContract {

    interface RegistrationViewInterface {
        void showToast(int code);
        void showToastException(String exception);
    }

    interface RegistrationPresenterInterface {
        void onRegistrationClick(String login, String password) throws JSONException, NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException;
    }

}
