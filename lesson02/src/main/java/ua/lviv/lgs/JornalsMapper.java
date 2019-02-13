package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JornalsMapper {
	public static Jornals map(ResultSet result) {
		try {
			int id = result.getInt("id");
			String name = result.getString("name");
			int reit = result.getInt("reit");
			String description = result.getString("description");
			double price = result.getDouble("price");
			return new Jornals(id, name, reit, price, description);
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		return null;
	}
}
