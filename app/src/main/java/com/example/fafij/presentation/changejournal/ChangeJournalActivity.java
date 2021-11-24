package com.example.fafij.presentation.changejournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fafij.databinding.ActivityChangejournalBinding;
import com.example.fafij.models.data.JournalNamesWithLoginsList;
import com.example.fafij.presentation.addjournal.AddJournalActivity;
import com.example.fafij.presentation.bottomnavigation.BottomNavigationActivity;

public class ChangeJournalActivity extends AppCompatActivity implements ChangeJournalContract.ChangeJournalViewInterface {

    ActivityChangejournalBinding binding;
    ChangeJournalPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChangejournalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ChangeJournalPresenter presenter = new ChangeJournalPresenter(this);

        presenter.onLoad("логин(затычка)");



    }

    /**
     * Перенаправляет на экран добавления журнала по клику (int)
     */
    public void goToAddJournal(View view) {
        Intent intent = new Intent(this, AddJournalActivity.class);
        startActivity(intent);
    }

    /**
     * Перенаправляет на экран журнала (ext)
     */
    @Override
    public void goToJournal() {
        Intent intent = new Intent(this, BottomNavigationActivity.class);
        startActivity(intent);
    }

    /**
     * Отображает тост "Отсутствует подключение к интернету" (ext)
     */
    @Override
    public void showToastConnectionError() {

    }

    /**
     * Отображает на экране список доступных журналов
     * @param journalNamesWithLoginsList список журналов и пользователей в них
     */
    @Override
    public void showJournalsList(JournalNamesWithLoginsList journalNamesWithLoginsList) {
        RecyclerView recyclerView = binding.recyclerViewChangeJournal;
        CJAdapter adapter = new CJAdapter(this, journalNamesWithLoginsList.getJournalNameWithLogins(), presenter);
        recyclerView.setAdapter(adapter);
    }
}