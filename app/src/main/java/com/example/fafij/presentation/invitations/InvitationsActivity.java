package com.example.fafij.presentation.invitations;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fafij.databinding.ActivityInvitationsBinding;
import com.example.fafij.models.data.Invitation;

import java.util.ArrayList;

public class InvitationsActivity extends AppCompatActivity implements InvitationsContract.InvitationsViewInterface {

    InvitationsPresenter presenter;
    ActivityInvitationsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInvitationsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        InvitationsPresenter presenter = new InvitationsPresenter(this);
        SharedPreferences sp = getSharedPreferences("mainStorage", Context.MODE_PRIVATE);
        presenter.onLoad(sp.getString("login", ""));

    }


    @Override
    public void showInvitations(ArrayList<Invitation> invitations) {
        RecyclerView recyclerView = binding.recyclerViewInvitations;
        IAdapter adapter = new IAdapter(this, invitations, presenter);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showToast(int code) {

    }

    @Override
    public void showToastException(String e) {

    }
}