package com.example.fafij.presentation.inviteuser;

import com.example.fafij.models.Network.RetrofitApiClient;
import com.example.fafij.models.data.postbodies.JournalLoginRole;

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
        String role = isAdult ? "Adult" : "Kid";
        JournalLoginRole journalLoginRole = new JournalLoginRole(journalName, login, role);
        Call<Void> call = RetrofitApiClient.getClient().addUser(journalLoginRole);
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
