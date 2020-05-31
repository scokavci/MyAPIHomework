package com.automation.pojos.hw3Pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/*
{
        "_id": "5a05e2b252f721a3cf2ea33f",
        "name": "Gryffindor",
        "mascot": "lion",
        "headOfHouse": "Minerva McGonagall",
        "houseGhost": "Nearly Headless Nick",
        "founder": "Goderic Gryffindor",
        "__v": 0,
        "school": "Hogwarts School of Witchcraft and Wizardry",
        "members": [
            "5a0fa648ae5bc100213c2332",
            "5a0fa67dae5bc100213c2333",
            "5a0fa7dcae5bc100213c2338",
            "5a107e1ae0686c0021283b19",
            "5a10944f3dc2080021cd8755",
            "5a10947c3dc2080021cd8756",
            "5a1096b33dc2080021cd8762",
            "5a1097653dc2080021cd8763",
            "5a1098fd3dc2080021cd876e",
            "5a109af13dc2080021cd877a",
            "5a109bfc3dc2080021cd877f",
            "5a109c3d3dc2080021cd8780",
            "5a109cb83dc2080021cd8784",
            "5a109cd33dc2080021cd8785",
            "5a109e143dc2080021cd878d",
            "5a109e1e3dc2080021cd878e",
            "5a109e253dc2080021cd878f",
            "5a109e543dc2080021cd8790",
            "5a109f053dc2080021cd8793",
            "5a1226520f5ae10021650d76",
            "5a1226d70f5ae10021650d77",
            "5a12292a0f5ae10021650d7e",
            "5a12298d0f5ae10021650d7f",
            "5a1229e10f5ae10021650d80",
            "5a122cbe0f5ae10021650d89",
            "5a1233ff0f5ae10021650d98",
            "5a1234cb0f5ae10021650d9b",
            "5a1237480f5ae10021650da3",
            "5a1237c00f5ae10021650da5",
            "5a1238070f5ae10021650da6",
            "5a1238350f5ae10021650da7",
            "5a12387a0f5ae10021650da8",
            "5a1238b20f5ae10021650da9",
            "5a1239130f5ae10021650daa",
            "5a12393d0f5ae10021650dab",
            "5a12395f0f5ae10021650dac",
            "5a1239c80f5ae10021650dad",
            "5a1239f10f5ae10021650dae",
            "5a123b450f5ae10021650db7",
            "5a123f130f5ae10021650dcc"
        ],
        "values": [
            "courage",
            "bravery",
            "nerve",
            "chivalry"
        ],
        "colors": [
            "scarlet",
            "gold"
        ]
    },
 */
public class House {

    @SerializedName("_id")
    private int id;
    private String name;
    private String mascot;
    private String headOfHouse;
    private String houseGhost;
    private String founder;
    @SerializedName("__v")
    private int v;
    private String school;
    private Members members;
    private List<String> values;
    private List<String> colors;

    public House(){

    }
    public House(int id, String name, String mascot, String headOfHouse, String houseGhost,
                 String founder, int v, String school, Members members,
                 List<String> values, List<String> colors) {
        this.id = id;
        this.name = name;
        this.mascot = mascot;
        this.headOfHouse = headOfHouse;
        this.houseGhost = houseGhost;
        this.founder = founder;
        this.v = v;
        this.school = school;
        this.members = members;
        this.values = values;
        this.colors = colors;
    }

    public House(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
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

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mascot='" + mascot + '\'' +
                ", headOfHouse='" + headOfHouse + '\'' +
                ", houseGhost='" + houseGhost + '\'' +
                ", founder='" + founder + '\'' +
                ", v=" + v +
                ", school='" + school + '\'' +
                ", members=" + members +
                ", values=" + values +
                ", colors=" + colors +
                '}';
    }
}