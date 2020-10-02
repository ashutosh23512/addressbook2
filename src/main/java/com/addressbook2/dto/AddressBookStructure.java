package com.addressbook2.dto;

public class AddressBookStructure {
	
	private String firstname;
	private String lastname;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	private String phoneno;
	private String email;
	
	
	public AddressBookStructure()
	{

	}
	
	public AddressBookStructure(String firstname, String lastname,	String address,	String city, String state,
	String zipcode, String phoneno,	String email)
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.phoneno = phoneno;
		this.email = email;
	}
	
	public String getfirstname() {
        return firstname;
    }
    public void setfirstname(String fname) {
        this.firstname = fname;
    }
    
    public String getlastname() {
        return lastname;
    }
    public void setlastname(String lname) {
        this.lastname = lname;
    }
    
    public String getaddress() {
        return address;
    }
    public void setaddress(String address) {
        this.address = address;
    }
    public String getcity() {
        return city;
    }
    public void setcity(String city) {
        this.city = city;
    }
    public String getstate() {
        return state;
    }
    public void setstate(String state) {
        this.state = state;
    }
    public String getzip() {
        return zipcode;
    }
    public void setzip(String zip) {
        this.zipcode = zip;
    }
    public String getphone() {
        return phoneno;
    }
    public void setphone(String phone) {
        this.phoneno = phone;
    }
    
    public String getemail() {
        return phoneno;
    }
    public void setemail(String email) {
        this.email = email;
    }
    
	@Override
	public String toString()
	{
		return "First name "+firstname+"\nLast name "+lastname+"\nAddress "+address+"\nCity "
	    +city+"\nState "+state+"\nZip Code "+zipcode+"\nPhone No. "+phoneno+"\nEmail "+email;
	}
}