package com.knoxor.graph.builder;

import com.knoxor.graph.model.Father;
import com.knoxor.graph.model.Grandfather;
import com.knoxor.graph.model.Mother;
import com.knoxor.graph.model.Person;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class PersonBuilder {

    String name;
    String surname;
    String age;
    String hobby;

    public PersonBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder age(String age) {
        this.age = age;
        return this;
    }

    public PersonBuilder hobby(String hobby) {
        this.name = hobby;
        return this;
    }

    public Person build(String type) {

        if("grandfather".equals(type)) {
            return new Grandfather(name, surname, age, hobby);
        } else if("father".equals(type)) {
            return new Father(name, surname, age,hobby);
        } else if("daughter".equals(type)) {
            return new Mother(name, surname, age,hobby);
        }
        throw new NotImplementedException();
    }
}
