package com.example.fafij.presentation.editnote;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.R;
import com.example.fafij.databinding.ActivityEditnoteBinding;
import com.example.fafij.databinding.ActivityInvitationsBinding;
import com.example.fafij.presentation.bottomnavigation.BottomNavigationActivity;

import java.util.Objects;

public class EditNoteActivity extends AppCompatActivity implements EditNoteContract.EditNoteViewInterface {

    EditNotePresenter presenter = new EditNotePresenter(this);
    ActivityEditnoteBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditnoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(false);
        Bundle bundle = getIntent().getExtras();
        binding.noteSumEdittext.setText(bundle.get("sum").toString());
        binding.categoryNameEdittext.setText(bundle.get("category").toString());
        binding.commentEdittext.setText(bundle.get("comment").toString());
        binding.editNoteButton.setOnClickListener(view -> {
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
            try {
                Long.parseLong(binding.noteSumEdittext.getText().toString());
            } catch (Exception e) {
                showToastException("Недействительное значение денежной суммы");
                return;
            }
            presenter.onSubmitClick(
                    bundle.getLong("id"),
                    bundle.get("date").toString(),
                    Long.parseLong(binding.noteSumEdittext.getText().toString()),
                    binding.categoryNameEdittext.getText().toString(),
                    binding.commentEdittext.getText().toString(),
                    bundle.get("login").toString()
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
        String toast = "";
        if (code == 500) toast = "Неизвестная ошибка";
        if (code == 406) toast = "Недостаточно прав";
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
}