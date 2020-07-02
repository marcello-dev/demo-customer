package com.example.democustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.democustomer.model.Statistic;
import com.example.democustomer.service.StatisticService;

@RestController
public class StatisticController {
	@Autowired
	private StatisticService statisticService;

	@PostMapping("/statistic")
	public Long generateStatistic() {
		return statisticService.generateStatistic();
	}

	@GetMapping("/statistic/latest")
	public Statistic getLatestStatistic() {
		return statisticService.getLatestStatistic();
	}
}
