package projetopadaria.view;

import projetopadaria.model.bean.Pessoa;
import projetopadaria.controller.PessoaController;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;


public class ManterPessoa {

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
        String nome = JOptionPane.showInputDialog("Nome");
        String sobrenome = JOptionPane.showInputDialog("Sobrenome");
        String telefone = JOptionPane.showInputDialog("Telefone");
        String cpf = JOptionPane.showInputDialog("CPF");
        String email = JOptionPane.showInputDialog("E-mail");
        Pessoa pesEnt = new Pessoa(nome, sobrenome, telefone, cpf, email);
        PessoaController pesCont = new PessoaController();
        Pessoa pesSaida = pesCont.inserir(pesEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    private static void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("Nome");
        String sobrenome = JOptionPane.showInputDialog("Sobrenome");
        String telefone = JOptionPane.showInputDialog("Telefone");
        String cpf = JOptionPane.showInputDialog("CPF");
        String email = JOptionPane.showInputDialog("E-mail");
        Pessoa pesEnt = new Pessoa(id, nome, sobrenome, telefone, cpf, email);
        PessoaController pesCont = new PessoaController();
       Pessoa pesSaida = pesCont.alterar(pesEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    private static void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pessoa pesEnt = new Pessoa(id);
        PessoaController pesCont = new PessoaController();
        Pessoa pesSaida = pesCont.buscar(pesEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    private static void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Pessoa pesEnt = new Pessoa(id);
        PessoaController pesCont = new PessoaController();
        Pessoa pesSaida = pesCont.excluir(pesEnt);
        JOptionPane.showMessageDialog(null,pesSaida.toString());
    }

    private static void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("Nome");
        Pessoa pesEnt = new Pessoa(nome);
        PessoaController pesCont = new PessoaController();
        List<Pessoa> listaPessoa = pesCont.listar(pesEnt);
        for (Pessoa pesSaida : listaPessoa) {
            JOptionPane.showMessageDialog(null,pesSaida.toString());
        }
    }    
}
