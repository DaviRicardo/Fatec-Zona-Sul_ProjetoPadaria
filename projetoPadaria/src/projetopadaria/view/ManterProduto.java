package projetopadaria.view;

import projetopadaria.model.bean.Produto;
import projetopadaria.controller.ProdutoController;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;


public class ManterProduto {

    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - Buscar \n 4 - Excluir \n 5 - Listar ";
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                inserir();
                break;
            case 2:
                alterar();
                break;
            case 3:
                buscar();
                break;
            case 4:
                excluir();
                break;
            case 5:
                listar();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção Inválida!", "Entrada inválida", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static void inserir() throws SQLException, ClassNotFoundException {
        String nomeProduto = JOptionPane.showInputDialog("Nome");
        String tipo = JOptionPane.showInputDialog("Tipo do produto");
        float precoUnitario = Float.parseFloat(JOptionPane.showInputDialog("Preço unitário"));
        Produto prodEnt = new Produto(nomeProduto, tipo, precoUnitario);
        ProdutoController prodCont = new ProdutoController();
        Produto prodSaida = prodCont.inserir(prodEnt);
        JOptionPane.showMessageDialog(null,prodSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nomeProduto = JOptionPane.showInputDialog("Nome");
        String tipo = JOptionPane.showInputDialog("Tipo do produto");
        float precoUnitario = Float.parseFloat(JOptionPane.showInputDialog("Preço unitário"));
        Produto prodEnt = new Produto(id, nomeProduto, tipo, precoUnitario);
        ProdutoController prodCont = new ProdutoController();
        Produto prodSaida = prodCont.alterar(prodEnt);
        JOptionPane.showMessageDialog(null,prodSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Produto prodEnt  = new Produto(id);
        ProdutoController prodCont = new ProdutoController();
        Produto prodSaida = prodCont.buscar(prodEnt);
        JOptionPane.showMessageDialog(null,prodSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Produto prodEnt  = new Produto(id);
        ProdutoController prodCont = new ProdutoController();
        Produto prodSaida = prodCont.excluir(prodEnt);
        JOptionPane.showMessageDialog(null,prodSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Nome");
        Produto prodEnt  = new Produto(nome);
        ProdutoController prodCont = new ProdutoController();
        List<Produto> listaProduto = prodCont.listar(prodEnt);
        for (Produto prodSaida : listaProduto) {
            JOptionPane.showMessageDialog(null,prodSaida.toString());
        }
    }    
}
