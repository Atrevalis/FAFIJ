package com.example.fafij.presentation.changejournal;

import java.util.ArrayList;


public interface ChangeJournalContract {

    interface ChangeJournalViewInterface {
        void goToJournal();
        void showToastConnectionError();
        void showJournalsList(ArrayList<String> journals);
    }

    interface ChangeJournalPresenterInterface {
        void onChangingClick(String journalName);
        void onRefresh(String login);
    }

}
