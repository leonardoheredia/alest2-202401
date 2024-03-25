package aula08_tabelas_hash;

public class TabelaHashEndAberto {
    private int capacidade;
    private final int CAPACIDADE_INICIAL = 5;
    private int tamanho;
    private int[] chaves;
    private String[] valores;
    public TabelaHashEndAberto() {
        this.capacidade = CAPACIDADE_INICIAL;
        chaves = new int[capacidade];
        valores = new String[capacidade];
        for (int i = 0; i < capacidade; i++) {
            chaves[i] = -1;
        }
    }
    public void adicionar(int chave, String valor) {
        int hash = chave % capacidade;
        if(chaves[hash] == -1) {
            chaves[hash] = chave;
            valores[hash] = valor;
        }
        else {
            int posicao = hash;
            while(posicao<= capacidade -1) {
                if(chaves[posicao]==-1) {
                    chaves[posicao] = chave;
                    valores[posicao] = valor;
                    break;
                }
                posicao++;
            }
        }
        tamanho++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tamanho; i++) {
            sb.append(i).append(" ").append(chaves[i]).append(" ").append(valores[i]).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
