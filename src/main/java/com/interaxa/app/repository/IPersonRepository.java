package com.interaxa.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interaxa.app.model.entity.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long>{

}
