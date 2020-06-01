package com.automation.pojos.hw3Pojo;
/*
{
    "_id": "5a0fa4daae5bc100213c232e",
    "name": "Hannah Abbott",
    "role": "student",
    "house": "Hufflepuff",
    "school": "Hogwarts School of Witchcraft and Wizardry",
    "__v": 0,
    "ministryOfMagic": false,
    "orderOfThePhoenix": false,
    "dumbledoresArmy": true,
    "deathEater": false,
    "bloodStatus": "half-blood",
    "species": "human"
}
 */

public class Characters {

    private String _id;
    private String name;
    private String role;
    private String house;
    private String school;
    private int __v;
    private String ministryOfMagic;
    private String orderOfThePhoenix;
    private String dumbledoresArmy;
    private String deathEater;
    private String bloodStatus;
    private String species;

    public Characters(){

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public String getMinistryOfMagic() {
        return ministryOfMagic;
    }

    public void setMinistryOfMagic(String ministryOfMagic) {
        this.ministryOfMagic = ministryOfMagic;
    }

    public String getOrderOfThePhoenix() {
        return orderOfThePhoenix;
    }

    public void setOrderOfThePhoenix(String orderOfThePhoenix) {
        this.orderOfThePhoenix = orderOfThePhoenix;
    }

    public String getDumbledoresArmy() {
        return dumbledoresArmy;
    }

    public void setDumbledoresArmy(String dumbledoresArmy) {
        this.dumbledoresArmy = dumbledoresArmy;
    }

    public String getDeathEater() {
        return deathEater;
    }

    public void setDeathEater(String deathEater) {
        this.deathEater = deathEater;
    }

    public String getBloodStatus() {
        return bloodStatus;
    }

    public void setBloodStatus(String bloodStatus) {
        this.bloodStatus = bloodStatus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String toString() {
        return "Characters{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", house='" + house + '\'' +
                ", school='" + school + '\'' +
                ", __v=" + __v +
                ", ministryOfMagic='" + ministryOfMagic + '\'' +
                ", orderOfThePhoenix='" + orderOfThePhoenix + '\'' +
                ", dumbledoresArmy='" + dumbledoresArmy + '\'' +
                ", deathEater='" + deathEater + '\'' +
                ", bloodStatus='" + bloodStatus + '\'' +
                ", species='" + species + '\'' +
                '}';
    }
}