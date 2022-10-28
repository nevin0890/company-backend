package com.nestdigital.company.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class AdminModel {
 @Id
 @GeneratedValue

    private  int   id;
    private  int  empcode;
    private String name;
    private String dob;
    private int    phone;
    private String address;
    private String designation;
    private String doj;
    private String email;
    private String password;

    public AdminModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpcode() {
        return empcode;
    }

    public void setEmpcode(int empcode) {
        this.empcode = empcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AdminModel(int id, int empcode, String name, String dob, int phone, String address, String designation, String doj, String email, String password) {
        this.id = id;
        this.empcode = empcode;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
        this.designation = designation;
        this.doj = doj;
        this.email = email;
        this.password = password;
    }
}

