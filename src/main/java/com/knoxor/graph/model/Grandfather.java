package com.knoxor.graph.model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Grandfather implements Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String surname;

    private String age;

    private String hobby;

    @Relationship(type="son")
    Father son;

    @Relationship(type="daughter")
    Father daughter;


    public Grandfather(String name, String surname, String age, String hobby) {
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

    public Father getSon() {
        return son;
    }

    public void setSon(Father son) {
        this.son = son;
    }

    public Father getDaughter() {
        return daughter;
    }

    public void setDaughter(Father daughter) {
        this.daughter = daughter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grandfather that = (Grandfather) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (hobby != null ? !hobby.equals(that.hobby) : that.hobby != null) return false;
        if (son != null ? !son.equals(that.son) : that.son != null) return false;
        return daughter != null ? daughter.equals(that.daughter) : that.daughter == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (hobby != null ? hobby.hashCode() : 0);
        result = 31 * result + (son != null ? son.hashCode() : 0);
        result = 31 * result + (daughter != null ? daughter.hashCode() : 0);
        return result;
    }
}
