package hrm.reponsitory;

import hrm.model.NhanVien;
import hrm.model.dto.NhanVienDTO;


import java.util.List;

public interface NhanVienRepository {
    List<NhanVien> findAll();

    List<NhanVien> find(NhanVienDTO nhanVienDTO);


    void create(NhanVien nhanVien);

    void update(NhanVien nhanVien);

    void delete(NhanVien nhanVien);
}
