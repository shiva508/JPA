package com.shiva.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shiva.dao.PersonDao;
import com.shiva.entity.Person;
@Service
public class PersonServiceImp implements PersonService{
	@Autowired
	private PersonDao personDao;
	
	@Override
	@Transactional
	public void addPerson(Person person) 
	{
	personDao.addPerson(person);	
	}

	@Override
	@Transactional
	public List<Person> getAll() 
	{
		return personDao.getAll();
	}
}
