package com.example.democustomer.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.democustomer.model.Statistic;

public interface StatisticRepository extends CrudRepository<Statistic, Long> {

    Optional<Statistic> findFirstByOrderByCreationDateDesc();
}
