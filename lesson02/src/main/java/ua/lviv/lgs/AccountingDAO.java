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
		this.connection=connection;
	} 
	
	public void insert(Accounting accounting) throws SQLException {
		preparedStatement = connection.prepareStatement(INSERT);
		preparedStatement.setInt(1, accounting.getUser_id());
		preparedStatement.setInt(2, accounting.getOperation_id());
		preparedStatement.setDouble(3, accounting.getSum());
		preparedStatement.executeUpdate();
	}
	
	public Accounting read(int id) throws SQLException {
		preparedStatement=connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return AccountingMapper.map(result);
	} 
	
	public void update(Accounting accounting) throws SQLException {
		preparedStatement=connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setInt(1, accounting.getUser_id());
		preparedStatement.setInt(2, accounting.getOperation_id());
		preparedStatement.setDouble(3, accounting.getSum());
		preparedStatement.setInt(4, accounting.getId());
		preparedStatement.executeUpdate();		
	}
	
	public void delete(Accounting accounting) throws SQLException {
		preparedStatement=connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, accounting.getId());
		preparedStatement.executeQuery();
	}
	
	public List<Accounting> readAll() throws SQLException{
		List<Accounting> listOfAccounting = new ArrayList<>();
		preparedStatement=connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			listOfAccounting.add(AccountingMapper.map(result));
		}
		return listOfAccounting;
	}
}
