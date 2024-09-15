package src;

import java.util.Scanner;

public class ContactManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactList contactList = new ContactList();
        int option;

        do {
            System.out.println("Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Remove Contact");
            System.out.println("4. List Contacts");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    contactList.addContact(new Contact(name, phone, email));
                    System.out.println("Contact added.");
                    break;
                case 2:
                    System.out.print("Enter name or phone number: ");
                    String searchQuery = scanner.nextLine();
                    Contact contact = contactList.searchContact(searchQuery);
                    if (contact != null) {
                        System.out.println("Found: " + contact);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter name or phone number to remove: ");
                    String removeQuery = scanner.nextLine();
                    contactList.removeContact(removeQuery);
                    System.out.println("Contact removed (if it existed).");
                    break;
                case 4:
                    System.out.println("Listing all contacts:");
                    contactList.listContacts();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (option != 5);

        scanner.close();
    }
}

