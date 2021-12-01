package com.example.fafij.presentation.addjournal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.databinding.ActivityAddjournalBinding;
import com.example.fafij.presentation.changejournal.ChangeJournalActivity;

import java.util.Objects;

public class AddJournalActivity extends AppCompatActivity implements AddJournalContract.AddJournalViewInterface {

    ActivityAddjournalBinding binding;
    AddJournalPresenter presenter= new AddJournalPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddjournalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        binding.addJournal.setOnClickListener(view -> sendAddingJournalName());

    }

    /**
     * Отображает тост ошибки кодом (ext)
     */
    @Override
    public void showToast(int code) {
        String toast = "";
        if (code == 0 || code == 500) toast = "Неизвестная ошибка";
        if (code == 409) toast = "Журнал с таким названием уже существует";
        Toast.makeText(
                this,
                toast,
                Toast.LENGTH_SHORT
        ).show();
    }

    /**
     * Отображает тост ошибки строкой (ext)
     */
    @Override
    public void showToastException(String e) {
        Toast.makeText(
                this,
                e,
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void returnToChange() {
        startActivity(new Intent(this, ChangeJournalActivity.class));
    }

    public void sendAddingJournalName() {
        if (binding.journalNameEdittext.getText().toString().equals("")) {
            showToastException("Введите название журнала");
            return;
        }
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        presenter.onAddJournalClick(sp.getString("login", ""), binding.journalNameEdittext.getText().toString());
    }

}