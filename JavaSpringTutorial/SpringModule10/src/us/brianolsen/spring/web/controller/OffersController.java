package us.brianolsen.spring.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping("/offers")
	public String showOffers(Model model) {

		List<Offer> offers = offersService.getOffers();

		model.addAttribute("offers", offers);

		return "offers";
	}

	@RequestMapping("/createOffer")
	public String createOffer(Model model) {
		
		model.addAttribute("offer", new Offer());

		return "createOffer";
	}
	
	@RequestMapping(value = "/doCreate", method = RequestMethod.POST)
	public String doCreateOffer(Model model, @Valid Offer offer, BindingResult result) {
		//offer get's mapped from form objects with same name value as Offer field values (e.g. email, name...)
		//System.out.println(offer);
		
		if(result.hasErrors()){
			//System.out.println("Form is invalid");
			//List<ObjectError> errors = result.getAllErrors();
			//for(ObjectError error : errors){
			//	System.out.println(error.getDefaultMessage());
			//}
			return "createOffer";
		}
		//else{
		//	System.out.println("Form is valid");
		//}
		offersService.create(offer);
		
		return "offerCreated";
	}
	/*
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException ex){
		return "error";
		
	}
	*/

}
