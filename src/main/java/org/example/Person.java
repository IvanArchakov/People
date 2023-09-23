package org.example;

import java.util.Objects;
import java.util.Optional;

public class Person {
    protected final String name;
    protected final String surname;
    protected Integer age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return getAge().isEmpty();
    }
    public boolean hasAddress() {
        return getAddress().isEmpty();
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public Optional getAge() {
        return Optional.of(age);
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void happyBirthday() {
        if (hasAge()) {
            this.age++;
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public String toString() {
        return "\nPerson: " +
                "имя = '" + name + '\'' +
                ", фамилия = '" + surname + '\'' +
                ", возраст = " + age +
                ", адрес = '" + address + '\'';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.surname).setAge(0).setAddress(this.address); }
}
