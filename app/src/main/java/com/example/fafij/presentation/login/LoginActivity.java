package com.example.fafij.presentation.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fafij.R;
import com.example.fafij.presentation.registration.RegistrationActivity;

import org.json.JSONException;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

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
    public void sendFormInfo(View view) throws JSONException, InvalidKeySpecException, NoSuchAlgorithmException {
        EditText login = (EditText)findViewById(R.id.login_edittext_login);
        EditText password = (EditText)findViewById(R.id.login_edittext_password);
        String loginString = login.getText().toString();
        String passwordString = password.getText().toString();
        presenter.onAuthorizationClick(loginString, passwordString);
    }

    @Override
    public void testSuccessMessage(){
        Toast.makeText(
                this,
                "Вы были успешно авторизированы.",
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