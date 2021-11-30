package com.example.fafij.presentation.bottomnavigation.journal;


import com.example.fafij.models.data.Category;
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
        void goToEditNote(long id, String date, long sum, String comment, Category category);
    }

    interface JournalPresenterInterface {
        void onDeleteClick(long id);
        void onEditClick(long id, String date, long sum, String comment, Category category);
        void onLoad(String journalName);
    }

}
