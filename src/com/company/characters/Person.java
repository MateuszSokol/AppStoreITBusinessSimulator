package com.company.characters;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String nationality;
    private String gender;
    private int age;


    public Person(String firstName, String lastName, String nationality, String gender, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.gender = gender;
        this.age = age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNationality() {
        return nationality;
    }

    public String isGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}
