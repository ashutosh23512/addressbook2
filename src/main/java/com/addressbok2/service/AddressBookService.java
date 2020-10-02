package com.addressbok2.service;
import com.addressbook2.dto.AddressBookContact;
public interface AddressBookService {
	public void findAPerson();
	public void showOptions(AddressBookContact addressBook);
	public void updateAPerson();
	public void deleteAPerson();
	public AddressBookContact createAddressBook(String name);


}
