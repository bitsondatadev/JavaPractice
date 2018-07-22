package us.brianolsen.spring.web.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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

	private User user1 = new User("brianolsen", "password", "brianolsen87@gmail.com", "Brian Olsen", true, "user");
	private User user2 = new User("johnpurcell", "hellothere", "john@caveofprogramming.com", "John Purcell", true,
			"ROLE_ADMIN");
	private User user3 = new User("silviaardila", "password", "silvia.ardila@gmail.com", "Silvia Ardila", true,
			"ROLE_USER");
	private User user4 = new User("nataliaardila", "hot123456", "natalia.ardila@gmail.com", "Natalia Ardila", false,
			"ROLE_USER");

	Offer offer1 = new Offer(user1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit");
	Offer offer2 = new Offer(user2,
			" esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, ");
	Offer offer3 = new Offer(user2, "Ut enim ad minim veniam, quis nostrud exercitation");
	Offer offer4 = new Offer(user3, "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua");
	Offer offer5 = new Offer(user3, "ullamco laboris nisi ut aliquip ex ea commodo consequat");
	Offer offer6 = new Offer(user3, "Duis aute irure dolor in reprehenderit in voluptate velit");
	Offer offer7 = new Offer(user4, "sunt in culpa qui officia deserunt mollit anim id est laborum.");

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);

		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");

		usersDao.create(user1);
		usersDao.create(user2);
		usersDao.create(user3);
		usersDao.create(user4);
	}

	@Test
	public void testCreateRetrieve() {

		offersDao.saveOrUpdate(offer1);

		List<Offer> offers = offersDao.getOffers();
		assertEquals("Should be one offer.", 1, offers.size());
		assertEquals("Retrived offer should equal offer1.", offer1, offers.get(0));

		offersDao.saveOrUpdate(offer2);
		offersDao.saveOrUpdate(offer3);
		offersDao.saveOrUpdate(offer4);
		offersDao.saveOrUpdate(offer5);
		offersDao.saveOrUpdate(offer6);
		offersDao.saveOrUpdate(offer7);

		offers = offersDao.getOffers();
		assertEquals("Should be six offers for enabled users.", 6, offers.size());
	}

	@Test
	public void testGetByUsername() {

		offersDao.saveOrUpdate(offer1);
		offersDao.saveOrUpdate(offer2);
		offersDao.saveOrUpdate(offer3);
		offersDao.saveOrUpdate(offer4);
		offersDao.saveOrUpdate(offer5);
		offersDao.saveOrUpdate(offer6);
		offersDao.saveOrUpdate(offer7);

		List<Offer> offers = offersDao.getOffers(user3.getUsername());
		assertEquals("Should be three offers for this user.", 3, offers.size());

		offers = offersDao.getOffers("dummy user");
		assertEquals("Should be zero offers for this user.", 0, offers.size());

		offers = offersDao.getOffers(user4.getUsername());
		assertEquals("Should be zero offers for this user.", 0, offers.size());

		offers = offersDao.getOffers(user1.getUsername());
		assertEquals("Should be one offers for this user.", 1, offers.size());
	}

	@Test
	public void testUpdate() {
		offersDao.saveOrUpdate(offer1);
		offersDao.saveOrUpdate(offer2);
		offersDao.saveOrUpdate(offer3);
		offersDao.saveOrUpdate(offer4);
		offersDao.saveOrUpdate(offer5);
		offersDao.saveOrUpdate(offer6);
		offersDao.saveOrUpdate(offer7);

		offer3.setText("This offer has updated text.");
		offersDao.saveOrUpdate(offer3);
		Offer retrievedOffer = offersDao.getOffer(offer3.getId());
		assertEquals("Retrived offer should be updated", offer3, retrievedOffer);
		System.out.println(retrievedOffer);

	}

	@Test
	public void testDelete() {
		offersDao.saveOrUpdate(offer1);
		offersDao.saveOrUpdate(offer2);
		offersDao.saveOrUpdate(offer3);
		offersDao.saveOrUpdate(offer4);
		offersDao.saveOrUpdate(offer5);
		offersDao.saveOrUpdate(offer6);
		offersDao.saveOrUpdate(offer7);

		offersDao.deleteOffer(offer2.getId());
		Offer offerRetrieved = offersDao.getOffer(offer1.getId());
		assertNotNull("Offer with id, " + offer1.getId() + " shouldn't be null.", offerRetrieved);
		offerRetrieved = offersDao.getOffer(offer2.getId());
		assertNull("Offer with id, " + offer2.getId() + " should be null.", offerRetrieved);
	}

	@Test
	public void testGetOfferById() {
		offersDao.saveOrUpdate(offer1);
		offersDao.saveOrUpdate(offer2);
		offersDao.saveOrUpdate(offer3);
		offersDao.saveOrUpdate(offer4);
		offersDao.saveOrUpdate(offer5);
		offersDao.saveOrUpdate(offer6);
		offersDao.saveOrUpdate(offer7);

		Offer offerRetrieved = offersDao.getOffer(offer1.getId());
		assertNotNull("Offer with id, " + offer1.getId() + " shouldn't be null.", offerRetrieved);

		offerRetrieved = offersDao.getOffer(offer2.getId());
		assertNotNull("Offer with id, " + offer2.getId() + " shouldn't be null.", offerRetrieved);

		offerRetrieved = offersDao.getOffer(offer6.getId());
		assertNotNull("Offer with id, " + offer6.getId() + " shouldn't be null.", offerRetrieved);

		offerRetrieved = offersDao.getOffer(offer7.getId());
		assertNull("Offer with id, " + offer7.getId() + " should be null.", offerRetrieved);
	}

	@Test
	public void testOffers() {
		offersDao.saveOrUpdate(offer1);
		offersDao.saveOrUpdate(offer2);

		List<Offer> offers = offersDao.getOffers();
		List<Offer> userOffers = offersDao.getOffers(user1.getUsername());

		assertEquals("Two offers should exist", 2, offers.size());
		assertEquals("Offers should be the same", offer1, offers.get(0));
		assertEquals("Offers should be the same", offer2, offers.get(1));

		assertEquals("One offer should exist", 1, userOffers.size());
		assertEquals("Offers should be the same", offer1, userOffers.get(0));

		offer1.setId(offers.get(0).getId());
		offer2.setId(offers.get(1).getId());

		Offer getOffer = offersDao.getOffer(offer1.getId());

		assertEquals("Offers should be the same", offer1, getOffer);

		getOffer = offersDao.getOffer(offer2.getId());

		assertEquals("Offers should be the same", offer2, getOffer);

		offer1.setText("This is the new offer text for update.");

		offersDao.saveOrUpdate(offer1);

		getOffer = offersDao.getOffer(offer1.getId());

		assertEquals("Offers should be the same", offer1, getOffer);

		offersDao.deleteOffer(offer1.getId());
		offersDao.deleteOffer(offer2.getId());

		offers = offersDao.getOffers();
		assertEquals("Offers list should be empty", 0, offers.size());
	}
}
