package com.sherlockHomies.interfaces;

import java.util.List;

import com.sherlockHomies.beans.Pet;

public interface PetDAOInterface {
	public List<Pet> getAll();
	
	public void insert(Pet pet);
	
	//mpre as needed
}
