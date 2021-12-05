package com.example.fafij.presentation.addnote;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Bitmap;

import android.graphics.Color;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.R;
import com.example.fafij.databinding.ActivityAddnoteBinding;
import com.github.mikephil.charting.utils.Utils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.datamatrix.DataMatrixReader;

import com.google.zxing.datamatrix.decoder.Decoder;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.QRCodeWriter;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class AddNoteActivity extends AppCompatActivity implements AddNoteContract.AddNoteViewInterface {


    AddNotePresenter presenter = new AddNotePresenter(this);
    ActivityAddnoteBinding binding;
    Calendar c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddnoteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        binding.addNoteButton.setOnClickListener(view -> sendAddingNote());
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
        try {
            Long.parseLong(binding.noteSumEdittext.getText().toString());
        } catch (Exception e) {
            showToastException("Недействительное значение денежной суммы");
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
}