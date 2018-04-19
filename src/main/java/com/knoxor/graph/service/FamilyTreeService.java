package com.knoxor.graph.service;

import com.knoxor.graph.model.Person;

import java.util.List;

public interface FamilyTreeService {

    Person createFamilyMember(Person member);

    List<Person> createFamily(List<Person> family);

    Person findMember(Long nodeId);

    Iterable<Person> findAll();

}
