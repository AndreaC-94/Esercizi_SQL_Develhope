import java.sql.*;
import java.util.ArrayList;

public class Connector {

    private Connection conn = null;
    private boolean doesTabExist = false;
    //private int id = 0; //Contatore degli id

    public Connection connection() throws SQLException, ClassNotFoundException {
        if(conn == null){
            // db parameters
            String url       = "jdbc:mysql://localhost:3306/newdb";
            String user      = "developer";
            String password  = "Developerpass1!";

            Class.forName("com.mysql.cj.jdbc.Driver");//Nome della connessione
            conn = DriverManager.getConnection(url,user,password);

            System.out.println("Connessione avvenuta con successo!");
        }
        return conn;
    }

    public void inserisciUtente(UtenteDB utente) throws SQLException{
        if(conn == null || !doesTabExist){
            System.out.println("Usa il comando 'connection()' per effettuare la connessione e crea la tabella se non esiste!");
        }
        else{
            String query = "INSERT INTO students(User_ID, Name, Surname) VALUES (0,?,?);";
            //I punti di domanda sono necessari per prevenire sql injection

            PreparedStatement preparedStatement = conn.prepareStatement(query);
            //Inserisco lo statement contenuto dentro 'query'
            //preparedStatement.setInt(1, id);
            preparedStatement.setString(2,utente.getName());
            preparedStatement.setString(3,utente.getSurname());
            //Modifico i valori, prima segno nella riga quale colonna modificare, poi con cosa la modifico
            preparedStatement.executeUpdate();//Esegue le modifiche che ho apportato
            //id++;
            System.out.println("User " + utente.getName() + " " + utente.getSurname() + " inserito con successo.");
        }
    }

    public void creaTabella() throws SQLException{
        if(conn == null){
            System.out.println("Usa il comando 'connection()' per effettuare la connessione prima!");
        }
        else{
            doesTabExist = true;
            String query = "CREATE TABLE IF NOT EXISTS students (User_ID INT NOT NULL AUTO_INCREMENT, " +
                    " Name VARCHAR(50), " +
                    "Surname VARCHAR(50)" +
                    ", PRIMARY KEY(User_ID));";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.executeUpdate();
            System.out.println("La tabella 'students' è stata creata con successo.");
        }
    }

    public ArrayList<String> getUsers() throws SQLException{
        ArrayList<String> surnames = new ArrayList<String>();
        String query = "SELECT Name, Surname FROM students;";
        PreparedStatement statement = conn.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()){
            surnames.add(rs.getString(2));
            System.out.println("Ho estratto " + rs.getString(1));
        }
    return surnames;
    }
}
