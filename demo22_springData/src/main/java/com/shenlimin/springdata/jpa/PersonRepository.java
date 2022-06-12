package com.shenlimin.springdata.jpa;

import org.springframework.data.repository.Repository;

public interface PersonRepository extends Repository<Person, Integer> {

    Person getByLastName(String lastName);

}
