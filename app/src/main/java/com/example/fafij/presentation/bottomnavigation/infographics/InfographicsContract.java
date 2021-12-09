package com.example.fafij.presentation.bottomnavigation.infographics;

import com.example.fafij.models.data.Note;

import java.util.ArrayList;

public interface InfographicsContract {

    interface InfographicsViewInterface {
        void showToastException(String e);
        void showPieChart(ArrayList<Note> notes);
    }

    interface InfographicsPresenterInterface {
        void onLoad(String journalName);
    }

}
