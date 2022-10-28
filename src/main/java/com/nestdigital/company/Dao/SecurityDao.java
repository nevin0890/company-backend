package com.nestdigital.company.Dao;

import com.nestdigital.company.Model.Security;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SecurityDao extends CrudRepository<Security, Integer> {

    @Query(value = "SELECT * FROM `security` WHERE `seuritycode`=:seuritycode", nativeQuery = true)
    List<Security>  getSecurityById(int seuritycode);

    @Modifying
    @Query(value = "DELETE FROM `security` WHERE `id`=:id", nativeQuery = true)
    void deleteById(int id);

    @Modifying
    @Query(value = "UPDATE `security` SET `dob`=:dob,`email`=:email,`name`=:name,`password`=:password,`phone`=:phone WHERE `seuritycode`=:seuritycode",nativeQuery = true)
    void updateSecurity(String dob,String email,String name,String password,int phone,int seuritycode);

    @Query(value = "SELECT * FROM `security` WHERE `email`=:email AND`password`=:password",nativeQuery = true)
    List<Security> Securitylogin(String email, String password);






}

