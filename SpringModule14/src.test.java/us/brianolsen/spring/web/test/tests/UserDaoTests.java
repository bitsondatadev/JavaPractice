package us.brianolsen.spring.web.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

	private User user1 = new User("brianolsen", "password", "brianolsen87@gmail.com", "Brian Olsen", true, "user");
	private User user2 = new User("johnpurcell", "hellothere", "john@caveofprogramming.com", "John Purcell", true,
			"ROLE_ADMIN");
	private User user3 = new User("silviaardila", "password", "silvia.ardila@gmail.com", "Silvia Ardila", true,
			"ROLE_USER");
	private User user4 = new User("nataliaardila", "hot123456", "natalia.ardila@gmail.com", "Natalia Ardila", false,
			"ROLE_USER");

	@Before
	public void init() {

		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");
	}

	@Test
	public void testCreateRetrieve() {
		usersDao.create(user1);

		List<User> users = usersDao.getAllUsers();

		assertEquals("One user should have been created and retrieved", 1, users.size());

		assertEquals("Inserted user should match retrived", user1, users.get(0));

		usersDao.create(user2);
		usersDao.create(user3);
		usersDao.create(user4);

		users = usersDao.getAllUsers();

		assertEquals("Four user should have been created and retrieved", 4, users.size());
	}

	@Test
	public void testExists() {
		usersDao.create(user1);
		usersDao.create(user2);
		usersDao.create(user3);
		assertTrue("User should exist", usersDao.exists(user1.getUsername()));
		assertTrue("User should exist", usersDao.exists(user2.getUsername()));
		assertFalse("User shouldn't exist", usersDao.exists(user4.getUsername()));
	}

}
