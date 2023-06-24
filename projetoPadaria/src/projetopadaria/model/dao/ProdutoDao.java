package projetopadaria.model.dao;

import projetopadaria.util.ConexaoDb;
import projetopadaria.model.bean.Produto;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ProdutoDao {
    private final Connection c;
    
    public ProdutoDao () throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }
    
    public Produto excluir (Produto prodEnt) throws SQLException {
        String sql = "DELETE FROM produto WHERE `produto`.`id_produto` = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        
        stmt.setInt(1, prodEnt.getId_produto());
        stmt.execute();
        stmt.close();
        c.close();
        return prodEnt;
    }
    
    public Produto buscar (Produto prodEnt) throws SQLException {
        String sql = "select * from produto where id_produto = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setInt(1, prodEnt.getId_produto());
        ResultSet rs = stmt.executeQuery();
        
        Produto prodSaida = null;
        while (rs.next()) {
            prodSaida = new Produto (
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getFloat(4)
            );
        }
        stmt.close();
        return prodSaida;
    }
    
    public Produto inserir (Produto prodEnt) throws SQLException {
        String sql = "insert into produto " + " (nome_produto, tipo, preco_unitario)" + "values (?, ?, ?)";
        PreparedStatement stmt = this.c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        stmt.setString(1, prodEnt.getNome_produto());
        stmt.setString(2, prodEnt.getTipo());
        stmt.setFloat(3, prodEnt.getPreco_unitario());
        
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            prodEnt.setId_produto(id);
        }
        stmt.close();
        return prodEnt;
    }
    
    public Produto alterar (Produto prodEnt) throws SQLException {
        String sql = "update produto set nome_produto = ?, tipo = ?, preco_unitario = ? where id_produto = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        
        stmt.setString(1, prodEnt.getNome_produto());
        stmt.setString(2, prodEnt.getTipo());
        stmt.setFloat(3, prodEnt.getPreco_unitario());
        stmt.setInt(4, prodEnt.getId_produto());
        
        stmt.execute();
        stmt.close();
        return prodEnt;
    }
    
    public List<Produto> listar (Produto prodEnt) throws SQLException {
        List<Produto> listProd = new ArrayList<>();
        String sql = "select * from produto where nome_produto like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        
        stmt.setString(1, "%" + prodEnt.getNome_produto() + "%");
        
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Produto prod = new Produto (
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getFloat(4)
            );
            listProd.add(prod);
        }
        rs.close();
        stmt.close();
        return listProd;   
    }
}
