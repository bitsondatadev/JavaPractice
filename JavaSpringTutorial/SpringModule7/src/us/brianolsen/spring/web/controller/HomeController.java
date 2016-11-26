package us.brianolsen.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showHome(Model model) {
		return "home";
	}
	
//	@RequestMapping("/")
//	public ModelAndView showHome(HttpSession session){
//		
//		//1st way to pass data
//		session.setAttribute("name", "Boris");
//
//		//second way to pass data
//		ModelAndView mv = new ModelAndView("home");
//		Map<String, Object> model = mv.getModel();
//		model.put("name", "River");
//		
//		return mv;
//	}

}
