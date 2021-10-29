package com.example.fafij.presentation.bottomnavigation.journal;

import com.example.fafij.models.Journal;

public interface JournalContract {

    interface JournalViewInterface {
        void refreshData(Journal journal);
        void showToastConnectionError();
    }

    interface JournalPresenterInterface {
        void onDeleteClick(int id);
        void onRefresh(int id);
    }

}
