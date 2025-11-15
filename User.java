package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {

    // Falta documentação do método
    public Connection conectarBD(){    // N1
        Connection conn = null;
        try{                           // N2
            // Driver possivelmente incorreto e exceção ignorada
            Class.forName("com.mysql.Driver.Manager").newInstance(); // N3

            // URL e credenciais expostas diretamente no código (má prática)
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";

            conn = DriverManager.getConnection(url);

        }catch (Exception e) {        // N4
            // Exceção ignorada
        }
        // Possível retorno null = risco de NullPointer
        return conn;                  // N5
    }

    // Variáveis públicas sem encapsulamento
    public String nome="";
    public boolean result = false;

    // Falta documentação do método
    public boolean verificarUsuario(String login, String senha){   // N6
        String sql = "";

        // 'conn' pode ser null = risco de NullPointer
        Connection conn = conectarBD();

        // Concatenação de dados = vulnerável a SQL Injection
        sql = "select nome from usuarios ";                        // N7
        sql +="where login = '" + login + "'";
        sql +=" and senha = '" + senha + "'";

        try{                                                      // N8
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);                  // (parte do N8)

            if(rs.next()){                                       // N9
                nome = rs.getString("nome");        // N10
                result = true;
            }                                                    // N11

            // Conexões e recursos não são fechados

        }catch (Exception e) {                                   // N12
            // Exceção ignorada
        }

        return result;                                           // N13

    }//fim da class
    // Comentário incorreto: esta chave fecha o método, não a classe

// Falta a chave final para encerrar a classe User corretamente