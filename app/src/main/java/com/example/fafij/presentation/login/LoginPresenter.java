package com.example.fafij.presentation.login;


import androidx.annotation.NonNull;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;



import com.example.fafij.models.Network.RetrofitApiClient;
import com.example.fafij.models.data.postbodies.LoginPass;
import com.example.fafij.models.data.TokenCatch;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginPresenter implements LoginContract.LoginPresenterInterface {

    public LoginContract.LoginViewInterface view;

    public LoginPresenter(LoginContract.LoginViewInterface view) {
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
    public void onAuthorizationClick(String login, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (login.equals("") || password.equals("")) {
            view.showToastException("Введите полные данные");
            return;
        }
        LoginPass postLoginPass = new LoginPass(login, hashPass(password));
        Call<TokenCatch> call = RetrofitApiClient.getClient().login(postLoginPass);
        call.enqueue(new Callback<TokenCatch>() {
            @Override
            public void onResponse(@NonNull Call<TokenCatch> call, @NonNull retrofit2.Response<TokenCatch> response) {
                if(!response.isSuccessful()) {
                    view.showToast(response.code());
                } else {
                    assert response.body() != null;
                    view.saveData(login, response.body().getJwtToken());
                    view.goToChangeJournal();
                }
            }
            @Override
            public void onFailure(@NonNull Call<TokenCatch> call, @NonNull Throwable t) {
                view.showToastException(t.getLocalizedMessage());
            }
        });
    }

    public static String hashPass(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = new byte[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 512, 128);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = f.generateSecret(spec).getEncoded();
        BigInteger bi = new BigInteger(1, hash);
        String hex = bi.toString(16);
        int paddingLength = (hash.length * 2) - hex.length();
        if(paddingLength > 0) return String.format("%0"  +paddingLength + "d", 0) + hex;
        else return hex;
    }
}
