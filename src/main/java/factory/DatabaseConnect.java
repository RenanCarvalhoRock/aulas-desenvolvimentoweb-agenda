package factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnect {
    private static final String URL = "jdbc:postgresql://localhost:5432/agenda_telefonica";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver do PostgreSQL não encontrado no classpath", e);
        }
    }

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(Exception e){
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }
}
