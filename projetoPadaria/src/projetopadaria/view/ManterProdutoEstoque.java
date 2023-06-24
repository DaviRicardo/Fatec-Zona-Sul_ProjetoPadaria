package projetopadaria.view;

import projetopadaria.controller.ProdutoEstoqueController;
import projetopadaria.model.bean.Produto_estoque;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;


public class ManterProdutoEstoque {
   
    public static void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - buscar \n 4 - excluir \n 5 - Listar " ;
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
        int idProduto = Integer.parseInt(JOptionPane.showInputDialog("idProduto"));
        int idEstoque = Integer.parseInt(JOptionPane.showInputDialog("idEstoque"));
        int quantidadeProduto = Integer.parseInt(JOptionPane.showInputDialog("Quantidade do produto"));
        String dataEntrada = JOptionPane.showInputDialog("Data de entrada");
        String dataValidade = JOptionPane.showInputDialog("Data de validade");
        Produto_estoque peEnt = new Produto_estoque(idProduto, idEstoque, quantidadeProduto, dataEntrada, dataValidade);
        ProdutoEstoqueController peCont = new ProdutoEstoqueController();
        Produto_estoque peSaida = peCont.inserir(peEnt);
        JOptionPane.showMessageDialog(null,peSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idProduto = Integer.parseInt(JOptionPane.showInputDialog("idProduto"));
        int idEstoque = Integer.parseInt(JOptionPane.showInputDialog("idEstoque"));
        int quantidadeProduto = Integer.parseInt(JOptionPane.showInputDialog("Quantidade do produto"));
        String dataEntrada = JOptionPane.showInputDialog("Data de entrada");
        String dataValidade = JOptionPane.showInputDialog("Data de validade");
        Produto_estoque peEnt = new Produto_estoque(id, idProduto, idEstoque, quantidadeProduto, dataEntrada, dataValidade);
        ProdutoEstoqueController peCont = new ProdutoEstoqueController();
        Produto_estoque peSaida = peCont.alterar(peEnt);
        JOptionPane.showMessageDialog(null,peSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Produto_estoque prodEstEnt = new Produto_estoque(id);
        ProdutoEstoqueController prodEstCont = new ProdutoEstoqueController();
        Produto_estoque prodEstSaida = prodEstCont.buscar(prodEstEnt);
        JOptionPane.showMessageDialog(null,prodEstSaida.toString());
        JOptionPane.showMessageDialog(null,prodEstSaida.getProduto().toString());
        JOptionPane.showMessageDialog(null,prodEstSaida.getEstoque().toString());

    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Produto_estoque peEnt = new Produto_estoque(id);
        ProdutoEstoqueController peCont = new ProdutoEstoqueController();
        Produto_estoque peSaida = peCont.excluir(peEnt);
        JOptionPane.showMessageDialog(null,peSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String dataValidade = JOptionPane.showInputDialog("Data de validade");
        Produto_estoque peEnt = new Produto_estoque(dataValidade);
        ProdutoEstoqueController peCont = new ProdutoEstoqueController();
        List<Produto_estoque> listaProdutoEstoque = peCont.listar(peEnt);
        for (Produto_estoque prodEstSaida : listaProdutoEstoque) {
            JOptionPane.showMessageDialog(null,prodEstSaida.toString());
            JOptionPane.showMessageDialog(null,prodEstSaida.getProduto().toString());
            JOptionPane.showMessageDialog(null,prodEstSaida.getEstoque().toString());
        }
    }
}
