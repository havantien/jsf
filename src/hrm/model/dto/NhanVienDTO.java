package hrm.model.dto;


public class NhanVienDTO {
    private int nhanVien;
    private String tenNV;
    private int maPB;
    private int maQL;
    private int luong;

    public int getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(int nhanVien) {
        this.nhanVien = nhanVien;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getMaPB() {
        return maPB;
    }

    public void setMaPB(int maPB) {
        this.maPB = maPB;
    }

    public int getMaQL() {
        return maQL;
    }

    public void setMaQL(int maQL) {
        this.maQL = maQL;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }
}
