import java.sql.SQLException;
import java.util.ArrayList;

public class Tester_Select {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connector connector = new Connector();
        ArrayList<String> surnames = new ArrayList<>();
        connector.connection();

        surnames = connector.getUsers();

        System.out.println("\nThe extracted surnames are:");
        for (String surname : surnames) {
            System.out.println(surname);
        }
    }
}
