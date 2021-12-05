package com.example.fafij.presentation.invitations;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fafij.databinding.ActivityInvitationsBinding;
import com.example.fafij.models.data.Invitation;
import com.example.fafij.models.data.postbodies.CategoryLoginJournal;
import com.example.fafij.models.data.postbodies.LoginJournal;

import java.util.ArrayList;
import java.util.Objects;

public class InvitationsActivity extends AppCompatActivity implements InvitationsContract.InvitationsViewInterface {

    InvitationsPresenter presenter = new InvitationsPresenter(this);
    ActivityInvitationsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInvitationsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        presenter.onLoad(sp.getString("login", ""));

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
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
        Toast.makeText(
                this,
                e,
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public LoginJournal getData(String journalName) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        return new LoginJournal(sp.getString("login", ""), journalName);
    }
}