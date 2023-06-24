package projetopadaria.view;

import projetopadaria.model.bean.Pedido;
import projetopadaria.controller.PedidoController;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ManterPedido {

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
        int idPessoa = Integer.parseInt(JOptionPane.showInputDialog("pessoa_id_pessoa"));
        float valorTotal = Float.parseFloat(JOptionPane.showInputDialog("Valor total"));
        String dataPedido = JOptionPane.showInputDialog("Data do pedido");
        String status = JOptionPane.showInputDialog("Status do pedido");
        Pedido pedEnt = new Pedido(idPessoa, valorTotal, dataPedido, status);
        PedidoController pedCont = new PedidoController();
        Pedido pedSaida = pedCont.inserir(pedEnt);
        JOptionPane.showMessageDialog(null,pedSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        float valorTotal = Float.parseFloat(JOptionPane.showInputDialog("Valor total"));
        String dataPedido = JOptionPane.showInputDialog("Data do pedido");
        String status = JOptionPane.showInputDialog("Status do pedido");
        Pedido pedEnt = new Pedido(id, valorTotal, dataPedido, status);
        PedidoController pedCont = new PedidoController();
        Pedido pedSaida = pedCont.inserir(pedEnt);
        JOptionPane.showMessageDialog(null,pedSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pedido pedtEnt = new Pedido(id);
        PedidoController pedCont = new PedidoController();
        Pedido pedSaida = pedCont.buscar(pedtEnt);
        JOptionPane.showMessageDialog(null,pedSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pedido pedtEnt = new Pedido(id);
        PedidoController pedCont = new PedidoController();
        Pedido pedSaida = pedCont.excluir(pedtEnt);
        JOptionPane.showMessageDialog(null,pedSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Nome");
        Pedido pedtEnt = new Pedido(nome);
        PedidoController pedCont = new PedidoController();
        List<Pedido> listaPedido = pedCont.listar(pedtEnt);
        for (Pedido pedSaida : listaPedido) {
            JOptionPane.showMessageDialog(null,pedSaida.toString());
        }
    }    
}
