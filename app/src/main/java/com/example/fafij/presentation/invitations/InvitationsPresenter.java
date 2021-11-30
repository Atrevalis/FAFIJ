package com.example.fafij.presentation.invitations;

import androidx.annotation.NonNull;

import com.example.fafij.models.Network.RetrofitApiClient;
import com.example.fafij.models.data.Invitation;
import com.example.fafij.models.data.Login;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InvitationsPresenter implements InvitationsContract.InvitationsPresenterInterface {

    public InvitationsContract.InvitationsViewInterface view;

    public InvitationsPresenter(InvitationsContract.InvitationsViewInterface view) {
        this.view = view;
    }

    @Override
    public void onAcceptClick(String journalName) {
        Call<Void> call = RetrofitApiClient.getClient().accept(view.getData(journalName));
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

    @Override
    public void onRefuseClick(String journalName) {
        Call<Void> call = RetrofitApiClient.getClient().decline(view.getData(journalName));
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

    @Override
    public void onLoad(String login) {
        Login postLogin = new Login(login);
        Call<ArrayList<Invitation>> call = RetrofitApiClient.getClient().userInvitation(postLogin);
        call.enqueue(new Callback<ArrayList<Invitation>>() {
            @Override
            public void onResponse(Call<ArrayList<Invitation>> call, Response<ArrayList<Invitation>> response) {
                if (!response.isSuccessful()) {
                    view.showToast(response.code());
                } else {
                    view.showToast(response.code());
                    view.showInvitations(response.body());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Invitation>> call, Throwable t) {

            }
        });
    }
}
