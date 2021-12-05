package com.example.fafij.presentation.inviteuser;

import androidx.annotation.NonNull;

import com.example.fafij.FafijApp;
import com.example.fafij.models.Network.RetrofitApiClient;
import com.example.fafij.models.data.postbodies.JournalLoginRoleAdmin;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InviteUserPresenter implements InviteUserContract.InviteUserPresenterInterface {

    public InviteUserContract.InviteUserViewInterface view;

    public InviteUserPresenter(InviteUserContract.InviteUserViewInterface view) {
        this.view = view;
    }

    @Override
    public void onInviteClick(String journalName, String login, boolean isAdult) {
        String role = isAdult ? "ADULT" : "KID";
        JournalLoginRoleAdmin journalLoginRoleAdmin = new JournalLoginRoleAdmin(journalName, login, role, view.getLogin());
        Call<Void> call = RetrofitApiClient.getClient().addUser(FafijApp.getToken(), journalLoginRoleAdmin);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(@NonNull Call<Void> call, @NonNull Response<Void> response) {
                view.showToast(response.code());
            }
            @Override
            public void onFailure(@NonNull Call<Void> call, @NonNull Throwable t) {
                view.showToastException(t.getLocalizedMessage());
            }
        });
    }
}
