package projetopadaria.model.bean;

public class Produto_estoque {
    private int id_produto_estoque;
    private int produto_id_produto;
    private int estoque_id_estoque;
    private int qntd_produto;
    private String data_entrada;
    private String data_validade;
    private Produto produto;
    private Estoque estoque;

    public Produto_estoque(int id_produto_estoque) {
        this.id_produto_estoque = id_produto_estoque;
    }

    public Produto_estoque(String data_validade) {
        this.data_validade = data_validade;
    }
    
    public Produto_estoque(int qntd_produto, String data_entrada, String data_validade) {
        this.qntd_produto = qntd_produto;
        this.data_entrada = data_entrada;
        this.data_validade = data_validade;
    }

    public Produto_estoque(int produto_id_produto, int estoque_id_estoque, int qntd_produto, String data_entrada, String data_validade) {
        this.produto_id_produto = produto_id_produto;
        this.estoque_id_estoque = estoque_id_estoque;
        this.qntd_produto = qntd_produto;
        this.data_entrada = data_entrada;
        this.data_validade = data_validade;
    }

    public Produto_estoque(int id_produto_estoque, int produto_id_produto, int estoque_id_estoque, int qntd_produto, String data_entrada, String data_validade) {
        this.id_produto_estoque = id_produto_estoque;
        this.produto_id_produto = produto_id_produto;
        this.estoque_id_estoque = estoque_id_estoque;
        this.qntd_produto = qntd_produto;
        this.data_entrada = data_entrada;
        this.data_validade = data_validade;
    }

    public int getId_produto_estoque() {
        return id_produto_estoque;
    }

    public void setId_produto_estoque(int id_produto_estoque) {
        this.id_produto_estoque = id_produto_estoque;
    }

    public int getProduto_id_produto() {
        return produto_id_produto;
    }

    public void setProduto_id_produto(int produto_id_produto) {
        this.produto_id_produto = produto_id_produto;
    }

    public int getEstoque_id_estoque() {
        return estoque_id_estoque;
    }

    public void setEstoque_id_estoque(int estoque_id_estoque) {
        this.estoque_id_estoque = estoque_id_estoque;
    }

    public int getQntd_produto() {
        return qntd_produto;
    }

    public void setQntd_produto(int qntd_produto) {
        this.qntd_produto = qntd_produto;
    }

    public String getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(String data_entrada) {
        this.data_entrada = data_entrada;
    }

    public String getData_validade() {
        return data_validade;
    }

    public void setData_validade(String data_validade) {
        this.data_validade = data_validade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "Produto_estoque{" + "id_produto_estoque=" + id_produto_estoque + ", produto_id_produto=" + produto_id_produto + ", estoque_id_estoque=" + estoque_id_estoque + ", qntd_produto=" + qntd_produto + ", data_entrada=" + data_entrada + ", data_validade=" + data_validade + '}';
    }   
}
