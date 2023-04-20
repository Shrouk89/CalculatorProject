package com.lab.task.model;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Calculation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private int num_1;
    private int num_2;
    private String oper;

    
    public void setid(int id) {
        this.id = id;
    }
    public int getid() {
        return id;
    }
    
    public void setNum_1(int num_1) {
        this.num_1 = num_1;
    }
    public int getNumber1() {
        return num_1;
    }
    public int getNum_2() {
        return num_2;
    }
    public void setNum_2(int num_2) {
        this.num_2 = num_2;
    }
   
    public void setOperation(String oper) {
        this.oper = oper;
    }
     public String getOperation() {
        return oper;
    }
}