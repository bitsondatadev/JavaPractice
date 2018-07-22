package us.brianolsen.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import us.brianolsen.spring.web.dao.OffersDao;
import us.brianolsen.spring.web.model.Offer;

@Service("offersService")
public class OffersService {

	private OffersDao offersDao;

	@Autowired
	public void setOffersDao(OffersDao offersDao) {
		this.offersDao = offersDao;
	}

	public List<Offer> getOffers() {
		return offersDao.getOffers();
	}

	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	public void create(Offer offer) {
		offersDao.saveOrUpdate(offer);
	}

	public void throwTestException() {
		offersDao.getOffer(99999);

	}

	public boolean hasOffer(String name) {

		if (name == null) {
			return false;
		}

		List<Offer> offers = offersDao.getOffers(name);

		if (offers.size() == 0) {
			return false;
		}
		return true;
	}

	public Offer getOffer(String username) {
		if (username == null) {
			return null;
		}

		List<Offer> offers = offersDao.getOffers(username);

		if (offers.size() < 1) {
			return null;
		}
		return offers.get(0);
	}

	public void upsert(Offer offer) {
		offersDao.saveOrUpdate(offer);
	}

	public void delete(int id) {
		offersDao.deleteOffer(id);

	}

}
