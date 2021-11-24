package com.example.fafij.presentation.bottomnavigation.journal;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fafij.R;
import com.example.fafij.databinding.FragmentJournalBinding;
import com.example.fafij.models.data.NotesList;
import com.example.fafij.presentation.addnote.AddNoteActivity;

public class JournalFragment extends Fragment implements JournalContract.JournalViewInterface {

    FragmentJournalBinding binding;
    JournalPresenter presenter;

    public JournalFragment() { }

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
        presenter.onLoad("логин(затычка)",0);//id journal тоже затычка
        binding.addNoteButton.setOnClickListener(view -> goToAddNote());
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
    public void showNotes(NotesList notesList) {
        RecyclerView recyclerView = binding.recyclerViewJournalNotes;
        JAdapter adapter = new JAdapter(getContext(), notesList.getNotesList(), presenter);
        recyclerView.setAdapter(adapter);
    }

    /**
     * Отображает тост "Отсутствует подключение к интернету" (ext)
     */
    @Override
    public void showToastConnectionError() {

    }


}