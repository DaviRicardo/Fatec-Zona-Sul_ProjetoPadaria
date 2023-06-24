package projetopadaria.view;

import projetopadaria.model.bean.Estoque;
import projetopadaria.controller.EstoqueController;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class ManterEstoque {

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
        String nomeEstoque = JOptionPane.showInputDialog("Nome do estoque");
        String localizacao = JOptionPane.showInputDialog("Localização do estoque");
        Estoque estEnt = new Estoque(nomeEstoque, localizacao);
        EstoqueController estCont = new EstoqueController();
        Estoque estSaida = estCont.inserir(estEnt);
        JOptionPane.showMessageDialog(null,estSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nomeEstoque = JOptionPane.showInputDialog("Nome do estoque");
        String localizacao = JOptionPane.showInputDialog("Localização do estoque");
        Estoque estEnt = new Estoque(nomeEstoque, localizacao);
        EstoqueController estCont = new EstoqueController();
        Estoque estSaida = estCont.alterar(estEnt);
        JOptionPane.showMessageDialog(null,estSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Estoque estEnt = new Estoque(id);
        EstoqueController estCont = new EstoqueController();
        Estoque estSaida = estCont.buscar(estEnt);
        JOptionPane.showMessageDialog(null,estSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Estoque estEnt = new Estoque(id);
        EstoqueController estCont = new EstoqueController();
        Estoque estSaida = estCont.excluir(estEnt);
        JOptionPane.showMessageDialog(null,estSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Nome");
        Estoque estEnt = new Estoque(nome);
        EstoqueController estCont = new EstoqueController();
        List<Estoque> listaEstoque = estCont.listar(estEnt);
        for (Estoque estSaida : listaEstoque) {
            JOptionPane.showMessageDialog(null,estSaida.toString());
        }
    }    
}
