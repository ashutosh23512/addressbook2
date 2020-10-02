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
		AddressBookContact addressBook = new AddressBookContact();
		AddressBookService addressBookService = new AdressBookImpl(sc);
		while (true) {
			System.out.println("1.) Create new Person Book");
			System.out.println("3.) Exit");
			int options = sc.nextInt();

			switch (options) {
			case 1:
				createNewAddressBook(addressBookService, addressBook, sc);
				break;
			case 3:
				System.out.println("Bye\n\n");
				return;
			default:
				break;
			}
		}
	}
	public static void createNewAddressBook(AddressBookService addressBookService,AddressBookContact addressBook ,Scanner sc) {
		addressBookService.showOptions(addressBook);
		System.out.print("Created\n\n");
	}

}
