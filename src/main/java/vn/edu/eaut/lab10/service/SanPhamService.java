package vn.edu.eaut.lab10.service;

import java.util.List;
import vn.edu.eaut.lab10.model.SanPham;
import vn.edu.eaut.lab10.repository.SanPhamRepository;

public class SanPhamService {
    private final SanPhamRepository repository = new SanPhamRepository();
    public List<SanPham> findAll() { return repository.findAll(); }
    public List<SanPham> search(String keyword) { return repository.search(keyword); }
    public SanPham findById(Integer id) { return repository.findById(id); }
    public void save(SanPham sanPham) { repository.save(sanPham); }
    public void update(SanPham sanPham) { repository.update(sanPham); }
    public void delete(Integer id) { repository.delete(id); }
}
