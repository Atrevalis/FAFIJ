package com.example.fafij.presentation.addjournal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.databinding.ActivityAddjournalBinding;
import com.example.fafij.presentation.changejournal.ChangeJournalActivity;

public class AddJournalActivity extends AppCompatActivity implements AddJournalContract.AddJournalViewInterface {

    ActivityAddjournalBinding binding;
    AddJournalPresenter presenter= new AddJournalPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddjournalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.addJournal.setOnClickListener(view -> sendAddingJournalName());

    }

    /**
     * Отображает тост ошибки кодом (ext)
     */
    @Override
    public void showToast(int code) {

    }

    /**
     * Отображает тост ошибки строкой (ext)
     */
    @Override
    public void showToastException(String e) {

    }

    @Override
    public void returnToChange() {
        startActivity(new Intent(this, ChangeJournalActivity.class));
    }

    public void sendAddingJournalName() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        presenter.onAddJournalClick(sp.getString("login", ""), binding.journalNameEdittext.getText().toString());
    }

}