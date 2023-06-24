package projetopadaria.model.bean;

public class Pessoa {
    private int id_pessoa;
    private String nome_pessoa, sobrenome, telefone, cpf, email;

    // Construtor para buscar e excluir
    public Pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    // Construtor para listar
    public Pessoa(String nome_pessoa) {
        this.nome_pessoa = nome_pessoa;
    }

    // Construtor para inserção
    public Pessoa(String nome_pessoa, String sobrenome, String telefone, String cpf, String email) {
        this.nome_pessoa = nome_pessoa;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
    }

    // Construtor para alterar
    public Pessoa(int id_pessoa, String nome_pessoa, String sobrenome, String telefone, String cpf, String email) {
        this.id_pessoa = id_pessoa;
        this.nome_pessoa = nome_pessoa;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
    }

    public int getId_pessoa() {
        return this.id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome_pessoa() {
        return this.nome_pessoa;
    }

    public void setNome_pessoa(String nome_pessoa) {
        this.nome_pessoa = nome_pessoa;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id_pessoa=" + id_pessoa + ", nome_pessoa=" + nome_pessoa + ", sobrenome=" + sobrenome + ", telefone=" + telefone + ", cpf=" + cpf + ", email=" + email + '}';
    }
    
}