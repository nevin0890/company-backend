package com.nestdigital.company.Controller;

import com.nestdigital.company.Dao.LeaveDao;
import com.nestdigital.company.Model.LeaveModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class LeaveController {

    @Autowired
    private LeaveDao leaveDao;


    //Add leave applications in employee
    @CrossOrigin("*")
    @PostMapping("/applyLeave")
    public String applyLeave(@RequestBody LeaveModel model){
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        model.setApplyDate((String.valueOf(date.format(now))));
        model.setStatus(0);
        leaveDao.save(model);
        return "Success";
    }

    //change leave status in admin
    @Transactional
    @CrossOrigin("*")
    @PostMapping("/leaveStatus")
    public String changeLeaveStatus(@RequestBody LeaveModel model){
        leaveDao.changeStatusOfLeave(model.getId(), model.getStatus());
        return "Success'";
    }

    //View All leaves in admin
    @CrossOrigin("*")
    @GetMapping("/viewAllLeaves")
    public List<Map<String,String>> viewAllLeaves(){
        return (List<Map<String, String>>) leaveDao.viewAllLeave();
    }


    //view all leaves pf empl0yee by employee


    @CrossOrigin("*")
    @PostMapping("/viewLeaveById")
    public List<Map<String,String>> viewLeaveById(@RequestBody LeaveModel model){
        return (List<Map<String, String>>) leaveDao.viewLeaveByEmpID(model.getEmp_id());
    }
}
