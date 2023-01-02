package com.example.rubyjdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class PersonDao {
    private static Logger logger=LoggerFactory.getLogger(PersonDao.class);
    public Person getPersonById(int id) {
        Person person = null;
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/ruby", "ruby", "ruby");
         //   Statement statement = connection.createStatement();
           // String query = "select * from person where id=" + id;
            //ResultSet rs = statement.executeQuery(query);
            // String prepQuery="select * from person where id=? and name=?";
            String prepQuery="select * from person where id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(prepQuery);
            preparedStatement.setInt(1,id);

            ResultSet rs= preparedStatement.executeQuery();


            while (rs.next()) {
                person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setEmail(rs.getString("email"));
                person.setPhone(rs.getString("phone"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;

    }

    public Person createPerson(Person person) throws SQLException {
      //  String insertquery="INSERT INTO person(name,email,phone) values('"+person.getName()+"','"+person.getEmail()+"','"+person.getPhone()+"')";
        Connection connection=null;
        try {
             connection= DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/ruby", "ruby", "ruby");
           // Statement statement = connection.createStatement();
           // String insertquery="INSERT INTO person(name,email,phone) values('"+person.getName()+"','"+person.getEmail()+"','"+person.getPhone()+"')";

          //  boolean status = statement.execute(insertquery);

            String prepQuery="INSERT INTO person(name,email,phone) values(?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(prepQuery);
            preparedStatement.setString(1,person.getName());
            preparedStatement.setString(2,person.getEmail());
            preparedStatement.setString(3, person.getPhone());
            preparedStatement.execute();




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            connection.close();
        }
        return person;
    }

    public Person updatePerson(Integer id,Person person) throws SQLException {
        Connection connection=null;
        boolean autoComit=false;
        try
        {
            connection=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/ruby", "ruby", "ruby");
            autoComit=connection.getAutoCommit();
            connection.setAutoCommit(false);

            String updateQuery="update person set name=?,email=?,phone=? where id=?";
            PreparedStatement preparedStatement=connection.prepareStatement(updateQuery);

            preparedStatement.setString(1,person.getName());
            preparedStatement.setString(2,person.getEmail());
            preparedStatement.setString(3, person.getPhone());
            preparedStatement.setInt(4,id);
            preparedStatement.executeUpdate();
            connection.commit();


        }
        catch (SQLException e){
            if(connection!=null) {
                connection.rollback();
            }
            e.printStackTrace();
        }
        finally {
            connection.setAutoCommit(autoComit);
           connection.close();
        }
        return person;
    }


    /*
    single APi
    //transaction
    start
    -update address
    -update person
    end
    fine:commit
    error:rollback
     */

}
