package com.nirmal.demo;


import com.nirmal.demo.Entity.Person;
import com.nirmal.demo.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class JpaWithJdbcApplicationJDBS implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PersonJdbcDao personJdbcDao;

    public static void main(String[] args) {
        SpringApplication.run(JpaWithJdbcApplicationJDBS.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("All user are -> {} ",personJdbcDao.findAll());
        logger.info("User with id 10001 -> {} ",personJdbcDao.findById(10001));
        logger.info("New User added with name -> {}",personJdbcDao.insert(
                new Person(21,"Ritu","Cuttack",new Date())));
        logger.info("User with id 10006 is deleted -> {}",personJdbcDao.deleteById(10006));

    }
}
