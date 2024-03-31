package aula11_tabelas_simbolos_tries;

public class TabelaSimbolos<Chave,Valor> {
    class Item<Chave, Valor> {
        Chave chave;
        Valor valor;
        public Item(Chave chave, Valor valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }
    private Item<Chave,Valor>[] itens;
    private int tamanho;
    private int capacidade;
    private final int CAPACIDADE_INICIAL = 5;
    //@SuppressWarnings("unchecked")
    public TabelaSimbolos() {
        capacidade = CAPACIDADE_INICIAL;
        itens = (Item[]) new Item[capacidade];
        tamanho = 0;
    }
    public Valor buscar(Chave chave) {
        for (int i = 0; i < tamanho; i++) {
            if(itens[i].chave.equals(chave)) return (Valor) itens[i].valor;
        }
        return null;
    }
    public void atualizar(Chave chave, Valor valor) {
        if(tamanho==capacidade) duplicarCapacidade();

        for (int i = 0; i < tamanho; i++) {
            if(itens[i].chave.equals(chave)) {
                itens[i].valor = valor;
                return;
            }
        }

        Item<Chave, Valor> n = new Item<>(chave, valor);
        itens[tamanho] = n;
        tamanho++;
    }
    public boolean contem(Chave chave) {
        for (int i = 0; i < tamanho; i++) {
            if(itens[i].chave.equals(chave)) return true;
        }
        return false;
    }

    private void duplicarCapacidade() {
        Item<Chave,Valor>[] arrayTemp = this.itens;
        int capacidadeAnterior = capacidade;
        capacidade = capacidade*2;
        tamanho=0;
        this.itens = new Item[capacidade];
        for (int i = 0; i < capacidadeAnterior; i++) {
            atualizar(arrayTemp[i].chave, arrayTemp[i].valor);
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            sb.append(itens[i].chave).append(" - ").append(itens[i].valor).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
