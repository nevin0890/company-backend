package com.nestdigital.company.Controller;

import com.nestdigital.company.Dao.AdminDao;
import com.nestdigital.company.Model.AdminModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private AdminDao dao;

    //addemployee

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemployee",consumes = "application/json", produces = "application/json")
    public String addEmployee(@RequestBody AdminModel admin) {
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String CurrentDate=String.valueOf(dt.format(now));
        admin.setDoj(dt.format(now));
        System.out.println(admin.toString());
        dao.save(admin);
        return "{status:'success'}";
    }

    //employeeview

    @CrossOrigin(origins = "*")
    @GetMapping("/employeeview")
    public List<AdminModel> viewEmployee(){
        return (List<AdminModel>) dao.findAll();
    }

    //employeesearch

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchemployee",consumes = "application/json", produces = "application/json")
    public List<AdminModel> searchEmployee(@RequestBody AdminModel admin) {
        return (List<AdminModel>) dao.getEmployeeById(admin.getEmpcode());
    }

    //deleteemployee
    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/deleteemployee",consumes = "application/json", produces = "application/json")
    public String deleteEmployee(@RequestBody AdminModel admin) {
        dao.deleteById(admin.getId());
        return "{status:'success'}";
    }

    //updateemployee

    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/updateemployee",consumes = "application/json", produces = "application/json")
    public String updateEmployee(@RequestBody AdminModel admin) {
        System.out.println(admin.toString());
        dao.updateEmployee(admin.getAddress(),admin.getDesignation(),admin.getDob(),admin.getDoj(),admin.getEmail(),admin.getName(),admin.getPassword(),admin.getPhone(),admin.getEmpcode());
        return "{status:'success'}";

    }
    //EMPLOYEE LOGIN

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/employeeLogin",consumes = "application/json", produces = "application/json")
    public List<AdminModel> employeeLogin(@RequestBody AdminModel admin) {
        return (List<AdminModel>) dao.EmployeeLogin(admin.getEmail(),admin.getPassword());
    }

}
