package com.example.fafij.presentation.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fafij.FafijApp;
import com.example.fafij.R;
import com.example.fafij.databinding.ActivityInviteuserBinding;
import com.example.fafij.databinding.ActivityLoginBinding;
import com.example.fafij.presentation.addjournal.AddJournalActivity;
import com.example.fafij.presentation.changejournal.ChangeJournalActivity;
import com.example.fafij.presentation.inviteuser.InviteUserPresenter;
import com.example.fafij.presentation.registration.RegistrationActivity;

import org.json.JSONException;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginViewInterface {

    ActivityLoginBinding binding;
    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FafijApp.context = this;
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        if (!sp.getString("login", "").equals("")) goToChangeJournal();
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        LoginPresenter presenter = new LoginPresenter(this);
        getSupportActionBar().setTitle("Вход");
        binding.loginButton.setOnClickListener(view -> {
            try {
                presenter.onAuthorizationClick(binding.loginEdittextLogin.getText().toString(), binding.loginEdittextPassword.getText().toString());
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                e.printStackTrace();
            }
        });
        binding.registrationButton.setOnClickListener(view -> goToRegistration());

    }

    @Override
    public void showToast(int code) {
        String toast = "";
        if (code == 0 || code == 500) toast = "Неизвестная ошибка";
        if (code == 401) toast = "Неверное имя пользователя или пароль";
        Toast.makeText(
                this,
                toast,
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void showToastException(String exception) {
        Toast.makeText(
                this,
                exception,
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void saveData(String login, String jwtToken) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("login", login);
        editor.putString("jwtToken", jwtToken);
        editor.apply();
    }

    /**
     * Перенаправляет на экран AddJournal (ext)
     */
    @Override
    public void goToChangeJournal() {
        startActivity(new Intent(this, ChangeJournalActivity.class));
    }

    /**
     * Перемещает на экран регистрации
     */
    public void goToRegistration() {
        Intent regIntent = new Intent(this, RegistrationActivity.class);
        startActivity(regIntent);
    }
}