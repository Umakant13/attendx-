package com.tka.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tka.entity.FacultyAttendance;

@Repository
public class FacultyAttendanceDAOImpl implements FacultyAttendanceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<FacultyAttendance> getAllFacultyAttendance() {
        Session session = null;
        List<FacultyAttendance> facultyAttendanceList;
        try {
            session = sessionFactory.openSession();
            facultyAttendanceList = session.createQuery("FROM FacultyAttendance", FacultyAttendance.class).getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return facultyAttendanceList;
    }

    @Override
    public FacultyAttendance getFacultyAttendanceById(Long id) {
        Session session = null;
        FacultyAttendance facultyAttendance = null;
        try {
            session = sessionFactory.openSession();
            facultyAttendance = session.get(FacultyAttendance.class, id);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return facultyAttendance;
    }

    @Override
    public void saveFacultyAttendance(FacultyAttendance facultyAttendance) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.saveOrUpdate(facultyAttendance);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void deleteFacultyAttendance(Long id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            FacultyAttendance facultyAttendance = session.get(FacultyAttendance.class, id);
            if (facultyAttendance != null) {
                session.delete(facultyAttendance);
            }
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
