package com.example.fafij.presentation.addcategory;

public class AddCategoryPresenter implements AddCategoryContract.AddCategoryPresenterInterface {

    public AddCategoryContract.AddCategoryViewInterface view;

    public AddCategoryPresenter(AddCategoryContract.AddCategoryViewInterface view) {
        this.view = view;
    }

    /**
     * Передаёт модели название категории для добавления в БД
     * @param category название категории
     */
    @Override
    public void onAddCategory(String category) {

    }
}
