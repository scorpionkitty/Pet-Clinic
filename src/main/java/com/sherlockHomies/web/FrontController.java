package com.sherlockHomies.web;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sherlockHomies.beans.Appointment;
import com.sherlockHomies.beans.Pet;
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
	
	@ResponseBody
    @RequestMapping(value="/pets/{param}", method=RequestMethod.GET, produces="application/json")
    public ResponseEntity<List<Pet>> getPets(@PathVariable(value="param") int userId) {
        return new ResponseEntity<List<Pet>>(businessDelegate.getPetByUserId(userId),HttpStatus.OK);
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
    
    /**
     * Add a new appointment when given an appointment object newAppt
     */
    @RequestMapping(value = "/add" , method = RequestMethod.POST, consumes="application/json")
    public void add(@RequestBody Appointment newAppt) {
    	System.out.println("New appointment: " + newAppt.toString());
    	System.out.println(newAppt.getPet().getOwner().getUserId());
    	System.out.println(newAppt.getVet().getUserId());
    	System.out.println(newAppt.getPet().getPetId());
    	System.out.println(newAppt.getDescription());
    	System.out.println(newAppt.getApptDate().toString());
    	//businessDelegate.insertAppt(userId, vetId, petId, description, apptDate, cardNumber);
    	businessDelegate.insertAppt(newAppt.getPet().getOwner().getUserId(), newAppt.getVet().getUserId(), 
    			newAppt.getPet().getPetId(), newAppt.getDescription(), newAppt.getApptDate());
    }
    
    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public ResponseEntity<User> validate(@RequestParam String username, HttpServletResponse response) throws JsonProcessingException{
    	System.out.println("Before user obj created");
        User user = businessDelegate.findUser(username);
        //response.addCookie(new Cookie("user",new ObjectMapper().writeValueAsString(user)));
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
}
