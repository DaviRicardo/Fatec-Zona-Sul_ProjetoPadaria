package projetopadaria.controller;

import projetopadaria.model.bean.Endereco;
import projetopadaria.model.dao.EnderecoDao;
import java.sql.SQLException;
import java.util.List;

public class EnderecoController {
    EnderecoDao endDao;
    
    public Endereco inserir(Endereco endEnt) throws SQLException, ClassNotFoundException {
        endDao = new EnderecoDao();
        Endereco endSaida = endDao.inserir(endEnt);
        return endSaida;
    }

    public Endereco alterar(Endereco endEnt) throws SQLException, ClassNotFoundException {
        endDao = new EnderecoDao();
        Endereco endSaida = endDao.alterar(endEnt);
        return endSaida;
    }

    public Endereco buscar(Endereco endEnt) throws SQLException, ClassNotFoundException {
        endDao = new EnderecoDao();
        Endereco endSaida = endDao.buscar(endEnt);
        return endSaida;
    }

    public Endereco excluir(Endereco endEnt) throws SQLException, ClassNotFoundException {
        endDao = new EnderecoDao();
        Endereco endSaida = endDao.excluir(endEnt);
        return endSaida;
    }

    public List<Endereco> listar(Endereco endEnt) throws SQLException, ClassNotFoundException {
        endDao = new EnderecoDao();
        List<Endereco> listEnd = endDao.listar(endEnt);
        return listEnd;
    }
}
