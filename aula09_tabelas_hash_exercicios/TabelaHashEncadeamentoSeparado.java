package aula09_tabelas_hash_exercicios;

import java.util.Arrays;

public class TabelaHashEncadeamentoSeparado {
    private final int CAPACIDADE_INICIAL = 5;
    private final double FATOR_DE_CARGA = 0.7;
    private int capacidade;
    private int tamanhoAtual;
    private Nodo[] tabela;
    public TabelaHashEncadeamentoSeparado() {
        capacidade = CAPACIDADE_INICIAL;
        tabela = new Nodo[capacidade];
    }
    public void adicionar(int chave, String valor) {
        if(tamanhoAtual>=capacidade*FATOR_DE_CARGA) {
            duplicarTabelaHash();
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
    public int funcaoHash(int chave) {
        return chave % capacidade;
    }
    public String buscar(int chave) {
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
        tamanhoAtual = 0;
        for (int i = 0; i < capacidadeAnterior; i++) {
            Nodo n = tabelaAnterior[i];
            while(n!=null) {
                adicionar(n.getChave(), n.getValor());
                n = n.getProximo();
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
