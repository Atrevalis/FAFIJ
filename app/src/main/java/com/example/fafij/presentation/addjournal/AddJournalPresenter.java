package com.example.fafij.presentation.addjournal;

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
        LoginJournal loginJournal = new LoginJournal(login, journalName);
        Call<Void> call = RetrofitApiClient.getClient().createJournal(loginJournal);
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
