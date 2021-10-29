package com.example.fafij.presentation.bottomnavigation.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.fafij.R;
import com.example.fafij.presentation.bottomnavigation.infographics.InfographicsContract;


public class CategoriesFragment extends Fragment implements CategoriesContract.CategoriesViewInterface {


    public CategoriesFragment() { }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_journal, container, false);
    }

    /**
     * Перенаправляет на экран категории
     */
    public void goToAddCategory() {

    }

}