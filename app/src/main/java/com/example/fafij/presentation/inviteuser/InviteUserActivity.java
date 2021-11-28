package com.example.fafij.presentation.inviteuser;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.R;
import com.example.fafij.databinding.ActivityInvitationsBinding;
import com.example.fafij.databinding.ActivityInviteuserBinding;

public class InviteUserActivity extends AppCompatActivity implements InviteUserContract.InviteUserViewInterface {

    InviteUserPresenter presenter;
    ActivityInviteuserBinding binding;
    private boolean isAdult = false;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInviteuserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        InviteUserPresenter presenter = new InviteUserPresenter(this);
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
        SharedPreferences sp = getSharedPreferences("mainStorage", Context.MODE_PRIVATE);
        presenter.onInviteClick(sp.getString("journalName", ""),binding.loginEditText.getText().toString(), isAdult);
    }


    @Override
    public void showToast(int code) {

    }

    @Override
    public void showToastException(String e) {

    }
}