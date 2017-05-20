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

	@Secured({"ROLE_USER","ROLE_ADMIN"})
	public void create(Offer offer) {
		offersDao.createOffer(offer);
	}

	public void throwTestException() {
		offersDao.getOffer(99999);
		
	}
	
}
