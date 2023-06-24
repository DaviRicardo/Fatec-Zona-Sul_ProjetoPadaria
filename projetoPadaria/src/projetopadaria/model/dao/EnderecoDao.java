package projetopadaria.model.dao;

import projetopadaria.util.ConexaoDb;
import projetopadaria.model.bean.Endereco;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDao {
    private final Connection c;
   
    public EnderecoDao() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }
    
    public Endereco excluir(Endereco endEnt) throws SQLException {
        String sql = "delete from endereco where id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, endEnt.getId_endereco());
        stmt.execute();
        stmt.close();
        c.close();
        return endEnt;
    }
    
    public Endereco buscar(Endereco endEnt) throws SQLException {
        String sql = "select * from endereco where id_endereco = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setInt(1, endEnt.getId_endereco());
        ResultSet rs = stmt.executeQuery();
        
        Endereco endSaida = null;
        while (rs.next()) {
            endSaida = new Endereco (
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8)
            );
        }
        stmt.close();
        return endSaida;
    }
    
    public Endereco inserir(Endereco endEnt) throws SQLException {
        String sql = "insert into endereco " + " (pessoa_id_pessoa, rua, numero, bairro, cidade, estado, cep)" + " values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        stmt.setInt(1, endEnt.getPessoa_id_pessoa());
        stmt.setString(2, endEnt.getRua());
        stmt.setString(3, endEnt.getNumero());
        stmt.setString(4, endEnt.getBairro());
        stmt.setString(5, endEnt.getCidade());
        stmt.setString(6, endEnt.getEstado());
        stmt.setString(7, endEnt.getCep());
        
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        
        if (rs.next()) {
            int id = rs.getInt(1);
            endEnt.setId_endereco(id);
        }
        stmt.close();
        return endEnt;
    }
    
    public Endereco alterar (Endereco endEnt) throws SQLException {
        String sql = "update endereco set pessoa_id_pessoa = ?, rua = ?, numero = ?, bairro = ?, "
                + "cidade = ?, estado = ?, cep = ? where id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, endEnt.getPessoa_id_pessoa());
        stmt.setString(2, endEnt.getRua());
        stmt.setString(3, endEnt.getNumero());
        stmt.setString(4, endEnt.getBairro());
        stmt.setString(5, endEnt.getCidade());
        stmt.setString(6, endEnt.getEstado());
        stmt.setString(7, endEnt.getCep());
        stmt.setInt(8, endEnt.getId_endereco());
        
        stmt.execute();
        stmt.close();
        return endEnt;
    }
    
    public List<Endereco> listar (Endereco endEnt) throws SQLException {
        List<Endereco> listEnd = new ArrayList<>();
        String sql = "select * from endereco where cidade like ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setString(1, "%" + endEnt.getCidade() + "%");
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            Endereco end = new Endereco (
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6), 
                    rs.getString(7),
                    rs.getString(8)
            );
            listEnd.add(end);
        }
        rs.close();
        stmt.close();
        return listEnd;
    }
}