import java.sql.SQLException;

public class Tester_Table {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Connector connector = new Connector();
        connector.connection();

        UtenteDB utenteDB1 = new UtenteDB();
        UtenteDB utenteDB2 = new UtenteDB();
        UtenteDB utenteDB3 = new UtenteDB();
        UtenteDB utenteDB4 = new UtenteDB();

        utenteDB1.setName("Andrea");
        utenteDB1.setSurname("Colucci");
        utenteDB2.setName("Matteo");
        utenteDB2.setSurname("Cimino");
        utenteDB3.setName("Marco");
        utenteDB3.setSurname("Satta");
        utenteDB4.setName("Antonio");
        utenteDB4.setSurname("Quartale");

        connector.creaTabella();
        connector.inserisciUtente(utenteDB1);
        connector.inserisciUtente(utenteDB2);
        connector.inserisciUtente(utenteDB3);
        connector.inserisciUtente(utenteDB4);


        //Screenshot di MySQL -> https://prnt.sc/HdRechp8QloO
    }
}
