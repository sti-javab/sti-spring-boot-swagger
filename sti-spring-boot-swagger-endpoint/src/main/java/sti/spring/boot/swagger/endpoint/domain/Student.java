package sti.spring.boot.swagger.endpoint.domain;

import java.util.Objects;

public class Student {

    private String givenName;

    private String surName;

    public Student(String givenName, String surName) {
        this.givenName = Objects.requireNonNull(givenName);
        this.surName = Objects.requireNonNull(surName);
    }

    public Student(Builder builder){
        this.givenName = builder.givenName;
        this.surName = builder.surName;
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

    public static Builder builder(){ return new Builder();}

    //nested class / nästlad klass / inner class /inre klass
    public static class Builder {

        private String givenName;

        private String surName;

        public Builder withGivenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        public Builder withSurname(String surname) {
            this.givenName = surname;
            return this;
        }

        public Student build() {
            return new Student(this.givenName, this.surName);
        }
    }
}
