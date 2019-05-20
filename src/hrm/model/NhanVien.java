package hrm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "nhanvien")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NhanVien {
    @Id
    @Column(name = "NHANVIEN")
    private int nhanVien;

    @Column(name = "LUONG")
    private Integer luong;

    @Column(name = "MAPB")
    private Integer maPB;

    @Column(name = "MAQL")
    private Integer maQL;

    @Column(name = "NGAYTL")
    private String ngayTL;

    @Column(name = "NGHENGHIEP")
    private String ngheNghiep;

    @NotNull
    @Column(name = "TENNV")
    private String tenNV;

    @Column(name = "THUONG")
    private Integer thuong;

    @Column(name = "NGAYBD")
    private String ngayBD;

    public int getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(int nhanVien) {
        this.nhanVien = nhanVien;
    }

    public Integer getLuong() {
        return luong;
    }

    public void setLuong(Integer luong) {
        this.luong = luong;
    }

    public Integer getMaPB() {
        return maPB;
    }

    public void setMaPB(Integer maPB) {
        this.maPB = maPB;
    }

    public Integer getMaQL() {
        return maQL;
    }

    public void setMaQL(Integer maQL) {
        this.maQL = maQL;
    }

    public String getNgayTL() {
        return ngayTL;
    }

    public void setNgayTL(String ngayTL) {
        this.ngayTL = ngayTL;
    }

    public String getNgheNghiep() {
        return ngheNghiep;
    }

    public void setNgheNghiep(String ngheNghiep) {
        this.ngheNghiep = ngheNghiep;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Integer getThuong() {
        return thuong;
    }

    public void setThuong(Integer thuong) {
        this.thuong = thuong;
    }

    public String getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(String ngayBD) {
        this.ngayBD = ngayBD;
    }
}
