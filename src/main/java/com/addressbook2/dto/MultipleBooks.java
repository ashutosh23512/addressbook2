package com.addressbook2.dto;
import java.util.ArrayList;
import java.util.List;
public class MultipleBooks {

		private List<AddressBookContact> addressBooks;
		
		public MultipleBooks() {
			addressBooks = new ArrayList<>();
		}
		
		public void  addAddressBook(AddressBookContact addressBook) {
			addressBooks.add(addressBook);
		}
		
		public AddressBookContact containdAddressBook(String name)
		{
			for(int i =0 ;i<addressBooks.size();i++) {
				if(addressBooks.get(i).getName().equals(name)) {
					return addressBooks.get(i);
				}
				
			}
			return null;
		}

	}

