package com.example.fafij.presentation.addjournal;

public class AddJournalPresenter implements AddJournalContract.AddJournalPresenterInterface {

    public AddJournalContract.AddJournalViewInterface view;

    public AddJournalPresenter(AddJournalContract.AddJournalViewInterface view) {
        this.view = view;
    }

    /**
     * Передаёт модели указания на создание записи в БД о новом журнале,
     * возвращает пользрователя на экран выбора журнала.
     * @param journalName название журнала, которое задал пользователь
     */
    @Override
    public void onAddClick(String journalName) {

    }
}
