package com.example.fafij.presentation.bottomnavigation.categories;

public class CategoriesPresenter implements CategoriesContract.CategoriesPresenterInterface {

    public CategoriesContract.CategoriesViewInterface view;

    public CategoriesPresenter(CategoriesContract.CategoriesViewInterface view) {
        this.view = view;
    }

    /**
     * Указывает модели какую категорию необходимо удалить из БД
     * @param category название категории
     */
    @Override
    public void onDeleteClick(String category) {

    }

    @Override
    public void onLoad(String login) {

    }
}
