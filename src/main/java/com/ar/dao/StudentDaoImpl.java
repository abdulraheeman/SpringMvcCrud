package com.ar.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ar.model.Student;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class StudentDaoImpl {

	@PersistenceContext
	private EntityManager entityManager;

	public void create(Student student) {
		entityManager.persist(student);
	}

	public void update(Student student) {
		entityManager.merge(student);
	}

	public void delete(int id) {
		Student student = entityManager.find(Student.class, id);
		entityManager.remove(student);
	}

	public Student findOne(int id) {
		return entityManager.find(Student.class, id);
	}

	public List<Student> findAll(Student student) {
		return (List<Student>) entityManager.createQuery("select s.name,s.address,s.phone from Student s");
	}
}
