package projetopadaria.controller;

import projetopadaria.model.bean.Produto;
import projetopadaria.model.bean.Estoque;
import projetopadaria.model.bean.Produto_estoque;
import projetopadaria.model.dao.Produto_estoqueDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoEstoqueController {
    Produto_estoqueDao prodEstDao;
    ProdutoController prodC;
    EstoqueController estC;
    
    public Produto_estoque inserir(Produto_estoque prodEstEnt) throws SQLException, ClassNotFoundException {
        prodEstDao = new Produto_estoqueDao();
        return prodEstDao.inserir(prodEstEnt);
    }

    public Produto_estoque alterar(Produto_estoque prodEstEnt) throws SQLException, ClassNotFoundException {
        prodEstDao = new Produto_estoqueDao();
        return prodEstDao.alterar(prodEstEnt);
    }
    
    public Produto_estoque buscar(Produto_estoque prodEstEnt) throws SQLException, ClassNotFoundException {
        prodEstDao = new Produto_estoqueDao();
        Produto_estoque pe = prodEstDao.buscar(prodEstEnt);
        Produto p = new Produto(pe.getProduto_id_produto());
        Estoque t = new Estoque(pe.getEstoque_id_estoque());
        prodC = new ProdutoController();
        estC = new EstoqueController();
        pe.setProduto(prodC.buscar(p));
        pe.setEstoque(estC.buscar(t));
        return pe;
    }

    public Produto_estoque excluir(Produto_estoque prodEstEnt) throws SQLException, ClassNotFoundException {
        prodEstDao = new Produto_estoqueDao();
        return prodEstDao.excluir(prodEstEnt);
    }

     public List<Produto_estoque> listar(Produto_estoque prodEstEnt) throws SQLException, ClassNotFoundException {
        prodEstDao = new Produto_estoqueDao();
        List<Produto_estoque> listaProdEst = prodEstDao.listar(prodEstEnt);
        List<Produto_estoque> listaProdEstAux = new ArrayList<>();

        for (Produto_estoque prodEstSaida : listaProdEst) {
            listaProdEstAux.add(buscar(prodEstSaida));
        }
        return listaProdEstAux;
    }
}
