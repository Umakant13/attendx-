package com.tka.dao;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tka.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> getAllStudents() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Student", Student.class).getResultList();
        }
    }

    @Override
    public Student getStudentById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Student.class, id);
        }
    }

    @Override
    public void saveStudent(Student student) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteStudent(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            if (student != null) {
                session.delete(student);
            }
            session.getTransaction().commit();
        }
    }
}