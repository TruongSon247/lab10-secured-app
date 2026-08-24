package vn.edu.eaut.lab10.repository;

import jakarta.persistence.*;
import vn.edu.eaut.lab10.config.JPAUtil;
import vn.edu.eaut.lab10.model.Sach;
import java.util.List;

public class SachRepository {

    public List<Sach> findAll() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.createQuery("SELECT s FROM Sach s ORDER BY s.id DESC", Sach.class)
                      .getResultList();
        } finally {
            em.close();
        }
    }

    public Sach findById(Integer id) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            return em.find(Sach.class, id);
        } finally {
            em.close();
        }
    }

    public void save(Sach sach) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(sach);
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx.isActive()) tx.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }

    public void update(Sach sach) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(sach);
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
            Sach s = em.find(Sach.class, id);
            if (s != null) em.remove(s);
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx.isActive()) tx.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }

    public List<Sach> search(String keyword) {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            String jpql = "SELECT s FROM Sach s WHERE LOWER(s.tenSach) LIKE :kw OR LOWER(s.tacGia) LIKE :kw";
            return em.createQuery(jpql, Sach.class)
                     .setParameter("kw", "%" + keyword.toLowerCase() + "%")
                     .getResultList();
        } finally {
            em.close();
        }
    }
}