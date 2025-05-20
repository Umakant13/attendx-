package com.tka.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tka.entity.Department;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO{
	@Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Department> getAllDepartments() {
        Session session = null;
        List<Department> departments;
        try {
            session = sessionFactory.openSession();
            departments = session.createQuery("FROM Department", Department.class).getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return departments;
    }

    @Override
    public Department getDepartmentById(Long id) {
        Session session = null;
        Department department = null;
        try {
            session = sessionFactory.openSession();
            department = session.get(Department.class, id);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return department;
    }

    @Override
    public void saveDepartment(Department department) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(department);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void deleteDepartment(Long id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            Department department = session.get(Department.class, id);
            if (department != null) {
                session.delete(department);
            }
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
