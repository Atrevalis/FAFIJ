package com.example.fafij.presentation.registration;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.R;
import com.example.fafij.databinding.ActivityLoginBinding;
import com.example.fafij.databinding.ActivityRegistrationBinding;
import com.example.fafij.presentation.login.LoginPresenter;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class RegistrationActivity extends AppCompatActivity implements RegistrationContract.RegistrationViewInterface {

    RegistrationPresenter presenter;
    ActivityRegistrationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        RegistrationPresenter presenter = new RegistrationPresenter(this);
        binding.registrationButton.setOnClickListener(view -> {
            try {
                presenter.onRegistrationClick(binding.registrationEdittextLogin.getText().toString(), binding.registrationEdittextPassword.getText().toString());
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                e.printStackTrace();
            }
        });

    }

    /**
     * Отправляет в презентер данные из форм (int)
     */
    /*public void sendFormInfo(View view) throws JSONException, InvalidKeySpecException, NoSuchAlgorithmException {
        EditText login = (EditText)findViewById(R.id.registration_edittext_login);
        EditText password = (EditText)findViewById(R.id.registration_edittext_password);
        String loginString = login.getText().toString();
        String passwordString = password.getText().toString();
        presenter.onRegistrationClick(loginString, passwordString);
    }*/

    @Override
    public void testSuccessMessage(int code){
        String toast = "";
        if (code == 0) toast = "Неизвестная ошибка";
        if (code == 201) toast = "Аккаунт создан";
        if (code == 202) toast = "Вход успешен";
        if (code == 406) toast = "Ошибка входа. Неправильное имя пользователя или пароль.";
        if (code == 500) toast = "Пользователь уже существует.";
        if (code == 401) toast = "Очередная хуйня";
        Toast.makeText(
                this,
                code + ": "+ toast,
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void testFailMessage(String exception) {
        Toast.makeText(
                this,
                "Произошла ошибка: " + exception,
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void testtest(String s) {
        Toast.makeText(
                this,
                s,
                Toast.LENGTH_SHORT
        ).show();
    }

    /**
     * Отображает тост "Пользователь с таким логином уже существует" (ext)
     */
    @Override
    public void showToastDuplicateError() {

    }

    /**
     * Отображает тост "Логин или пароль не соответствуют стандартам" (ext)
     */
    @Override
    public void showToastDataError() {

    }

    /**
     * Отображает тост "Отсутствует подключение к интернету" (ext)
     */
    @Override
    public void showToastConnectionError() {

    }

    /**
     * Перенаправляет на экран AddJournal (ext)
     */
    @Override
    public void goToAddJournal() {

    }
}