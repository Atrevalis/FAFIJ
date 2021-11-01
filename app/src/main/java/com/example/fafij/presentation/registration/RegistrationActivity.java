package com.example.fafij.presentation.registration;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.R;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class RegistrationActivity extends AppCompatActivity implements RegistrationContract.RegistrationViewInterface {

    RegistrationPresenter presenter = new RegistrationPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    /**
     * Отправляет в презентер данные из форм (int)
     */
    public void sendFormInfo(View view) throws JSONException, InvalidKeySpecException, NoSuchAlgorithmException {
        EditText login = (EditText)findViewById(R.id.registration_edittext_login);
        EditText password = (EditText)findViewById(R.id.registration_edittext_password);
        String loginString = login.getText().toString();
        String passwordString = password.getText().toString();
        presenter.onRegistrationClick(loginString, passwordString);
    }

    public void testSuccessMessage(){
        Toast.makeText(
                this,
                "Регистрация прошла успешно.",
                Toast.LENGTH_SHORT
                ).show();
    }

    @Override
    public void testFailMessage() {
        Toast.makeText(
                this,
                "Произошла ошибка.",
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