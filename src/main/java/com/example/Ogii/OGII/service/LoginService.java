package com.example.Ogii.OGII.service;

import com.example.Ogii.OGII.Repository.LoginRepository;
import com.example.Ogii.OGII.model.Login;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {
    @Autowired
    LoginRepository loginRepository;

    public List<Login> getAllLogin() {
        try {
            List<Login> logins = loginRepository.findAll();
            List<Login> customLogins = new ArrayList<>();
            logins.stream().forEach(e -> {
                Login login = new Login();
                BeanUtils.copyProperties(e, login);
                customLogins.add(login);
            });
            return customLogins;
        } catch (Exception e) {
            throw e;
        }
    }
    public String addLogin(Login login) {
        try {
            if(!loginRepository.existsByEmailAndPassword(login.getEmail(), login.getPassword())){
                loginRepository.save(login);
                return "Login added Succesfully";
            }else {
                return "This login is already exists in the database";
            }
        }catch (Exception e) {
            throw e;
        }
    }


}