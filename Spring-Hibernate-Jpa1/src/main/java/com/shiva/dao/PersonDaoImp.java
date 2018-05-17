package com.shiva.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import com.shiva.entity.Person;

@Repository
public class PersonDaoImp implements PersonDao{
	@PersistenceContext
	private EntityManager em;
	@Override
	public void addPerson(Person person) {
		em.persist(person);
		
	}

	@Override
	public List<Person> getAll() {
		CriteriaQuery<Person> criteriaQuery=em.getCriteriaBuilder().createQuery(Person.class);
		Root<Person> root=criteriaQuery.from(Person.class);
		return em.createQuery(criteriaQuery).getResultList();
	}
}
