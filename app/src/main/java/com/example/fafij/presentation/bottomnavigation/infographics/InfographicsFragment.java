package com.example.fafij.presentation.bottomnavigation.infographics;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.fafij.R;
import com.example.fafij.models.Journal;
import com.example.fafij.presentation.bottomnavigation.journal.JournalContract;


public class InfographicsFragment extends Fragment implements InfographicsContract.InfographicsViewInterface {

    public InfographicsFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_journal, container, false);
    }


}