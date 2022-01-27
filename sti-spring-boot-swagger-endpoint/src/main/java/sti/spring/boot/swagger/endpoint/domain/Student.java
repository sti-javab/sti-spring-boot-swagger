package sti.spring.boot.swagger.endpoint.domain;

import java.util.Objects;

public class Student {

    private String givenName;

    private String surName;

    public Student(String givenName, String surName) {
        this.givenName = Objects.requireNonNull(givenName);
        this.surName = Objects.requireNonNull(surName);
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString(){
        return givenName + " " + surName;
    }

}
