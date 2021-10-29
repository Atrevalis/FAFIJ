package com.example.fafij.presentation.editnote;

public interface EditNoteContract {

    interface EditNoteViewInterface {
        void returnToJournal();
    }

    interface EditNotePresenterInterface {
        void onSubmitClick(int id, String category, long sum, boolean sing, String comment);
    }

}
