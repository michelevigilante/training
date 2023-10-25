package com.example.formDb;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int val1;
    private int val2;

    private int sum;

    private String name;
    private String surname;
    private String email;
    private String state;
    private String province;
    private String city;
    private String address;
    private String comment;



   public Form() {}

    public int getVal1() {

        return val1;
    }

    public void setVal1(int val1) {

        this.val1 = val1;
    }

    public int getVal2() {

        return val2;
    }

    public void setVal2(int val2) {

        this.val2 = val2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void doSum() {
        sum = val1 + val2;
    }
    public int getSum(){
        return sum;
    }

    public Float getAvg(Iterable<Form> dataList){
        int totalSum = 0;
        int lineCount = 0;
        float avg;

        for (Form data:dataList){
            totalSum += data.getVal1() + data.getVal2();
            lineCount++;
        }

        avg = (float) totalSum /(lineCount*2);

        return avg;
    }
}
