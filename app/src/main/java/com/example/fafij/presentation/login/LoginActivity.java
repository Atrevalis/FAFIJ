package com.example.fafij.presentation.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fafij.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginViewInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginPresenter presenter = new LoginPresenter(this);
    }


    /**
     * Отправляет в презентер данные из форм (int)
     */
    public void sendFormInfo() {

    }

    /**
     * Отображает тост "Данные не верны" (ext)
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