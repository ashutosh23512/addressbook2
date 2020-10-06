package com.addressbook2.dto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
		public List<AddressBookStructure> searchcity(String city) {
			 List<AddressBookStructure> cityy = new ArrayList<AddressBookStructure>();
			  addressBooks.stream().forEach(x -> cityy.addAll(x.personContacts.stream().filter(a -> a.getcity().equalsIgnoreCase(city)).collect(Collectors.toList())));
			 return cityy;
		}

		public List<AddressBookStructure> searchstate(String state) {
			 List<AddressBookStructure> statee= new ArrayList<AddressBookStructure>();
			  addressBooks.stream().forEach(x -> statee.addAll(x.personContacts.stream().filter(a -> a.getstate().equalsIgnoreCase(state)).collect(Collectors.toList())));
			 return statee;
		}

	}

