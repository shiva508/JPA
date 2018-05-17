package com.shiva.service;

import java.util.List;

import com.shiva.entity.Person;

public interface PersonService {
public void addPerson(Person person);
public List<Person> getAll();
}
