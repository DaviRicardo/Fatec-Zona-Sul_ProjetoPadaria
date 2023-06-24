package projetopadaria.model.bean;

public class Produto {
    private int id_produto;
    private String nome_produto;
    private String tipo;
    private float preco_unitario;

    
    public Produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public Produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public Produto(String nome_produto, String tipo, float preco_unitario) {
        this.nome_produto = nome_produto;
        this.tipo = tipo;
        this.preco_unitario = preco_unitario;
    }

    public Produto(int id_produto, String nome_produto, String tipo, float preco_unitario) {
        this.id_produto = id_produto;
        this.nome_produto = nome_produto;
        this.tipo = tipo;
        this.preco_unitario = preco_unitario;
    }

    public int getId_produto() {
        return this.id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome_produto() {
        return this.nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getPreco_unitario() {
        return this.preco_unitario;
    }

    public void setPreco_unitario(float preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    @Override
    public String toString() {
        return "Produto{" + "id_produto=" + id_produto + ", nome_produto=" + nome_produto + ", tipo=" + tipo + ", preco_unitario=" + preco_unitario + '}';
    }   
}
