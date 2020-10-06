package addressbook2;
import java.util.*;

import com.addressbook2.dto.*;
import com.addressbok2.service.*;
import com.addressbok2.service.impl.*;
import java.util.*;
public class Executor {

	public static void main(String[] args) {
		System.out.println("Welcome to address book project");
		AddressBookStructure person = new AddressBookStructure();
		Scanner sc = new Scanner(System.in);
		MultipleBooks addressBook = new MultipleBooks();
		AddressBookService addressBookService = new AdressBookImpl(sc);
		while (true) {
			System.out.println("1.) Open an existing Address book");
			System.out.println("2.) Create new Address Book");
			System.out.println("3.) Search Contacts by City");
			System.out.println("4.) Search Contacts by State");
			System.out.println("5.) Exit");
			int options = sc.nextInt();

			switch (options) {
			case 1:
			openExistingAddressBook(addressBookService, addressBook,sc);
				break;
			case 2:
				createNewAddressBook(addressBookService, addressBook, sc);
				break;
			case 3:
				System.out.println("Enter City Name");
				String city=sc.next();
				System.out.println(addressBook.searchcity(city));
				System.out.println(addressBook.citycount(city));

				break;
			case 4:
				System.out.println("Enter State Name");
				String state=sc.next();
				System.out.println(addressBook.searchstate(state));
				System.out.println(addressBook.statecount(state));
				break;
				
			case 5:
				System.out.println("Good Bye\n\n");
				return;
			default:
				break;
			}
		}

	}
	
	public static void openExistingAddressBook(AddressBookService addressBookService,MultipleBooks addressBooks,Scanner sc) {
		System.out.print("Enter Name");
		String name = sc.next();
		AddressBookContact addressBook = addressBooks.containdAddressBook(name);
		if(Objects.nonNull(addressBook)) {
			addressBookService.showOptions(addressBook);
			return;
	}
		System.out.println("Not Address Book Found");
	}
	
	public static void createNewAddressBook(AddressBookService addressBookService,MultipleBooks addressBooks ,Scanner sc) {
		System.out.print("Enter Name");
		String name = sc.next();
		AddressBookContact addressBook = addressBookService.createAddressBook(name);
		addressBooks.addAddressBook(addressBook);
		System.out.print("Created\n\n");
	}

}
