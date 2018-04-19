package com.knoxor.graph.model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Mother implements Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String surname;

    private String age;

    private String hobby;

    @Relationship(type="father")
    Grandfather grandfather;

    public Mother(String name, String surname, String age, String hobby) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mother mother = (Mother) o;

        if (name != null ? !name.equals(mother.name) : mother.name != null) return false;
        if (surname != null ? !surname.equals(mother.surname) : mother.surname != null) return false;
        if (age != null ? !age.equals(mother.age) : mother.age != null) return false;
        if (hobby != null ? !hobby.equals(mother.hobby) : mother.hobby != null) return false;
        return grandfather != null ? grandfather.equals(mother.grandfather) : mother.grandfather == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (hobby != null ? hobby.hashCode() : 0);
        result = 31 * result + (grandfather != null ? grandfather.hashCode() : 0);
        return result;
    }
}
