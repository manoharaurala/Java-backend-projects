package io.bootify.visitor_app.repos;

import  io.bootify.visitor_app.domain.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface VisitorRepository extends JpaRepository<Visitor, Long> {

    @Query(value = "SELECT * FROM visitor WHERE idnumber = :idNumber", nativeQuery = true)
    Optional<Visitor> findOneByIdNumber(@Param("idNumber") String idNumber);

}
