package com.automation.pojos.hw3Pojo;

public class Members {
    String _id;
    //String name;

    @Override
    public String toString() {
        return "Members{" +
                "id='" + _id + '\'' +
                '}';
    }

    public Members() {
    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

}

