package com.example.fafij.presentation.bottomnavigation.journal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fafij.R;
import com.example.fafij.models.data.Note;

import java.util.ArrayList;

public class JAdapter extends RecyclerView.Adapter<JAdapter.HolderJ> {

    private final LayoutInflater inflater;

    ArrayList<Note> listOfElements;
    private final JournalPresenter presenter;

    JAdapter(Context context, ArrayList<Note> listOfElements, JournalPresenter presenter) {
        this.listOfElements = listOfElements;
        this.inflater = LayoutInflater.from(context);
        this.presenter = presenter;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addElement(Note element) {
        listOfElements.add(element);
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void deleteElement(int position) {
        listOfElements.remove(position);
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void clearElement() {
        listOfElements.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolderJ onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_view_journal_note, parent, false);
        return new HolderJ(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull HolderJ holder, int position) {
        Note note = listOfElements.get(position);
        holder.textId.setText(Long.toString(note.getId()));
        holder.textDate.setText(note.getDate());
        holder.textSum.setText(Long.toString(note.getSum()));
        if (note.getSum() > 0L) {
            holder.textSum.setTextColor(Color.parseColor("#00ff00"));
        }
        else if (note.getSum() < 0L) holder.textSum.setTextColor(Color.parseColor("#ff0000"));
        holder.textCategory.setText(note.getCategory().getName());
        holder.textComment.setText(note.getComment());
        holder.delete.setOnClickListener(view -> {
            presenter.onDeleteClick(note.getId());
            deleteElement(position);
        });
        holder.edit.setOnClickListener(view -> {
            presenter.onEditClick(note.getId(), note.getDate(), note.getSum(), note.getComment(), note.getCategory());
        });
    }

    @Override
    public int getItemCount() {
        return listOfElements.size();
    }

    protected static class HolderJ extends RecyclerView.ViewHolder {
        TextView textId, textDate, textSum, textCategory, textComment;
        Button edit, delete;

        public HolderJ(@NonNull View view) {
            super(view);
            textId = view.findViewById(R.id.id_note);
            textDate = view.findViewById(R.id.date_note);
            textSum = view.findViewById(R.id.sum);
            textCategory = view.findViewById(R.id.note_category_name);
            textComment = view.findViewById(R.id.comment);
            edit = view.findViewById(R.id.note_edit_button);
            delete = view.findViewById(R.id.note_delete_button);
        }
    }
}
