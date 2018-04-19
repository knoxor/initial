package com.knoxor.graph.model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Father implements Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String surname;

    private String age;

    private String hobby;

    @Relationship(type="father")
    Grandfather grandfather;

    public Father(String name, String surname, String age, String hobby) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.hobby = hobby;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Grandfather getGrandfather() {
        return grandfather;
    }

    public void setGrandfather(Grandfather grandfather) {
        this.grandfather = grandfather;
    }
}
