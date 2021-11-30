package com.example.fafij.presentation.bottomnavigation.categories;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.fafij.models.Network.RetrofitApiClient;

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
        Call<Void> call = RetrofitApiClient.getClient().deleteCategory(view.getData(category));
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                if (!response.isSuccessful()) {
                    view.showToast(response.code());
                } else {
                    view.showToast(response.code());
                    view.loadCategories();
                }
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
        Call<ArrayList<String>> call = RetrofitApiClient.getClient().listCategory(postJournalName);
        call.enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<String>> call, @NonNull Response<ArrayList<String>> response) {
                if (!response.isSuccessful()) {
                    view.showToast(response.code());
                } else view.showCategories(response.body());
            }
            @Override
            public void onFailure(@NonNull Call<ArrayList<String>> call, @NonNull Throwable t) {
                view.showToastException(t.getLocalizedMessage());
                Log.d("test1", t.getLocalizedMessage());
            }
        });
    }
}
