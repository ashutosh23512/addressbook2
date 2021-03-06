package com.addressbok2.service.impl;
import com.addressbook2.dto.*;
import com.addressbok2.service.*;
import java.util.*;

public class AdressBookImpl implements AddressBookService {
	private AddressBookContact addressBook;
	private PersonService personService;
	private Scanner sc;
	
	public AdressBookImpl(Scanner sc) {
		this.sc = sc;
	}
	public void showOptions(AddressBookContact addressBook){
		this.addressBook = addressBook;
		personService = new PersonImpl(this.sc);
		while(true) {
		System.out.println("Option For Address Book");

		System.out.println("1.) Find A Person");
		System.out.println("2.) Create A Person");
		System.out.println("3.) Edit A Person");
		System.out.println("4.) Delete A Person");
		System.out.println("5.) Show Sorted Contacts");
		System.out.println("6.) Show Sorted Contacts by city");
		System.out.println("7.) Show Sorted Contacts by state");
		System.out.println("8.) Show Sorted zip");
		System.out.println("9.) Exit");

		
		int option = sc.nextInt();
		switch(option) {	
		
		case 1:
			findAPerson();
			break;
		case 2:
			createAPerson();		
			break;
		case 3:
			updateAPerson();
			break;
		case 4:
			deleteAPerson();
			break;
		case 5:
			System.out.println(addressBook.sortcontact());
			break;
		case 6:
			System.out.println(addressBook.sortcity());
			break;
		case 7:
			System.out.println(addressBook.sortstate());
			break;
		case 8:
			System.out.println(addressBook.sortzip());
			break;
		case 9:
			return;
		default:
			System.out.println("Invalid Input");
			break;
		
		
		}
	}
	}
	@Override
	public void findAPerson() {
		System.out.println("Enter Person Name");
		Scanner d = new Scanner(System.in);
		String name = d.nextLine(); 
		personService.displayPerson(addressBook.isPerson(name));
		
	}
	public void createAPerson(){
		addressBook.addContact(personService.createPerson());
	}
	public void display() {
		addressBook.getAddressBook();
	}
	
	@Override
	public void updateAPerson() {
		System.out.println("Enter Person Name");
		String name = sc.next();
		AddressBookStructure person = addressBook.isPerson(name);
		if(Objects.nonNull(person)) {
			personService.updatePerson(person);
			return;
		}
		System.out.println("Person Not Found");
	}
	@Override
	public void deleteAPerson() {
		System.out.println("Enter Person Name");
		String name = sc.next(); 
		if(Objects.nonNull(addressBook.isPerson(name))){
			addressBook.deletePerson(name);
			return;
		}
		System.out.println("Person Not Found");
		
	}
	@Override
	public AddressBookContact createAddressBook(String name) {
		AddressBookContact addressBook= new AddressBookContact(name);
		return addressBook;
	}




}