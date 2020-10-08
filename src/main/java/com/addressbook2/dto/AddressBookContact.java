package com.addressbook2.dto;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AddressBookContact {
	static List<AddressBookStructure> personContacts = new ArrayList<AddressBookStructure>();
	private String name;
	
	public List<AddressBookStructure> getAddressBook(){
		 return this.personContacts;
	 }
	public void addContact(AddressBookStructure contactObj) {
		personContacts.add(contactObj);
	 }
	
	public boolean checkname(String fname) {
		return personContacts.stream().anyMatch(x -> x.getfirstname().equalsIgnoreCase(fname));
			
	}

	public AddressBookContact() {
		
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
	public List<AddressBookStructure> sortcontact(){
		return personContacts.stream().sorted((n1, n2) -> n1.getfirstname().compareTo(n2.getfirstname())).collect(Collectors.toList());
	}
	public List<AddressBookStructure> sortcity(){
		return personContacts.stream().sorted((n1,n2) -> n1.getcity().compareTo(n2.getcity())).collect(Collectors.toList());
	}
	
	public List<AddressBookStructure> sortstate(){
		return personContacts.stream().sorted((n1,n2) -> n1.getstate().compareTo(n2.getstate())).collect(Collectors.toList());
	}
	
	public List<AddressBookStructure> sortzip(){
		return personContacts.stream().sorted((n1,n2) -> n1.getzip().compareTo(n2.getzip())).collect(Collectors.toList());
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
