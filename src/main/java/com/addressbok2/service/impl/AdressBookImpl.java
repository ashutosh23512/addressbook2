package com.addressbok2.service.impl;
import com.addressbook2.dto.*;
import com.addressbok2.service.*;
import java.util.*;

public class AdressBookImpl implements AddressBookService {
	private AddressBookContact addressBook = new AddressBookContact();
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
		System.out.println("2.) Create A Persion");
		System.out.println("3.) Exit");
		
		int option = sc.nextInt();
		switch(option) {	
		
		case 1:
			findAPerson();
			//display();
			break;
		case 2:
			AddressBookStructure person = new  AddressBookStructure();
			createAPerson();		
			display();
			break;
		case 3:
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




}