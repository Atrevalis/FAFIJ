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
import java.util.Objects;

public class RegistrationActivity extends AppCompatActivity implements RegistrationContract.RegistrationViewInterface {

    ActivityRegistrationBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistrationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        RegistrationPresenter presenter = new RegistrationPresenter(this);
        binding.registrationButton.setOnClickListener(view -> {
            try {
                presenter.onRegistrationClick(binding.registrationEdittextLogin.getText().toString(), binding.registrationEdittextPassword.getText().toString());
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                e.printStackTrace();
            }
        });

    }


    @Override
    public void showToast(int code){
        String toast = "";
        if (code == 0 || code == 500) toast = "Неизвестная ошибка";
        if (code == 201) toast = "Аккаунт создан";
        if (code == 500) toast = "Пользователь уже существует";
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

}