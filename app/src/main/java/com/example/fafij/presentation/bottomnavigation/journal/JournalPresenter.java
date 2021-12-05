package com.example.fafij.presentation.bottomnavigation.journal;



import androidx.annotation.NonNull;

import com.example.fafij.models.Network.RetrofitApiClient;
import com.example.fafij.models.data.Category;
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
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                view.showToast(response.code());
                view.loadNotes();
            }
            @Override
            public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                view.showToastException(t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void onEditClick(long id, String date, long sum, String comment, Category category) {
        view.goToEditNote(id, date, sum, comment, category);
    }

    @Override
    public void onLoad(String journalName) {
        JournalName postJournalName = new JournalName(journalName);
        Call<ArrayList<Note>> call = RetrofitApiClient.getClient().listNote(postJournalName);
        call.enqueue(new Callback<ArrayList<Note>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Note>> call, @NonNull Response<ArrayList<Note>> response) {
                if (!response.isSuccessful()) {
                    view.showToast(response.code());
                }
                view.showNotes(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Note>> call, @NonNull Throwable t) {
                view.showToastException(t.getLocalizedMessage());
            }
        });
    }

}
