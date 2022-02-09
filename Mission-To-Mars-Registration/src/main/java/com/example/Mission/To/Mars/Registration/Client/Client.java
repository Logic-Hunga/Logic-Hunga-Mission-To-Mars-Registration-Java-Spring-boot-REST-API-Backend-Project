package com.example.Mission.To.Mars.Registration.Client;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;


/**Mapping the Client to the database*/
@SuppressWarnings("ALL")
@Entity // For hibernate
@Table // For the table in database

public class Client {

    /**Sequence generator*/
    @Id
    @SequenceGenerator(
            name = "client_sequence",
            sequenceName =  "client_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "client_sequence")
    /**default private class  variables*/
    private Long id;
    private char gender;
    private String name;
    private LocalDate dob;
    private String email;
    private String password;
    private String university;
    private String country;

    // Auto Date Compute
    @Transient
    private Integer age;
    /**The  Client Object constructor on arguments*/
    public Client() { // No arguments

    }
    /**The with arguments Client Object constructor*/
    public Client(Long id, char gender, String name, LocalDate dob,String email, String password,String university, String country) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.password = password;
        this.university = university;
        this.country = country;
    }
    /** Client Object constructor with no id argument*/
    public Client(char gender, String name, LocalDate dob, String email, String password, String university, String country) {
        this.gender = gender;
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.password = password;
        this.university = university;
        this.country = country;
    }
    /**Setter and accessor methods*/
    public Long getId() {
        return  id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public char getGender() {
        return gender;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob(){
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return  email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return  password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUniversity() {
        return  university;
    }
    public void setUniversity(String university) {
        this.university = university;
    }

    public String getCountry() {
        return  country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    /**The toString method (from java.lang.Objects */
    // Overriding the default  object toString method
    public String toString() {
        return "ID= "+ id + "\nGender " + gender + "\nName " + name + "DOB" + dob +
                "\nEmail " + email + "\nPassword " + password + "\nUniversity " + university + "\nCountry " + country;
    }
}
