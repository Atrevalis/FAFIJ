package com.example.fafij.presentation.registration;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static com.example.fafij.models.Network.hashPass;
import static com.example.fafij.models.Network.postRequest;

public class RegistrationPresenter implements RegistrationContract.RegistrationPresenterInterface {

    public RegistrationContract.RegistrationViewInterface view;

    public RegistrationPresenter(RegistrationContract.RegistrationViewInterface view) {
        this.view = view;
    }

    /**
     * Проверяет на наличие логина в БД,
     * хэширует пароль,
     * создаёт и входит в аккаунт.
     * @param login логин пользователя
     * @param password пароль пользователя
     */
    @Override
    public void onRegistrationClick(String login, String password) throws JSONException, NoSuchAlgorithmException, InvalidKeySpecException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("login", login);
        jsonObject.put("password", hashPass(password));
        JSONObject request = postRequest(jsonObject,"/registration");
        // true -- регистрация успешна, false -- не учпешна (логику потом пропишу)
        // if (true) view.testSuccessMessage();
        // else view.testFailMessage();
        view.testtest(request.toString());
    }
}
