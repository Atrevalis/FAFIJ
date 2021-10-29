package com.example.fafij.presentation.changejournal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.R;

import java.util.ArrayList;

public class ChangeJournalActivity extends AppCompatActivity implements ChangeJournalContract.ChangeJournalViewInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ChangeJournalPresenter presenter = new ChangeJournalPresenter(this);
    }

    /**
     * Перенаправляет на экран добавления журнала по клику (int)
     */
    public void goToAddJournal() {

    }

    /**
     * Перенаправляет на экран журнала (ext)
     */
    @Override
    public void goToJournal() {

    }

    /**
     * Отображает тост "Отсутствует подключение к интернету" (ext)
     */
    @Override
    public void showToastConnectionError() {

    }

    /**
     * Отображает на экране список доступных журналов
     * @param journals список журналов
     */
    @Override
    public void showJournalsList(ArrayList<String> journals) {

    }
}