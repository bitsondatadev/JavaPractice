package us.brianolsen.spring.web.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import us.brianolsen.spring.web.dao.FormValidationGroup;
import us.brianolsen.spring.web.model.Message;
import us.brianolsen.spring.web.model.User;
import us.brianolsen.spring.web.service.UsersService;

@Controller
public class LoginController {

	private UsersService usersService;

	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}

	@RequestMapping("/denied")
	public String showDenied() {
		return "denied";
	}

	@RequestMapping("/messages")
	public String showMessages() {
		return "messages";
	}

	@RequestMapping("/admin")
	public String showAdmin(Model model) {
		List<User> users = usersService.getAllUsers();

		model.addAttribute("users", users);

		return "admin";
	}

	@RequestMapping("/newaccount")
	public String showNewAccount(Model model) {
		model.addAttribute("user", new User());
		return "newaccount";
	}

	@RequestMapping("/loggedout")
	public String showLoggedOut(Model model) {
		return "loggedout";
	}

	@RequestMapping(value = "/createaccount", method = RequestMethod.POST)
	public String createAccount(/* @Valid */@Validated(FormValidationGroup.class) User user, BindingResult result) {

		if (result.hasErrors()) {
			return "newaccount";
		}

		user.setEnabled(true);
		user.setAuthority("ROLE_USER");

		String fieldPath = "username";
		String errorCode = "DuplicateKey.user.username";

		if (usersService.exists(user.getUsername())) {
			result.rejectValue(fieldPath, errorCode);
			return "newaccount";
		}

		try {
			usersService.create(user);
		} catch (DuplicateKeyException e) {
			result.rejectValue(fieldPath, errorCode);
			return "newaccount";
		}

		return "accountcreated";
	}

	@RequestMapping(value = "/getmessages", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Map<String, Object> getMessages(Principal principal) {
		List<Message> messages = null;
		if (principal == null) {
			messages = new ArrayList<>();
		} else {
			String username = principal.getName();
			messages = usersService.getMessages(username);
		}

		Map<String, Object> data = new HashMap<>();
		data.put("messages", messages);
		data.put("number", messages.size());

		return data;
	}

	@RequestMapping(value = "/sendmessage", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Map<String, Object> sendMessage(Principal principal, @RequestBody Map<String, Object> data) {
		Map<String, Object> returnObject = new HashMap<>();

		String text = (String) data.get("text");
		String name = (String) data.get("name");
		String email = (String) data.get("email");
		Integer target = (Integer) data.get("target");

		returnObject.put("success", true);
		returnObject.put("target", target);
		System.out.println(StringUtils.join(new String[] { text, name, email }, ':'));

		return returnObject;
	}
}
