import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class AddressBookApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Entry> addressBook = new ArrayList<Entry>();
        boolean promptUser = true;

        while (promptUser) {
            System.out.println("Address Book Menu:");
            System.out.println("1) Add an entry");
            System.out.println("2) Remove an entry");
            System.out.println("3) Search for a specific entry");
            System.out.println("4) Print Address Book");
            System.out.println("5) Delete Book");
            System.out.println("6) Quit \n");
            System.out.println("Please select an option: ");

            char choice = sc.next().charAt(0);

            switch (choice) {
                case '1':
                    System.out.println("Enter first name: ");
                    String firstName = sc.next();
                    System.out.println("Enter last name: ");
                    String lastName = sc.next();
                    System.out.println("Enter phone number: ");
                    String phoneNumber = sc.next();
                    System.out.println("Enter email address: ");
                    String emailAddress = sc.next();

                    Entry entry = new Entry(firstName, lastName, phoneNumber, emailAddress);
                    addressBook.add(entry);

                    System.out.println("\nEntry added!\n");
                    break;

                case '2':
                    System.out.println("Enter the email address of the entry to delete:");
                    String email = sc.next();
                    int size = addressBook.size();
                    Iterator<Entry> itr = addressBook.iterator();
                    while (itr.hasNext()) {
                        Entry e = itr.next();
                        if (e.getEmailAddress().equals(email)) {
                            System.out.println("Deleting the following entry:");
                            System.out.println("\n******************************");
                            System.out.println("First Name: " + e.getFirstName());
                            System.out.println("Last Name: " + e.getLastName());
                            System.out.println("Phone Number: " + e.getPhoneNumber());
                            System.out.println("Email: " + e.getEmailAddress());
                            System.out.println("******************************\n");
                            itr.remove();
                        }
                    }
                    if (size == addressBook.size()) {
                        System.out.println("No entries found with that email");
                    }
                    break;


                case '3':
                    System.out.println("How would you like to search? (enter number)");
                    System.out.println("1) By first name:");
                    System.out.println("2) By last name:");
                    System.out.println("3) By phone number:");
                    System.out.println("4) By email address:");
                    char ch = sc.next().charAt(0);
                    switch (ch) {

                        case '1':
                            System.out.println("Enter first name:");
                            String firstNameSearch = sc.next();
                            for (Entry e : addressBook) {
                                if (e.getFirstName().toLowerCase().contains((firstNameSearch.toLowerCase()))) {
                                    System.out.println("\n******************************");
                                    System.out.println("Name: " + e.getFirstName() + " " + e.getLastName());
                                    System.out.println("Phone Number: " + e.getPhoneNumber());
                                    System.out.println("Email Address: " + e.getEmailAddress());
                                    System.out.println("******************************\n");
                                } else if (addressBook.size() == (addressBook.indexOf(e) + 1)) {
                                    System.out.println("No entries found\n");
                                }
                            }
                            break;

                        case '2':
                            System.out.println("Enter last name:");
                            String lastNameSearch = sc.next();
                            for (Entry e : addressBook) {
                                if (e.getLastName().toLowerCase().contains((lastNameSearch.toLowerCase()))) {
                                    System.out.println("\n******************************");
                                    System.out.println(e.getFirstName() + " " + e.getLastName());
                                    System.out.println(e.getPhoneNumber());
                                    System.out.println(e.getEmailAddress());
                                    System.out.println("******************************\n");
                                } else if (addressBook.size() == (addressBook.indexOf(e) + 1)) {
                                        System.out.println("No entries found\n");
                                    }
                                }

                            break;

                        case '3':
                            System.out.println("Enter phone number:");
                            String phoneNumberSearch = sc.next();
                            for (Entry e : addressBook) {
                                if (e.getPhoneNumber().contains((phoneNumberSearch))) {
                                    System.out.println("\n******************************");
                                    System.out.println(e.getFirstName() + " " + e.getLastName());
                                    System.out.println(e.getPhoneNumber());
                                    System.out.println(e.getEmailAddress());
                                    System.out.println("******************************\n");
                                } else if (addressBook.size() == (addressBook.indexOf(e) + 1)) {
                                    System.out.println("No entries found\n");
                                }
                            }
                            break;

                        case '4':
                            System.out.println("Enter email address:");
                            String emailAddressSearch = sc.next();
                            for (Entry e : addressBook) {
                                if (e.getEmailAddress().contains((emailAddressSearch))) {
                                    System.out.println("\n******************************");
                                    System.out.println(e.getFirstName() + " " + e.getLastName());
                                    System.out.println(e.getPhoneNumber());
                                    System.out.println(e.getEmailAddress());
                                    System.out.println("******************************\n");
                                } else if (addressBook.size() == (addressBook.indexOf(e) + 1)) {
                                    System.out.println("No entries found\n");
                                }
                            }
                            break;

                        default: System.out.println("Please choose a valid option between 1-4.\n");
                    }
                    break; // End of nested switch

                case '4':
                    if (addressBook.isEmpty()) {
                        System.out.println("Your address book does not contain any entries");
                    }
                    for (Entry e : addressBook) {
                        System.out.println("\n******************************");
                        System.out.println("First Name: " + e.getFirstName());
                        System.out.println("Last Name: " + e.getLastName());
                        System.out.println("Phone Number: " + e.getPhoneNumber());
                        System.out.println("Email: " + e.getEmailAddress());
                        System.out.println("******************************\n");
                    }
                    break;

                case '5':
                    if (addressBook.isEmpty()) {
                        System.out.println("Your address book does not contain any entries");
                    } else {
                        System.out.println("Clearing address book\n");
                        addressBook.clear();
                        System.out.println("Address book has been cleared\n");
                    }
                    break;

                case '6':
                    System.out.println("Closing your address book.");
                    promptUser = false;
                    break;

                default:
                    System.out.println("Please choose a valid option between 1-6.\n");
            } //End of main switch statement

        }
    }


}




















