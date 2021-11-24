package com.example.fafij.presentation.addcategory;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.R;
import com.example.fafij.databinding.ActivityAddcategoryBinding;
import com.example.fafij.databinding.ActivityAddjournalBinding;
import com.example.fafij.presentation.addjournal.AddJournalPresenter;

public class AddCategoryActivity extends AppCompatActivity implements AddCategoryContract.AddCategoryViewInterface {

    ActivityAddcategoryBinding binding;
    AddCategoryPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddcategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AddCategoryPresenter presenter = new AddCategoryPresenter(this);
        presenter.onAddCategory(binding.addCategoryEdittext.getText().toString());
    }

    /**
     * Возвращает на экран категорий (deprecated)
     */
    @Override
    public void returnToCategories() {

    }

    @Override
    public void showToastDuplicateError() {

    }

    @Override
    public void showToastConnectionError() {

    }

    public void sendAddingCategoryName(View view) {
    }
}