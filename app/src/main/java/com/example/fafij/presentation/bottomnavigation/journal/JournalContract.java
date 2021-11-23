package com.example.fafij.presentation.bottomnavigation.journal;

import com.example.fafij.models.JournalNameWithLogins;

public interface JournalContract {

    interface JournalViewInterface {
        void refreshData(JournalNameWithLogins journal);
        void showToastConnectionError();
    }

    interface JournalPresenterInterface {
        void onDeleteClick(int id);
        void onRefresh(int id);
    }

}
