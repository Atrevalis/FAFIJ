package com.example.fafij.presentation.inviteuser;

import android.annotation.SuppressLint;
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
    }

    public void sendInvitation(View view) {
        presenter.onInviteClick(binding.loginEditText.getText().toString(), isAdult);
    }

    @Override
    public void showInviteSuccessToast() {
        Toast.makeText(
                this,
                "Приглашение успешно отправлено.",
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void showInviteFailToast() {
        Toast.makeText(
                this,
                "Пользователь не найден.(??)",
                Toast.LENGTH_SHORT
        ).show();
    }
}