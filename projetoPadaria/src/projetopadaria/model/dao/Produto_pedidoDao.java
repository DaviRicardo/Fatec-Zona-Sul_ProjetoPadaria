package projetopadaria.model.dao;

import projetopadaria.util.ConexaoDb;
import projetopadaria.model.bean.Produto_pedido;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class Produto_pedidoDao {
    private final Connection c;
    
    public Produto_pedidoDao() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }
    
    public Produto_pedido excluir (Produto_pedido prodPed) throws SQLException {
        String sql = "delete from produto_pedido where id_produto_pedido = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, prodPed.getId_produto_pedido());
        stmt.execute();
        stmt.close();
        c.close();
        return prodPed;
    }
    
    public Produto_pedido buscar (Produto_pedido prodPed) throws SQLException {
        String sql = "select * from produto_pedido where id_produto_pedido = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setInt(1, prodPed.getId_produto_pedido());
        ResultSet rs = stmt.executeQuery();
        Produto_pedido prodPedSaida = null;
        while (rs.next()) {
            prodPedSaida = new Produto_pedido (
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getFloat(5)
            );
        }
        stmt.close();
        return prodPedSaida;
    }
    
    public Produto_pedido inserir (Produto_pedido prodPed) throws SQLException {
        String sql = "insert into produto_pedido" + " (produto_id_produto, pedido_id_pedido, quantidade, preco)"
                + " values (?, ?, ?, ?)";
        PreparedStatement stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, prodPed.getProduto_id_produto());
        stmt.setInt(2, prodPed.getPedido_id_pedido());
        stmt.setInt(3, prodPed.getQuantidade());
        stmt.setFloat(4, prodPed.getPreco());
        
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        
        if (rs.next()) {
            int id = rs.getInt(1);
            prodPed.setId_produto_pedido(id);
        }
        stmt.close();
        return prodPed;
    }
    
    public Produto_pedido alterar (Produto_pedido prodPed) throws SQLException {
        String sql = "update produto_pedido set produto_id_produto = ?, pedido_id_pedido = ?, quantidade = ?, "
                + "preco = ?, where id_produto_pedido = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        
        stmt.setInt(1, prodPed.getProduto_id_produto());
        stmt.setInt(2, prodPed.getPedido_id_pedido());
        stmt.setInt(3, prodPed.getQuantidade());
        stmt.setFloat(4, prodPed.getPreco());
        stmt.setInt(5, prodPed.getId_produto_pedido());
        
        stmt.execute();
        stmt.close();
        return prodPed;
    }
    
    public List<Produto_pedido> listar (Produto_pedido prodPed) throws SQLException {
       List<Produto_pedido> prodPedList = new ArrayList<>();
       
       String sql = "select * from produto_pedido where preco = ?";
       PreparedStatement stmt = this.c.prepareStatement(sql);
       stmt.setFloat(1, prodPed.getPreco());
       
       ResultSet rs = stmt.executeQuery();
       while (rs.next()) {
           Produto_pedido prod = new Produto_pedido (
                   rs.getInt(1),
                   rs.getInt(2),
                   rs.getInt(3),
                   rs.getInt(4),
                   rs.getFloat(5) 
           );
           prodPedList.add(prod);
       }
       stmt.close();
       rs.close();
       return prodPedList;
    } 
}
