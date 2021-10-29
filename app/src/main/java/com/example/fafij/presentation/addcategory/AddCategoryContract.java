package com.example.fafij.presentation.addcategory;

public interface AddCategoryContract {

    interface AddCategoryViewInterface {
        void returnToCategories();
    }

    interface AddCategoryPresenterInterface {
        void onAddCategory(String category);
    }

}
