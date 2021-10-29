package com.example.fafij.presentation.qrcode;

public class QRCodePresenter implements QRCodeContract.QRCodePresenterInterface {

    public QRCodeContract.QRCodeViewInterface view;

    public QRCodePresenter(QRCodeContract.QRCodeViewInterface view) {
        this.view = view;
    }


}
