package io.transaction.details.dao;

import java.util.List;
import java.util.Map;

public interface TransactionDao {
	List<Map<String, Double>> getAvgRevenueForUsers();

	List<Map<String, Integer>> getNewUserCount();

	List<Map<String, Integer>> getActiveUsersCount();

	List<Map<String, Double>> getRevenueByYear();

	Double getRevenue();
}
