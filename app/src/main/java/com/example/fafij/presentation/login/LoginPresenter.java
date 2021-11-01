package com.example.fafij.presentation.login;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static com.example.fafij.models.Network.hashPass;
import static com.example.fafij.models.Network.postRequest;

public class LoginPresenter implements LoginContract.LoginPresenterInterface {

    public LoginContract.LoginViewInterface view;

    public LoginPresenter(LoginContract.LoginViewInterface view) {
        this.view = view;
    }

    /**
     * Проверяет логин и пароль на корректность,
     * проверяет наличие интернет соединения,
     * входит в аккаунт.
     * @param login логин пользователя
     * @param password пароль пользователя
     */
    @Override
    public void onAuthorizationClick(String login, String password) throws JSONException, NoSuchAlgorithmException, InvalidKeySpecException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("login", login);
        jsonObject.put("password", hashPass(password));
        JSONObject request = postRequest(jsonObject,"/login");
        // true -- авторизация успешна, false -- не учпешна (логику потом пропишу)
        // if (true) view.testSuccessMessage();
        // else view.testFailMessage();
        view.testtest(request.toString());
    }
}
