package com.example.ormcus;

import com.example.ormcus.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Persistent;

import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@SpringBootApplication
public class OrmCusApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrmCusApplication.class, args);
    }


}
