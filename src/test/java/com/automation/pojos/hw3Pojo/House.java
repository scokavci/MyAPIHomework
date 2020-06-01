package com.automation.pojos.hw3Pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class House {
    private String _id;
    private String name;
    private String mascot;
    private String headOfHouse;
    private String houseGhost;
    private String founder;
    private int __v;
    private String school;
    private List<String> members;
    private List<String> values;
    private List<String> colors;

    public House(String name, String mascot, String headOfHouse, String houseGhost, String founder, int __v, String school, List<String> members, List<String> values, List<String> colors) {
        this.name = name;
        this.mascot = mascot;
        this.headOfHouse = headOfHouse;
        this.houseGhost = houseGhost;
        this.founder = founder;
        this.__v = __v;
        this.school = school;
        this.members = members;
        this.values = values;
        this.colors = colors;
    }

    public House() {
    }

    @Override
    public String toString() {
        return "House{" +
                "id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", mascot='" + mascot + '\'' +
                ", headOfHouse='" + headOfHouse + '\'' +
                ", houseGhost='" + houseGhost + '\'' +
                ", founder='" + founder + '\'' +
                ", v=" + __v +
                ", school='" + school + '\'' +
                ", members=" + members +
                ", values=" + values +
                ", colors=" + colors +
                '}';
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

    public String getMascot() {
        return mascot;
    }

    public void setMascot(String mascot) {
        this.mascot = mascot;
    }

    public String getHeadOfHouse() {
        return headOfHouse;
    }

    public void setHeadOfHouse(String headOfHouse) {
        this.headOfHouse = headOfHouse;
    }

    public String getHouseGhost() {
        return houseGhost;
    }

    public void setHouseGhost(String houseGhost) {
        this.houseGhost = houseGhost;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }
}

