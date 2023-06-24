package projetopadaria.view;

import projetopadaria.controller.ProdutoPedidoController;
import projetopadaria.model.bean.Produto_pedido;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;


public class ManterProdutoPedido {
   
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
        int idProduto = Integer.parseInt(JOptionPane.showInputDialog("produto_id_produto"));
        int idPedido = Integer.parseInt(JOptionPane.showInputDialog("pedido_id_pedido"));
        int quantidadeProduto = Integer.parseInt(JOptionPane.showInputDialog("Quantidade do produto"));
        float preco = Float.parseFloat(JOptionPane.showInputDialog("Preço"));
        Produto_pedido ppEnt = new Produto_pedido(idProduto, idPedido, quantidadeProduto, preco);
        ProdutoPedidoController peCont = new ProdutoPedidoController();
        Produto_pedido ppSaida = peCont.inserir(ppEnt);
        JOptionPane.showMessageDialog(null,ppSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException  {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idProduto = Integer.parseInt(JOptionPane.showInputDialog("idProduto"));
        int idPedido = Integer.parseInt(JOptionPane.showInputDialog("idPedido"));
        int quantidadeProduto = Integer.parseInt(JOptionPane.showInputDialog("Quantidade do produto"));
        float preco = Float.parseFloat(JOptionPane.showInputDialog("Preço"));
        Produto_pedido ppEnt = new Produto_pedido(idProduto, idPedido, quantidadeProduto, preco);
        ProdutoPedidoController peCont = new ProdutoPedidoController();
        Produto_pedido ppSaida = peCont.inserir(ppEnt);
        JOptionPane.showMessageDialog(null,ppSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Produto_pedido ppEnt = new Produto_pedido(id);
        ProdutoPedidoController peCont = new ProdutoPedidoController();
        Produto_pedido ppSaida = peCont.buscar(ppEnt);
        JOptionPane.showMessageDialog(null,ppSaida.toString());
        JOptionPane.showMessageDialog(null,ppSaida.getProduto().toString());
        JOptionPane.showMessageDialog(null,ppSaida.getPedido().toString());

    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Produto_pedido ppEnt = new Produto_pedido(id);
        ProdutoPedidoController peCont = new ProdutoPedidoController();
        Produto_pedido ppSaida = peCont.buscar(ppEnt);
        JOptionPane.showMessageDialog(null,ppSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        float preco = Float.parseFloat(JOptionPane.showInputDialog("Preço do produto"));
        Produto_pedido ppEnt = new Produto_pedido(preco);
        ProdutoPedidoController peCont = new ProdutoPedidoController();
        List<Produto_pedido> listaProdutoPedido = peCont.listar(ppEnt);
        for (Produto_pedido ppSaida : listaProdutoPedido) {
            JOptionPane.showMessageDialog(null,ppSaida.toString());
            JOptionPane.showMessageDialog(null,ppSaida.getProduto().toString());
            JOptionPane.showMessageDialog(null,ppSaida.getPedido().toString());
        }
    }
}
