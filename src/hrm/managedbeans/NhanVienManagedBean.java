package hrm.managedbeans;

import hrm.NhanVienService.NhanVienService;
import hrm.model.NhanVien;
import hrm.model.search.NhanVienSearch;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@Getter
@Setter
@SuppressWarnings("ALL")
@Component
@ManagedBean(name = "nhanVienManagedBean")
@SessionScoped
public class NhanVienManagedBean {

    @Autowired
    public NhanVienService nhanVienService;

    private List<NhanVien> nhanViens;

    private NhanVien nhanVien = new NhanVien();

    private NhanVienSearch nhanVienSearch = new NhanVienSearch();


    public void onload() {
        this.nhanVien = new NhanVien();
        this.nhanViens = nhanVienService.findAll();
    }

    public String add() {
        return "add?faces-redirect=true";
    }

    public String save() {
        this.nhanVienService.create(nhanVien);
        return "index?faces-redirect=true";
    }

    public String edit(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
        return "edit?faces-redirect=true";
    }

    public String update() {
        this.nhanVienService.update(this.nhanVien);
        return "index?faces-redirect=true";
    }


    public String delete(NhanVien nhanVien) {
        this.nhanVienService.delete(nhanVien);
        return "index?faces-redirect=true";
    }

    public String formSearch() {
        return "search?faces-redirect=true";
    }

    public String find() {
        this.nhanViens = nhanVienService.find(nhanVienSearch);
        return "viewsearch?faces-redirect=true";
    }

}
