package com.codelean.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "nhanviens")
public class Nhanvien {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "ID cannot be changer")
    @Size(min=2, max=10)
    private String hoten;

    private String ngaysinh;

    @Max(3)
    private int capdo;

    private byte[] anh;

    @ManyToOne
    @JoinColumn(name = "phongban_id")
    private Phongban phongban;

    public Nhanvien(){}


    public Nhanvien(String hoten,String ngaysinh,int capdo, byte[] anh){
        this.id=id;
        this.hoten=hoten;
        this.ngaysinh=ngaysinh;
        this.capdo=capdo;
        this.anh = anh;
    }

    @Override
    public String toString() {
        return String.format("Nhanvien[id=%d,hoten='%s',ngaysinh='%s',capdo='%s']",id,hoten,ngaysinh,capdo);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public int getCapdo() {
        return capdo;
    }

    public void setCapdo(int capdo) {
        this.capdo = capdo;
    }

    public byte[] getAnh() {
        return anh;
    }

    public void setAnh(byte[] anh) {
        this.anh = anh;
    }

    public Phongban getPhongban() {
        return phongban;
    }

    public void setPhongban(Phongban phongban) {
        this.phongban = phongban;
    }

}
