package com.example.fafij.presentation.bottomnavigation.journal;


import com.example.fafij.models.data.Note;
import com.example.fafij.models.data.postbodies.NoteLoginJournal;


import java.util.ArrayList;

public interface JournalContract {

    interface JournalViewInterface {
        void showNotes(ArrayList<Note> notes);
        void showToast(int code);
        void showToastException(String e);
        NoteLoginJournal getData(long idNote);
        void loadNotes();
    }

    interface JournalPresenterInterface {
        void onDeleteClick(long id);
        void onLoad(String journalName);
    }

}
