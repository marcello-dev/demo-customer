package com.example.democustomer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.democustomer.model.Statistic;
import com.example.democustomer.repo.CustomerRepository;
import com.example.democustomer.repo.StatisticRepository;

@Service
public class StatisticService {
	@Autowired
	private StatisticRepository statisticRepo;
	@Autowired
	private CustomerRepository customerRepo;

	public Statistic getLatestStatistic() {
		return statisticRepo.findFirstByOrderByCreationDateDesc().orElse(null);
	}

	public Long generateStatistic() {
		long totalCustomers = customerRepo.count();
		Statistic statistic = new Statistic(totalCustomers);
		return statisticRepo.save(statistic).getId();
	}
}
