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
import us.brianolsen.spring.web.model.Offer;

@ActiveProfiles("dev")
@ContextConfiguration(locations = { "classpath:us/brianolsen/spring/web/config/dao-context.xml",
		"classpath:us/brianolsen/spring/web/config/security-context.xml",
		"classpath:us/brianolsen/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class OffersDaoTests {
	
	@Autowired
	private OffersDao offersDao;
	
	@Autowired
	private DataSource dataSource;
	
	@Before
	public void init(){
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		
		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");
		jdbc.execute("delete from authorities");
		
	}

	@Test
	public void testCreateUser(){
		Offer offer = new Offer("brianolsen offer", "brianolsen87@gmail.com", "Here's my offer...");
		assertTrue("Offer creation should return true", offersDao.createOffer(offer));
		
		List<Offer> offers = offersDao.getOffers();
		
		assertEquals("One offer should exist", 1, offers.size());
		assertEquals("Offers should be the same", offer, offers.get(0));
		
		offer.setId(offers.get(0).getId());
		
		Offer getOffer = offersDao.getOffer(offer.getId());
		
		assertEquals("Offers should be the same", offer, getOffer);
		
		
		
		offersDao.deleteOffer(offer.getId());
		
		offers = offersDao.getOffers();
		assertEquals("Offers list should be empty", 0, offers.size());
	}
}
