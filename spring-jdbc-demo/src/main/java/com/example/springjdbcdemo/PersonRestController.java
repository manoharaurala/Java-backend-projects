package com.example.springjdbcdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

@RestController
@RequestMapping("/person")
public class PersonRestController {
    @Autowired
    PersonService productService;
    @PostMapping
    public ResponseEntity<Person> createProduct(@RequestBody Person person) throws URISyntaxException, SQLException {
        person=productService.addPerson(person);
        URI uri=new URI(("/person/"+person.getId()));
        return ResponseEntity.created(uri).body(person);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable ("id") Integer id){
        Person product=productService.getPersonById(id);
        if(product==null){
            return ResponseEntity.notFound().build();
        }

        return  ResponseEntity.ok(product);
    }

    @PutMapping("{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Integer id,@RequestBody Person person) throws SQLException, URISyntaxException {

    Person person1=productService.updatePerson(id,person);
        URI uri=new URI(("/person/"+person1.getId()));
        return ResponseEntity.created(uri).body(person1);

    }
}
