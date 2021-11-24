package com.example.fafij.presentation.invitations;

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
import com.example.fafij.models.data.Invitation;


import java.util.ArrayList;

public class IAdapter extends RecyclerView.Adapter<IAdapter.HolderI> {

    private final LayoutInflater inflater;

    ArrayList<Invitation> listOfElements;
    private final InvitationsPresenter presenter;

    IAdapter(Context context, ArrayList<Invitation> listOfElements, InvitationsPresenter presenter) {
        this.listOfElements = listOfElements;
        this.inflater = LayoutInflater.from(context);
        this.presenter = presenter;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void addElement(Invitation element) {
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
    public HolderI onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_view_invitations, parent, false);
        return new HolderI(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderI holder, int position) {
        Invitation invitation = listOfElements.get(position);
        holder.textViewName.setText(invitation.getJournalName());
        for (int i = 0; i < invitation.getLogins().size(); i++) {
            //holder.textViewLogins.uppend(invitation.getLogins().get(i));
        }
        holder.textViewRole.setText(invitation.getRole());
        holder.accept.setOnClickListener(view -> {
            presenter.onAcceptClick(invitation.getJournalName());
            deleteElement(position);
        });
        holder.refuse.setOnClickListener(view -> {
            presenter.onRefuseClick(invitation.getJournalName());
            deleteElement(position);
        });
    }

    @Override
    public int getItemCount() {
        return listOfElements.size();
    }

    protected static class HolderI extends RecyclerView.ViewHolder {
        TextView textViewName, textViewLogins, textViewRole;
        Button accept, refuse;

        public HolderI(@NonNull View view) {
            super(view);
            textViewName = view.findViewById(R.id.invitations_name);
            textViewLogins = view.findViewById(R.id.invitations_logins);
            textViewRole = view.findViewById(R.id.invitations_role);
            refuse = view.findViewById(R.id.refuse_button);
            accept = view.findViewById(R.id.accept_button);
        }
    }
}
