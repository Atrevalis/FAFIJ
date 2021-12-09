package com.example.fafij.presentation.editnote;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.R;
import com.example.fafij.databinding.ActivityEditnoteBinding;
import com.example.fafij.databinding.ActivityInvitationsBinding;
import com.example.fafij.presentation.bottomnavigation.BottomNavigationActivity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class EditNoteActivity extends AppCompatActivity implements EditNoteContract.EditNoteViewInterface {

    EditNotePresenter presenter = new EditNotePresenter(this);
    ActivityEditnoteBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditnoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
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
        binding.qrcodeButton.setOnClickListener(view -> {
            try {
                showQR();
            } catch (WriterException | NotFoundException e) {
                showToastException(e.getLocalizedMessage());
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("SetTextI18n")
    public void showQR() throws WriterException, NotFoundException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(String.valueOf(ThreadLocalRandom.current().nextLong(-20000L,-1L)), BarcodeFormat.
                QR_CODE, 250, 250);
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        int[] pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            int offset = y * width;
            for (int x = 0; x < width; x++) {
                pixels[offset + x] = bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE;
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
        binding.qrCode.setImageBitmap(bitmap);
        binding.qrCode.setVisibility(View.VISIBLE);
        int[] intArray = new int[bitmap.getWidth() * bitmap.getHeight()];
        bitmap.getPixels(intArray, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        LuminanceSource source = new RGBLuminanceSource(bitmap.getWidth(), bitmap.getHeight(), intArray);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(source));
        Result result = new MultiFormatReader().decode(binaryBitmap);
        binding.qrsum.setText(getString(R.string.check_sum) + result.getText());
        binding.noteSumEdittext.setText(result.getText());
        binding.qrsum.setVisibility(View.VISIBLE);
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