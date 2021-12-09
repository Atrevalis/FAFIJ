package com.example.fafij.presentation.bottomnavigation.journal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fafij.R;
import com.example.fafij.databinding.FragmentJournalBinding;
import com.example.fafij.models.data.Category;
import com.example.fafij.models.data.Note;
import com.example.fafij.models.data.postbodies.NoteLoginJournal;
import com.example.fafij.presentation.addnote.AddNoteActivity;
import com.example.fafij.presentation.editnote.EditNoteActivity;

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
        binding = FragmentJournalBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.addNoteButton.setOnClickListener(view -> goToAddNote());
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadNotes();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter = new JournalPresenter(this);
        loadNotes();
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



    @Override
    public void showNotes(ArrayList<Note> notes) {
        RecyclerView recyclerView = binding.recyclerViewJournalNotes;
        JAdapter adapter = new JAdapter(getContext(), notes, presenter);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showToast(int code) {
        String toast = "";
        if (code == 406) toast = "Недостаточно прав";
        if (code == 201) toast = "Запись удалена";
        Toast.makeText(
                getContext(),
                toast,
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void showToastException(String e) {
        Toast.makeText(
                requireActivity(),
                e,
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public NoteLoginJournal getData(long idNote) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(requireActivity());
        return new NoteLoginJournal(idNote,sp.getString("login", ""), sp.getString("journalName", ""));
    }

    @Override
    public void loadNotes() {
        presenter = new JournalPresenter(this);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(requireActivity());
        presenter.onLoad(sp.getString("journalName", ""));
    }

    @Override
    public void goToEditNote(long id, String date, long sum, String comment, Category category) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(requireActivity());
        Intent intent = new Intent(getActivity(), EditNoteActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("date", date);
        intent.putExtra("sum", sum);
        intent.putExtra("comment", comment);
        intent.putExtra("category", category.getName());
        intent.putExtra("login", sp.getString("login", ""));
        startActivity(intent);
    }


}