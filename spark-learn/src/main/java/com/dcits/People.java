package com.dcits;

import java.io.Serializable;

public class People implements Serializable {
    private static final long serialVersionUID = -8843264837345502547L;
    private int id;  
    private String name;  
    private String surname;  
    private int age;  

    public People(int id, String name, String surname, int age) {  
        this.id = id;  
        this.name = name;  
        this.surname = surname;  
        this.age = age;  
    }  

    public People() {  
    }  

    public int getId() {  
        return id;  
    }  

    public void setId(int id) {  
        this.id = id;  
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

    public int getAge() {  
        return age;  
    }  

    public void setAge(int age) {  
        this.age = age;  
    }  

}