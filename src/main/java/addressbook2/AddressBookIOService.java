package addressbook2;

import com.addressbook2.dto.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.CSVReader;
import com.opencsv.*;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
public class AddressBookIOService {

	public static String CONTACT_FILE_NAME = "contactsfile.txt";
	public static final String SAMPLE_CSV_FILE_PATH = "./demo.csv";
	public static final String SAMPLE_JSON_FILE_PATH = "./demo.json";

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

	@SuppressWarnings("unchecked")
	public List<AddressBookStructure> readCSVData() {
		List<AddressBookStructure> contactsList = new ArrayList<>();
		try {
			Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
			CsvToBean<AddressBookStructure> csvToBean = new CsvToBeanBuilder<AddressBookStructure>(reader)
					.withType(AddressBookStructure.class).withIgnoreLeadingWhiteSpace(true).build();

			contactsList = csvToBean.parse();
			reader.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return contactsList;
	}

	public boolean writeCSVData(List<AddressBookStructure> contactList) {
		try (Writer writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_PATH))) {
			StatefulBeanToCsv<AddressBookStructure> beanToCsv = new StatefulBeanToCsvBuilder<AddressBookStructure>(
					writer).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();

			beanToCsv.write(contactList);
		} catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException | IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean writeJsonData(List<AddressBookStructure> contactList) {
		Gson gson = new Gson();
		String json = gson.toJson(contactList);
		try {
			FileWriter fileWriter = new FileWriter(SAMPLE_JSON_FILE_PATH);
			fileWriter.write(json);
			fileWriter.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean readJsonData(){
		try {
			Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_JSON_FILE_PATH));
			JsonParser jsonParser = new JsonParser();
			JsonElement obj = jsonParser.parse(reader);
			JsonArray contactList = (JsonArray) obj;
			System.out.println(contactList);
			
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}