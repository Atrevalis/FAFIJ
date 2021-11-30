package com.example.fafij.presentation.bottomnavigation.categories;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fafij.databinding.FragmentCategoriesBinding;
import com.example.fafij.models.data.postbodies.CategoryLoginJournal;
import com.example.fafij.presentation.addcategory.AddCategoryActivity;

import java.util.ArrayList;


public class CategoriesFragment extends Fragment implements CategoriesContract.CategoriesViewInterface {

    FragmentCategoriesBinding binding;
    CategoriesPresenter presenter = new CategoriesPresenter(this);

    public CategoriesFragment() { }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.addCategoriesButton.setOnClickListener(view -> goToAddCategory());
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        loadCategories();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadCategories();
    }

    /**
     * Перенаправляет на экран добавления категории
     */
    public void goToAddCategory() {
        startActivity(new Intent(getActivity(), AddCategoryActivity.class));
    }

    @Override
    public void showCategories(ArrayList<String> categories) {
        RecyclerView recyclerView = binding.recyclerViewCategories;
        Log.d("test1", categories.toString());
        CAdapter adapter = new CAdapter(getContext(), categories, presenter);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public CategoryLoginJournal getData(String category) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(requireActivity());
        return new CategoryLoginJournal(category,sp.getString("login", ""), sp.getString("journalName", ""));
    }

    @Override
    public void showToastTest(String string) {
        Toast.makeText(getContext(), string, Toast.LENGTH_LONG).show();
    }

    @Override
    public void loadCategories() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(requireActivity());
        presenter.onLoad(sp.getString("journalName", ""));
    }

    @Override
    public void showToast(int code) {
        String s = String.valueOf(code);
        Toast.makeText(
                getContext(),
                s + " Ошибка",
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void showToastException(String e) {

    }
}