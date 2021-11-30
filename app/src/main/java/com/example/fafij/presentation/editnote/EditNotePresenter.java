package com.example.fafij.presentation.editnote;

import androidx.annotation.NonNull;

import com.example.fafij.models.Network.RetrofitApiClient;
import com.example.fafij.models.data.postbodies.NoteEdit;
import com.example.fafij.models.data.postbodies.NotePost;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditNotePresenter implements EditNoteContract.EditNotePresenterInterface {

    public EditNoteContract.EditNoteViewInterface view;

    public EditNotePresenter(EditNoteContract.EditNoteViewInterface view) {
        this.view = view;
    }



    @Override
    public void onSubmitClick(long id, String date, long sum, String category, String comment, String journalName) {
        NoteEdit noteEdit = new NoteEdit(id, date, sum, category, comment, journalName);
        Call<Void> call = RetrofitApiClient.getClient().updateNote(noteEdit);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                view.showToast(response.code());
                if (response.isSuccessful()) view.returnToJournal();
            }

            @Override
            public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                view.showToastException(t.getLocalizedMessage());
            }
        });
    }
}
