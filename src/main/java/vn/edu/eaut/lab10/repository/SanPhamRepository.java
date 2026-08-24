package vn.edu.eaut.lab10.repository;

import jakarta.persistence.*;
import vn.edu.eaut.lab10.config.JPAUtil;
import vn.edu.eaut.lab10.model.SanPham;
import java.util.List;

public class SanPhamRepository {

    public List<SanPham> findAll() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT s FROM SanPham s ORDER BY s.id DESC", SanPham.class)
                      .getResultList();
        } finally {
            em.close();
        }
    }

    public SanPham findById(Integer id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.find(SanPham.class, id);
        } finally {
            em.close();
        }
    }

    public void save(SanPham sanPham) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(sanPham);
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx.isActive()) tx.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }

    public void update(SanPham sanPham) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(sanPham);
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx.isActive()) tx.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }

    public void delete(Integer id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            SanPham sp = em.find(SanPham.class, id);
            if (sp != null) em.remove(sp);
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx.isActive()) tx.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }

    public List<SanPham> search(String keyword) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            String jpql = "SELECT s FROM SanPham s WHERE LOWER(s.tenSanPham) LIKE :kw";
            return em.createQuery(jpql, SanPham.class)
                     .setParameter("kw", "%" + keyword.toLowerCase() + "%")
                     .getResultList();
        } finally {
            em.close();
        }
    }
}