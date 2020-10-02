package com.addressbok2.service;

import com.addressbook2.dto.AddressBookStructure;

public interface PersonService {

	public AddressBookStructure createPerson();
			
	public void displayPerson(AddressBookStructure personContact);
	
	public void updatePerson(AddressBookStructure personContact);


}
