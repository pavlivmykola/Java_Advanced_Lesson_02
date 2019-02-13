package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionsDAO {
	static String READ_ALL = "select * from subscription";
	static String INSERT = "insert into subscription (user_id,jornal_id,start,end) values (?,?,?,?)";
	static String READ_BY_ID = "select * from subscription where id=?";
	static String UPDATE_BY_ID = "update subscription set user_id=?, jornal_id=?, start=?, end=? where id=?";
	static String DELETE_BY_ID = "delete from subscription where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public SubscriptionsDAO(Connection connection) {
		this.connection = connection;
	}

	public void insert(Subscriptions subscription) {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setInt(1, subscription.getUser_id());
			preparedStatement.setInt(2, subscription.getJornal_id());
			preparedStatement.setDate(3, subscription.getStart());
			preparedStatement.setDate(4, subscription.getEnd());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
	}

	public Subscriptions read(int id) {
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			return SubscriptionsMapper.map(result);
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		return null;
	}

	public void update(Subscriptions subscription) {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setInt(1, subscription.getUser_id());
			preparedStatement.setInt(2, subscription.getJornal_id());
			preparedStatement.setDate(3, subscription.getStart());
			preparedStatement.setDate(4, subscription.getEnd());
			preparedStatement.setInt(5, subscription.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
	}

	public void delete(Subscriptions subscription) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, subscription.getId());
			preparedStatement.executeQuery();
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
	}

	public List<Subscriptions> readAll() {
		List<Subscriptions> listOfSubscriptions = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				listOfSubscriptions.add(SubscriptionsMapper.map(result));
			}
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		return listOfSubscriptions;
	}
}
