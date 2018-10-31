package io.transaction.details.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.transaction.details.dao.TransactionDao;

@Service
public class TransactionService {

	@Autowired
	@Qualifier("mysql")
	private TransactionDao transactionDao;

	public List<Map<String, Double>> getAvgRevenueForUsers() {
		return transactionDao.getAvgRevenueForUsers();
	}

	public List<Map<String, Integer>> getNewUserCount() {
		return transactionDao.getNewUserCount();
	}

	public List<Map<String, Integer>> getActiveUsersCount() {
		return transactionDao.getActiveUsersCount();
	}

	public List<Map<String, Double>> getRevenueByYear() {
		return transactionDao.getRevenueByYear();
	}

	public Double getRevenue() {
		return transactionDao.getRevenue();
	}
}
