package com.example.fafij.presentation.addcategory;

import androidx.annotation.NonNull;

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
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                if (!response.isSuccessful())view.showToast(response.code());
                else view.finishActivity();
            }
            @Override
            public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                view.showToastException(t.getLocalizedMessage());
            }
        });
    }
}
