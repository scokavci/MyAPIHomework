package com.automation.pojos.hw1Pojo;
/*
 {
        "name": "Zekeriya",
        "surname": "Erdem",
        "gender": "male",
        "region": "Turkey"
    },
 */
public class Person {
    private String name;
    private String surname;
    private String gender;
    private String region;

    public Person(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
}
