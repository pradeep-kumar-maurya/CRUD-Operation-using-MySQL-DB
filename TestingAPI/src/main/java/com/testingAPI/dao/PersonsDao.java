package com.testingAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.testingAPI.beans.Persons;

@Repository
public interface PersonsDao extends JpaRepository<Persons, Integer> {

	@Query("select p from Persons p where id=?1")
	Persons findPersonById(int id);

}
