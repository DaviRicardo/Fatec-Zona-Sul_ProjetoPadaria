package projetopadaria.view;

import projetopadaria.model.bean.Endereco;
import projetopadaria.controller.EnderecoController;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;


public class ManterEndereco {

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
        String rua = JOptionPane.showInputDialog("Rua");
        String numero = JOptionPane.showInputDialog("Numero");
        String bairro = JOptionPane.showInputDialog("Bairro");
        String cidade = JOptionPane.showInputDialog("Cidade");
        String estado = JOptionPane.showInputDialog("Estado");
        String cep = JOptionPane.showInputDialog("cep");
        Endereco endEnt = new Endereco(idPessoa, rua, numero, bairro, cidade, estado, cep);
        EnderecoController endCont = new EnderecoController();
        Endereco endSaida = endCont.inserir(endEnt);
        JOptionPane.showMessageDialog(null,endSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String rua = JOptionPane.showInputDialog("Rua");
        String numero = JOptionPane.showInputDialog("Numero");
        String bairro = JOptionPane.showInputDialog("Bairro");
        String cidade = JOptionPane.showInputDialog("Cidade");
        String estado = JOptionPane.showInputDialog("Estado");
        String cep = JOptionPane.showInputDialog("cep");
        Endereco endEnt = new Endereco(id, rua, numero, bairro, cidade, estado, cep);
        EnderecoController endCont = new EnderecoController();
        Endereco endSaida = endCont.alterar(endEnt);
        JOptionPane.showMessageDialog(null,endSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Endereco pesEnt = new Endereco(id);
        EnderecoController endCont = new EnderecoController();
        Endereco endSaida = endCont.buscar(pesEnt);
        JOptionPane.showMessageDialog(null,endSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Endereco endEnt = new Endereco(id);
        EnderecoController endCont = new EnderecoController();
        Endereco endSaida = endCont.excluir(endEnt);
        JOptionPane.showMessageDialog(null,endSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String cidade = JOptionPane.showInputDialog("Cidade");
        Endereco pesEnt = new Endereco(cidade);
        EnderecoController endCont = new EnderecoController();
        List<Endereco> listaEndereco = endCont.listar(pesEnt);
        for (Endereco endSaida : listaEndereco) {
            JOptionPane.showMessageDialog(null,endSaida.toString());
        }
    }    
}
