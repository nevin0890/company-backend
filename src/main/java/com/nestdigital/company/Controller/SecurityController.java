package com.nestdigital.company.Controller;

import com.nestdigital.company.Dao.SecurityDao;
import com.nestdigital.company.Model.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class SecurityController {

    @Autowired
    private SecurityDao dao;

    //SECURITY ADD

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/securityAdd",consumes = "application/json", produces = "application/json")
    public String securityAdd(@RequestBody Security security) {
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String CurrentDate=String.valueOf(dt.format(now));
        security.setDoj(dt.format(now));
        System.out.println(security.toString());
        dao.save(security);
        return "{status:'success'}";
    }
    //SECURITY VIEW

    @CrossOrigin(origins = "*")
    @GetMapping("/securityView")
    public List<Security> securityView(@RequestBody Security security) {
        return (List<Security>) dao.findAll();
    }

    //SECURITY SEARCH

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/securitySearch",consumes = "application/json", produces = "application/json")
    public List<Security> securitySearch(@RequestBody Security security) {
        return (List<Security>) dao.getSecurityById(security.getSeuritycode());
    }

    //SECURITY DELETE

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/securityDelete",consumes = "application/json", produces = "application/json")
    public String securityDelete(@RequestBody Security security) {
        dao.deleteById(security.getId());
        return "{status:'success'}";
    }

    //SECURITY UPDATE

    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/securityUpdate",consumes = "application/json", produces = "application/json")
    public String securityUpdate(@RequestBody Security security) {
        dao.updateSecurity(security.getDob(),security.getEmail(),security.getName(),security.getPassword(),security.getPhone(),security.getSeuritycode());

        return "{status:'success'}";
    }
    //SECURITY LOGIN

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/securityLogin",consumes = "application/json", produces = "application/json")
    public List<Security> securityLogin(@RequestBody Security security) {
        return (List<Security>) dao.Securitylogin(security.getEmail(),security.getPassword());
    }







}
