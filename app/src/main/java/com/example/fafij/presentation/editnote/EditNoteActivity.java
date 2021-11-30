package com.example.fafij.presentation.editnote;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.R;
import com.example.fafij.databinding.ActivityEditnoteBinding;
import com.example.fafij.databinding.ActivityInvitationsBinding;
import com.example.fafij.presentation.bottomnavigation.BottomNavigationActivity;

public class EditNoteActivity extends AppCompatActivity implements EditNoteContract.EditNoteViewInterface {

    EditNotePresenter presenter = new EditNotePresenter(this);
    ActivityEditnoteBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditnoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle bundle = getIntent().getExtras();
        binding.noteSumEdittext.setText(bundle.get("sum").toString());
        binding.categoryNameEdittext.setText(bundle.get("category").toString());
        binding.commentEdittext.setText(bundle.get("comment").toString());
        binding.editNoteButton.setOnClickListener(view -> {
            presenter.onSubmitClick(
                    bundle.getLong("id"),
                    bundle.get("date").toString(),
                    Long.parseLong(binding.noteSumEdittext.getText().toString()),
                    binding.categoryNameEdittext.getText().toString(),
                    binding.commentEdittext.getText().toString(),
                    bundle.get("journalName").toString()
                    );
        });

    }

    /**
     * Перенаправляет на экран QRCode
     */
    public void goToQRCode() {

    }

    /**
     * Возвращает на экран журнала
     */
    @Override
    public void returnToJournal() {
        startActivity(new Intent(this, BottomNavigationActivity.class));
    }

    @Override
    public void showToast(int code) {

    }

    @Override
    public void showToastException(String e) {

    }
}