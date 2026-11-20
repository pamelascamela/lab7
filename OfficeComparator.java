import java.util.Comparator;

public class OfficeComparator implements Comparator<Contact> {

    public int compare(Contact first, Contact second){
        String firstOffice = first.getOffice(); 
        String secondOffice = second.getOffice();
        return firstOffice.compareToIgnoreCase(secondOffice);
    }
}