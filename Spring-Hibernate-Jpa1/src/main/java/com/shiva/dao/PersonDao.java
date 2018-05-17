package com.shiva.dao;

import java.util.List;

import com.shiva.entity.Person;

public interface PersonDao {
	public void addPerson(Person person);
	public List<Person> getAll();

}
