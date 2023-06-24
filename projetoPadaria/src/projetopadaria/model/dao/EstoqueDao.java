package projetopadaria.model.dao;

import projetopadaria.util.ConexaoDb;
import projetopadaria.model.bean.Estoque;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class EstoqueDao {
    private final Connection c;
    
    public EstoqueDao() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }
    
    public Estoque excluir(Estoque estEnt) throws SQLException {
        String sql = "DELETE FROM estoque WHERE `estoque`.`id_estoque` = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        
        stmt.setInt(1, estEnt.getId_estoque());
        stmt.execute();
        stmt.close();
        c.close();
        return estEnt;
    }
    
    public Estoque buscar(Estoque estEnt) throws SQLException {
        String sql = "select * from estoque where id_estoque = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setInt(1, estEnt.getId_estoque());
        ResultSet rs = stmt.executeQuery();
        
        Estoque estSaida = null;
        while (rs.next()) {
            estSaida = new Estoque (
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)
            );
        }
        stmt.close();
        return estSaida;
    }
    
    public Estoque inserir(Estoque estEnt) throws SQLException {
        String sql = "insert into estoque" + " (nome_estoque, localizacao)" + "values (?, ?)";
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        stmt.setString(1, estEnt.getNome_estoque());
        stmt.setString(2, estEnt.getLocalizacao());
        
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            estEnt.setId_estoque(id);
        }
        stmt.close();
        return estEnt;
    }
    
    public Estoque alterar(Estoque estEnt) throws SQLException {
        String sql = "UPDATE estoque SET nome_estoque = ?, localizacao = ? WHERE id_estoque = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        
        stmt.setString(1, estEnt.getNome_estoque());
        stmt.setString(2, estEnt.getLocalizacao());
        stmt.setInt(3, estEnt.getId_estoque());
        
        stmt.execute();
        stmt.close();
        return estEnt;
    }
    
    public List<Estoque> listar(Estoque estEnt) throws SQLException {
        List<Estoque> listEst = new ArrayList<>();
        String sql = "select * from estoque where nome_estoque like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        
        stmt.setString(1, "%" + estEnt.getNome_estoque() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            Estoque est = new Estoque (
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)
            );
            listEst.add(est);
        }
        rs.close();
        stmt.close();
        return listEst;
    }
 }
