package com.nestdigital.company.Dao;

import com.nestdigital.company.Model.LogModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface LogDao extends CrudRepository<LogModel, Integer> {

    @Modifying
    @Query(value = "UPDATE `logdetails` SET `logout_time`=:logoutTime ,`logout_sec_id`=:logout_sec_id WHERE id = :log_id",nativeQuery = true)
    public void updateLogDetails(String logoutTime,int logout_sec_id,int log_id);

    @Query(value = "SELECT l.`id`, l.`emp_id`, l.`login_time`, l.`login_sec_id`, l.`logout_time`, l.`logout_sec_id`," +
            "e.name as emp_name,s1.name as login_sec_name, s2.name as logout_sec_name FROM `logdetails` l " +
            "JOIN employee e JOIN security s1 JOIN security s2 ON l.emp_id = e.empcode AND " +
            "l.login_sec_id = s1.seuritycode AND l.logout_sec_id = s2.seuritycode ",nativeQuery = true)
    public List<Map<String,String>> viewAllLogs();

    @Query(value="SELECT l.`id`, l.`emp_id`, l.`login_time`, l.`login_sec_id`, l.`logout_time`, l.`logout_sec_id`, " +
            "e.name as emp_name,s1.name as login_sec_name, s2.name as logout_sec_name FROM `logdetails` l JOIN " +
            "employees e JOIN security s1 JOIN security s2 ON l.emp_id = e.id AND " +
            "l.login_sec_id = s1.id AND l.logout_sec_id = s2.id  WHERE l.emp_id = :emp_id",nativeQuery = true)
    public List<Map<String,String>> viewLogByEmpId(Integer emp_id);
}

