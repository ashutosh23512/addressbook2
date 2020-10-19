package addressbook2;

import java.util.ArrayList;
import java.util.List;

import com.addressbook2.dto.AddressBookStructure;

public class AddressBookIOServiceMain {

	public static void main(String[] args) {
		AddressBookIOService addressBookFileIOService = new AddressBookIOService();
		List<AddressBookStructure> contactList = new ArrayList<>();
		AddressBookStructure contact1 = new AddressBookStructure("Ashutosh", "Aggarwal", "asr", "asr", "asr", "12345",
				"91 9999999999", "abc@google.com");
		AddressBookStructure contact2 = new AddressBookStructure("Test1", "Test", "test", "test", "test", "987345",
				"91 8888888888", "abc@gmail.com");
		AddressBookStructure contact3 = new AddressBookStructure("Test2", "Test", "test", "test", "test", "987345",
				"91 8888888880", "abc@gmail.com");
		contactList.add(contact1);
		contactList.add(contact2);
		contactList.add(contact3);
		addressBookFileIOService.writeData(contactList);
		addressBookFileIOService.readData();
		addressBookFileIOService.writeCSVData(contactList);
		addressBookFileIOService.readCSVData();
		addressBookFileIOService.readJsonData();
		addressBookFileIOService.writeJsonData(contactList);


		

	}

}
