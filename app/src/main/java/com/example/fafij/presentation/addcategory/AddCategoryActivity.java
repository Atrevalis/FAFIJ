package com.example.fafij.presentation.addcategory;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.R;
import com.example.fafij.databinding.ActivityAddcategoryBinding;
import com.example.fafij.databinding.ActivityAddjournalBinding;
import com.example.fafij.models.data.postbodies.CategoryLoginJournal;
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
        binding.addCategoryButton.setOnClickListener(view -> sendAddingCategoryName());

    }


    public void sendAddingCategoryName() {

        SharedPreferences sp = getSharedPreferences("mainStorage", Context.MODE_PRIVATE);
        presenter.onAddCategory(new CategoryLoginJournal(binding.addCategoryEdittext.getText().toString()
                , sp.getString("login", ""), sp.getString("journalName", "")));
    }

    @Override
    public void showToast(int code) {

    }

    @Override
    public void showToastException(String e) {

    }
}