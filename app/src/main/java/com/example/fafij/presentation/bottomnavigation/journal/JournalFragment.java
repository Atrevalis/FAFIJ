package com.example.fafij.presentation.bottomnavigation.journal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fafij.R;
import com.example.fafij.models.Journal;

public class JournalFragment extends Fragment implements JournalContract.JournalViewInterface {

    public JournalFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_journal, container, false);
    }

    /**
     * Перенаправляет на экран добавления записи (int)
     */
    public void onAddNoteClick() {

    }

    /**
     * Перенаправляет на экран редактирования нажатой записи (int)
     */
    public void onEditClick() {

    }

    /**
     * Обновляет данные в списке записей (ext/int)
     */
    @Override
    public void refreshData(Journal journal) {

    }

    /**
     * Отображает тост "Отсутствует подключение к интернету" (ext)
     */
    @Override
    public void showToastConnectionError() {

    }


}