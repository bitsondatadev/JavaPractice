package us.brianolsen.spring.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import us.brianolsen.spring.web.dao.FormValidationGroup;
import us.brianolsen.spring.web.model.Offer;
import us.brianolsen.spring.web.service.OffersService;

@Controller
public class OffersController {

	private OffersService offersService;

	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String showTest(Model model, @RequestParam("id") String id) {
		System.out.println("id is: " + id);
		return "home";
	}

	@RequestMapping("/createoffer")
	public String createOffer(Model model, Principal principal) {
		Offer offer = null;

		if (principal.getName() != null) {
			String username = principal.getName();
			offer = offersService.getOffer(username);
		}

		if (offer == null) {
			offer = new Offer();
		}

		model.addAttribute("offer", offer);

		return "createoffer";
	}

	@RequestMapping(value = "/doCreate", method = RequestMethod.POST)
	public String doCreateOffer(Model model, /* @Valid */ @Validated(FormValidationGroup.class) Offer offer,
			BindingResult result, Principal principal,
			@RequestParam(value = "delete", required = false) String delete) {

		if (result.hasErrors()) {
			return "createoffer";
		}

		if (delete == null) {
			String username = principal.getName();

			offer.getUser().setUsername(username);

			offersService.upsert(offer);
			// offersService.create(offer);

			return "offercreated";
		} else {
			offersService.delete(offer.getId());

			return "offerdeleted";
		}
	}

}
