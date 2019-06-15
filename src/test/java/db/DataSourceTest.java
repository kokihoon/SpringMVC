package test.java.db;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import main.java.com.kokihoon.controller.BoardController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:webapp/WEB-INF/root-context.xml"})
public class DataSourceTest {
	
	private static final Logger logger =LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testConnection() throws Exception {
		try(Connection connection = dataSource.getConnection()) {
			System.out.println(connection);
			logger.info("연결되었습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
