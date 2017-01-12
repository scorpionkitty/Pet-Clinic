package com.sherlockHomies.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sherlockHomies.beans.Appointment;
import com.sherlockHomies.beans.User;

@Controller
public class FrontController {
	
	@Autowired
	private BusinessDelegate businessDelegate;
	
	public void setBusinessDelegate(BusinessDelegate businessDelegate) {
		this.businessDelegate = businessDelegate;
	}
/*	
	*//**
	 * Used to log in TODO
	 *//*
	@ResponseBody
	@RequestMapping(value={"/login"}, method={RequestMethod.POST}, consumes={"application/json"}, produces={"application/json"})
	public String login(@RequestBody User user, HttpSession session){
		user = businessDelegate.findUser(user.getUsername());
		session.setAttribute("user", user);
		if(user == null)
			return "{ \"result\" : \"failure\" }";
		else return "{ \"result\" : \"success\" }";
	}
	
	*//**
	 * Used to 
	 *//*
	@ResponseBody
	@RequestMapping(value={"/user"}, method={RequestMethod.GET}, produces={"application/json"})
	public User getUser(HttpSession session) {
		session.getAttribute("user").getClass();
		return (User)session.getAttribute("user_obj"); 
	}

	@RequestMapping(value={"/logout"}, method={RequestMethod.GET})
	public void logout(HttpSession session) {
		session.setAttribute("user", null);
	}
*/
	
	/**
	 * Returns the home.html for the pet owner to view
	 */
/*	@ResponseBody
	@RequestMapping(value={"/owner"}, method=RequestMethod.GET, produces="application/json")
	public String ownerHomePage() {
		User owner = businessDelegate.getUserById(1);
		businessDelegate.apptOfOwner(owner);
		return "home";
	}*/
	  
	/**
	 * Used to return a user object when given the user Id
	 */
/*	@ResponseBody
	@RequestMapping(value="/user/{param}", method=RequestMethod.GET, produces="application/json")
	public User getUser(@PathVariable(value="param") int id) {
		return businessDelegate.getUserById(id);
	}*/

	@RequestMapping(value="/user/{param}", method=RequestMethod.GET, produces="application/json")
	public String getUser(@PathVariable(value="param") int id) {
		businessDelegate.getUserById(id);
		return "home";
	}
	
/*	@ResponseBody
	@RequestMapping(value="/user/{param}", method=RequestMethod.GET, produces="application/json")
	public User getUserByUsername(@PathVariable(value="param") String username) {
		return businessDelegate.getUserByUsername(username);
	}*/
	
	/**
	 * Used to return a list of all the vets
	 */
/*	@ResponseBody
	@RequestMapping(value="/vets", method=RequestMethod.GET, produces="application/json")
	public List<User> listVets() {
		return businessDelegate.getAllVets();
	}*/
	
	@ResponseBody
    @RequestMapping(value="/vets", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<List<User>> listVets() {
        return new ResponseEntity<List<User>>(businessDelegate.getAllVets(),HttpStatus.OK);
    }
	
	/**
	 * Used to return a list of all the vets
	 */
/*	@ResponseBody
	@RequestMapping(value="/vets", method=RequestMethod.GET, produces="application/json")
	public List<User> listVetsOfASpecialty(String petType) {
		return businessDelegate.getVetsOfASpecialty(petType); TODO
	}*/
	
/*	@ResponseBody
    @RequestMapping(value="/appt/{param}", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<List<Appointment>> listAppt(@PathVariable(value="param") int id) {
        return new ResponseEntity<List<Appointment>>(businessDelegate.getApptById(id),HttpStatus.OK);
    }*/
	
	@ResponseBody
    @RequestMapping(value="/{param}/completedAppts", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<List<Appointment>> upcomingAppts(@PathVariable(value="param") int ownerId) {
        return new ResponseEntity<List<Appointment>>(businessDelegate.getUpcoming(ownerId),HttpStatus.OK);
    }
}
