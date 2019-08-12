import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        Integer input;

        while(true){
            printOptions();
            System.out.println("Enter an option: ");
            input = reader.nextInt();
            switch(input) {
                case 1:
                    getAllContacts(phoneBook);
                    break;
                case 2:
                    addContact(reader, phoneBook);
                    break;
                case 3:
                    updateContact(reader, phoneBook);
                    break;
                case 4:
                    removeContact(reader, phoneBook);
                    break;
                case 5:
                    getContact(reader, phoneBook);
                    break;
                case 0:
                    System.exit(0);
                    default:
                        System.out.println("Invalid options!");


            }

        }

    }


    public static void printOptions() {
        System.out.println();
        System.out.println("~~~~~~~~~~OPTIONS~~~~~~~~~~");
        System.out.println("1. Get all contacts from the phoneBook");
        System.out.println("2. Add a contact to the phoneBook");
        System.out.println("3. Update a contact from the phoneBook");
        System.out.println("4. Remove a contact from the phoneBook");
        System.out.println("5. Get a contact from the phoneBook");
    }

    public static void getAllContacts(PhoneBook phoneBook){
        List<Contact> contacts = phoneBook.getContacts();
        if(contacts.size() != 0){
            System.out.println("List of contacts: ");
            for(Contact contact : contacts){
                System.out.println(contact.toString());
            }
        }
        else {
            System.out.println("There are no contacts in the phoneBook!");
        }
    }

    public static void addContact(Scanner reader, PhoneBook phoneBook) {
        System.out.println("Enter the name for the new contact: ");
        String name = reader.next();
        System.out.println("Enter the phone number for the new contact: ");
        String phoneNumber = reader.next();

        if(phoneBook.addContact(new Contact(name, phoneNumber))) {
            System.out.println("The contact was successfully added!!");
        }
        else {
            System.out.println("Something went wrong! Try again!");
        }
    }

    public static void updateContact(Scanner reader, PhoneBook phoneBook) {
        System.out.println("Enter the name of the contact you want to update: ");
        String name = reader.next();
        System.out.println("Enter the new phone number : ");
        String phoneNumber = reader.next();

        if(phoneBook.updateContact(new Contact(name, phoneNumber))) {
            System.out.println("The contact was successfully updated!!");
        }
        else {
            System.out.println("That contact doesn't exist in the phoneBook!");
        }
    }

    public static void removeContact(Scanner reader, PhoneBook phoneBook) {
        System.out.println("Enter the name of the contact you want to remove from the phoneBook: ");
        String name = reader.next();
        if(phoneBook.removeContact(name) != null){
            System.out.println("The contact was successfully removed!!");
        }
        else {
            System.out.println("That contact doesn't exist in the phoneBook!");
        }

    }

    public static void getContact(Scanner reader, PhoneBook phoneBook) {
        System.out.println("Enter the name of the contact you want to search: ");
        String name = reader.next();
        System.out.println("Enter the contacts phone number : ");
        String phoneNumber = reader.next();

        Contact contact = phoneBook.getContactByNameAndNumber(name, phoneNumber);
        if( contact != null) {
            System.out.println(contact.toString());
        }
        else {
            System.out.println("That contact doesn't exist in the phoneBook!");
        }
    }

}
