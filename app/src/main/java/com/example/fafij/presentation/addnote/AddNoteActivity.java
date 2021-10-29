package com.example.fafij.presentation.addnote;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.R;

public class AddNoteActivity extends AppCompatActivity implements AddNoteContract.AddNoteViewInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AddNotePresenter presenter = new AddNotePresenter(this);
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