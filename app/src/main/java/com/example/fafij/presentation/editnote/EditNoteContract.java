package com.example.fafij.presentation.editnote;

public interface EditNoteContract {

    interface EditNoteViewInterface {
        void returnToJournal();
        void showToast(int code);
        void showToastException(String e);
    }

    interface EditNotePresenterInterface {
        void onSubmitClick(long id, String date, long sum, String category, String comment, String journalName);
    }

}
