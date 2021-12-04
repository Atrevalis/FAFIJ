package com.example.fafij.models.Network;


import com.example.fafij.models.data.Invitation;
import com.example.fafij.models.data.Journal;
import com.example.fafij.models.data.Login;
import com.example.fafij.models.data.Note;
import com.example.fafij.models.data.postbodies.CategoryLoginJournal;
import com.example.fafij.models.data.postbodies.JournalLoginRoleAdmin;
import com.example.fafij.models.data.postbodies.JournalName;
import com.example.fafij.models.data.postbodies.LoginPass;
import com.example.fafij.models.data.TokenCatch;
import com.example.fafij.models.data.postbodies.LoginJournal;
import com.example.fafij.models.data.postbodies.NoteEdit;
import com.example.fafij.models.data.postbodies.NoteLoginJournal;
import com.example.fafij.models.data.postbodies.NotePost;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface RetrofitApiInterface {

    @POST("login")
    Call<TokenCatch> login(@Body LoginPass loginPass);

    @POST("registration")
    Call<Void> registration(@Body LoginPass loginPass);

    @POST("private/userJournals")
    Call<ArrayList<Journal>> userJournals(@Body Login login);

    @POST("private/createJournal")
    Call<Void> createJournal(@Body LoginJournal loginJournal);

    @POST("private/listNote")
    Call<ArrayList<Note>> listNote(@Body JournalName journalName);

    @POST("private/deleteNote")
    Call<Void> deleteNote(@Body NoteLoginJournal noteLoginJournal);

    @POST("private/addNote")
    Call<Void> addNote(@Body NotePost notePost);

    @POST("private/listCategory")
    Call<ArrayList<String>> listCategory(@Body JournalName journalName);

    @POST("private/addCategory")
    Call<Void> addCategory(@Body CategoryLoginJournal categoryLoginJournal);

    @POST("private/deleteCategory")
    Call<Void> deleteCategory(@Body CategoryLoginJournal categoryLoginJournal);

    @POST("private/addUser")
    Call<Void> addUser(@Body JournalLoginRoleAdmin journalLoginRoleAdmin);

    @POST("private/invitations")
    Call<ArrayList<Invitation>> userInvitation(@Body Login login);

    @POST("private/accept")
    Call<Void> accept(@Body LoginJournal loginJournal);

    @POST("private/decline")
    Call<Void> decline(@Body LoginJournal loginJournal);

    @POST("private/updateNote")
    Call<Void> updateNote(@Body NoteEdit noteEdit);

    @POST("private/userRole")
    Call<Long> userRole(@Body LoginJournal loginJournal);

}
