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

	/**
	 * Returns home.html
	 */
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String getHomepage() {
		return "home";
	}
	
	/**
	 * Returns the JSON of all the vets
	 */
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
	
	
	/**
	 * Returns the JSON of upcoming appointments of an owner when given ownerId as {param}
	 * Example: http://localhost:9090/PetClinic/3/upcomingAppts
	 */
	@ResponseBody
    @RequestMapping(value="/{param}/upcomingAppts", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<List<Appointment>> upcomingAppts(@PathVariable(value="param") int ownerId) {
        return new ResponseEntity<List<Appointment>>(businessDelegate.getUpcoming(ownerId),HttpStatus.OK);
    }
	
	/**
	 * Returns the JSON of completed appointments of an owner when given ownerId as {param}
	 * Example: http://localhost:9090/PetClinic/3/completedAppts
	 */
	@ResponseBody
    @RequestMapping(value="/{param}/completedAppts", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<List<Appointment>> completedAppts(@PathVariable(value="param") int ownerId) {
        return new ResponseEntity<List<Appointment>>(businessDelegate.getCompleted(ownerId),HttpStatus.OK);
    }
	
	/**
	 * Returns the JSON of a specific user when given the user id
	 */
	@ResponseBody
    @RequestMapping(value="/user/{param}", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<User> getUser(@PathVariable(value="param") int userId) {
        return new ResponseEntity<User>(businessDelegate.getUserById(userId),HttpStatus.OK);
    }
    
    /**
     * Returns the JSON of a specific user when given the user's username
     * Example: http://localhost:9090/PetClinic/username/pusheen
     */
    @ResponseBody
    @RequestMapping(value="/username/{param}", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<User> getUserByUsername(@PathVariable(value="param") String username) {
        return new ResponseEntity<User>(businessDelegate.findUser(username),HttpStatus.OK);
    }
}
