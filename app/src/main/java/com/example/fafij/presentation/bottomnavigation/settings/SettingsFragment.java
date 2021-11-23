package com.example.fafij.presentation.bottomnavigation.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.fafij.R;
import com.example.fafij.databinding.ActivityAddjournalBinding;
import com.example.fafij.databinding.FragmentSettingsBinding;
import com.example.fafij.presentation.addjournal.AddJournalActivity;
import com.example.fafij.presentation.changejournal.ChangeJournalActivity;
import com.example.fafij.presentation.invitations.InvitationsActivity;
import com.example.fafij.presentation.inviteuser.InviteUserActivity;


public class SettingsFragment extends Fragment implements SettingsContract.SettingsViewInterface {

    public SettingsFragment() { }

    FragmentSettingsBinding binding;
    SettingsPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        binding = FragmentSettingsBinding.inflate(getLayoutInflater());
        presenter = new SettingsPresenter(this);
        binding.changeJournal.setOnClickListener(view -> goToChangeJournal(getView()));
        binding.addUser.setOnClickListener(view -> goToInviteUser(getView()));
        binding.invitations.setOnClickListener(view -> goToInvitations(getView()));
        binding.exit.setOnClickListener(view -> presenter.onExitClick());

    }

    public void goToChangeJournal(View view) {
        Intent intent = new Intent(getActivity(), ChangeJournalActivity.class);
        startActivity(intent);
    }

    public void goToInviteUser(View view) {
        Intent intent = new Intent(getActivity(), InviteUserActivity.class);
        startActivity(intent);
    }

    public void goToInvitations(View view) {
        Intent intent = new Intent(getActivity(), InvitationsActivity.class);
        startActivity(intent);
    }

}