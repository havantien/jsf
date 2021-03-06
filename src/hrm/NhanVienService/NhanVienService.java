package hrm.NhanVienService;

import hrm.model.NhanVien;
import hrm.model.search.NhanVienSearch;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienService {
    List<NhanVien> findAll();

    List<NhanVien> find(NhanVienSearch nhanVienSearch);

    void create(NhanVien nhanVien);

    void update(NhanVien nhanVien);

    void delete(NhanVien nhanVien);
}
