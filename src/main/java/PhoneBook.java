import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    private List<Contact> contacts = new ArrayList<Contact>();

    public boolean addContact(Contact contact) {
        return contacts.add(contact);
    }

    public Contact removeContact(String name) {
        for ( int i=0; i< contacts.size(); i++){
            if(contacts.get(i).getName().equals(name)){
                return contacts.remove(i);
            }
        }
        return null;
    }

    public boolean updateContact(Contact contact){
        for (Contact oldContact: contacts) {
            if(oldContact.getName().equals(contact.getName())){
                oldContact.setPhoneNumber(contact.getPhoneNumber());
                return true;
            }
        }
        return false;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public Contact getContactByNameAndNumber(String name, String phoneNumber) {
        for (Contact contact: contacts) {
            if(contact.getName().equals(name) && contact.getPhoneNumber().equals(phoneNumber))
                return contact;

        }
        return null;
    }


}
