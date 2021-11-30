package com.example.fafij.presentation.bottomnavigation.infographics;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.fafij.R;
import com.example.fafij.databinding.FragmentInfographicsBinding;
import com.example.fafij.databinding.FragmentJournalBinding;
import com.example.fafij.databinding.FragmentSettingsBinding;
import com.example.fafij.presentation.bottomnavigation.journal.JournalPresenter;


public class InfographicsFragment extends Fragment implements InfographicsContract.InfographicsViewInterface {

    FragmentInfographicsBinding binding;
    InfographicsPresenter presenter;

    public InfographicsFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInfographicsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }


}