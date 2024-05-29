/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SachForm;

import java.util.Date;

/**
 *
 * @author DO THI THANH AN
 */
public class ClassSach {
    
    public String MaSach,TenSach,TenTG,HinhAnh;
    public Date NamXB;
    public String SLTon,GiaBan;
    public String MaTL;
    public String TheLoai;

    public ClassSach() {
    }

    public ClassSach(String MaSach, String TenSach, String TenTG, String HinhAnh, Date NamXB, String SLTon, String GiaBan, String MaTL, String TheLoai) {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.TenTG = TenTG;
        this.HinhAnh = HinhAnh;
        this.NamXB = NamXB;
        this.SLTon = SLTon;
        this.GiaBan = GiaBan;
        this.MaTL = MaTL;
        this.TheLoai = TheLoai;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public String getTenTG() {
        return TenTG;
    }

    public void setTenTG(String TenTG) {
        this.TenTG = TenTG;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public Date getNamXB() {
        return NamXB;
    }

    public void setNamXB(Date NamXB) {
        this.NamXB = NamXB;
    }

    public String getSLTon() {
        return SLTon;
    }

    public void setSLTon(String SLTon) {
        this.SLTon = SLTon;
    }

    public String getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(String GiaBan) {
        this.GiaBan = GiaBan;
    }

    public String getMaTL() {
        return MaTL;
    }

    public void setMaTL(String MaTL) {
        this.MaTL = MaTL;
    }

    public String getTheLoai() {
        return TheLoai;
    }

    public void setTheLoai(String TheLoai) {
        this.TheLoai = TheLoai;
    }
}
