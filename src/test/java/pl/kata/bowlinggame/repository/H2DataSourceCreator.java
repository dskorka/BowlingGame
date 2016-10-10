package pl.kata.bowlinggame.repository;

import java.util.Random;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcDataSource;

public class H2DataSourceCreator {

	public static DataSource create() {
		JdbcDataSource ds = new JdbcDataSource();

		Random ran = new Random();
		int test = ran.nextInt(10000);
		String DB_CONNECTION = "jdbc:h2:mem:test" + test
				+ ";INIT=RUNSCRIPT FROM 'classpath:db/create_table.sql';DB_CLOSE_DELAY=-1"; // DB_CLOSE_ON_EXIT=FALSE
		ds.setURL(DB_CONNECTION);
	
		return ds;
	}
}