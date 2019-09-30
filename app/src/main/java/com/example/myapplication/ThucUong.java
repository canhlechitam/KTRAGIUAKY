package com.example.myapplication;

import java.io.Serializable;

public class ThucUong implements Serializable {
    private String tenthucuong;
    private int gia;

    public ThucUong(String tenthucuong, int gia) {
        this.tenthucuong = tenthucuong;
        this.gia = gia;
    }

    public String getTenthucuong() {
        return tenthucuong;
    }

    public int getGia() {
        return gia;
    }

    public void setTenthucuong(String tenthucuong) {
        this.tenthucuong = tenthucuong;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return tenthucuong;
    }
}
