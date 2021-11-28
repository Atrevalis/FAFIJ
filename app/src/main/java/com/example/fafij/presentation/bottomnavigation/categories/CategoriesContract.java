package com.example.fafij.presentation.bottomnavigation.categories;


import com.example.fafij.models.data.Category;
import com.example.fafij.models.data.postbodies.CategoryLoginJournal;

import java.util.ArrayList;

public interface CategoriesContract {

    interface CategoriesViewInterface {
        void showCategories(ArrayList<Category> categories);
        void showToast(int code);
        void showToastException(String e);
        void loadCategories();
        CategoryLoginJournal getData(String category);
    }

    interface CategoriesPresenterInterface {
        void onDeleteClick(String category);
        void onLoad(String login);
    }

}
