package com.codelean.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "kiluats")
public class Kiluat {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private Boolean loai;

    @NotBlank(message = "ID cannot be changer")
    private String lido;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date ngayghinhan;

    @ManyToOne
    @JoinColumn(name = "nhanvien_id")
    private Nhanvien nhanvien;


    public Kiluat(){}

    public Kiluat(Boolean loai,String lido, Date ngayghinhan){
        this.id=id;
        this.loai=loai;
        this.lido=lido;
        this.ngayghinhan=ngayghinhan;
    }

    @Override
    public String toString() {
        return String.format("Kiluat[id=%d,loai='%s',lido='%s',ngayghinhan='%s']",id,loai,lido,ngayghinhan);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getLoai() {
        return loai;
    }

    public void setLoai(Boolean loai) {
        this.loai = loai;
    }

    public String getLido() {
        return lido;
    }

    public void setLido(String lido) {
        this.lido = lido;
    }

    public Date getNgayghinhan() {
        return ngayghinhan;
    }

    public void setNgayghinhan(Date ngayghinhan) {
        this.ngayghinhan = ngayghinhan;
    }

    public Nhanvien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(Nhanvien nhanvien) {
        this.nhanvien = nhanvien;
    }

}
