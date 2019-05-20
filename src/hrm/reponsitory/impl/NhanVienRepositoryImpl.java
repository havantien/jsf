package hrm.reponsitory.impl;


import hrm.model.NhanVien;
import hrm.model.search.NhanVienSearch;
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
    public List<NhanVien> find(NhanVienSearch nhanVienSearch) {
        try {

            String nhanVien = "";
            List<NhanVien> lst = new ArrayList<>();
            String sql = "select n from NhanVien n where 1=1 ";

            if (!nhanVienSearch.getTenNV().equals("")) {
                sql = sql + " and tenNV like :nv ";
            }
            if ((nhanVienSearch.getMaPB() != 0)) {

                sql = sql + " and maPB like :mapb";
            }
            if ((nhanVienSearch.getNhanVien() != 0)) {
                sql = sql + "and nhanVien like :nhanVien";
            }
            if ((nhanVienSearch.getMinLuong() != 0) && (nhanVienSearch.getMaxluong() != 0)) {
                sql = sql + "and between luong=:minLuong and luong=:maxLuong";
            }
            Query query = entityManager
                    .createQuery(sql);


            if (!nhanVienSearch.getTenNV().equals("")) {
                query.setParameter("nv", "%" + nhanVienSearch.getTenNV() + "%");

            }
            if (!(nhanVienSearch.getMaPB() == 0)) {

                query.setParameter("mapb", "%" + nhanVienSearch.getMaPB() + "%");
            }
            if (!(nhanVienSearch.getNhanVien() == 0)) {
                query.setParameter("nhanVien", "%" + nhanVienSearch.getNhanVien() + "%");
            }
            if ((nhanVienSearch.getMinLuong() != 0) && (nhanVienSearch.getMaxluong() != 0)) {
                query
                        .setParameter("minLuong", nhanVienSearch.getMinLuong())
                        .setParameter("maxLuong", nhanVienSearch.getMaxluong());

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
