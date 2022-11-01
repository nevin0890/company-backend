package com.nestdigital.company.Controller;

import com.nestdigital.company.Dao.LeaveDao;
import com.nestdigital.company.Model.LeaveModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class LeaveController {

    @Autowired
    private LeaveDao Doa;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addLeave",consumes = "application/json", produces = "application/json")
    public String addLeave(@RequestBody LeaveModel leave) {
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String CurrentDate=String.valueOf(dt.format(now));
        leave.setDate(dt.format(now));
        leave.setStatus("Pending");
        System.out.println(leave.toString());
        Doa.save(leave);
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
  @GetMapping("/viewLeave")
    public List<LeaveModel> viewleave() {
        return (List<LeaveModel>) Doa.findAll();
    }
    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/updateleave",consumes = "application/json", produces = "application/json")
    public String updateLeave(@RequestBody LeaveModel leave) {
        System.out.println(leave.toString());
        Doa.updateLeave(leave.getStatus(), leave.getId());
        return "{status:'success'}";
    }
}
