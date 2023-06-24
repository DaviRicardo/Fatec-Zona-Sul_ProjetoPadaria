package projetopadaria.model.dao;

import projetopadaria.model.bean.Produto_estoque;
import projetopadaria.util.ConexaoDb;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Produto_estoqueDao {
    private final Connection c;
    
    public Produto_estoqueDao() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    public Produto_estoque excluir(Produto_estoque prodEst) throws SQLException{
        String sql = "delete from produto_estoque where id_produto_estoque = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, prodEst.getId_produto_estoque());
        stmt.execute();
        stmt.close();
        c.close();
        return prodEst;
    }
    
    public Produto_estoque buscar(Produto_estoque prodEst) throws SQLException{
        String sql = "select * from produto_estoque where id_produto_estoque = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setInt(1, prodEst.getId_produto_estoque());
        ResultSet rs = stmt.executeQuery();
            
        Produto_estoque prodSaida = null;
        while (rs.next()) {      
            prodSaida = new Produto_estoque (
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getString(5),
                rs.getString(6)
            );
        }
        stmt.close();
        return prodSaida;
    }

    public Produto_estoque inserir(Produto_estoque prodEst) throws SQLException {
        String sql = "insert into produto_estoque" + " (produto_id_produto, estoque_id_estoque, qntd_produto, data_entrada, "
                + "data_validade)" + " values (?, ?, ?, ?, ?)";
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        
        stmt.setInt(1, prodEst.getProduto_id_produto());
        stmt.setInt(2, prodEst.getEstoque_id_estoque());
        stmt.setInt(3, prodEst.getQntd_produto());
        stmt.setString(4, prodEst.getData_entrada());
        stmt.setString(5,  prodEst.getData_validade());

        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            prodEst.setId_produto_estoque(id);
        }
        stmt.close();
        return prodEst;
    }

    public Produto_estoque alterar(Produto_estoque prodEst) throws SQLException{
        String sql = "UPDATE produto_estoque SET id_produto_estoque = ?, produto_id_produto = ?, estoque_id_estoque = ?, qntd_produto = ?, "
                + "data_entrada = ?, data_validade = ? WHERE id_produto_estoque = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        
        stmt.setInt(1, prodEst.getId_produto_estoque());
        stmt.setInt(2, prodEst.getProduto_id_produto());
        stmt.setInt(3, prodEst.getEstoque_id_estoque());
        stmt.setInt(4, prodEst.getQntd_produto());
        stmt.setString(5, prodEst.getData_entrada());
        stmt.setString(6,  prodEst.getData_validade());
        stmt.setInt(7, prodEst.getId_produto_estoque());
        
        stmt.execute();
        stmt.close();
        c.close();
        return prodEst;
    }

   public List<Produto_estoque> listar(Produto_estoque prodEst) throws SQLException{
        List<Produto_estoque> prodEstList = new ArrayList<>();
        
        String sql = "select * from produto_estoque where data_validade like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        
        stmt.setString(1,"%" + prodEst.getData_validade() + "%");
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            Produto_estoque produtoEstoque = new Produto_estoque (
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getInt(4),
                rs.getString(5),
                rs.getString(6)
            );
            prodEstList.add(produtoEstoque);
        }
        rs.close();
        stmt.close();
        return prodEstList;
    }
}
