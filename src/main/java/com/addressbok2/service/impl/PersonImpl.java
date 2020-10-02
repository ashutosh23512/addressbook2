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
		personContact.setphone(sc.next());
		System.out.print("Enter Email");
		personContact.setemail(sc.next());
		return personContact;
	}
	
public void updatePerson(AddressBookStructure personContact) {
		
		while(true) {
			System.out.println("1.) FirstName Update");
			System.out.println("2.) LastName Update");
			System.out.println("3.) Address Update");
			System.out.println("4.) City Update");
			System.out.println("5.) State Update");
			System.out.println("6.) Zip Update");
			System.out.println("7.) Phone Update");
			System.out.println("8.) Email Update");
			System.out.println("9.) Exit");
			int options = sc.nextInt();

			switch (options) {
			case 1:
				System.out.println("Enter New FirstName");
				String newName = sc.nextLine();
					personContact.setfirstname(newName);
				break;
			case 2:
				System.out.println("Enter New LastName");
				String newLastName= sc.nextLine();
				personContact.setlastname(newLastName);

				break;
			case 3:
				System.out.println("Enter New Address");
				String newAddre = sc.nextLine();
				personContact.setaddress(newAddre);

				break;
			case 4:
				System.out.println("Enter New City");
				String newCity = sc.nextLine();
				personContact.setcity(newCity);
				
				break;
			case 5:
				System.out.println("Enter State");
				String newState = sc.nextLine();
				personContact.setstate(newState);

				break;
			case 6:
				System.out.println("Enter New Zip");
				String newZip= sc.nextLine();
				personContact.setzip(newZip);

				break;
			case 7:
				System.out.println("Enter New Phone");
				String newPhone = sc.nextLine();
				personContact.setphone(newPhone);

				break;	
			case 8:
				System.out.println("Enter New Email");
				String newEmail = sc.nextLine();
				personContact.setemail(newEmail);

				break;
			case 9:
				System.out.println("Exit");
				return;
			default:
				System.out.println("INVALID ENTRY");
				break;
			}
		}
		
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
