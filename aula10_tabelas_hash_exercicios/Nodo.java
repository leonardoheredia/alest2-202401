package aula10_tabelas_hash_exercicios;

public class Nodo {
    private long chave;
    private String valor;
    private Nodo proximo;
    public Nodo(long chave, String valor) {
        this.chave = chave;
        this.valor = valor;
    }
    public Nodo getProximo() {
        return proximo;
    }
    public void setProximo(Nodo proximo) {
        this.proximo = proximo;
    }
    public long getChave() {
        return chave;
    }
    public String getValor() {
        return valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "{" + chave + "," + valor + "}";
    }
}
