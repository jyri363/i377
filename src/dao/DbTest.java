package dao;

import java.sql.SQLException;

public class DbTest {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		new SetupDao().createSchema();
		new SetupDao().insertSampleData();
	}
}
