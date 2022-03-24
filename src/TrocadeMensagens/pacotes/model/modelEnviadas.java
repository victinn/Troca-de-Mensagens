package TrocadeMensagens.pacotes.model;

import TrocadeMensagens.pacotes.DAO.MensagensDAO;
import TrocadeMensagens.pacotes.DAO.UsuarioDAO;
import TrocadeMensagens.pacotes.entities.Mensagens;
import TrocadeMensagens.pacotes.entities.Usuarios;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class modelEnviadas extends AbstractTableModel{
    ArrayList<Mensagens> mensagens = new ArrayList();
    String[] colunas = {"Destinatário", "Corpo"};
    
    public void SelecionarEnviadas(int id_remetente) throws SQLException{
        MensagensDAO dao = new MensagensDAO();
        mensagens = dao.SelecionarEnviadas(id_remetente);
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return mensagens.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int coluna){
        return colunas[coluna];
    }
    
    public String pegarNome(int id) throws SQLException{
        UsuarioDAO dao = new UsuarioDAO();
        Usuarios u = dao.selecionarPorID(id);
        return u.getNome();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
            {
                try {
                    return pegarNome(mensagens.get(linha).getId_destinatario());
                } catch (SQLException ex) {
                    Logger.getLogger(modelEnviadas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            case 1:
                return mensagens.get(linha).getCorpo();

        }
        return null;
    }
    
}
