package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String DATABASE = "financas";
    private final String URL = "jdbc:mysql://localhost:3306/" + DATABASE;
    private final String USER = "root";
    private final String PASSWORD = "senac";
    
    private Connection connection = null;
    
    public boolean open() {
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return true;
        } catch(ClassNotFoundException | SQLException error) {
            System.out.println("Erro: " + error);
        }
        return false;
    }
    
    public boolean close() {
        try {
            this.connection.close();
            return true;
        } catch (SQLException error) {
            System.out.println("Erro: " + error);
        }
        return false;
    }
    
    public Connection getConnetion() {
        return this.connection;
    }
    
}
