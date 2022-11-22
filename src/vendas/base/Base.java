package vendas.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Base {

    public static Connection connection;
    public static Statement statement;

    public static void main(String[] args) {

      connection = null;


        try{
            connection = DriverManager.getConnection("jdbc:sqlite:base.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30);

            statement.executeUpdate("DROP TABLE IF EXISTS Produtos");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Produtos (id INTEGER, name STRING, preço BIGDECIMAL)");
            statement.executeUpdate("INSERT INTO Produtos VALUES(1, 'Bobina térmica 80x40', 119.90)");
            statement.executeUpdate("INSERT INTO Produtos VALUES(1, 'Bobina térmica 80x30', 99.90)");

            ResultSet rs = statement.executeQuery("SELECT * FROM Produtos");

            while(rs.next()) {
                // Ler os dados inseridos
                System.out.println("Produto  : " + rs.getString("name"));
                System.out.println("Identificador : " + rs.getInt("id"));
                System.out.println("Preço : " + rs.getBigDecimal("preço"));
            }

        } catch(Exception e){
            System.err.println(e.getMessage());
        }

        finally {
            try {
                if(connection != null){
                    connection.close();
                }
            } catch(SQLException e) {
                // Falhou também para fechar o arquivo
                System.err.println(e.getMessage());
            }
        }


    }
}
