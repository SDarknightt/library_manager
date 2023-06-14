package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaDB {
    private static final String URL = "jdbc:postgresql://localhost/poo?charSet=UTF-8";
    private static final String LOGIN = "postgres";
    private static final String SENHA = "1234";


    public static void main(String[] args) {
        new ConectaDB().getConexao();
        System.out.println("Conexão executada com sucesso!");

    }


    public Connection getConexao(){
        Connection conn = null;
        try{

            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(URL, LOGIN, SENHA);

        }catch(ClassNotFoundException e){
            System.out.println("Classe de conexão com o banco não configurada");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("URL, usuário ou senha do banco errados");
            e.printStackTrace();
        }

        return conn;
    }

}
