package com.example.democustomer.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Report {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private @Id Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    private long totalCustomers;

    public Report(long totalCustomers) {
        this.creationDate = new Date();
        this.totalCustomers = totalCustomers;
    }
}
