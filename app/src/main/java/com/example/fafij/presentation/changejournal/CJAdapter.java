package com.example.fafij.presentation.changejournal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fafij.R;
import com.example.fafij.models.data.Journal;

import java.util.ArrayList;

public class CJAdapter extends RecyclerView.Adapter<CJAdapter.HolderCJ> {

    private final LayoutInflater inflater;
    ArrayList<Journal> listOfElements;
    private final ChangeJournalPresenter presenter;

    CJAdapter(Context context, ArrayList<Journal> listOfElements, ChangeJournalPresenter presenter) {
        this.listOfElements = listOfElements;
        this.inflater = LayoutInflater.from(context);
        this.presenter = presenter;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addElement(Journal element) {
        listOfElements.add(element);
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void clearElement() {
        listOfElements.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolderCJ onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_view_journal, parent, false);
        return new HolderCJ(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderCJ holder, int position) {
        Journal journal = listOfElements.get(position);
        holder.textViewName.setText(journal.getJournalName());
        StringBuilder logins = new StringBuilder();
        for (int i = 0; i < journal.getLogins().size(); i++) {
            logins.append(journal.getLogins().get(i).getLogin()).append(" ");
        }
        holder.textViewLogins.setText(logins);
        holder.itemView.setOnClickListener(view -> presenter.onChangingClick(journal.getJournalName()));
    }

    @Override
    public int getItemCount() {
        return listOfElements.size();
    }

    protected static class HolderCJ extends RecyclerView.ViewHolder {
        final TextView textViewName, textViewLogins;

        public HolderCJ(@NonNull View view) {
            super(view);
            textViewName = view.findViewById(R.id.journal_change_name);
            textViewLogins = view.findViewById(R.id.journal_change_logins);
        }
    }
}
