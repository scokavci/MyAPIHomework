package com.automation.pojos.hw3Pojo;

import com.google.gson.annotations.SerializedName;

public class Character {

    @SerializedName("_id")
    private String id;
    private String name;
    private String role;
    private String house;
    private String school;
    private String founder;
    @SerializedName("__v")
    private int v;
    private String ministryOfMagic;
    private String orderOfThePhoenix;
    private String dumbledoresArmy;
    private String deathEater;
    private String bloodStatus;
    private String species;

    @Override
    public String toString() {
        return "Character{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", house='" + house + '\'' +
                ", school='" + school + '\'' +
                ", founder='" + founder + '\'' +
                ", v=" + v +
                ", ministryOfMagic='" + ministryOfMagic + '\'' +
                ", orderOfThePhoenix='" + orderOfThePhoenix + '\'' +
                ", dumbledoresArmy='" + dumbledoresArmy + '\'' +
                ", deathEater='" + deathEater + '\'' +
                ", bloodStatus='" + bloodStatus + '\'' +
                ", species='" + species + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
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
}
