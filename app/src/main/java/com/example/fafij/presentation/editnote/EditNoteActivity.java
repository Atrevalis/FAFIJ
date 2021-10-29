package com.example.fafij.presentation.editnote;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.R;

public class EditNoteActivity extends AppCompatActivity implements EditNoteContract.EditNoteViewInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditNotePresenter presenter = new EditNotePresenter(this);
    }

    /**
     * Перенаправляет на экран QRCode
     */
    public void goToQRCode() {

    }

    /**
     * Возвращает на экран журнала
     */
    @Override
    public void returnToJournal() {

    }
}