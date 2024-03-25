package aula09_tabelas_hash_exercicios;

public class Nodo {
    private int chave;
    private String valor;
    private Nodo proximo;
    public Nodo(int chave, String valor) {
        this.chave = chave;
        this.valor = valor;
    }
    public Nodo getProximo() {
        return proximo;
    }
    public void setProximo(Nodo proximo) {
        this.proximo = proximo;
    }

    public int getChave() {
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
