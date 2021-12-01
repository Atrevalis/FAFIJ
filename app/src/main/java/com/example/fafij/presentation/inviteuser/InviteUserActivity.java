package com.example.fafij.presentation.inviteuser;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.R;
import com.example.fafij.databinding.ActivityInvitationsBinding;
import com.example.fafij.databinding.ActivityInviteuserBinding;

import java.util.Objects;

public class InviteUserActivity extends AppCompatActivity implements InviteUserContract.InviteUserViewInterface {

    InviteUserPresenter presenter = new InviteUserPresenter(this);
    ActivityInviteuserBinding binding;
    private boolean isAdult = false;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInviteuserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        binding.radioButtonsRole.setOnCheckedChangeListener((radioGroup, r_id) -> {
            switch(r_id){
                case R.id.adult:
                    isAdult = true;
                    break;
                case R.id.kid:
                    isAdult = false;
                    break;
            }
        });
        binding.inviteButton.setOnClickListener(view -> sendInvitation());
    }

    public void sendInvitation() {
        if (binding.loginEditText.getText().toString().equals("")) {
            showToastException("Введите логин пользователя");
            return;
        }
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        presenter.onInviteClick(sp.getString("journalName", ""),binding.loginEditText.getText().toString(), isAdult);
    }


    @Override
    public void showToast(int code) {
        String toast = "";
        if (code == 404) toast = "Пользователь не найден";
        if (code == 406) toast = "Недостаточно прав";
        if (code == 500) toast = "Неизвестная ошибка";
        if (code == 409) toast = "Пользователь уже использует этот журнал";
        if (code == 201) toast = "Приглашение отправлено";
        if (code == 303) toast = "Пользователь уже приглашён";
        Toast.makeText(
                this,
                toast,
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void showToastException(String e) {
        Toast.makeText(
                this,
                e,
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public String getLogin() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        return sp.getString("login", "");
    }
}