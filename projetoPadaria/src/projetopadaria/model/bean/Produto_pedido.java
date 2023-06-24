package projetopadaria.model.bean;

public class Produto_pedido {
    private int id_produto_pedido;
    private int produto_id_produto;
    private int pedido_id_pedido;
    private int quantidade;
    private float preco;
    private Produto produto;
    private Pedido pedido;

    
    public Produto_pedido(int id_produto_pedido) {
        this.id_produto_pedido = id_produto_pedido;
    }

    public Produto_pedido(float preco) {
        this.preco = preco;
    }

    public Produto_pedido(int produto_id_produto, int pedido_id_pedido, int quantidade, float preco) {
        this.produto_id_produto = produto_id_produto;
        this.pedido_id_pedido = pedido_id_pedido;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Produto_pedido(int id_produto_pedido, int produto_id_produto, int pedido_id_pedido, int quantidade, float preco) {
        this.id_produto_pedido = id_produto_pedido;
        this.produto_id_produto = produto_id_produto;
        this.pedido_id_pedido = pedido_id_pedido;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getId_produto_pedido() {
        return id_produto_pedido;
    }

    public void setId_produto_pedido(int id_produto_pedido) {
        this.id_produto_pedido = id_produto_pedido;
    }

    public int getProduto_id_produto() {
        return produto_id_produto;
    }

    public void setProduto_id_produto(int produto_id_produto) {
        this.produto_id_produto = produto_id_produto;
    }

    public int getPedido_id_pedido() {
        return pedido_id_pedido;
    }

    public void setPedido_id_pedido(int pedido_id_pedido) {
        this.pedido_id_pedido = pedido_id_pedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    @Override
    public String toString() {
        return "Produto_pedido{" + "id_produto_pedido=" + id_produto_pedido + ", produto_id_produto=" + produto_id_produto + ", pedido_id_pedido=" + pedido_id_pedido + ", quantidade=" + quantidade + ", preco=" + preco + '}';
    }
}
