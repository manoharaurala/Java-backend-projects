package io.bootify.visitor_app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import java.time.OffsetDateTime;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public class Address {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(name = "address_sequence_gen", sequenceName = "address_sequence", initialValue = 4)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence_gen")

    private Long id;

    @Column(nullable = false)
    private String line1;

    @Column
    private String line2;

    @Column(nullable = false, length = 6)
    private String pincode;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String country;

    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private Set<User> address;



    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

}
