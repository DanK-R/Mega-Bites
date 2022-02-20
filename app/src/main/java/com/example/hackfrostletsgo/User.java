package com.example.hackfrostletsgo;

public class User {


    private String country;
    private String school;
    private String name;

    public User(){}
    public User(String country, String school, String name ) {
        // [START_EXCLUDE]
        this.name = name;

        this.country = country;


        this.school = school;
        // [END_EXCLUDE]
    }

    public String getName() {
        return name;
    }

    public String getSchool() {
        return school;
    }

    public String getCountry() {
        return country;
    }

}
