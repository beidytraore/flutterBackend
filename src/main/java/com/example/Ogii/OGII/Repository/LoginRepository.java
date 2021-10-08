package com.example.Ogii.OGII.Repository;

import com.example.Ogii.OGII.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,Integer> {

    boolean existsByEmailAndPassword(String Email, String password);
}
