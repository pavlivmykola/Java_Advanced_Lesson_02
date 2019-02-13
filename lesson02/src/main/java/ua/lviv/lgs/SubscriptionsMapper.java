package ua.lviv.lgs;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubscriptionsMapper {
	public static Subscriptions map(ResultSet result) {
		try {
			int id = result.getInt("id");
			int user_id = result.getInt("user_id");
			int jornal_id = result.getInt("jornal_id");
			Date start = result.getDate("start");
			Date end = result.getDate("end");
			return new Subscriptions(id, user_id, jornal_id, start, end);
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		return null;
	}
}
