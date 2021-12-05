package com.example.fafij.presentation.changejournal;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.fafij.models.Network.RetrofitApiClient;
import com.example.fafij.models.data.Journal;
import com.example.fafij.models.data.Login;
import com.example.fafij.models.data.postbodies.LoginJournal;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangeJournalPresenter implements ChangeJournalContract.ChangeJournalPresenterInterface {

    public ChangeJournalContract.ChangeJournalViewInterface view;

    public ChangeJournalPresenter(ChangeJournalContract.ChangeJournalViewInterface view) {
        this.view = view;
    }

    /**
     * Получает данные по выбранному журналу, инициализирует журнал в системе как действующий,
     * указывает View перейти на экран журнала.
     *
     * @param journalName название журнала, на который пользователь нажал
     */
    @Override
    public void onChangingClick(String journalName) {
        view.saveData(journalName);
        view.getRole();
    }

    /**
     * Получает данные о доступных пользователю журналах из модели
     * полученный список передаёт в метод showJournalsList в View
     *
     * @param login логин пользователя
     */
    @Override
    public void onLoad(String login) {
        Login postLogin = new Login(login);
        Call<ArrayList<Journal>> call = RetrofitApiClient.getClient().userJournals(postLogin);
        call.enqueue(new Callback<ArrayList<Journal>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Journal>> call, @NonNull Response<ArrayList<Journal>> response) {
                if (!response.isSuccessful()) {
                    view.showToastError(response.code());
                } else view.showJournalsList(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Journal>> call, @NonNull Throwable t) {
                view.showToastException(t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void onLoadingView(String login, String journalName) {
        Log.e("test", login + " " + journalName);
        LoginJournal loginJournal = new LoginJournal(login, journalName);
        Call<Long> call = RetrofitApiClient.getClient().userRole(loginJournal);
        call.enqueue(new Callback<Long>() {
            @Override
            public void onResponse(@NonNull Call<Long> call, @NonNull Response<Long> response) {
                if (response.body() == null) Log.e("test", "NULLNULLNULL");

                view.saveIdRole(response.body());
                view.goToBottomViewNavigation();
            }

            @Override
            public void onFailure(@NonNull Call<Long> call, @NonNull Throwable t) {
                view.showToastException(t.getLocalizedMessage());
            }
        });
    }
}

