package projetopadaria.controller;

import projetopadaria.model.bean.Estoque;
import projetopadaria.model.dao.EstoqueDao;
import java.sql.SQLException;
import java.util.List;

public class EstoqueController {
    EstoqueDao entDao;
    
    public Estoque inserir(Estoque estEnt) throws SQLException, ClassNotFoundException {
        entDao = new EstoqueDao();
        Estoque estSaida = entDao.inserir(estEnt);
        return estSaida;
    }

    public Estoque alterar(Estoque estEnt) throws SQLException, ClassNotFoundException {
        entDao = new EstoqueDao();
        Estoque endSaida = entDao.alterar(estEnt);
        return endSaida;
    }

    public Estoque buscar(Estoque estEnt) throws SQLException, ClassNotFoundException {
        entDao = new EstoqueDao();
        Estoque endSaida = entDao.buscar(estEnt);
        return endSaida;
    }

    public Estoque excluir(Estoque estEnt) throws SQLException, ClassNotFoundException {
        entDao = new EstoqueDao();
        Estoque endSaida = entDao.excluir(estEnt);
        return endSaida;
    }

    public List<Estoque> listar(Estoque estEnt) throws SQLException, ClassNotFoundException {
        entDao = new EstoqueDao();
        List<Estoque> listEnt = entDao.listar(estEnt);
        return listEnt;
    }
}
