package com.addressbook2.dto;
import java.util.*;
public class AddressBookContact {
	private List<AddressBookStructure> personContacts = new ArrayList<AddressBookStructure>();
	
	
	public List<AddressBookStructure> getAddressBook(){
		 return this.personContacts;
	 }
	public void addContact(AddressBookStructure contactObj) {
		personContacts.add(contactObj);
	 }
	public AddressBookStructure isPerson(String firstName) {
		for(int i=0 ; i<personContacts.size();i++) {
			 if(personContacts.get(i).getfirstname().equalsIgnoreCase(firstName)) {
				 return personContacts.get(i);
				 
			 }
		}
		return null;
	}

}
