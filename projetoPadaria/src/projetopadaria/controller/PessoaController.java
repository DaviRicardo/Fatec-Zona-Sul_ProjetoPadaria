package projetopadaria.controller;

import projetopadaria.model.bean.Pessoa;
import projetopadaria.model.dao.PessoaDao;
import java.sql.SQLException;
import java.util.List;

public class PessoaController {
   PessoaDao pesDao;
  
   public Pessoa inserir (Pessoa pesEnt) throws SQLException, ClassNotFoundException {
       pesDao = new PessoaDao();
       Pessoa pesSaida = pesDao.inserir(pesEnt);
       return pesSaida;
   }
   
   public Pessoa alterar (Pessoa pestEnt) throws SQLException, ClassNotFoundException {
       pesDao = new PessoaDao();
       Pessoa pesSaida = pesDao.alterar(pestEnt);
       return pesSaida;
   }
   
   public Pessoa buscar (Pessoa pesEnt) throws SQLException, ClassNotFoundException {
       pesDao = new PessoaDao();
       Pessoa pesSaida = pesDao.buscar(pesEnt);
       return pesSaida;
   }
   
   public Pessoa excluir (Pessoa pesEnt) throws SQLException, ClassNotFoundException {
       pesDao = new PessoaDao();
       Pessoa pesSaida = pesDao.excluir(pesEnt);
       return pesSaida;
   }
   
   public List<Pessoa> listar (Pessoa pesEnt) throws SQLException, ClassNotFoundException {
       pesDao = new PessoaDao();
       List<Pessoa> listaPessoa = pesDao.listar(pesEnt);
       return listaPessoa;
   }
}