package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application {


	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		JornalsDAO jornalDAO = new JornalsDAO(ConnectionUtils.openConnecton());
		jornalDAO.readAll().forEach(System.out::println);
		
	}

}
