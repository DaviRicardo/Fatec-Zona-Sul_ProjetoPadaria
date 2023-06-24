package projetopadaria.util;

import java.sql.Connection; //  Representa uma conexão com um BD relacional
import java.sql.DriverManager; // Classe responsável por criar a conexão com o banco de dados
import java.sql.SQLException;

public class ConexaoDb {    
    public static String status = "Não conectado...";

    public ConexaoDb() {

    }

    public static Connection getConexaoMySQL() {
        Connection connection = null;          
        try {
            // Carregando o Java Database Connectivity (JDBC) Driver padrão
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            
            // Configurando a conexão com o banco de dados
            String serverName = "localhost";          // Caminho do servidor do banco de dados 
            String mydatabase ="projetopadaria";     // Nome do banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase + "?useTimezone=true&serverTimezone=UTC";
            
            String username = "root";        // nome de um usuário de seu banco de dados
            String password = "";           // sua senha de acesso
            
            connection = DriverManager.getConnection(url, username, password);
            //Testa sua conexão
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }
            
            return connection;
        } catch (ClassNotFoundException e) {  
            System.out.println("O driver especificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            System.out.println("Erro" + e.getMessage());
            return null;
        }
    }
    //Método que retorna o status da sua conexão//
    public static String statusConection() {
        return status;
    }
    //Método que fecha sua conexão//'
    public static boolean FecharConexao() {
        try {
           ConexaoDb.getConexaoMySQL().close();
           return true;
        } catch (SQLException e) {
            return false;
        }
    }
   //Método que reinicia sua conexão//
    public static Connection ReiniciarConexao() {
        return ConexaoDb.getConexaoMySQL();
    }
}

