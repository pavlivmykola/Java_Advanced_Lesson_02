package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JornalsDAO {
	static String READ_ALL = "select * from jornals";
	static String INSERT = "insert into jornals (name,reit,price,description) values (?,?,?,?)";
	static String READ_BY_ID = "select * from jornals where id=?";
	static String UPDATE_BY_ID = "update jornals set name=?, reit=?,price=?,description=? where id=?";
	static String DELETE_BY_ID = "delete from jornals where id=?";
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	
	public JornalsDAO(Connection connection) {
		this.connection=connection;
	} 
	
	public void insert(Jornals jornal) throws SQLException {
		preparedStatement = connection.prepareStatement(INSERT);
		preparedStatement.setString(1, jornal.getName());
		preparedStatement.setInt(2, jornal.getReit());
		preparedStatement.setDouble(3, jornal.getPrice());
		preparedStatement.setString(4, jornal.getDescription());
		preparedStatement.executeUpdate();
	}
	
	public Jornals read(int id) throws SQLException {
		preparedStatement=connection.prepareStatement(READ_BY_ID);
		preparedStatement.setInt(1, id);
		ResultSet result = preparedStatement.executeQuery();
		result.next();
		return JornalsMapper.map(result);
	} 
	
	public void update(Jornals jornal) throws SQLException {
		preparedStatement=connection.prepareStatement(UPDATE_BY_ID);
		preparedStatement.setString(1, jornal.getName());
		preparedStatement.setInt(2, jornal.getReit());
		preparedStatement.setDouble(3, jornal.getPrice());
		preparedStatement.setString(4, jornal.getDescription());
		preparedStatement.setInt(5, jornal.getId());
		preparedStatement.executeUpdate();		
	}
	
	public void delete(Jornals jornal) throws SQLException {
		preparedStatement=connection.prepareStatement(DELETE_BY_ID);
		preparedStatement.setInt(1, jornal.getId());
		preparedStatement.executeQuery();
	}
	
	public List<Jornals> readAll() throws SQLException{
		List<Jornals> listOfJornals = new ArrayList<>();
		preparedStatement=connection.prepareStatement(READ_ALL);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			listOfJornals.add(JornalsMapper.map(result));
		}
		return listOfJornals;
	}
}
