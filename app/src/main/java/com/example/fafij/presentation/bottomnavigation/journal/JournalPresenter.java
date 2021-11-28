package com.example.fafij.presentation.bottomnavigation.journal;



import com.example.fafij.models.Network.RetrofitApiClient;
import com.example.fafij.models.data.Journal;
import com.example.fafij.models.data.Note;
import com.example.fafij.models.data.postbodies.JournalName;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JournalPresenter implements JournalContract.JournalPresenterInterface {

    public JournalContract.JournalViewInterface view;
    public Journal model;

    public JournalPresenter(JournalContract.JournalViewInterface view) {
        this.view = view;
        this.model = new Journal();
    }

    /**
     * Указывает модели на необходимость удалить запись из журнала в БД,
     * вызывает метод refreshData в View
     * @param id идентификатор записи
     */
    @Override
    public void onDeleteClick(long id) {
        Call<Void> call = RetrofitApiClient.getClient().deleteNote(view.getData(id));
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (!response.isSuccessful()) {
                    view.showToast(response.code());
                } else {
                    view.showToast(response.code());
                    view.loadNotes();
                }

            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                view.showToastException(t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void onLoad(String journalName) {
        JournalName postJournalName = new JournalName(journalName);
        Call<ArrayList<Note>> call = RetrofitApiClient.getClient().listNote(postJournalName);
        call.enqueue(new Callback<ArrayList<Note>>() {
            @Override
            public void onResponse(Call<ArrayList<Note>> call, Response<ArrayList<Note>> response) {
                if (!response.isSuccessful()) {
                    view.showToast(response.code());
                } else view.showNotes(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Note>> call, Throwable t) {
                view.showToastException(t.getLocalizedMessage());
            }
        });
    }

}
