package io.bootify.visitor_app.repos;


import io.bootify.visitor_app.domain.Flat;
import io.bootify.visitor_app.domain.Visit;
import io.bootify.visitor_app.domain.Visitor;
import io.bootify.visitor_app.model.VisitStatus;
import io.bootify.visitor_app.model.VisitorDTO;
import io.bootify.visitor_app.model.VistDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface VistRepository extends JpaRepository<Visit, Long> {

    @Query(value = "SELECT * FROM visit WHERE flat_id = :flatid AND status = :status", nativeQuery = true)
    public List<Visit> findByFlatAndStatus(@Param("flatid") Long flatId, @Param("status") String status);
}
