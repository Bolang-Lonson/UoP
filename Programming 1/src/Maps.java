import textio.TextIO;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


class Contact {
    private String name;
    private int number;

    public Contact(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() { return this.name; }
    public int getNumber() { return this.number; }
    public void setName(String name) { this.name = name; }
    public void setNumber(int number) { this.number = number; }
}

public class Maps {

    public static void main(String[] args) {
        HashMap<String, Integer> contactList = new HashMap<>();
        String nameString;
        int number;
        TextIO.putln("Contact Registry");

        do {
            TextIO.putln("Enter name ('no' to end):");
            nameString = TextIO.getln();
            if (nameString.equals("no")) { break; }
            TextIO.putln("Enter number:");
            number = TextIO.getlnInt();

            Contact newContact = new Contact(nameString, number);
            contactList.put(newContact.getName(), newContact.getNumber());
            TextIO.putln();

        } while (true);

        Set<String> keys = contactList.keySet();
        Iterator<String> keyIter = keys.iterator();
        System.out.println("The contact list contains the following contacts");
        while (keyIter.hasNext()) {
            String name = keyIter.next();
            int num = contactList.get(name);
            System.out.println(name + "\t\t" + num);
        }
    }
}