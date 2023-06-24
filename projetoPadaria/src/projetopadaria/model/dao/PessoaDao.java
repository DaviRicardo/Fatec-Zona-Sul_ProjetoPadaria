package projetopadaria.model.dao;

import projetopadaria.util.ConexaoDb;
import projetopadaria.model.bean.Pessoa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDao {
    private final Connection c;
    
    public PessoaDao() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }
    
    public Pessoa excluir (Pessoa pesEnt) throws SQLException {
        String sql = "delete from pessoa where id_pessoa = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        
        stmt.setInt(1, pesEnt.getId_pessoa());
        stmt.execute();
        stmt.close();
        this.c.close();
        return pesEnt;
    }
    
    public Pessoa buscar (Pessoa pesEnt) throws SQLException {
        String sql = "select * from pessoa where id_pessoa = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setInt(1, pesEnt.getId_pessoa());
        ResultSet rs = stmt.executeQuery();
        
        Pessoa pesSaida = null;
        while (rs.next()) {
            pesSaida = new Pessoa (
             rs.getInt(1),
           rs.getString (2),
             rs.getString(3),
             rs.getString(4),
                 rs.getString(5),
                rs.getString(6)
                );
            }
        stmt.close();
        return pesSaida;   
    }
    
    public Pessoa inserir (Pessoa pesEnt) throws SQLException {
        String sql = "insert into pessoa" + " (nome_pessoa, sobrenome, telefone, cpf, email) " + " values (?, ?, ?, ?, ?)";
        PreparedStatement stmt = this.c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        stmt.setString(1, pesEnt.getNome_pessoa());
        stmt.setString(2, pesEnt.getSobrenome());
        stmt.setString(3, pesEnt.getTelefone());
        stmt.setString(4, pesEnt.getCpf());
        stmt.setString(5, pesEnt.getEmail());
        
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            pesEnt.setId_pessoa(id);
        }
        stmt.close();
        return pesEnt;
    }
    
    public Pessoa alterar (Pessoa pesEnt) throws SQLException {
        String sql = "update pessoa set nome_pessoa = ?, sobrenome = ?, telefone = ?, cpf = ?, email = ? where id_pessoa = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        
        stmt.setString(1, pesEnt.getNome_pessoa());
        stmt.setString(2, pesEnt.getSobrenome());
        stmt.setString(3, pesEnt.getTelefone());
        stmt.setString(4, pesEnt.getCpf());
        stmt.setString(5, pesEnt.getEmail());
        stmt.setInt(6, pesEnt.getId_pessoa());
        
        stmt.execute();
        stmt.close();
        return pesEnt;
    }
    
    public List<Pessoa> listar (Pessoa pesEnt) throws SQLException {
        List<Pessoa> listaPess = new ArrayList<>();
        String sql = "select * from pessoa where nome_pessoa like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        
        stmt.setString(1, "%" + pesEnt.getNome_pessoa() + "%");
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            Pessoa pes = new Pessoa (
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)
            );
            listaPess.add(pes);
        }
        rs.close();
        stmt.close();
        return listaPess;
    }
}