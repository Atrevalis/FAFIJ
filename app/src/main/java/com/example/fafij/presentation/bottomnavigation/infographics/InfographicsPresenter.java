package com.example.fafij.presentation.bottomnavigation.infographics;

import androidx.annotation.NonNull;

import com.example.fafij.FafijApp;
import com.example.fafij.models.Network.RetrofitApiClient;
import com.example.fafij.models.data.Note;
import com.example.fafij.models.data.postbodies.JournalName;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfographicsPresenter implements InfographicsContract.InfographicsPresenterInterface {

    public InfographicsContract.InfographicsViewInterface view;

    public InfographicsPresenter(InfographicsContract.InfographicsViewInterface view) {
        this.view = view;
    }

    @Override
    public void onLoad(String journalName) {
        JournalName postJournalName = new JournalName(journalName);
        Call<ArrayList<Note>> call = RetrofitApiClient.getClient().listNote(FafijApp.getToken(), postJournalName);
        call.enqueue(new Callback<ArrayList<Note>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Note>> call, @NonNull Response<ArrayList<Note>> response) {
                view.showPieChart(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<ArrayList<Note>> call, @NonNull Throwable t) {
                view.showToastException(t.getLocalizedMessage());
            }
        });
    }
}
