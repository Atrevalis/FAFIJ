package com.example.fafij.presentation.addnote;

public interface AddNoteContract {

    interface AddNoteViewInterface {
        void returnToJournal();
    }

    interface AddNotePresenterInterface {
        void onAddClick(String category, long sum, boolean sing, String comment);
    }

}
