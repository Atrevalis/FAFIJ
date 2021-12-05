package com.example.fafij.presentation.addjournal;

import androidx.annotation.NonNull;

import com.example.fafij.FafijApp;
import com.example.fafij.models.Network.RetrofitApiClient;
import com.example.fafij.models.data.postbodies.LoginJournal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddJournalPresenter implements AddJournalContract.AddJournalPresenterInterface {

    public AddJournalContract.AddJournalViewInterface view;

    public AddJournalPresenter(AddJournalContract.AddJournalViewInterface view) {
        this.view = view;
    }

    /**
     * Передаёт модели указания на создание записи в БД о новом журнале,
     * возвращает пользрователя на экран выбора журнала.
     * @param journalName название журнала, которое задал пользователь
     */
    @Override
    public void onAddJournalClick(String login, String journalName) {
        if (journalName.equals("")) {
            view.showToastException("Введите название журнала");
            return;
        }
        LoginJournal loginJournal = new LoginJournal(login, journalName);
        Call<Void> call = RetrofitApiClient.getClient().createJournal(FafijApp.getToken(), loginJournal);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                if (!response.isSuccessful()) view.showToast(response.code());
                else view.returnToChange();
            }

            @Override
            public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                view.showToastException(t.getLocalizedMessage());
            }
        });
    }
}
