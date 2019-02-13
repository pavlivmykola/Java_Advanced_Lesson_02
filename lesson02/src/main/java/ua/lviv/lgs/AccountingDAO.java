package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountingDAO {
	static String READ_ALL = "select * from accounting";
	static String INSERT = "insert into accounting (user_id,operation_id,sum) values (?,?,?)";
	static String READ_BY_ID = "select * from accounting where id=?";
	static String UPDATE_BY_ID = "update accounting set user_id=?, operation_id=?, sum=? where id=?";
	static String DELETE_BY_ID = "delete from accounting where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public AccountingDAO(Connection connection) {
		this.connection = connection;
	}

	public void insert(Accounting accounting) {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setInt(1, accounting.getUser_id());
			preparedStatement.setInt(2, accounting.getOperation_id());
			preparedStatement.setDouble(3, accounting.getSum());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
	}

	public Accounting read(int id) {
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			return AccountingMapper.map(result);
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		return null;
	}

	public void update(Accounting accounting) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setInt(1, accounting.getUser_id());
			preparedStatement.setInt(2, accounting.getOperation_id());
			preparedStatement.setDouble(3, accounting.getSum());
			preparedStatement.setInt(4, accounting.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
	}

	public void delete(Accounting accounting) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, accounting.getId());
			preparedStatement.executeQuery();
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
	}

	public List<Accounting> readAll() {
		List<Accounting> listOfAccounting = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				listOfAccounting.add(AccountingMapper.map(result));
			}
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		return listOfAccounting;

	}
}
