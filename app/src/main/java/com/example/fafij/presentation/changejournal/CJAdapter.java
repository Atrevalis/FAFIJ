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
import com.example.fafij.models.JournalNameWithLogins;

import java.util.ArrayList;

public class CJAdapter extends RecyclerView.Adapter<CJAdapter.HolderCJ> {

    private final LayoutInflater inflater;
    ArrayList<JournalNameWithLogins> listOfElements;
    private final ChangeJournalPresenter presenter;

    CJAdapter(Context context, ArrayList<JournalNameWithLogins> listOfElements, ChangeJournalPresenter presenter) {
        this.listOfElements = listOfElements;
        this.inflater = LayoutInflater.from(context);
        this.presenter = presenter;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addElement(JournalNameWithLogins element) {
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
        JournalNameWithLogins journalNameWithLogins = listOfElements.get(position);
        holder.textViewName.setText(journalNameWithLogins.getJournalName());
        for (int i = 0; i < journalNameWithLogins.getLogins().size(); i++) {
            //holder.textViewLogins.uppend(journalNameWithLogins.getLogins().get(i));
        }
        holder.itemView.setOnClickListener(view -> presenter.onChangingClick(journalNameWithLogins.getJournalName()));
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
