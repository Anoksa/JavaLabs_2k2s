package it.belstu.karpushevich.java_univer.uni;

import java.io.Serializable;

public abstract class Person implements Serializable {

    public int age;
    public String name;
    public String surname;
    public Person(int age, String name, String surname)
    {
        this.age=age;
        this.name=name;
        this.surname=surname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
