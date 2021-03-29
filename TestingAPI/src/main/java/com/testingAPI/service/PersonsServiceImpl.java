package com.testingAPI.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testingAPI.beans.Persons;
import com.testingAPI.dao.PersonsDao;

@Service
@Transactional
public class PersonsServiceImpl implements PersonsServiceI{

	@Autowired
	private PersonsDao dao;

	@Override
	public List<Persons> getAllPersons() {
		List<Persons> list = dao.findAll();
		return list;
	}

	@Override
	public Persons getPerson(int id) {
		Persons p = dao.findPersonById(id);
		if(p!=null)
			return p;

		else
			return null;
	}

	@Override
	public Persons createPerson(Persons person) {
		Persons p = dao.save(person);
		return p;
	}

	@Override
	public Persons updatePerson(Persons person) {

		Persons p = dao.findPersonById(person.getId());
		
		if(p!=null) {
			Persons p1 = dao.save(person);
			return p1;
		}
		
		else {
			return null;
		}
	}

	@Override
	public Persons deletePerson(int id) {
		Persons p = dao.findPersonById(id);
		if(p!=null) {
			dao.deleteById(id);
			return p;
		}
		else {
			return null;
		}
	}
}