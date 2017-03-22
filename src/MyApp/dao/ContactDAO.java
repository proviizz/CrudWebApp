package MyApp.dao;

import java.util.List;
import MyApp.model.Contact;

public interface ContactDAO {
	public List<Contact> displayAllContacts();
	public int insert(Contact contact);
	public Contact getContact(String id);
	public String updateContact(String id,String empName, String mobileNo,String homeNo,String officeNo,String email);
	public String deleteContact(String id);
	
}

