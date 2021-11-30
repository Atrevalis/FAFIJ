package com.example.fafij.presentation.changejournal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fafij.databinding.ActivityChangejournalBinding;
import com.example.fafij.models.data.Journal;
import com.example.fafij.presentation.addjournal.AddJournalActivity;
import com.example.fafij.presentation.bottomnavigation.BottomNavigationActivity;

import java.util.ArrayList;

public class ChangeJournalActivity extends AppCompatActivity implements ChangeJournalContract.ChangeJournalViewInterface {

    ActivityChangejournalBinding binding;
    ChangeJournalPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangejournalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new ChangeJournalPresenter(this);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        if (!sp.getString("journalName", "").equals("")) goToBottomNavigation();
        presenter.onLoad(sp.getString("login", ""));
        binding.addJournalButton.setOnClickListener(view -> goToAddJournal());


    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        presenter.onLoad(sp.getString("login", ""));
    }

    @Override
    public void saveData(String journalName) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("journalName", journalName);
        editor.apply();
    }

    @Override
    public void goToBottomNavigation() {
        startActivity(new Intent(this, BottomNavigationActivity.class));
    }

    /**
     * Перенаправляет на экран добавления журнала по клику (int)
     */
    public void goToAddJournal() {
        Intent intent = new Intent(this, AddJournalActivity.class);
        startActivity(intent);
    }


    /**
     * Отображает тост ошибки кодом (ext)
     */
    @Override
    public void showToastError(int code) {

    }

    /**
     * Отображает тост ошибки строкой (ext)
     */
    @Override
    public void showToastException(String e) {

    }

    /**
     * Отображает на экране список доступных журналов
     * @param journals список журналов и пользователей в них
     */
    @Override
    public void showJournalsList(ArrayList<Journal> journals) {
        RecyclerView recyclerView = binding.recyclerViewChangeJournal;
        CJAdapter adapter = new CJAdapter(this, journals, presenter);
        recyclerView.setAdapter(adapter);
    }
}