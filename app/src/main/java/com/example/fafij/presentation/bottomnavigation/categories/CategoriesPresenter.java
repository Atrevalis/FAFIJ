package com.example.fafij.presentation.bottomnavigation.categories;

public class CategoriesPresenter implements CategoriesContract.CategoriesPresenterInterface {

    public CategoriesContract.CategoriesViewInterface view;

    public CategoriesPresenter(CategoriesContract.CategoriesViewInterface view) {
        this.view = view;
    }

    /**
     * Указывает модели какую категорию необходимо удалить из БД
     * @param id идентификатор категории
     */
    @Override
    public void onDelete(int id) {

    }
}
