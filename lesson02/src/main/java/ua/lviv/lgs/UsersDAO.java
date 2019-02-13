package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {
	static String READ_ALL = "select * from users";
	static String INSERT = "insert into users (first_name,last_name) values (?,?)";
	static String READ_BY_ID = "select * from Users where id=?";
	static String UPDATE_BY_ID = "update users set first_name=?, last_name=? where id=?";
	static String DELETE_BY_ID = "delete from users where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public UsersDAO(Connection connection) {
		this.connection = connection;
	}

	public void insert(Users user) {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, user.getFirst_name());
			preparedStatement.setString(2, user.getLast_name());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
	}

	public Users read(int id) {
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			return UsersMapper.map(result);
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		return null;
	}

	public void update(Users user) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, user.getFirst_name());
			preparedStatement.setString(2, user.getLast_name());
			preparedStatement.setInt(3, user.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
	}

	public void delete(Users user) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.executeQuery();
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
	}

	public List<Users> readAll() {
		List<Users> listOfUsers = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				listOfUsers.add(UsersMapper.map(result));
			}
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		return listOfUsers;
	}
}
