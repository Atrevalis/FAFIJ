package com.example.fafij.presentation.bottomnavigation.journal;

import com.example.fafij.models.data.JournalNameWithLogins;

public class JournalPresenter implements JournalContract.JournalPresenterInterface {

    public JournalContract.JournalViewInterface view;
    public JournalNameWithLogins model;

    public JournalPresenter(JournalContract.JournalViewInterface view) {
        this.view = view;
        this.model = new JournalNameWithLogins();
    }

    /**
     * Указывает модели на необходимость удалить запись из журнала в БД,
     * вызывает метод refreshData в View
     * @param id идентификатор записи
     */
    @Override
    public void onDeleteClick(int id) {

    }

    @Override
    public void onLoad(String login, int journalId) {

    }

}
