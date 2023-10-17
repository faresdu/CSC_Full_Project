public class Event implements Comparable<Event> {
	private String eventTitle;
	private String dateAndTime;
	private String location;
	private LinkedList<Contact> contactLinkedList;

	public Event() {
		this.contactLinkedList = new LinkedList<Contact>();
		this.eventTitle = null;
		this.dateAndTime = null;
		this.location = null;

	}

	public Event(String eventTitle, String dateAndTime, String location) {
		this.eventTitle = eventTitle;
		this.dateAndTime = dateAndTime;
		this.location = location;

	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Contact findContactInEvent(String data, String type) {
		contactLinkedList.findfirst();
		if (contactLinkedList.empty()) {
			return null;
		}
		boolean Signal = true;
		;

		while (Signal) {
			Contact currentContact = contactLinkedList.retrieve();
			if (currentContact != null) {
				if (type.equalsIgnoreCase("Name") && currentContact.getContactName().equalsIgnoreCase(data)) {
					return currentContact;
				} else if (type.equalsIgnoreCase("Email") && currentContact.getEmailAddress().equalsIgnoreCase(data)) {
					return currentContact;
				} else if (type.equalsIgnoreCase("PhoneNumber")
						&& currentContact.getPhoneNumber().equalsIgnoreCase(data)) {
					return currentContact;
				} else if (type.equalsIgnoreCase("Address") && currentContact.getAddress().equalsIgnoreCase(data)) {
					return currentContact;
				} else if (type.equalsIgnoreCase("Birthday") && currentContact.getBirthday().equalsIgnoreCase(data)) {
					return currentContact;
				}
			}
			if (contactLinkedList.last()) {
				Signal = false;
				break;
			}
			contactLinkedList.findnext();

		}
		return null;
	}

	public void addContacttoEvent(Contact a) {
		contactLinkedList.insert(a);
	}

	public void removeContactInEvent() {
		contactLinkedList.remove();
	}

	public void printContactsNames() {
		System.out.println("Contact List: ");
		int c = 1;

		if (contactLinkedList.empty()) {
			System.out.println("THERE IS NO CONTACTS");
			return;
		}
		contactLinkedList.findfirst();
		boolean Signal = true;
		while (Signal) {
			System.out.println(c++ + " : " + contactLinkedList.retrieve().getContactName());

			if (contactLinkedList.last()) {
				Signal = false;
				break;
			}
			contactLinkedList.findnext();
		}

	}

	public boolean isEmptyContact() {
		return contactLinkedList.empty();
	}

	public void printFirstName(String name) {
		if (contactLinkedList.empty()) {
			return;
		}
		boolean printname = true;
		contactLinkedList.findfirst();
		boolean Signal = true;
		while (Signal) {
			Contact tmp = contactLinkedList.retrieve();
			if (tmp.getContactName().substring(0, name.length()).equalsIgnoreCase(name)) {
				if (printname == true) {
					System.out.println();
					System.out.println("Event Name: " + getEventTitle());
					System.out.println("------------------------------");
					printname = false;
				}
				System.out.println();
				System.out.println(tmp.toString());
				System.out.println();

			}
			if (contactLinkedList.last()) {
				Signal = false;
				break;
			}
			contactLinkedList.findnext();
		}
		System.out.println();
	}

	public int compareTo(Event o) {
		try {
			return (this.eventTitle.compareTo(o.getEventTitle()));

		} catch (Exception e) {
			throw new UnsupportedOperationException();
		}
	}

}