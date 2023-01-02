package com.example.rubyjdbc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {


    @Autowired
    PersonDao personDao;



    static List<Person> personList = new ArrayList<>();



    


    public Person addPerson(Person person) throws SQLException {
        return personDao.createPerson(person);


    }

    public List<Person> getPerson(){
        return personList;
    }

    public List<Person> getPersonByName(String name){

        List<Person> result = new ArrayList<>();
        for(Person person: personList){
            if(name.equals(person.getName())){
                result.add(person);
            }
        }
        return result;
    }


    public Person getPersonById(Integer id){


        return  personDao.getPersonById(id);
    }

    public Person updatePerson(Integer id,Person person) throws SQLException {
        return personDao.updatePerson(id, person);
    }
}
