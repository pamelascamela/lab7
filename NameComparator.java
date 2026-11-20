import java.util.Comparator;

public class NameComparator implements Comparator<Contact> {

    public int compare(Contact first, Contact second){
        String firstName = first.getName(); 
        String secondName = second.getName();
        return firstName.compareToIgnoreCase(secondName);
    }
}