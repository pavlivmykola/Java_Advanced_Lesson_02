package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountingMapper {
	public static Accounting map (ResultSet result) throws SQLException {
		int id = result.getInt("id");
		int user_id = result.getInt("user_id");
		int operation_id = result.getInt("operation_id");
		double sum = result.getDouble("sum");
		return new Accounting(id,user_id,operation_id,sum);
	}
}
