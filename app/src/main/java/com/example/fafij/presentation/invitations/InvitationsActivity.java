package com.example.fafij.presentation.invitations;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fafij.databinding.ActivityInvitationsBinding;
import com.example.fafij.models.data.Invitation;
import com.example.fafij.models.data.postbodies.CategoryLoginJournal;
import com.example.fafij.models.data.postbodies.LoginJournal;

import java.util.ArrayList;

public class InvitationsActivity extends AppCompatActivity implements InvitationsContract.InvitationsViewInterface {

    InvitationsPresenter presenter = new InvitationsPresenter(this);
    ActivityInvitationsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInvitationsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
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

    @Override
    public LoginJournal getData(String journalName) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        return new LoginJournal(sp.getString("login", ""), journalName);
    }
}