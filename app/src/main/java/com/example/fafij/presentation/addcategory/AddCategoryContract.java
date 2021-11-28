package com.example.fafij.presentation.addcategory;

import com.example.fafij.models.data.postbodies.CategoryLoginJournal;

public interface AddCategoryContract {

    interface AddCategoryViewInterface {
        void showToast(int code);
        void showToastException(String e);
    }

    interface AddCategoryPresenterInterface {
        void onAddCategory(CategoryLoginJournal categoryLoginJournal);
    }

}
