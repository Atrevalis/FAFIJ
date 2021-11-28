package com.example.fafij.models.Network;

import com.example.fafij.models.data.Category;
import com.example.fafij.models.data.Invitation;
import com.example.fafij.models.data.Journal;
import com.example.fafij.models.data.Login;
import com.example.fafij.models.data.Note;
import com.example.fafij.models.data.postbodies.CategoryLoginJournal;
import com.example.fafij.models.data.postbodies.JournalLoginRole;
import com.example.fafij.models.data.postbodies.JournalName;
import com.example.fafij.models.data.postbodies.LoginPass;
import com.example.fafij.models.data.TokenCatch;
import com.example.fafij.models.data.postbodies.LoginJournal;
import com.example.fafij.models.data.postbodies.NoteLoginJournal;
import com.example.fafij.models.data.postbodies.NotePost;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface RetrofitApiInterface {

    @POST("login")
    Call<TokenCatch> login(@Body LoginPass loginPass);

    @POST("registration")
    Call<Void> registration(@Body LoginPass loginPass);

    @GET("private/userJournals")
    Call<ArrayList<Journal>> userJournals(@Body Login login);

    @POST("private/createJournal")
    Call<Void> createJournal(@Body LoginJournal loginJournal);

    @GET("private/listNote")
    Call<ArrayList<Note>> listNote(@Body JournalName journalName);

    @POST("private/deleteNote")
    Call<Void> deleteNote(@Body NoteLoginJournal noteLoginJournal);

    @POST("private/addNote")
    Call<Void> addNote(@Body NotePost notePost);

    @GET("private/listCategory")
    Call<ArrayList<Category>> listCategory(@Body JournalName journalName);

    @POST("private/addCategory")
    Call<Void> addCategory(@Body CategoryLoginJournal categoryLoginJournal);

    @POST("private/deleteCategory")
    Call<Void> deleteCategory(@Body CategoryLoginJournal categoryLoginJournal);

    @POST("private/addUser")
    Call<Void> addUser(@Body JournalLoginRole journalLoginRole);

    @GET("private/userInvitation")
    Call<ArrayList<Invitation>> userInvitation(@Body Login login);

}
