package com.example.fafij.presentation.addnote;

import androidx.annotation.NonNull;

import com.example.fafij.models.Network.RetrofitApiClient;
import com.example.fafij.models.data.postbodies.LoginJournal;
import com.example.fafij.models.data.postbodies.NotePost;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddNotePresenter implements AddNoteContract.AddNotePresenterInterface {

    public AddNoteContract.AddNoteViewInterface view;

    public AddNotePresenter(AddNoteContract.AddNoteViewInterface view) {
        this.view = view;
    }



    @Override
    public void onAddClick(String date, long sum, String category, String comment, String journalName) {
        NotePost notePost = new NotePost(date, sum, category, comment, journalName);
        Call<Void> call = RetrofitApiClient.getClient().addNote(notePost);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                if (response.isSuccessful()) {
                    view.finishActivity();
                }
                view.showToast(response.code());
            }

            @Override
            public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                view.showToastException(t.getLocalizedMessage());
            }
        });
    }
}
