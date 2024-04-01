package aula11_tabelas_simbolos_tries;

public class TabelaSimbolosEncadeada<Chave, Valor> {
    private class Nodo {
        Chave chave;
        Valor valor;
        Nodo proximo;
        public Nodo(Chave chave, Valor valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }
    private Nodo inicio;
    private int tamanho;
    public Valor buscar(Chave chave) {
        Nodo aux = inicio;
        while(aux!=null) {
            if(aux.chave.equals(chave)) return aux.valor;
            aux = aux.proximo;
        }
        return null;
    }
    public void atualizar(Chave chave, Valor valor) {
        Nodo aux = inicio;
        while (aux!=null) {
            if(aux.chave.equals(chave)) {
                aux.valor = valor;
                return;
            }
            aux = aux.proximo;
        }
        //inserindo um novo
        Nodo novo = new Nodo(chave, valor);
        if(inicio == null) inicio = novo;
        else {
            novo.proximo = inicio;
            inicio = novo;
        }
        tamanho++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Nodo aux = inicio;
        while(aux!=null) {
            sb.append(aux.chave).append(" - ").append(aux.valor).append(System.lineSeparator());
            aux = aux.proximo;
        }
        return sb.toString();
    }
}
