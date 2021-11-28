package com.example.fafij.presentation.addjournal;

import com.example.fafij.models.data.Journal;

import java.util.ArrayList;

public interface AddJournalContract {

    interface AddJournalViewInterface {
        void showToast(int code);
        void showToastException(String e);
    }

    interface AddJournalPresenterInterface {
        void onAddJournalClick(String login, String journalName);
    }

}
