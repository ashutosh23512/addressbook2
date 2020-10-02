package com.addressbok2.service.impl;
import java.util.Scanner;
import com.addressbook2.dto.AddressBookStructure;
import com.addressbok2.service.PersonService;
public class PersonImpl implements PersonService {
	
private Scanner sc;
	
	
	public PersonImpl(Scanner sc ) {
		this.sc= sc;
	}
	
	public AddressBookStructure createPerson() {
		AddressBookStructure personContact = new AddressBookStructure();
		System.out.print("Enter First Name");
		personContact.setfirstname(sc.next());
		System.out.print("Enter Last Name");
		personContact.setlastname(sc.next());
		System.out.print("Enter Address ");
		personContact.setaddress(sc.next());
		System.out.print("Enter City ");
		personContact.setcity(sc.next());
		System.out.print("Enter State");
		personContact.setstate(sc.next());
		System.out.print("Enter Zip");
		personContact.setzip(sc.next());
		System.out.print("Enter Phone");
		personContact.setphone(sc.nextLine());
		System.out.print("Enter Email");
		personContact.setemail(sc.next());
		return personContact;
	}
	public void displayPerson(AddressBookStructure personContact) {
		
		if(personContact == null) {
			System.out.println("Person Not Found");
			return;
		}
		
		System.out.println(String.format("Person FirstName,%s LastName,%s"
				+ "Address,%s City,%s "
				+ "State,%s Zip,%s "
				+ "Phone %s Email %s",personContact.getfirstname(),personContact.getlastname(),
				personContact.getaddress(),personContact.getcity(),personContact.getstate(),
				personContact.getzip(),personContact.getphone(),personContact.getemail()));
	}


}
