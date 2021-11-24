package com.example.fafij.presentation.addcategory;

public interface AddCategoryContract {

    interface AddCategoryViewInterface {
        void returnToCategories();
        void showToastDuplicateError();
        void showToastConnectionError();
    }

    interface AddCategoryPresenterInterface {
        void onAddCategory(String category);
    }

}
