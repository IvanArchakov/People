package org.example;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected Integer age;
    protected String address;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }
    public PersonBuilder setAge(int age) {
        if (age >= 0) {
        this.age = age;
        return this;
    }
        throw new IllegalArgumentException("Возраст должен быть больше или равен 0");
    }
    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (this.name == null || this.surname == null) {
            throw new IllegalStateException("Недостаточно обязательных полей");
        }
        Person person;
        if (age != null) {
            person = new Person(this.name, this.surname, this.age);
        } else {
            person = new Person(this.name, this.surname);
        }
        person.setAddress(this.address);
        return person;
    }
}
