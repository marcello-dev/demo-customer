package com.example.democustomer.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.democustomer.model.Report;

public interface ReportRepository extends CrudRepository<Report, Long> {

    Optional<Report> findFirstByOrderByCreationDateDesc();
}
