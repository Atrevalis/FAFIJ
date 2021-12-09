package com.example.fafij.models.Network;


import com.example.fafij.models.data.Invitation;
import com.example.fafij.models.data.Journal;
import com.example.fafij.models.data.Login;
import com.example.fafij.models.data.Note;
import com.example.fafij.models.data.postbodies.BitMatrixBody;
import com.example.fafij.models.data.postbodies.CategoryLoginJournal;
import com.example.fafij.models.data.postbodies.JournalLoginRoleAdmin;
import com.example.fafij.models.data.postbodies.JournalName;
import com.example.fafij.models.data.postbodies.LoginPass;
import com.example.fafij.models.data.TokenCatch;
import com.example.fafij.models.data.postbodies.LoginJournal;
import com.example.fafij.models.data.postbodies.NoteEdit;
import com.example.fafij.models.data.postbodies.NoteLoginJournal;
import com.example.fafij.models.data.postbodies.NotePost;

import com.google.zxing.common.BitMatrix;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface RetrofitApiInterface {

    @POST("login")
    Call<TokenCatch> login(@Body LoginPass loginPass);

    @POST("registration")
    Call<Void> registration(@Body LoginPass loginPass);

    @POST("private/userJournals")
    Call<ArrayList<Journal>> userJournals(@Header("Authorization") String token, @Body Login login);

    @POST("private/createJournal")
    Call<Void> createJournal(@Header("Authorization") String token, @Body LoginJournal loginJournal);

    @POST("private/listNote")
    Call<ArrayList<Note>> listNote(@Header("Authorization") String token, @Body JournalName journalName);

    @POST("private/deleteNote")
    Call<Void> deleteNote(@Header("Authorization") String token, @Body NoteLoginJournal noteLoginJournal);

    @POST("private/addNote")
    Call<Void> addNote(@Header("Authorization") String token, @Body NotePost notePost);

    @POST("private/listCategory")
    Call<ArrayList<String>> listCategory(@Header("Authorization") String token, @Body JournalName journalName);

    @POST("private/addCategory")
    Call<Void> addCategory(@Header("Authorization") String token, @Body CategoryLoginJournal categoryLoginJournal);

    @POST("private/deleteCategory")
    Call<Void> deleteCategory(@Header("Authorization") String token, @Body CategoryLoginJournal categoryLoginJournal);

    @POST("private/addUser")
    Call<Void> addUser(@Header("Authorization") String token, @Body JournalLoginRoleAdmin journalLoginRoleAdmin);

    @POST("private/invitations")
    Call<ArrayList<Invitation>> userInvitation(@Header("Authorization") String token, @Body Login login);

    @POST("private/accept")
    Call<Void> accept(@Header("Authorization") String token, @Body LoginJournal loginJournal);

    @POST("private/decline")
    Call<Void> decline(@Header("Authorization") String token, @Body LoginJournal loginJournal);

    @POST("private/updateNote")
    Call<Void> updateNote(@Header("Authorization") String token, @Body NoteEdit noteEdit);

    @POST("private/userRole")
    Call<Long> userRole(@Header("Authorization") String token, @Body LoginJournal loginJournal);


}
