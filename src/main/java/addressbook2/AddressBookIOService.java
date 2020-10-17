package addressbook2;

import com.addressbook2.dto.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AddressBookIOService {

	public static String CONTACT_FILE_NAME = "contactsfile.txt";

	public List<AddressBookStructure> readData() {
		List<AddressBookStructure> contactsList = new ArrayList<>();
		try {
			Files.lines(new File(CONTACT_FILE_NAME).toPath()).map(line -> line.trim())
					.forEach(line -> System.out.println(line));
			Files.lines(new File(CONTACT_FILE_NAME).toPath()).map(line -> line.trim()).forEach(line -> {

				String[] words = line.split("[\\s,:]+");
				for (String i : words) {
					System.out.println(i + " ");
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contactsList;
	}

	public void writeData(List<AddressBookStructure> contactList) {
		StringBuffer empBuffer = new StringBuffer();
		contactList.forEach(contact -> {
			String employeeDataString = contact.toString().concat("\n");
			empBuffer.append(employeeDataString);
		});
		try {
			Files.write(Paths.get(CONTACT_FILE_NAME), empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public long countEntries() {
		long entries = 0;
		try {
			entries = Files.lines(new File(CONTACT_FILE_NAME).toPath()).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entries;
	}
}