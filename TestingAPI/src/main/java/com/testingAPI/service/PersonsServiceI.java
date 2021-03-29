package com.testingAPI.service;

import java.util.List;

import com.testingAPI.beans.Persons;

public interface PersonsServiceI {

	List<Persons> getAllPersons();

	Persons getPerson(int id);

	Persons createPerson(Persons person);

	Persons updatePerson(Persons person);

	Persons deletePerson(int id);

}
