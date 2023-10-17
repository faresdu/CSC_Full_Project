/****************************

CLASS: Contact.java

CSC212 Data structures - Project phase I

Fall 2023

EDIT DATE:

17-10-2023

TEAM:

CSC

AUTHORS:

1- Abdulaziz Alkhonefer                            443100675
2- Abdulrahman Hamad Alaqeel                       443100920           
3- Fares Essa Alduhailan                           443102276

***********************************/
public class Contact implements Comparable<Contact> {
    private String contactName;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private String birthday;
    private String notes;
    private LinkedList<String> eventsCalendar;

    public Contact() {
        this.eventsCalendar = new LinkedList<>();
        this.contactName = null;
        this.phoneNumber = null;
        this.emailAddress = null;
        this.address = null;
        this.birthday = null;
        this.notes = null;
    }

    public Contact(Contact c) {
        this.eventsCalendar = c.eventsCalendar;
        this.contactName = c.contactName;
        this.phoneNumber = c.phoneNumber;
        this.emailAddress = c.emailAddress;
        this.address = c.address;
        this.birthday = c.birthday;
        this.notes = c.notes;
    }

		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.address = address;
		this.notes = notes;
		this.birthday = birthday;
	}
	
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getType(String Type){
		if(Type.equalsIgnoreCase("Name")){
			return getContactName();
		}
		else if(Type.equalsIgnoreCase("Email")){
			return getEmailAddress();
		}
		else if(Type.equalsIgnoreCase("Address")){
			return getAddress();
		}
		else if(Type.equalsIgnoreCase("PhoneNumber")){
			return getPhoneNumber();
		}
		else if(Type.equalsIgnoreCase("Birthday")){
			
			return getBirthday();
		}
		return null;
		
	}
	
	public int compareTo(Contact o) {  
        try {  
            return (this.contactName.compareTo(o.getContactName()));   
                                                    
        }  
        catch (Exception e)  
        {  
            throw new UnsupportedOperationException();  
        }  
    }  
	
	


}