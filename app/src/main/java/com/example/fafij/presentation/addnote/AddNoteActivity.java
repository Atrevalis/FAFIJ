package com.example.fafij.presentation.addnote;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.R;
import com.example.fafij.databinding.ActivityAddnoteBinding;
import com.example.fafij.models.data.postbodies.NoteLoginJournal;
import com.example.fafij.presentation.addjournal.AddJournalPresenter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

public class AddNoteActivity extends AppCompatActivity implements AddNoteContract.AddNoteViewInterface {


    AddNotePresenter presenter = new AddNotePresenter(this);
    ActivityAddnoteBinding binding;
    Calendar c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddnoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        binding.addNoteButton.setOnClickListener(view -> sendAddingNote());


    }

    public String getDate() {
        c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, second);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return format.format(cal.getTime());
    }

    public void sendAddingNote() {
        if (binding.categoryNameEdittext.getText().toString().equals("") && binding.noteSumEdittext.getText().toString().equals("")) {
            showToastException("Введите денежную сумму и категорию");
            return;
        }
        if (binding.categoryNameEdittext.getText().toString().equals("")) {
            showToastException("Введите категорию");
            return;
        }
        if (binding.noteSumEdittext.getText().toString().equals("")) {
            showToastException("Введите денежную сумму");
            return;
        }
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
        String toast = "";
        if (code == 500) toast = "Категория не найдена";
        Toast.makeText(
                this,
                toast,
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void showToastException(String e) {
        Toast.makeText(
                this,
                e,
                Toast.LENGTH_SHORT
        ).show();
    }

    @Override
    public void finishActivity() {
        finish();
    }
}