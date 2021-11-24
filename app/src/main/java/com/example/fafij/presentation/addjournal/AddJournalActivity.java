package com.example.fafij.presentation.addjournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.databinding.ActivityAddjournalBinding;
import com.example.fafij.presentation.changejournal.ChangeJournalActivity;

public class AddJournalActivity extends AppCompatActivity implements AddJournalContract.AddJournalViewInterface {

    ActivityAddjournalBinding binding;
    AddJournalPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddjournalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AddJournalPresenter presenter = new AddJournalPresenter(this);
        presenter.onAddJournalClick(binding.journalNameEdittext.getText().toString());
    }

    /**
     * Показывает тост "Журнал с таким названием уже существует у вас" (ext)
     */
    @Override
    public void showToastDuplicateError() {

    }

    /**
     * Показывает тост "Отсутствует подключение к интернету" (ext)
     */
    @Override
    public void showToastConnectionError() {

    }

    public void sendAddingJournalName(View view) {
        presenter.onAddJournalClick(binding.journalNameEdittext.getText().toString());
    }

    public void onChangeJournalActivity() {
        Intent intent = new Intent(this, ChangeJournalActivity.class);
        startActivity(intent);
    }
}