package us.brianolsen.spring.web.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private static Logger logger = LogManager.getLogger(HomeController.class);

	@RequestMapping("/")
	public String showHome(Model model) {
		logger.info("Showing home page...");
		return "home";
	}

}
