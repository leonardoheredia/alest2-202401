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
            int posicaoOriginal = posicao;
            while(posicao<= capacidade -1) {
                if(chaves[posicao]==-1) {
                    chaves[posicao] = chave;
                    valores[posicao] = valor;
                    break;
                }
                posicao++;
                if(posicao==capacidade) posicao=0;
                else if(posicao==posicaoOriginal) break;
            }
        }
        tamanho++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacidade; i++) {
            sb.append(i).append(" ").append(chaves[i]).append(" ").append(valores[i]).append(System.lineSeparator());
        }
        return sb.toString();
    }
/*
    public int buscar(int chave) {
        int hash = funcaoHashing(chave);
        int sondagens = 0;
        if (tabela[hash] == -1) {
            return -1;
        } else if (chave == tabela[hash]) {
            return hash; //achou a chave
        } else {
            int posicao_original = hash;
            int proxima_posicao = hash + 1;
            while (true) {  // percorre a tabela até achar a chave ou achar uma posição vazia
                if (proxima_posicao == this.capacidade) proxima_posicao = 0;
                if (chave == [proxima_posicao]) { //achou
                    return hash;
                }
                proxima_posicao++;
                if (tabela[proxima_posicao] == -1 || proxima_posicao == posicao_original)
                    return -1; //se encontrar uma posição vazia ou tiver percorrido tudo e não achado a chave entao retorna -1
            }
        }
*/
    }
