package com.example.springjdbcdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class PersonDao {
    private static Logger logger=LoggerFactory.getLogger(PersonDao.class);

    @Autowired
   private JdbcTemplate jdbcTemplate;
    public Person getPersonById(int id) {
        Person person = null;
        String prepQuery="select * from person where id="+id;
        Person person=jdbcTemplate.query(prepQuery,new)
        return person;

    }

    public Person createPerson(Person person) throws SQLException {


        return person;
    }

    public Person updatePerson(Integer id,Person person) throws SQLException {

        return person;
    }




}
