package projetopadaria.model.dao;

import projetopadaria.util.ConexaoDb;
import projetopadaria.model.bean.Pedido;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class PedidoDao {
    private final Connection c;
    
    public PedidoDao() throws SQLException, ClassNotFoundException {
        this.c = ConexaoDb.getConexaoMySQL();
    }
    
    public Pedido excluir(Pedido pedEnt) throws SQLException {
        String sql = "delete from pedido where id = ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        stmt.setInt(1, pedEnt.getId_pedido());
        stmt.execute();
        stmt.close();
        this.c.close();
        return pedEnt;
    }
    
    public Pedido buscar(Pedido pedEnt) throws SQLException {
        String sql = "select * from pedido where id_pedido = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        stmt.setInt(1, pedEnt.getId_pedido());
        
        ResultSet rs = stmt.executeQuery();
        Pedido pedSaida = null;
        while (rs.next()) {
            pedSaida = new Pedido (
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getFloat(3),
                    rs.getString(4),
                    rs.getString(5)
            );
        }
        stmt.close();
        return pedSaida;
    }
    
    public Pedido inserir(Pedido pedEnt) throws SQLException {
        String sql = "insert into pedido (pessoa_id_pessoa, valor_total, data_pedido, status)" + " values (?, ?, ?, ?)";
        PreparedStatement stmt = this.c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        stmt.setInt(1, pedEnt.getPessoa_id_pessoa());
        stmt.setFloat(2, pedEnt.getValor_total());
        stmt.setString(3, pedEnt.getData_pedido());
        stmt.setString(4, pedEnt.getStatus());
        
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        
        if (rs.next()) {
            int id = rs.getInt(1);
            pedEnt.setId_pedido(id);
        }
        stmt.close();
        return pedEnt;
    }
    
    public Pedido alterar (Pedido pedEnt) throws SQLException {
        String sql = "update pedido set valor_total = ?, data_pedido = ?, status = ? where id_pedido ?";
        PreparedStatement stmt = c.prepareStatement(sql);
        
        stmt.setFloat(1, pedEnt.getValor_total());
        stmt.setString(2, pedEnt.getData_pedido());
        stmt.setString(3, pedEnt.getStatus());
        
        stmt.execute();
        stmt.close();
        return pedEnt;
    }
    
    public List<Pedido> listar(Pedido pedEnt) throws SQLException {
        List<Pedido> listPed = new ArrayList<>();
        String sql = "select * from pedido where status like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        
        stmt.setString(1, "%" + pedEnt.getStatus() + "%");
        
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Pedido ped = new Pedido (
                    rs.getInt(1),
                    rs.getFloat(2),
                    rs.getString(3),
                    rs.getString(4)
            );
            listPed.add(ped);
        }
        rs.close();
        stmt.close();
        return listPed;
    }
}
