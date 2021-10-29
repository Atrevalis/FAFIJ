package com.example.fafij.presentation.qrcode;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fafij.R;

public class QRCodeActivity extends AppCompatActivity implements QRCodeContract.QRCodeViewInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        QRCodePresenter presenter = new QRCodePresenter(this);
    }


}