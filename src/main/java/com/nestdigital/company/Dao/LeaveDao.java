package com.nestdigital.company.Dao;

import com.nestdigital.company.Model.LeaveModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LeaveDao extends CrudRepository<LeaveModel, Integer> {

    @Modifying
    @Query(value="SELECT * FROM `leaves",nativeQuery = true)
    List<LeaveModel> viewleave();

    //update leave


    @Modifying
    @Query(value="UPDATE `leaves` SET `status`=:status WHERE `id`=:id",nativeQuery = true)
    void updateLeave(String status,int id);


}

