package com.nestdigital.company.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "security")
public class Security {
    @Id
    @GeneratedValue

    private  int   id;
    private  int  seuritycode;
    private String name;
    private String dob;
    private String    doj;
    private int    phone;
    private String email;
    private String password;

    public Security() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeuritycode() {
        return seuritycode;
    }

    public void setSeuritycode(int seuritycode) {
        this.seuritycode = seuritycode;
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

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
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

    public Security(int id, int seuritycode, String name, String dob, String doj, int phone, String email, String password) {
        this.id = id;
        this.seuritycode = seuritycode;
        this.name = name;
        this.dob = dob;
        this.doj = doj;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
}
