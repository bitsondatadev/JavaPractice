package us.brianolsen.spring.web.controller;

import java.security.Principal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import us.brianolsen.spring.web.model.Offer;
import us.brianolsen.spring.web.service.OffersService;

@Controller
public class HomeController {
	private static Logger logger = LogManager.getLogger(HomeController.class);
	
	@Autowired
	private OffersService offersService;

	@RequestMapping("/")
	public String showHome(Model model, Principal principal) {
		logger.info("Showing home page...");

			List<Offer> offers = offersService.getOffers();

			model.addAttribute("offers", offers);
			
			boolean hasOffer = false;
			
			if(principal != null){
				hasOffer = offersService.hasOffer(principal.getName());
			}
			
			model.addAttribute("hasOffer", hasOffer);
			
		return "home";
	}

}
