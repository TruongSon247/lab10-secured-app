package vn.edu.eaut.lab10.service;

import java.util.List;
import vn.edu.eaut.lab10.model.SinhVien;
import vn.edu.eaut.lab10.repository.SinhVienRepository;

public class SinhVienService {
    private final SinhVienRepository repository = new SinhVienRepository();
    public List<SinhVien> findAll() { return repository.findAll(); }
    public List<SinhVien> search(String keyword) { return repository.search(keyword); }
    public SinhVien findById(Integer id) { return repository.findById(id); }
    public void save(SinhVien sinhVien) { repository.save(sinhVien); }
    public void update(SinhVien sinhVien) { repository.update(sinhVien); }
    public void delete(Integer id) { repository.delete(id); }
}
