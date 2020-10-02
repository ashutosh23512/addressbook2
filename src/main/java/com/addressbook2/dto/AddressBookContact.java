package com.addressbook2.dto;
import java.util.*;
public class AddressBookContact {
	private List<AddressBookStructure> personContacts = new ArrayList<AddressBookStructure>();
	private String name;
	
	public List<AddressBookStructure> getAddressBook(){
		 return this.personContacts;
	 }
	public void addContact(AddressBookStructure contactObj) {
		personContacts.add(contactObj);
	 }
	public AddressBookContact(String name) {
		this.name = name;
		personContacts= new ArrayList<AddressBookStructure>();
	}
	public AddressBookStructure isPerson(String firstName) {
		for(int i=0 ; i<personContacts.size();i++) {
			 if(personContacts.get(i).getfirstname().equalsIgnoreCase(firstName)) {
				 return personContacts.get(i);
				 
			 }
		}
		return null;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		}
	public void  deletePerson(String firstName) {
		for(int i=0 ; i<personContacts.size();i++) {
			 if(personContacts.get(i).getfirstname().equalsIgnoreCase(firstName)) {
				 	personContacts.remove(i);
				 	System.out.println("Person Deleted");
				 	return;
			 }
		}
	}

}
