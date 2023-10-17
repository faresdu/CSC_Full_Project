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

    public Contact(String contactName, String phoneNumber, String emailAddress, String address, String notes, String birthday) {
        this.eventsCalendar = new LinkedList<>();
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

    public String getType(String type) {
        if (type.equalsIgnoreCase("Name")) {
            return getContactName();
        } else if (type.equalsIgnoreCase("Email")) {
            return getEmailAddress();
        } else if (type.equalsIgnoreCase("Address")) {
            return getAddress();
        } else if (type.equalsIgnoreCase("PhoneNumber")) {
            return getPhoneNumber();
        } else if (type.equalsIgnoreCase("Birthday")) {
            return getBirthday();
        }
        return null;
    }

    public int compareTo(Contact o) {
        return this.contactName.compareTo(o.getContactName());
    }

    @Override
    public String toString() {
        return "\nName: " + this.contactName +
                "\nPhone Number: " + this.phoneNumber +
                "\nEmail Address: " + this.emailAddress +
                "\nAddress: " + this.address +
                "\nBirthday: " + this.birthday +
                "\nNotes: " + this.notes + "\n";
    }

    public void addEventtoCalender(String date) {
        eventsCalendar.insert(date);
    }
    public String getReteriveDate(){
    	return eventsCalendar.retrieve();
    }
    public void findnextDate() {
    	eventsCalendar.findnext();
    }
    public void getfirstDate() {
    	eventsCalendar.findfirst();
    }
    public boolean IsemptyDate() {
    	return eventsCalendar.empty();
    }
    public boolean isLastDate() {
    	return eventsCalendar.last();
    }
}