package projetopadaria.model.bean;

public class Endereco {
    private int id_endereco;
    private int pessoa_id_pessoa;
    private String rua, numero, bairro, cidade, estado, cep;
    private Pessoa p;

    // Construtor para buscar e excluir
    public Endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }
    
    // Construtor para listar
    public Endereco(String cidade) {
        this.cidade = cidade;
    }
    
    // Construtor para inserção
    public Endereco(int pessoa_id_pessoa, String rua, String numero, String bairro, String cidade, String estado, String cep) {
        this.pessoa_id_pessoa = pessoa_id_pessoa;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
    
    
    // Construtor para alterar
    public Endereco(int id_endereco, int pessoa_id_pessoa, String rua, String numero, String bairro, String cidade, String estado, String cep) {
        this.id_endereco = id_endereco;
        this.pessoa_id_pessoa = pessoa_id_pessoa;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    public int getId_endereco() {
        return this.id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public int getPessoa_id_pessoa() {
        return this.pessoa_id_pessoa;
    }

    public void setPessoa_id_pessoa(int pessoa_id_pessoa) {
        this.pessoa_id_pessoa = pessoa_id_pessoa;
    }

    public String getRua() {
        return this.rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Pessoa getP() {
        return this.p;
    }

    public void setP(Pessoa p) {
        this.p = p;
    }
   
    @Override
    public String toString() {
        return "Endereco{" + "id_endereco=" + id_endereco + ", pessoa_id_pessoa=" + pessoa_id_pessoa + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + '}';
    }
}
