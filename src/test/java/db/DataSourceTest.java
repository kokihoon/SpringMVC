package test.java.db;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:webapp/WEB-INF/spring-servlet.xml"})
public class DataSourceTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testConnection() throws Exception {
		try(Connection connection = dataSource.getConnection()) {
			System.out.println(connection);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
