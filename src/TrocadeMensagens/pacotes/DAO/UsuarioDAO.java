package TrocadeMensagens.pacotes.DAO;

import TrocadeMensagens.pacotes.entities.Usuarios;
import TrocadeMensagens.pacotes.factories.ConnectionFactory;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAO {
    public void Adicionar(Usuarios u) throws SQLException{
        String sql = "INSERT INTO USUARIO (USERNAME, SENHA, NOME) VALUES (?,?,?)";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, u.getUsername());
        stmt.setString(2, u.getSenha());
        stmt.setString(3, u.getNome());
        
        stmt.execute();
        stmt.close();
        connection.close();        
    }
    
    public ArrayList<Usuarios> SelecionarTodos() throws SQLException{
        ArrayList<Usuarios> array = new ArrayList();
        String sql = "SELECT ID, USERNAME, SENHA, NOME FROM USUARIO";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Usuarios u = new Usuarios();
            u.setId(rs.getInt("ID"));
            u.setUsername(rs.getString("USERNAME"));
            u.setSenha(rs.getString("SENHA"));
            u.setNome(rs.getString("NOME"));
            array.add(u);
        }
        
        return array;
    }
    
    public Usuarios Autenticar(String username, String senha) throws SQLException{
        Usuarios u = null;
        
        String sql = "SELECT ID, USERNAME, SENHA, NOME FROM USUARIO WHERE USERNAME = ? AND SENHA = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, username);
        stmt.setString(2, senha);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            u = new Usuarios();
            u.setId(rs.getInt("ID"));
            u.setUsername(rs.getString("USERNAME"));
            u.setSenha(rs.getString("SENHA"));
            u.setNome(rs.getString("NOME"));
        }
        
        return u;
    }
    
    public Usuarios selecionarPorID(int id) throws SQLException{
        Usuarios u = new Usuarios();
        String sql = "SELECT ID, USERNAME, NOME, SENHA FROM USUARIO WHERE ID = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            u.setId(rs.getInt("ID"));
            u.setUsername(rs.getString("USERNAME"));
            u.setNome(rs.getString("NOME"));
            u.setSenha(rs.getString("SENHA"));
        }
        
        return u;                
    }
}
