package TrocadeMensagens.pacotes.DAO;

import TrocadeMensagens.pacotes.entities.Mensagens;
import java.sql.SQLException;
import java.sql.Connection;
import TrocadeMensagens.pacotes.factories.ConnectionFactory;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;


public class MensagensDAO {
    public void Adicionar(Mensagens m) throws SQLException{
        String sql = "INSERT INTO MENSAGEM (CORPO, ID_REMETENTE, ID_DESTINATARIO) VALUES (?, ?, ?)";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, m.getCorpo());
        stmt.setInt(2, m.getId_remetente());
        stmt.setInt(3, m.getId_destinatario());
        
        stmt.execute();
        stmt.close();
        connection.close();
    }
    
    public ArrayList<Mensagens> SelecionarTodos() throws SQLException{
        ArrayList<Mensagens> retorno = new ArrayList();
        String sql = "SELECT ID, CORPO, ID_REMETENTE, ID_DESTINATARIO) FROM MENSAGEM";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Mensagens m = new Mensagens();
            m.setId(rs.getInt("ID"));
            m.setCorpo(rs.getString("CORPO"));
            m.setId(rs.getInt("ID_REMETENTE"));
            m.setId_destinatario(rs.getInt("ID_DESTINATARIO"));
            retorno.add(m);
        }
        
        return retorno;        
    }
    
    public ArrayList<Mensagens> SelecionarRecebidas(int id_destinatario) throws SQLException{
        ArrayList<Mensagens> retorno = new ArrayList();
        String sql = "SELECT ID, CORPO, ID_REMETENTE, ID_DESTINATARIO FROM MENSAGEM WHERE ID_DESTINATARIO = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id_destinatario);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Mensagens m = new Mensagens();
            m.setId(rs.getInt("ID"));
            m.setCorpo(rs.getString("CORPO"));
            m.setId(rs.getInt("ID_REMETENTE"));
            m.setId_destinatario(rs.getInt("ID_DESTINATARIO"));
            retorno.add(m);
        }
        
        return retorno;
    }
    
    public ArrayList<Mensagens> SelecionarEnviadas(int id_remetente) throws SQLException{
        ArrayList<Mensagens> retorno = new ArrayList();
        String sql = "SELECT ID, CORPO, ID_REMETENTE, ID_DESTINATARIO FROM MENSAGEM WHERE ID_REMETENTE = ?";
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id_remetente);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            Mensagens m = new Mensagens();
            m.setId(rs.getInt("ID"));
            m.setCorpo(rs.getString("CORPO"));
            m.setId(rs.getInt("ID_REMETENTE"));
            m.setId_destinatario(rs.getInt("ID_DESTINATARIO"));
            retorno.add(m);
        }
        
        return retorno;
    }
}
