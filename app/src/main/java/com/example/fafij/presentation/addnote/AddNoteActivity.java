package com.example.fafij.presentation.addnote;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.R;
import com.example.fafij.databinding.ActivityAddnoteBinding;
import com.example.fafij.models.data.postbodies.NoteLoginJournal;
import com.example.fafij.presentation.addjournal.AddJournalPresenter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddNoteActivity extends AppCompatActivity implements AddNoteContract.AddNoteViewInterface {


    AddNotePresenter presenter = new AddNotePresenter(this);
    ActivityAddnoteBinding binding;
    Calendar c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddnoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.addNoteButton.setOnClickListener(view -> sendAddingNote());


    }

    public String getDate() {
        c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR, hour);
        cal.set(Calendar.MINUTE, minute);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        return format.format(cal.getTime());
    }

    public void sendAddingNote() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        presenter.onAddClick(
                getDate(),
                Long.parseLong(binding.noteSumEdittext.getText().toString()),
                binding.categoryNameEdittext.getText().toString(),
                binding.commentEdittext.getText().toString(),
                sp.getString("journalName", "")
        );
    }

    /**
     * Перенаправляет на экран QRCode
     */
    public void goToQRCode() {

    }


    @Override
    public void showToast(int code) {

    }

    @Override
    public void showToastException(String e) {

    }
}