package projetopadaria.controller;

import projetopadaria.model.bean.Produto;
import projetopadaria.model.dao.ProdutoDao;
import java.sql.SQLException;
import java.util.List;

public class ProdutoController {
   ProdutoDao prodDao;
  
   public Produto inserir (Produto prodEnt) throws SQLException, ClassNotFoundException {
       prodDao = new ProdutoDao();
       Produto prodSaida = prodDao.inserir(prodEnt);
       return prodSaida;
   }
   
   public Produto alterar (Produto prodEnt) throws SQLException, ClassNotFoundException {
       prodDao = new ProdutoDao();
       Produto prodSaida = prodDao.alterar(prodEnt);
       return prodSaida;
   }
   
   public Produto buscar (Produto prodEnt) throws SQLException, ClassNotFoundException {
       prodDao = new ProdutoDao();
       Produto prodSaida = prodDao.buscar(prodEnt);
       return prodSaida;
   }
   
   public Produto excluir (Produto prodEnt) throws SQLException, ClassNotFoundException {
       prodDao = new ProdutoDao();
       Produto prodSaida = prodDao.excluir(prodEnt);
       return prodSaida;
   }
   
   public List<Produto> listar (Produto prodEnt) throws SQLException, ClassNotFoundException {
       prodDao = new ProdutoDao();
       List<Produto> listaProd = prodDao.listar(prodEnt);
       return listaProd;
   }
}