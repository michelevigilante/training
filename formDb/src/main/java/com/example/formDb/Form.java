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

    private Form(){}

    public Form(int val1, int val2, int sum) {
        this.val1 = val1;
        this.val2 = val2;
        this.sum = sum;
    }

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
