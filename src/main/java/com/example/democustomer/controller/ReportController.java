package com.example.democustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.democustomer.model.Report;
import com.example.democustomer.service.ReportService;

@RestController
public class ReportController {
	@Autowired
	private ReportService reportService;

	@PostMapping("/report")
	public Long generateReport() {
		return reportService.generateReport();
	}

	@GetMapping("/report/latest")
	public Report getLatestReport() {
		return reportService.getLatestReport();
	}
}
