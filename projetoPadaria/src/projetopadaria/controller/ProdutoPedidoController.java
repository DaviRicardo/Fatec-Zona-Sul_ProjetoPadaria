package projetopadaria.controller;

import projetopadaria.model.bean.Produto;
import projetopadaria.model.bean.Pedido;
import projetopadaria.model.bean.Produto_pedido;
import projetopadaria.model.dao.Produto_pedidoDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoPedidoController {
    Produto_pedidoDao prodPedDao;
    ProdutoController prodC;
    PedidoController pedC;
    
    public Produto_pedido inserir(Produto_pedido prodPedEnt) throws SQLException, ClassNotFoundException {
        prodPedDao = new Produto_pedidoDao();
        return prodPedDao.inserir(prodPedEnt);
    }

    public Produto_pedido alterar(Produto_pedido prodPedEnt) throws SQLException, ClassNotFoundException {
        prodPedDao = new Produto_pedidoDao();
        return prodPedDao.alterar(prodPedEnt);
    }
    
    public Produto_pedido buscar(Produto_pedido prodPedEnt) throws SQLException, ClassNotFoundException {
        prodPedDao = new Produto_pedidoDao();
        Produto_pedido pp = prodPedDao.buscar(prodPedEnt);
        Produto prod = new Produto(pp.getProduto_id_produto());
        Pedido ped = new Pedido(pp.getPedido_id_pedido());
        prodC = new ProdutoController();
        pedC = new PedidoController();
        pp.setProduto(prodC.buscar(prod));
        pp.setPedido(pedC.buscar(ped));
        return pp;
    }

    public Produto_pedido excluir(Produto_pedido prodPedEnt) throws SQLException, ClassNotFoundException {
        prodPedDao = new Produto_pedidoDao();
        return prodPedDao.excluir(prodPedEnt);
    }

     public List<Produto_pedido> listar(Produto_pedido prodPedEnt) throws SQLException, ClassNotFoundException {
        prodPedDao = new Produto_pedidoDao();
        List<Produto_pedido> listaProdPed = prodPedDao.listar(prodPedEnt);
        List<Produto_pedido> listaProdPedAux = new ArrayList<>();

        for (Produto_pedido peSaida : listaProdPed) {
            listaProdPedAux.add(buscar(peSaida));
        }
        return listaProdPedAux;
    }
}
