package com.example.fafij.presentation.changejournal;

import com.example.fafij.models.data.Journal;

import java.util.ArrayList;


public interface ChangeJournalContract {

    interface ChangeJournalViewInterface {
        void showToastError(int code);
        void showToastException(String e);
        void showJournalsList(ArrayList<Journal> journals);
        void saveData(String journalName);
        void goToBottomNavigation();
    }

    interface ChangeJournalPresenterInterface {
        void onChangingClick(String journalName);
        void onLoad(String login);
    }

}
