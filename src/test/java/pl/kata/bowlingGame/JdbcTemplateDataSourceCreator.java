package pl.kata.bowlingGame;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;


public class JdbcTemplateDataSourceCreator {


	public static DataSource createEmbeddedDatabase(){
		EmbeddedDatabase builder = new EmbeddedDatabaseBuilder()
				 .generateUniqueName(true)
			     .setType(EmbeddedDatabaseType.H2)
			     .setScriptEncoding("UTF-8")
			     .ignoreFailedDrops(true)
			     .addScript("classpath:db/create_table.sql")
			     .build();
		return builder;
	}
	
}
