package com.nestdigital.company.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "leaves")
public class LeaveModel {

    @Id
    @GeneratedValue

    private int id;

    private String type;
    private int emp_id;
    private String description;

    public LeaveModel(int id, String type, int emp_id, String description, String applyDate, String leaveDate, int status) {
        this.id = id;
        this.type = type;
        this.emp_id = emp_id;
        this.description = description;
        this.applyDate = applyDate;
        this.leaveDate = leaveDate;
        Status = status;
    }

    private String applyDate;
    private String leaveDate;
    private int Status;

    public LeaveModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
