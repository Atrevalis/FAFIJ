package com.example.fafij.presentation.addjournal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.R;

public class AddJournalActivity extends AppCompatActivity implements AddJournalContract.AddJournalViewInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AddJournalPresenter presenter = new AddJournalPresenter(this);
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

    /**
     * Возвращает пользователя на экран (ext/int)
     */
    @Override
    public void returnToChanging() {

    }
}