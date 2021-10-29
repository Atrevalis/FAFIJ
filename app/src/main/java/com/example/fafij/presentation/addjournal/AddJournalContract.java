package com.example.fafij.presentation.addjournal;

public interface AddJournalContract {

    interface AddJournalViewInterface {
        void showToastDuplicateError();
        void showToastConnectionError();
        void returnToChanging();
    }

    interface AddJournalPresenterInterface {
        void onAddClick(String journalName);
    }

}
