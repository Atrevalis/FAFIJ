package com.example.fafij.presentation.bottomnavigation.categories;

import com.example.fafij.models.data.CategoriesList;

public interface CategoriesContract {

    interface CategoriesViewInterface {
        void showCategories(CategoriesList categoriesList);
    }

    interface CategoriesPresenterInterface {
        void onDeleteClick(String category);
        void onLoad(String login);
    }

}
