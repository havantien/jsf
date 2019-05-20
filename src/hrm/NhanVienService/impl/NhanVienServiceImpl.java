package hrm.NhanVienService.impl;

import hrm.NhanVienService.NhanVienService;
import hrm.model.NhanVien;
import hrm.model.dto.NhanVienDTO;
import hrm.reponsitory.NhanVienRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NhanVienServiceImpl implements NhanVienService {

    private NhanVienRepository nhanVienRepository;

    public NhanVienServiceImpl(NhanVienRepository nhanVienRepository) {
        this.nhanVienRepository = nhanVienRepository;

    }

    @Override
    public List<NhanVien> findAll() {
        return nhanVienRepository.findAll();
    }

    @Override
    public List<NhanVien> find(NhanVienDTO nhanVienDTO) {
        return nhanVienRepository.find(nhanVienDTO);
    }

    @Override
    public void create(NhanVien nhanVien) {
        nhanVienRepository.create(nhanVien);
    }

    @Override
    public void update(NhanVien nhanVien) {
        nhanVienRepository.update(nhanVien);
    }

    @Override
    public void delete(NhanVien nhanVien) {
        nhanVienRepository.delete(nhanVien);
    }
}
