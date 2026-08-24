package vn.edu.eaut.lab10.service;

import java.util.List;
import vn.edu.eaut.lab10.model.Sach;
import vn.edu.eaut.lab10.repository.SachRepository;

public class SachService {
    private final SachRepository repository = new SachRepository();
    public List<Sach> findAll() { return repository.findAll(); }
    public List<Sach> search(String keyword) { return repository.search(keyword); }
    public Sach findById(Integer id) { return repository.findById(id); }
    public void save(Sach sach) { repository.save(sach); }
    public void update(Sach sach) { repository.update(sach); }
    public void delete(Integer id) { repository.delete(id); }
}
