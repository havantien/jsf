package hrm.reponsitory;

import hrm.model.NhanVien;
import hrm.model.search.NhanVienSearch;


import java.util.List;

public interface NhanVienRepository {
    List<NhanVien> findAll();

    List<NhanVien> find(NhanVienSearch nhanVienSearch);


    void create(NhanVien nhanVien);

    void update(NhanVien nhanVien);

    void delete(NhanVien nhanVien);
}
