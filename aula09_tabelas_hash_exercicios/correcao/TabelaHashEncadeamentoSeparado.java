package aula09_tabelas_hash_exercicios.correcao;

public class TabelaHashEncadeamentoSeparado {
    private final int CAPACIDADE_INICIAL = 5;
    private Nodo[] tabela;
    private int tamanhoAtual;
    private int capacidade;
    private final double FATOR_DE_CARGA = 0.7;
    public TabelaHashEncadeamentoSeparado() {
        capacidade = CAPACIDADE_INICIAL;
        tabela = new Nodo[capacidade];
        tamanhoAtual = 0;
    }
    public void adicionar(int chave, String valor) {
        if(tamanhoAtual>=capacidade*FATOR_DE_CARGA) {
            System.out.println("duplicando.....");
            duplicarTabela();
        }
        int posicao = funcaoHash(chave);
        Nodo n = new Nodo(chave, valor);
        if(tabela[posicao]==null) tabela[posicao] = n;
        else {
            n.setProximo(tabela[posicao]);
            tabela[posicao] = n;
        }
        tamanhoAtual++;
    }
    public void atualizar(int chave, String valor) {
        int posicao = funcaoHash(chave);
        Nodo n = tabela[posicao];
        while(n!=null) {
            if(n.getChave()==chave) {
                n.setValor(valor);
                return;
            }
            n = n.getProximo();
        }
    }
    public void remover(int chave) {
        int posicao = funcaoHash(chave);
        Nodo n = tabela[posicao];
        Nodo anterior = null;
        while(n!=null) {
            if(n.getChave() == chave) {
                if(anterior==null) { //eh o primeiro nodo da lista
                    tabela[posicao] = n.getProximo();
                }
                else anterior.setProximo(n.getProximo());
                return;
            }
            anterior = n;
            n = n.getProximo();
        }
    }
    private int funcaoHash(int chave) {
        return chave % capacidade;
    }
    public String buscar(int chave) {
        int posicao = funcaoHash(chave);
        Nodo n = tabela[posicao];
        if(n==null) return null;
        while(n!=null) {
            if(chave==n.getChave()) return n.getValor();
            n = n.getProximo();
        }
        return null;
    }
    public void duplicarTabela(){
        Nodo[] tabelaAnterior = tabela;
        int capacidadeAnterior = capacidade;
        capacidade = capacidade * 2;
        tabela = new Nodo[capacidade];
        tamanhoAtual = 0;
        for (int i = 0; i < capacidadeAnterior; i++) {
            if(tabelaAnterior[i]!=null) {
                adicionar(tabelaAnterior[i].getChave(), tabelaAnterior[i].getValor());
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < capacidade; i++) {
            sb.append(i).append(" - ");
            if(tabela[i]!=null) {
                Nodo n = tabela[i];
                while(n!=null) {
                    sb.append(n).append(" ");
                    n = n.getProximo();
                }
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
