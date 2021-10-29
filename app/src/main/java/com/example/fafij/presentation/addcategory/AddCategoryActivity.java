package com.example.fafij.presentation.addcategory;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.R;

public class AddCategoryActivity extends AppCompatActivity implements AddCategoryContract.AddCategoryViewInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AddCategoryPresenter presenter = new AddCategoryPresenter(this);
    }

    /**
     * Возвращает на экран категорий
     */
    @Override
    public void returnToCategories() {

    }
}