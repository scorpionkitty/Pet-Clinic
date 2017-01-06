package com.sherlockHomies.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sherlockHomies.beans.User;

@Controller
public class FrontController {
	
	@Autowired
	private Delegate businessDelegate;
	
	public void setBusinessDelegate(Delegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}
	
	@RequestMapping(value={"/home"}, method=RequestMethod.GET)
	public String homePage() {
		//requestDispatcher.forward(req, resp)
		return "home";
	}
	
	/**
	 * 
	 * @param id The id of the user we will be fetching 
	 * @return the User object
	 */
	@ResponseBody
	@RequestMapping(value="/user/{param}", method=RequestMethod.GET, produces="application/json")
	public User getOwner(@PathVariable(value="param") int id) {
		return businessDelegate.getUser(id);
	}
	
	/**
	 * 
	 * @param id the id of the user (vet) we will be fetching
	 * @return the user (vet) object
	 */
	@ResponseBody
	@RequestMapping(value="/vet/{param}", method=RequestMethod.GET, produces="application/json")
	public User getVet(@PathVariable(value="param") int id) {
		return businessDelegate.getVet(id);
	}
	/**
	 * For whenever the user needs to be redirected to the home page 
	 * (in the event of a multi-page application)
	 * @param request
	 * @param response
	 * @return
	 */
	//TODO MAP IN THE CONFIG FILE
	public ModelAndView viewHome(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("homePage");
		
		return model;
	}
	
	
	
	
}
