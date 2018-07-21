package us.brianolsen.spring.web.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import us.brianolsen.spring.web.dao.UsersDao;
import us.brianolsen.spring.web.model.User;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:us/brianolsen/spring/web/config/dao-context.xml",
		"classpath:us/brianolsen/spring/web/config/security-context.xml",
		"classpath:us/brianolsen/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {
	
	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private DataSource dataSource;
	
	@Before
	public void init(){
		
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");
	}

	@Test
	public void testUsers(){
		User user = new User("brianolsen","password","brianolsen87@gmail.com", "Brian Olsen", true, "user");
		assertTrue("User creation should return true", usersDao.createUser(user));
		
		List<User> users = usersDao.getAllUsers();
		
		assertEquals("One user should exist", 1, users.size());
		assertEquals("Users should be the same", user, users.get(0));
		
		assertTrue("User should exist", usersDao.exists(user.getUsername()));
	}
}
