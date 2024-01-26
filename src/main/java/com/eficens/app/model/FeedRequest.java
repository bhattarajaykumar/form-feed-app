package com.eficens.app.model;

public class FeedRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String skills;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "{" +
                "firstName : '" + firstName + '\'' +
                ", lastName : '" + lastName + '\'' +
                ", email : '" + email + '\'' +
                ", address :'" + address + '\'' +
                ", skills : '" + skills + '\'' +
                '}';
    }
}
