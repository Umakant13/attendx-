package com.tka.dao;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tka.entity.Admin;

@Repository
public class AdminDAOImpl implements AdminDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Admin> getAllAdmins() {
        Session session = null;
        List<Admin> adminList;
        try {
            session = sessionFactory.openSession();
            adminList = session.createQuery("FROM Admin", Admin.class).getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return adminList;
    }

    @Override
    public Admin getAdminById(Long id) {
        Session session = null;
        Admin admin = null;
        try {
            session = sessionFactory.openSession();
            admin = session.get(Admin.class, id);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return admin;
    }

    @Override
    public void saveAdmin(Admin admin) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(admin);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void deleteAdmin(Long id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Admin admin = session.get(Admin.class, id);
            if (admin != null) {
                session.delete(admin);
            }
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}