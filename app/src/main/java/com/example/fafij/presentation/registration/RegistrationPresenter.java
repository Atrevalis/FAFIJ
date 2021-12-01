package com.example.fafij.presentation.registration;

import androidx.annotation.NonNull;

import com.example.fafij.models.Network.RetrofitApiClient;
import com.example.fafij.models.data.postbodies.LoginPass;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import retrofit2.Call;
import retrofit2.Callback;

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
    public void onRegistrationClick(String login, String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (login.equals("") || password.equals("")) {
            view.showToastException("Введите полные данные");
            return;
        }
        LoginPass postRegIn = new LoginPass(login, hashPass(password));
        Call<Void> call = RetrofitApiClient.getClient().registration(postRegIn);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull retrofit2.Response<Void> response) {
                if (!response.isSuccessful()) view.showToast(response.code());
                else view.finishRegistration();
            }

            @Override
            public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
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
