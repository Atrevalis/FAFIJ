package com.example.fafij.presentation.changejournal;

import com.example.fafij.models.data.JournalNamesWithLoginsList;


public interface ChangeJournalContract {

    interface ChangeJournalViewInterface {
        void goToJournal();
        void showToastConnectionError();
        void showJournalsList(JournalNamesWithLoginsList journalNamesWithLoginsList);
    }

    interface ChangeJournalPresenterInterface {
        void onChangingClick(String journalName);
        void onLoad(String login);
    }

}
