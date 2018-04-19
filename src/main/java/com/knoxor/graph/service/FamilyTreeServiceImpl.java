package com.knoxor.graph.service;

import com.knoxor.graph.model.Person;
import com.knoxor.graph.repository.FamilyTreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FamilyTreeServiceImpl implements FamilyTreeService{

    private FamilyTreeRepository familyTreeRepository;

    @Autowired
    public FamilyTreeServiceImpl(FamilyTreeRepository familyTreeRepository) {
        this.familyTreeRepository = familyTreeRepository;
    }

    @Override
    public Person createFamilyMember(Person member) {
        return familyTreeRepository.save(member);
    }

    public List<Person> createFamily(List<Person> familyList) {
        return familyList.stream().map(family -> familyTreeRepository.save(family)).collect(Collectors.toList());
    }

    @Override
    public Person findMember(Long nodeId) {
        return familyTreeRepository.findById(nodeId).get();
    }

    @Override
    public Iterable<Person> findAll() {
        return familyTreeRepository.findAll();
    }
}
