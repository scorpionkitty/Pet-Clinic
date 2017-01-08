package com.sherlockHomies.web;

import java.util.List;

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
//@RequestMapping("/home")
public class FrontController {
	
	//@Autowired
	private BusinessDelegate businessDelegate;
	
	public void setBusinessDelegate(BusinessDelegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}
	
	/**
	 * Get back a list of all the vets
	 * @return the list of vets
	 */
	@RequestMapping("/vets")
	public List<User> listVets() {
		return businessDelegate.getAllVets();
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
		return businessDelegate.getUserById(id);
	}
	
	/**
	 * 
	 * @param id the id of the user (vet) we will be fetching
	 * @return the user (vet) object
	 */
	@ResponseBody
	@RequestMapping(value="/vet/{param}", method=RequestMethod.GET, produces="application/json")
	public User getVet(@PathVariable(value="param") int id) {
		return businessDelegate.getVetById(id);
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
