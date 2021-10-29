package com.example.fafij.presentation.registration;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.R;

public class RegistrationActivity extends AppCompatActivity implements RegistrationContract.RegistrationViewInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        RegistrationPresenter presenter = new RegistrationPresenter(this);
    }

    /**
     * Отправляет в презентер данные из форм (int)
     */
    public void sendFormInfo() {

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