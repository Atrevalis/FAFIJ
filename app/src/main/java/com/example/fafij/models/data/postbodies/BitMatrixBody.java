package com.example.fafij.models.data.postbodies;

import com.google.zxing.common.BitMatrix;

public class BitMatrixBody {
    public BitMatrix getQR() {
        return qr;
    }

    public void setQR(BitMatrix qr) {
        this.qr = qr;
    }

    public BitMatrixBody(BitMatrix qr) {
        this.qr = qr;
    }

    private BitMatrix qr;
}
