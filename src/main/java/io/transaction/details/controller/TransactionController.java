package io.transaction.details.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.transaction.details.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@RequestMapping(method = RequestMethod.GET, value = "/totalrevenue")
	public Map<String, Double> getRevenue() {
		Map<String, Double> revenue = new HashMap<String, Double>();
		revenue.put("revenue", transactionService.getRevenue());
		return revenue;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/revenue")
	public Map<String, List<Map<String, Double>>> getRevenueByYear() {
		Map<String, List<Map<String, Double>>> revenue = new HashMap<String, List<Map<String, Double>>>();
		revenue.put("revenue", transactionService.getRevenueByYear());
		return revenue;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/arpau")
	public Map<String, List<Map<String, Double>>> getAvgRevenueForUsers() {
		Map<String, List<Map<String, Double>>> avgRev = new HashMap<String, List<Map<String, Double>>>();
		avgRev.put("arpau", transactionService.getAvgRevenueForUsers());
		return avgRev;
	}

	@RequestMapping("/newusercount")
	public Map<String, List<Map<String, Integer>>> getNewUserCount() {
		Map<String, List<Map<String, Integer>>> newUserCnt = new HashMap<String, List<Map<String, Integer>>>();
		newUserCnt.put("newusercount", transactionService.getNewUserCount());
		return newUserCnt;
	}

	@RequestMapping("/activeusers")
	public Map<String, List<Map<String, Integer>>> getActiveUsersCount() {
		Map<String, List<Map<String, Integer>>> activeUserCnt = new HashMap<String, List<Map<String, Integer>>>();
		activeUserCnt.put("activeusercount", transactionService.getActiveUsersCount());
		return activeUserCnt;
	}
}
