package com.example.fafij.presentation.addcategory;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.R;
import com.example.fafij.databinding.ActivityAddcategoryBinding;
import com.example.fafij.databinding.ActivityAddjournalBinding;
import com.example.fafij.models.data.postbodies.CategoryLoginJournal;
import com.example.fafij.presentation.addjournal.AddJournalPresenter;

import java.util.Objects;

public class AddCategoryActivity extends AppCompatActivity implements AddCategoryContract.AddCategoryViewInterface {

    ActivityAddcategoryBinding binding;
    AddCategoryPresenter presenter = new AddCategoryPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddcategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        binding.addCategoryButton.setOnClickListener(view -> sendAddingCategoryName());

    }


    public void sendAddingCategoryName() {
        if (binding.addCategoryEdittext.getText().toString().equals("")) {
            showToastException("Введите название категории");
            return;
        }
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        presenter.onAddCategory(new CategoryLoginJournal(binding.addCategoryEdittext.getText().toString()
                , sp.getString("login", ""), sp.getString("journalName", "")));
    }

    @Override
    public void showToast(int code) {
        String toast = "";
        if (code == 406) toast = "Недостаточно прав";
        if (code == 409) toast = "Категория уже существует";
        Toast.makeText(
                this,
                toast,
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void showToastException(String e) {
        Toast.makeText(
                this,
                e,
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void finishActivity() {
        finish();
    }
}