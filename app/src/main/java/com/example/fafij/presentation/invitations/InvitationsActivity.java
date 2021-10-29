package com.example.fafij.presentation.invitations;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.R;

public class InvitationsActivity extends AppCompatActivity implements InvitationsContract.InvitationsViewInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InvitationsPresenter presenter = new InvitationsPresenter(this);
    }


}