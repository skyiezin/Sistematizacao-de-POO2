package src;

public class ContactList {
    private Node head;

    public ContactList() {
        head = null;
    }

    public void addContact(Contact contact) {
        Node newNode = new Node(contact);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public Contact searchContact(String nameOrPhone) {
        Node current = head;
        while (current != null) {
            Contact contact = current.getContact();
            if (contact.getName().equalsIgnoreCase(nameOrPhone) ||
                contact.getPhoneNumber().equals(nameOrPhone)) {
                return contact;
            }
            current = current.getNext();
        }
        return null;
    }

    public void removeContact(String nameOrPhone) {
        if (head == null) return;

        if (head.getContact().getName().equalsIgnoreCase(nameOrPhone) ||
            head.getContact().getPhoneNumber().equals(nameOrPhone)) {
            head = head.getNext();
            return;
        }

        Node current = head;
        while (current.getNext() != null) {
            if (current.getNext().getContact().getName().equalsIgnoreCase(nameOrPhone) ||
                current.getNext().getContact().getPhoneNumber().equals(nameOrPhone)) {
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }
    }

    public void listContacts() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getContact());
            current = current.getNext();
        }
    }
}
