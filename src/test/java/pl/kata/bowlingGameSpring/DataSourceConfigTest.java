package pl.kata.bowlingGameSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import pl.kata.bowlingGame.repository.GameRepository;
import pl.kata.bowlingGame.repository.JdbcTemplateGameRepository;

@Configuration
public class DataSourceConfigTest {

	public class JdbcTemplateDataSourceCreator {

		@Bean
		public EmbeddedDatabase dataSource() {
			EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
			return builder
					.setType(EmbeddedDatabaseType.H2)
					.setName("ds")
					.addScript("classpath:db/create_table.sql")
					.build();
		}
		
		@Bean
		public GameRepository jdbcTemplateGameRepository(){
			return new JdbcTemplateGameRepository(dataSource());
		}
	}
}
