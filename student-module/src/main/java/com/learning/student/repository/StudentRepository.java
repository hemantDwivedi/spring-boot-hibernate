package com.learning.student.repository;

import com.learning.student.config.DBConfig;
import com.learning.student.entity.Student;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class StudentRepository {
    private final DBConfig config;

    public List<Student> getStudents(){
        LocalSessionFactoryBean factory = config.sessionFactory();
        Session session = Objects.requireNonNull(factory.getObject()).getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
        query.select(root);
        Query<Student> sessionQuery = session.createQuery(query);
        return sessionQuery.getResultList();
    }

    public Student getStudentById(Long id){
        LocalSessionFactoryBean factory = config.sessionFactory();
        Session session = Objects.requireNonNull(factory.getObject()).getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = query.from(Student.class);
        query.select(root.get("id"));
        query.where(criteriaBuilder.equal(root.get("id"), id));

        Query<Student> sessionQuery = session.createQuery(query);
        return sessionQuery.getSingleResult();
    }

    public void save(Student student){
        // save object
    }
}
