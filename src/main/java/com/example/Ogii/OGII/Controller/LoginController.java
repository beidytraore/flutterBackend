package com.example.Ogii.OGII.Controller;


import com.example.Ogii.OGII.model.Login;
import com.example.Ogii.OGII.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "getallLogin", method = RequestMethod.GET)

    public List<Login> getAllLogin() {
        return loginService.getAllLogin();
    }
    @RequestMapping(value = "addLogin",method = RequestMethod.POST)

    public String addLogin(@RequestBody Login login) {
        return loginService.addLogin(login);
    }
}


