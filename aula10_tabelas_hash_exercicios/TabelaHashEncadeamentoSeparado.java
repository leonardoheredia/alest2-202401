package aula10_tabelas_hash_exercicios;

public class TabelaHashEncadeamentoSeparado {
    private final int CAPACIDADE_INICIAL = 4789;
    private final double FATOR_DE_CARGA = 0.7;
    private int capacidade;
    private int tamanhoAtual;
    private int colisoesAtual;
    private Nodo[] tabela;
    public TabelaHashEncadeamentoSeparado() {
        capacidade = CAPACIDADE_INICIAL;
        tabela = new Nodo[capacidade];
    }
    public void adicionar(long chave, String valor) {
        if(tamanhoAtual>=capacidade*FATOR_DE_CARGA) {
            //System.out.println(colisoesAtual);
            duplicarTabelaHash();
        }
        int posicao = funcaoHash(chave);
        Nodo n = new Nodo(chave, valor);
        if(tabela[posicao]==null) tabela[posicao] = n;
        else {
            colisoesAtual++;
            n.setProximo(tabela[posicao]);
            tabela[posicao] = n;
        }
        tamanhoAtual++;
    }
    public int funcaoHash(long chave) {
        return (int) (chave % capacidade);
        //return funcaoHash2(chave);
    }
    public String buscar(long chave) {
        int posicao = funcaoHash(chave);
        Nodo n = tabela[posicao];
        while(n!=null) {
            if(chave==n.getChave()) return n.getValor();
            else n = n.getProximo();
        }
        return null;
    }
    public void remover(int chave) {
        int posicao = funcaoHash(chave);
        Nodo n = tabela[posicao];
        Nodo anterior = null;
        while (n!=null) {
            if(chave==n.getChave()) {//achei quem eu quero excluir
                if(anterior==null)  { //eh o primeiro da lista
                    tabela[posicao] = n.getProximo();
                }
                else anterior.setProximo(n.getProximo());
                tamanhoAtual--;
            }
            anterior = n;
            n = n.getProximo();
        }
    }

    private void duplicarTabelaHash() {
        Nodo[] tabelaAnterior = tabela;
        int capacidadeAnterior = capacidade;
        capacidade = capacidade*2;
        tabela = new Nodo[capacidade];
        //System.out.println("novo tamanho = " + capacidade);
        //colisoesAtual = 0;
        tamanhoAtual = 0;
        for (int i = 0; i < capacidadeAnterior; i++) {
            Nodo n = tabelaAnterior[i];
            while(n!=null) {
                adicionar(n.getChave(), n.getValor());
                n = n.getProximo();
            }
        }
    }

    public int getCAPACIDADE_INICIAL() {
        return CAPACIDADE_INICIAL;
    }
    public int getColisoesAtual() {
        return colisoesAtual;
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
