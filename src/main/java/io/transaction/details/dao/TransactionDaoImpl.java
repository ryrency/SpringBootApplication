package io.transaction.details.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("mysql")
public class TransactionDaoImpl implements TransactionDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Double>> getAvgRevenueForUsers() {

		String sql = "select  user, avg(sales_amount) as avg_sales " + "from transaction_details " + "group by user "
				+ "order by avg(sales_amount) desc;";
		return jdbcTemplate.query(sql, new RowMapper<Map<String, Double>>() {

			@Override
			public Map<String, Double> mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Map<String, Double> avgRevenue = new HashMap<>();
				avgRevenue.put(resultSet.getString("user"), resultSet.getDouble("avg_sales"));
				return avgRevenue;
			}

		});
	}

	public List<Map<String, Integer>> getNewUserCount() {
		String sql = "Select  Year(join_date) as yr_of_join, count(*) as no_of_users\n" + "From transaction_details\n"
				+ "Where Year(join_date) IN (select Year(join_date) from transaction_details group by Year(join_date))\n"
				+ "group by Year(join_date);";

		return jdbcTemplate.query(sql, new RowMapper<Map<String, Integer>>() {

			@Override
			public Map<String, Integer> mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Map<String, Integer> userCnt = new HashMap<>();
				userCnt.put(resultSet.getString("yr_of_join"), resultSet.getInt("no_of_users"));
				return userCnt;
			}

		});
	}

	public List<Map<String, Integer>> getActiveUsersCount() {
		String sql = "Select  Year(transaction_date) as yr_of_transaction, count(*) as no_of_users\n"
				+ "From transaction_details\n"
				+ "Where Year(transaction_date) IN (select  Year(transaction_date) from transaction_details group by  Year(transaction_date))\n"
				+ "group by Year(transaction_date);";

		return jdbcTemplate.query(sql, new RowMapper<Map<String, Integer>>() {

			@Override
			public Map<String, Integer> mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Map<String, Integer> activeUserCnt = new HashMap<>();
				activeUserCnt.put(resultSet.getString("yr_of_transaction"), resultSet.getInt("no_of_users"));
				return activeUserCnt;
			}

		});
	}

	@Override
	public Double getRevenue() {
		String sql = "select sum(sales_amount)\n" + "from transaction_details";
		return jdbcTemplate.queryForObject(sql, Double.class);
	}

	@Override
	public List<Map<String, Double>> getRevenueByYear() {
		String sql = "select Year(transaction_date) as yr_of_revenue, sum(sales_amount) as total_sale\n"
				+ "From transaction_details\n"
				+ "Where Year(transaction_date) IN (select Year(transaction_date) from transaction_details group by Year(transaction_date))\n"
				+ "group by Year(transaction_date);";
		return jdbcTemplate.query(sql, new RowMapper<Map<String, Double>>() {

			@Override
			public Map<String, Double> mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				Map<String, Double> reveueByYear = new HashMap<>();
				reveueByYear.put(resultSet.getString("yr_of_revenue"), resultSet.getDouble("total_sale"));
				return reveueByYear;
			}

		});
	}

}
