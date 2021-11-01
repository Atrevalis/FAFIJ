package com.example.fafij.presentation.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.fafij.R;
import com.example.fafij.presentation.registration.RegistrationActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginViewInterface {

    LoginPresenter presenter = new LoginPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Вход");
    }


    /**
     * Отправляет в презентер данные из форм (int)
     */
    public void sendFormInfo() {
        EditText login = (EditText)findViewById(R.id.login_edittext_login);
        EditText password = (EditText)findViewById(R.id.login_edittext_password);
        String loginString = login.getText().toString();
        String passwordString = password.getText().toString();
        presenter.onAuthorizationClick(loginString, passwordString);
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

    /**
     * Перемещает на экран регистрации
     */
    public void goToRegistration(View view){
        Intent regIntent = new Intent(this, RegistrationActivity.class);
        startActivity(regIntent);
    }
}