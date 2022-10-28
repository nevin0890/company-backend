package com.nestdigital.company.Dao;

import com.nestdigital.company.Model.AdminModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminDao extends CrudRepository<AdminModel, Integer> {


    //SEARCH EMPLOYEE
    @Query(value = "SELECT * FROM `employee` WHERE `empcode`=:empcode", nativeQuery = true)
    List<AdminModel> getEmployeeById(int empcode);

    //DELETE EMPLOYEE


    @Modifying
    @Query(value = "DELETE FROM `employee` WHERE `id`=:id", nativeQuery = true)
    void deleteById(int id);


    //UPDATE EMPLOYEE
    @Modifying
    @Query(value = "UPDATE `employee` SET `address`=:address,`designation`=:designation,`dob`=:dob,`doj`=:doj,`email`=:email,`name`=:name,`password`=:password,`phone`=:phone WHERE `empcode`=:empcode ",nativeQuery = true)
    void updateEmployee(String address,String designation,String dob,String doj,String email,String name,String password,int phone,int empcode);

    //LOGIN EMPLOYEE`

    @Query(value = "SELECT * FROM `employee` WHERE `email`=:email AND`password`=:password",nativeQuery = true)
    List<AdminModel> EmployeeLogin(String email, String password);





}

