package projetopadaria;

import projetopadaria.view.ManterPessoa;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;
import projetopadaria.view.ManterEndereco;
import projetopadaria.view.ManterEstoque;
import projetopadaria.view.ManterPedido;
import projetopadaria.view.ManterProduto;
import projetopadaria.view.ManterProdutoEstoque;
import projetopadaria.view.ManterProdutoPedido;

public class ProjetoPadaria {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        menu();         
    }

    public static void menu() throws SQLException, ClassNotFoundException, ParseException {
        String msg = " 0 - Sair \n 1 - Endereço \n 2 - Pessoa \n 3 - Pedido \n 4 - Produto \n 5 - Produto_pedido \n 6 - Estoque \n 7 - Produto_estoque \n";
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 0:
                int sair = JOptionPane.showConfirmDialog(null,"Deseja Sair?");
                if (sair > 0) menu();
                break;
            case 1:
                ManterEndereco.menu();
                break;
            case 2:
                ManterPessoa.menu();
                break;
            case 3:
                ManterPedido.menu();
                break;
            case 4:
                ManterProduto.menu();
                break;
            case 5:
                ManterProdutoPedido.menu();
                break;
            case 6:
                ManterEstoque.menu();
                break;
            case 7:
                ManterProdutoEstoque.menu();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção Inválida!", "Entrada inválida", JOptionPane.WARNING_MESSAGE);
        }
    }
}
