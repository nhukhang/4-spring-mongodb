package com.mycompany.app.modal;

import org.springframework.data.annotation.Id;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 12/4/14
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Person {

    //id will be used for storing MongoDB _id
    @Id
    private String id;

    private String first;
    private String last;
    private String dob;
    private String gender;
    private String hair_colour;
    private String occupation;
    private String nationality;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHair_colour() {
        return hair_colour;
    }

    public void setHair_colour(String hair_colour) {
        this.hair_colour = hair_colour;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString(){
        return first+"-"+last;
    }

}
