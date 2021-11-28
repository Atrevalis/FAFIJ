package com.example.fafij.presentation.addcategory;

import com.example.fafij.models.Network.RetrofitApiClient;
import com.example.fafij.models.data.postbodies.CategoryLoginJournal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCategoryPresenter implements AddCategoryContract.AddCategoryPresenterInterface {

    public AddCategoryContract.AddCategoryViewInterface view;

    public AddCategoryPresenter(AddCategoryContract.AddCategoryViewInterface view) {
        this.view = view;
    }

    @Override
    public void onAddCategory(CategoryLoginJournal categoryLoginJournal) {
        Call<Void> call = RetrofitApiClient.getClient().addCategory(categoryLoginJournal);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                view.showToast(response.code());
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                view.showToastException(t.getLocalizedMessage());
            }
        });
    }
}
