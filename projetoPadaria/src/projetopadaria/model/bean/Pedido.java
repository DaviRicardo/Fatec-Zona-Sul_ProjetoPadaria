package projetopadaria.model.bean;

public class Pedido {
    private int id_pedido;
    private int pessoa_id_pessoa;
    private float valor_total;
    private String data_pedido;
    private String status;

    public Pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Pedido(String status) {
        this.status = status;
    }

    public Pedido(int pessoa_id_pessoa, float valor_total, String data_pedido, String status) {
        this.pessoa_id_pessoa = pessoa_id_pessoa;
        this.valor_total = valor_total;
        this.data_pedido = data_pedido;
        this.status = status;
    }

    
    public Pedido(int id_pedido, int pessoa_id_pessoa, float valor_total, String data_pedido, String status) {
        this.id_pedido = id_pedido;
        this.pessoa_id_pessoa = pessoa_id_pessoa;
        this.valor_total = valor_total;
        this.data_pedido = data_pedido;
        this.status = status;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getPessoa_id_pessoa() {
        return pessoa_id_pessoa;
    }

    public void setPessoa_id_pessoa(int pessoa_id_pessoa) {
        this.pessoa_id_pessoa = pessoa_id_pessoa;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public String getData_pedido() {
        return data_pedido;
    }

    public void setData_pedido(String data_pedido) {
        this.data_pedido = data_pedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id_pedido=" + id_pedido + ", pessoa_id_pessoa=" + pessoa_id_pessoa + ", valor_total=" + valor_total + ", data_pedido=" + data_pedido + ", status=" + status + '}';
    }  
}
