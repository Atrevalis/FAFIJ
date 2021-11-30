package com.example.fafij.presentation.bottomnavigation.categories;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fafij.R;



import java.util.ArrayList;

public class CAdapter extends RecyclerView.Adapter<CAdapter.HolderC> {

    private final LayoutInflater inflater;

    ArrayList<String> listOfElements;
    private final CategoriesPresenter presenter;

    CAdapter(Context context, ArrayList<String> listOfElements, CategoriesPresenter presenter) {
        this.listOfElements = listOfElements;
        this.inflater = LayoutInflater.from(context);
        this.presenter = presenter;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addElement(String element) {
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
    public HolderC onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_view_categories, parent, false);
        return new HolderC(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderC holder, int position) {
        String category = listOfElements.get(position);
        holder.textCategory.setText(category);
        holder.delete.setOnClickListener(view -> {
            presenter.onDeleteClick(category);
            deleteElement(position);
        });
    }

    @Override
    public int getItemCount() {
        return listOfElements.size();
    }

    protected static class HolderC extends RecyclerView.ViewHolder {
        TextView textCategory;
        Button delete;

        public HolderC(@NonNull View view) {
            super(view);
            textCategory = view.findViewById(R.id.category_name);
            delete = view.findViewById(R.id.category_delete_button);
        }
    }
}
