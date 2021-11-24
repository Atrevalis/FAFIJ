package com.example.fafij.presentation.bottomnavigation.categories;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fafij.R;
import com.example.fafij.databinding.FragmentCategoriesBinding;
import com.example.fafij.models.data.CategoriesList;
import com.example.fafij.presentation.addcategory.AddCategoryActivity;


public class CategoriesFragment extends Fragment implements CategoriesContract.CategoriesViewInterface {

    FragmentCategoriesBinding binding;
    CategoriesPresenter presenter;

    public CategoriesFragment() { }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_categories, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        binding = FragmentCategoriesBinding.inflate(getLayoutInflater());
        presenter = new CategoriesPresenter(this);
        presenter.onLoad("логин(затычка)");
        binding.addCategoriesButton.setOnClickListener(view -> goToAddCategory());
    }

    /**
     * Перенаправляет на экран добавления категории
     */
    public void goToAddCategory() {
        startActivity(new Intent(getActivity(), AddCategoryActivity.class));
    }

    @Override
    public void showCategories(CategoriesList categoriesList) {
        RecyclerView recyclerView = binding.recyclerViewCategories;
        CAdapter adapter = new CAdapter(getContext(), categoriesList.getCategoriesList(), presenter);
        recyclerView.setAdapter(adapter);
    }
}