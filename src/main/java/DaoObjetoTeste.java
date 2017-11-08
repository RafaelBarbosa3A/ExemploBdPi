
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author r.almeida.barbosa
 */
public class DaoObjetoTeste{
    
    public void inserir(ObjetoTeste novoTeste)
    throws SQLException, Exception{
        String insert = "insert into teste2 (NOME, IDADE) values (?, ?)";
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = ConnectionUtils.getConnection();
            preparedStatement = connection.prepareStatement(insert);
            
            preparedStatement.setString(1, novoTeste.getNome());
            preparedStatement.setInt (2, novoTeste.getIdade());
            
            preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        
        
    }
    
}
