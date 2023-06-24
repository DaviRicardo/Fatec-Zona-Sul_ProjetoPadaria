package projetopadaria.controller;

import projetopadaria.model.bean.Pedido;
import projetopadaria.model.dao.PedidoDao;
import java.sql.SQLException;
import java.util.List;

public class PedidoController {
    PedidoDao pedDao;
    
    public Pedido inserir(Pedido pedEnt) throws SQLException, ClassNotFoundException {
        pedDao = new PedidoDao();
        Pedido pedSaida = pedDao.inserir(pedEnt);
        return pedSaida;
    }

    public Pedido alterar(Pedido pedEnt) throws SQLException, ClassNotFoundException {
        pedDao = new PedidoDao();
        Pedido pedSaida = pedDao.alterar(pedEnt);
        return pedSaida;
    }

    public Pedido buscar(Pedido pedEnt) throws SQLException, ClassNotFoundException {
        pedDao = new PedidoDao();
        Pedido pedSaida = pedDao.buscar(pedEnt);
        return pedSaida;
    }

    public Pedido excluir(Pedido pedEnt) throws SQLException, ClassNotFoundException {
        pedDao = new PedidoDao();
        Pedido pedSaida = pedDao.excluir(pedEnt);
        return pedSaida;
    }

    public List<Pedido> listar(Pedido pedEnt) throws SQLException, ClassNotFoundException {
        pedDao = new PedidoDao();
        List<Pedido> listPed = pedDao.listar(pedEnt);
        return listPed;
    }
}
