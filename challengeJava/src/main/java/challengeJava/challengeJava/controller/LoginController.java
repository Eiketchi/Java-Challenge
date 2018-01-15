package challengeJava.challengeJava.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import challengeJava.challengeJava.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    LoginService service;
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String showLoginPage1(ModelMap model){
        return "login";
    }


    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "login";
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password, @RequestParam String Choice){
    	
    	if (Choice.equals("Login"))
    	{    	
	        boolean isValidUser = service.validateUser(name, password);
	       
	        if (!isValidUser) {
	            model.put("errorMessage", "Invalid Credentials");
	            return "login";
	        }
	
	        model.put("name", name);
	        model.put("password", password);
	
	        return "welcome";
    	}else
    	{
    		boolean isValidAdd = service.addUser(name, password);
    		
    		if (!isValidAdd) {
	            model.put("errorMessage", "Email already registered");
	            return "login";
	        }
    		
    		model.put("name", name);
	        model.put("password", password);
    		model.put("msg","you have been registered");
    		return "welcome";
    	}
    	
    }

}