package com.example.fafij.presentation.inviteuser;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.R;

public class InviteUserActivity extends AppCompatActivity implements InviteUserContract.InviteUserViewInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InviteUserPresenter presenter = new InviteUserPresenter(this);
    }


}