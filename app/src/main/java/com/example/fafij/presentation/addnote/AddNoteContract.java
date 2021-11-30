package com.example.fafij.presentation.addnote;

public interface AddNoteContract {

    interface AddNoteViewInterface {
        void showToast(int code);
        void showToastException(String e);
        void finishActivity();

    }

    interface AddNotePresenterInterface {
        void onAddClick(String date, long sum, String category, String comment, String journalName);
    }

}
