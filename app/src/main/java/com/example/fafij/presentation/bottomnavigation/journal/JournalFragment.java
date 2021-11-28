package com.example.fafij.presentation.bottomnavigation.journal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fafij.R;
import com.example.fafij.databinding.FragmentJournalBinding;
import com.example.fafij.models.data.Note;
import com.example.fafij.models.data.postbodies.NoteLoginJournal;
import com.example.fafij.presentation.addnote.AddNoteActivity;

import java.util.ArrayList;
import java.util.Objects;

public class JournalFragment extends Fragment implements JournalContract.JournalViewInterface {

    FragmentJournalBinding binding;
    JournalPresenter presenter;

    public JournalFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_journal, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        binding = FragmentJournalBinding.inflate(getLayoutInflater());
        presenter = new JournalPresenter(this);
        loadNotes();
        binding.addNoteButton.setOnClickListener(view -> goToAddNote());
    }

    @Override
    public void onResume() {
        super.onResume();
        loadNotes();
    }

    /**
     * Перенаправляет на экран добавления записи
     */
    public void goToAddNote() {
        startActivity(new Intent(getActivity(), AddNoteActivity.class));
    }


    /**
     * Перенаправляет на экран редактирования нажатой записи (int)
     */
    public void onEditClick() {

    }


    @Override
    public void showNotes(ArrayList<Note> notes) {
        RecyclerView recyclerView = binding.recyclerViewJournalNotes;
        JAdapter adapter = new JAdapter(getContext(), notes, presenter);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showToast(int code) {

    }

    @Override
    public void showToastException(String e) {

    }

    @Override
    public NoteLoginJournal getData(long idNote) {
        SharedPreferences sp = requireActivity()
                .getApplicationContext()
                .getSharedPreferences("mainStorage", Context.MODE_PRIVATE);
        return new NoteLoginJournal(idNote,sp.getString("login", ""), sp.getString("journalName", ""));
    }

    @Override
    public void loadNotes() {
        SharedPreferences sp = requireActivity()
                .getApplicationContext()
                .getSharedPreferences("mainStorage", Context.MODE_PRIVATE);
        presenter.onLoad(sp.getString("journalName", ""));
    }


}