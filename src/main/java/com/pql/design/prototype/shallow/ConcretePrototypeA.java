package com.pql.design.prototype.shallow;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ConcretePrototypeA implements Prototype {

    private int age;
    private String name;
    private List hobbies;

    @Override
    public ConcretePrototypeA clone() {
        ConcretePrototypeA concretePrototype = new ConcretePrototypeA();
        concretePrototype.setAge(this.age);
        concretePrototype.setName(this.name);
        concretePrototype.setHobbies(this.hobbies);
        return concretePrototype;
    }
}
