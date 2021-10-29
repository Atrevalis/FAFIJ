package com.example.fafij.presentation.changejournal;

public class ChangeJournalPresenter implements ChangeJournalContract.ChangeJournalPresenterInterface {

    public ChangeJournalContract.ChangeJournalViewInterface view;

    public ChangeJournalPresenter(ChangeJournalContract.ChangeJournalViewInterface view) {
        this.view = view;
    }

    /**
     * Получает данные по выбранному журналу, инициализирует журнал в системе как действующий,
     * указывает View перейти на экран журнала.
     * @param journalName название журнала, на который пользователь нажал
     */
    @Override
    public void onChangingClick(String journalName) {

    }

    /**
     * Получает данные о доступных пользователю журналах из модели
     * полученный список передаёт в метод showJournalsList в View
     * @param login логин пользователя
     */
    @Override
    public void onRefresh(String login) {

    }
}
