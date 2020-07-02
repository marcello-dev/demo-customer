package com.example.democustomer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.democustomer.model.Report;
import com.example.democustomer.repo.CustomerRepository;
import com.example.democustomer.repo.ReportRepository;

@Service
public class ReportService {
	@Autowired
	private ReportRepository reportRepository;
	@Autowired
	private CustomerRepository customerRepository;

	public Report getLatestReport() {
		return reportRepository.findFirstByOrderByCreationDateDesc().orElse(null);
	}

	public Long generateReport() {
		long totalCustomers = customerRepository.count();
		Report report = new Report(totalCustomers);
		return reportRepository.save(report).getId();
	}
}
