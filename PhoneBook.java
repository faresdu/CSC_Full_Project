public class PhoneBook {
	private LinkedList<Contact> contactLinkedList;
	private LinkedList<Event> EventLinkedList;
	public PhoneBook() {
		this.contactLinkedList = new LinkedList<>();
		this.EventLinkedList = new LinkedList<>();
		
	}
	
	public void addContact(Contact contact) {
			if (contactLinkedList.empty()) {
				contactLinkedList.insert(contact);
				System.out.println("the CONTACT has been Added successfully!");
				return;
			} else {
				if (checkUnique(contact)) {
					contactLinkedList.insert(contact);
					System.out.println("the CONTACT has been Added successfully!");
					return;
				}}
			System.out.println("THE PhoneNumber already exists!");
		}
	private boolean checkUnique(Contact n) {
		contactLinkedList.findfirst();
		boolean Signal = true;
		while (Signal){
			if (contactLinkedList.retrieve().getPhoneNumber().equalsIgnoreCase(n.getPhoneNumber())) {
				return false;
			}
			if(contactLinkedList.last()) {
				Signal=false;
				break;
			}
			contactLinkedList.findnext();
			}
		
	return true;
	}
	
	public void deleteContact(String c) {
		if (contactLinkedList.empty()) {
			System.out.println("The List is empty!");
			return;
		}
		Contact tmp=findContact(c, "PhoneNumber");
		if(tmp==null) {
			System.out.println("The contact not exist!");
		}
		if(!EventLinkedList.empty()){
		EventLinkedList.findfirst();
		boolean Signal=true;
		while(Signal) {
			if(EventLinkedList.retrieve().findContactInEvent(c, "PhoneNumber")!=null) {
			EventLinkedList.retrieve().removeContactInEvent();
			}
			if(EventLinkedList.retrieve().isEmptyContact()) {
				EventLinkedList.remove();
			}
			if(EventLinkedList.last()) {
				Signal=false;
				break;
			}
			EventLinkedList.findnext();
		}
		}
		
		contactLinkedList.remove();
		System.out.println("THE CONTACT HAS BEEN DELETED");
		}
	
	 public Contact findContact(String data, String type) {
			contactLinkedList.findfirst();
			if (contactLinkedList.empty()) {
				return null;
			}
			boolean Signal = true;;
			
			while(Signal) {
				Contact currentContact = contactLinkedList.retrieve();
				if (currentContact != null) {
					if (type.equalsIgnoreCase("Name") && currentContact.getContactName().equalsIgnoreCase(data)) {
						return currentContact;
					}else if (type.equalsIgnoreCase("Email") && currentContact.getEmailAddress().equalsIgnoreCase(data)) {
						return currentContact;
					}else if (type.equalsIgnoreCase("PhoneNumber") && currentContact.getPhoneNumber().equalsIgnoreCase(data)) {
						return currentContact;
					}else if (type.equalsIgnoreCase("Address") && currentContact.getAddress().equalsIgnoreCase(data)) {
						return currentContact;
					}else if (type.equalsIgnoreCase("birthday") && currentContact.getBirthday().equalsIgnoreCase(data)) {
						return currentContact;
					}
				}
				if(contactLinkedList.last()) {
					Signal=false;
					break;
				}
				contactLinkedList.findnext();
				
			}
		
			return null;
		}
		
	public void searchContact(String data, String type) {
		int nb = 1;
		Contact tmp = findContact(data, type);
		if(tmp!=null){
		if (type.equalsIgnoreCase("Email") || type.equalsIgnoreCase("birthday") || type.equalsIgnoreCase("Address")) {
			contactLinkedList.findfirst();
			boolean Signal = true;
			while (Signal) {
				if (tmp!=null&&tmp.getType(type).equalsIgnoreCase(contactLinkedList.retrieve().getType(type))) {
					System.out.println("\nContact " + nb + " found!");
					System.out.println(contactLinkedList.retrieve().toString());
					nb++;
				}
				if(contactLinkedList.last()) {
					Signal=false;
					break;
				}
				contactLinkedList.findnext();
			}
	
			
		} else{
			System.out.println("\nContact found!");
			System.out.println(tmp.toString());;} 
		}else {
			System.out.println("CONTACT NOT FOUND!");
		}
	}
    	
	 public void scheduleEvent(Event event,Contact a) {
			if (a == null) {
				System.out.println("Contact does not exist in the phonebook.");
				return;
			} else {

			}
			if (conflictDate(a, event.getDateAndTime())) {
				System.out.println("There's a scheduling conflict for this contact.");
				return;
			} else {
				
				if(findEvent(event)) {
					EventLinkedList.retrieve().addContacttoEvent(a);
					a.addEventtoCalender(EventLinkedList.retrieve().getDateAndTime());
				System.out.println("The event has been schudlede!");
				return;
				}else {
				event.addContacttoEvent(a);
				a.addEventtoCalender(event.getDateAndTime());
				EventLinkedList.insert(event);
				System.out.println("The event has been schudlede!");}
				
					
				}
		}
		

	private boolean conflictDate(Contact contact, String DateAndTime) {
			if (contact.IsemptyDate()) {
				return false;
			} else {
				contact.getfirstDate();;
				boolean Signal=true;
				while (Signal) {
					if (contact.getReteriveDate().equalsIgnoreCase(DateAndTime))
							{
						return true;
					}
					if(contact.isLastDate())
						break;
					contact.findnextDate();
				}
			}
			return false;
		}
		
	 private boolean findEvent(Event a){
		
		 if(EventLinkedList.empty())
			 return false;
		 EventLinkedList.findfirst();
		 boolean Signal = true;
		 while(Signal){
			 Event tmp = EventLinkedList.retrieve();
			if(tmp.getEventTitle().equalsIgnoreCase(a.getEventTitle())
					&&tmp.getDateAndTime().equalsIgnoreCase(a.getDateAndTime())
					&&tmp.getLocation().equalsIgnoreCase(a.getLocation()))
				return true;
			if(EventLinkedList.last()) {
				Signal=false;
				break;
			}
			
			 EventLinkedList.findnext();
			 }
		 
		 
		 return false;
	 }
	 

	 public void PrintEvent() {
			if(!EventLinkedList.empty()){
			EventLinkedList.findfirst();
			while (!EventLinkedList.last()) {
				System.out.println(EventLinkedList.retrieve().getEventTitle());
				EventLinkedList.findnext();
			}
			if (EventLinkedList.last()) {
				System.out.println(EventLinkedList.retrieve().getEventTitle());
				return;
			}
		}
			System.out.println("The List is empty");}
	 
		public void SearchEvent(String data, String Type) {
			if (EventLinkedList.empty()) {
				System.out.println("The event list is empty! ");
				return;
			}
			boolean Signal = true;
			EventLinkedList.findfirst();
			do{
				Event tmp = EventLinkedList.retrieve();
				if (tmp.getEventTitle().equalsIgnoreCase(data) && Type.equalsIgnoreCase("Title")) {
					
					System.out.println("Event found!\n");
					System.out.println("Event title: " + tmp.getEventTitle());
					tmp.printContactsNames();
					System.out.println("Event date and time: " + tmp.getDateAndTime());
					System.out.println("Event Location: " + tmp.getLocation());
					return;
	
				}else if(EventLinkedList.retrieve().findContactInEvent(data, "Name")!=null&& Type.equalsIgnoreCase("Name")) {
					System.out.println("\nEvent found!\n");
					System.out.println("Event title: " + tmp.getEventTitle());
					tmp.printContactsNames();
					System.out.println("Event date and time: " + tmp.getDateAndTime());
					System.out.println("Event Location: " + tmp.getLocation());
				}
				
				if(EventLinkedList.last()) {
					Signal = false;
					return;}
					EventLinkedList.findnext();
					}while(Signal);
					System.out.println("Event not founded! ");}
		
		
		public void searchByFirstName(String name) {
		    if (EventLinkedList.empty()) {
		        return;
		    }

		    EventLinkedList.findfirst();

		    while (!EventLinkedList.last()){
		        Event currentEvent = EventLinkedList.retrieve();
		        currentEvent.printFirstName(name);
		        EventLinkedList.findnext();
		    }

		    Event lastEvent = EventLinkedList.retrieve();
		    lastEvent.printFirstName(name);
		}
}