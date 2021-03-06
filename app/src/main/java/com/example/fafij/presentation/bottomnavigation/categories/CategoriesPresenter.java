package com.example.fafij.presentation.bottomnavigation.categories;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.fafij.FafijApp;
import com.example.fafij.models.Network.RetrofitApiClient;

import com.example.fafij.models.data.Category;
import com.example.fafij.models.data.postbodies.JournalName;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesPresenter implements CategoriesContract.CategoriesPresenterInterface {

    public CategoriesContract.CategoriesViewInterface view;

    public CategoriesPresenter(CategoriesContract.CategoriesViewInterface view) {
        this.view = view;
    }

    /**
     * Указывает модели какую категорию необходимо удалить из БД
     *
     * @param category название категории
     */
    @Override
    public void onDeleteClick(String category) {
        Call<Void> call = RetrofitApiClient.getClient().deleteCategory(FafijApp.getToken(), view.getData(category));
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                view.showToast(response.code());
                view.loadCategories();
            }

            @Override
            public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                view.showToastException(t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void onLoad(String journalName) {
        JournalName postJournalName = new JournalName(journalName);
        Call<ArrayList<Category>> call = RetrofitApiClient.getClient().listCategory(FafijApp.getToken(), postJournalName);
        call.enqueue(new Callback<ArrayList<Category>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Category>> call, @NonNull Response<ArrayList<Category>> response) {
                if (!response.isSuccessful()) {
                    view.showToast(response.code());
                } else view.showCategories(response.body());
            }
            @Override
            public void onFailure(@NonNull Call<ArrayList<Category>> call, @NonNull Throwable t) {
                view.showToastException(t.getLocalizedMessage());
            }
        });
    }
}
