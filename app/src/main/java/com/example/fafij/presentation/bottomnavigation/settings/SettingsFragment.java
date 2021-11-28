package com.example.fafij.presentation.bottomnavigation.settings;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
import com.example.fafij.presentation.login.LoginActivity;

import java.util.Objects;


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
        binding.changeJournal.setOnClickListener(view -> goToChangeJournal());
        binding.addUser.setOnClickListener(view -> goToInviteUser());
        binding.invitations.setOnClickListener(view -> goToInvitations());
        binding.exit.setOnClickListener(view -> goOut());

    }

    public void goToChangeJournal() {
        Intent intent = new Intent(getActivity(), ChangeJournalActivity.class);
        startActivity(intent);
    }

    public void goToInviteUser() {
        Intent intent = new Intent(getActivity(), InviteUserActivity.class);
        startActivity(intent);
    }

    public void goToInvitations() {
        Intent intent = new Intent(getActivity(), InvitationsActivity.class);
        startActivity(intent);
    }

    public void goOut() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("journalName", "");
        editor.putString("jwtToken", "");
        editor.putString("login", "");
        editor.apply();
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
    }

}