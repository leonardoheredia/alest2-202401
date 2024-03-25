package aula09_tabelas_hash_exercicios;

import java.util.Arrays;

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
        //IMPLEMENTAR
    }
    public void remover(int chave) {
        //implementar
    }
    private int funcaoHash(int chave) {
        return chave % capacidade;
    }
    public String buscar(int chave) {
        //implementar
        return null;
    }
    public void duplicarTabela(){
        //implementar
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
