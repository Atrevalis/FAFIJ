package com.example.fafij.presentation.bottomnavigation.journal;


import com.example.fafij.models.data.NotesList;

public interface JournalContract {

    interface JournalViewInterface {
        void showNotes(NotesList notesList);
        void showToastConnectionError();
    }

    interface JournalPresenterInterface {
        void onDeleteClick(int id);
        void onLoad(String login, int journalId);
    }

}
