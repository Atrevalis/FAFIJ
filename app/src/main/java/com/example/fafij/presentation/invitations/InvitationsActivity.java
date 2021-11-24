package com.example.fafij.presentation.invitations;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fafij.databinding.ActivityInvitationsBinding;
import com.example.fafij.models.data.InvitationsList;

public class InvitationsActivity extends AppCompatActivity implements InvitationsContract.InvitationsViewInterface {

    InvitationsPresenter presenter;
    ActivityInvitationsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInvitationsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        InvitationsPresenter presenter = new InvitationsPresenter(this);
        presenter.onLoad("логин(затычка)");

    }


    @Override
    public void showInvitations(InvitationsList invitationsList) {
        RecyclerView recyclerView = binding.recyclerViewInvitations;
        IAdapter adapter = new IAdapter(this, invitationsList.getInvitation(), presenter);
        recyclerView.setAdapter(adapter);
    }
}