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

import us.brianolsen.spring.web.dao.OffersDao;
import us.brianolsen.spring.web.dao.UsersDao;
import us.brianolsen.spring.web.model.Offer;
import us.brianolsen.spring.web.model.User;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:us/brianolsen/spring/web/config/dao-context.xml",
		"classpath:us/brianolsen/spring/web/config/security-context.xml",
		"classpath:us/brianolsen/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class OffersDaoTests {
	
	@Autowired
	private OffersDao offersDao;
	
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
	public void testOffers(){
		User user = new User("brianolsen","password","brianolsen87@gmail.com", "Brian Olsen", true, "user");
		assertTrue("User creation should return true", usersDao.createUser(user));
		
		Offer offer = new Offer(user, "Here's my offer...");
		assertTrue("Offer creation should return true", offersDao.createOffer(offer));
		
		Offer offer2 = new Offer(user, "No really, here's my offer...");
		assertTrue("Offer creation should return true", offersDao.createOffer(offer2));

		List<Offer> offers = offersDao.getOffers();
		List<Offer> userOffers = offersDao.getOffers(user.getUsername());
		
		assertEquals("One offer should exist", 2, offers.size());
		assertEquals("Offers should be the same", offer, offers.get(0));
		assertEquals("Offers should be the same", offer2, offers.get(1));
		
		assertEquals("One offer should exist", 2, userOffers.size());
		assertEquals("Offers should be the same", offer, userOffers.get(0));
		assertEquals("Offers should be the same", offer2, userOffers.get(1));
		
		offer.setId(offers.get(0).getId());
		offer2.setId(offers.get(1).getId());
		
		Offer getOffer = offersDao.getOffer(offer.getId());
		
		assertEquals("Offers should be the same", offer, getOffer);
		
		getOffer = offersDao.getOffer(offer2.getId());
		
		assertEquals("Offers should be the same", offer2, getOffer);
		
		
		
		offersDao.deleteOffer(offer.getId());
		offersDao.deleteOffer(offer2.getId());
		
		offers = offersDao.getOffers();
		assertEquals("Offers list should be empty", 0, offers.size());
	}
}
