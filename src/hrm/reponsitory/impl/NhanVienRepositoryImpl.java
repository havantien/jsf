package hrm.reponsitory.impl;


import hrm.model.NhanVien;
import hrm.model.dto.NhanVienDTO;
import hrm.reponsitory.NhanVienRepository;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("ALL")
@Repository
public class NhanVienRepositoryImpl implements NhanVienRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<NhanVien> findAll() {
        try {
            return entityManager
                    .createQuery("select c from NhanVien c")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
//        List<Object[]> lst = entityManager.createNativeQuery("select * from nhanvien ").getResultList();
//        List<NhanVien> lstNv = new ArrayList<>();
//
//        for(Object[] obj : lst){
//            NhanVien nhanVien = new NhanVien();
//            nhanVien.setNhanVien((Integer) obj[0]);
//            nhanVien.setLuong((Integer) obj[1]);
//            nhanVien.setMaPB((Integer) obj[2]);
//            lstNv.add(nhanVien);
//        }
//        return  lstNv;
    }

    @Override
    public List<NhanVien> find(NhanVienDTO nhanVienDTO) {
        try {

            String nhanVien = "";
            List<NhanVien> lst = new ArrayList<>();
            String sql = "select n from NhanVien n where 1=1 ";

            if (!nhanVienDTO.getTenNV().equals("")) {
                sql = sql + " and tenNV like :nv ";
            }
            if ((nhanVienDTO.getMaPB() != 0)) {

                sql = sql + " and maPB like :mapb";
            }
            if ((nhanVienDTO.getNhanVien() != 0)) {
                sql = sql + "and nhanVien like :nhanVien";
            }
            if ((nhanVienDTO.getLuong() != 0)) {
                sql = sql + "and between luong and luong";
            }
            Query query = entityManager
                    .createQuery(sql);


            if (!nhanVienDTO.getTenNV().equals("")) {
                query.setParameter("nv","%" + nhanVienDTO.getTenNV() +"%");

            }
            if (!(nhanVienDTO.getMaPB() == 0)) {

                query.setParameter("mapb","%" + nhanVienDTO.getMaPB() + "%");
            }
            if (!(nhanVienDTO.getNhanVien() == 0)) {
                query.setParameter("nhanVien", "%" + nhanVienDTO.getNhanVien() + "%");
            }
            if (!(nhanVienDTO.getLuong() == 0)) {
                query
                        .setParameter("luong", nhanVienDTO.getLuong())
                        .setParameter("luong", nhanVienDTO.getLuong());

            }

            lst = query.getResultList();
            return lst;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void create(NhanVien nhanVien) {
        entityManager.persist(nhanVien);
    }

    @Override
    public void update(NhanVien nhanVien) {
        entityManager.merge(nhanVien);
    }

    @Override
    public void delete(NhanVien nhanVien) {
        entityManager.remove(entityManager.merge(nhanVien));
    }
}
