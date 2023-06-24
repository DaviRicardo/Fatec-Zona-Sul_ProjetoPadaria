package projetopadaria.model.bean;

public class Estoque {
    private int id_estoque;
    private String nome_estoque;
    private String localizacao;

    public Estoque(int id_estoque) {
        this.id_estoque = id_estoque;
    }

    public Estoque(String nome_estoque) {
        this.nome_estoque = nome_estoque;
    }

    public Estoque(String nome_estoque, String localizacao) {
        this.nome_estoque = nome_estoque;
        this.localizacao = localizacao;
    }

    public Estoque(int id_estoque, String nome_estoque, String localizacao) {
        this.id_estoque = id_estoque;
        this.nome_estoque = nome_estoque;
        this.localizacao = localizacao;
    }

    public int getId_estoque() {
        return id_estoque;
    }

    public void setId_estoque(int id_estoque) {
        this.id_estoque = id_estoque;
    }

    public String getNome_estoque() {
        return nome_estoque;
    }

    public void setNome_estoque(String nome_estoque) {
        this.nome_estoque = nome_estoque;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return "Estoque{" + "id_estoque=" + id_estoque + ", nome_estoque=" + nome_estoque + ", localizacao=" + localizacao + '}';
    }
}
