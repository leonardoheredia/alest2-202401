package aula05_filasdeprioridade_heap;

import utils.ArrayUtils;

/*
 * Estrutura de dados HeapMaximo
 * Implementação para fins didáticos
 * Limitada a números inteiros maiores que 0.
 * O valor -1 na chave indica que a posição do heap está vazia
 * */
public class HeapMaximo {
    private static int POSICAO_INVALIDA = -10;
    private int[] chaves;
    private int capacidade; //capacidade do heap, não a sua quantidade de elementos/chaves
    private int tamanho; //quantidade de elementos/chaves do heap
    public HeapMaximo(int capacidade) {
        this.chaves = new int[capacidade];
        this.capacidade = capacidade;
        this.tamanho = 0;
        for (int i = 0; i < capacidade; i++) { chaves[i] = -1; }
    }
    public HeapMaximo(int[] chaves) {
        this.chaves = chaves;
        this.capacidade = this.chaves.length+1;
        this.tamanho = this.chaves.length;
        gerarHeap();
    }
    private int pai(int posicao) {
        int p = (posicao-1)/2;
        if(p<0) p = 0;
        return p;
    }
    private int filhoEsquerda(int posicao) {
        return posicao * 2 + 1;
    }
    private int filhoDireita(int posicao) {
        int p = posicao * 2 + 2;
        if(p>=tamanho) p = HeapMaximo.POSICAO_INVALIDA;
        return p;

    }
    private void gerarHeap() {
        //um array qualquer recebido no construtor pode nao ser um heap-maximo
        //nesse caso temos que transformar ele em um heap - heapify
        int ultimaPosicao = tamanho - 1;
        int ultimoPai = ultimaPosicao / 2;
        for (int i = ultimoPai; i >= 0; i--) {
            ArrayUtils.imprimir(chaves);
            sinkAfundar(i);
        }
    }
    public int[] getChaves() {
        return chaves;
    }
    public int getTamanho() { return tamanho;}
    public int getCapacidade() { return capacidade;}
    public void inserir(int chave) {
        //Inserir sempre no final

        //verificar se ainda tem espcaço
        if(tamanho+1>capacidade) {
            System.out.println("lotou");
            aumentarCapacidade();
        }
        System.out.println("Inserindo " + chave);
        int ultimaPosicaoPreenchida = this.tamanho;
        this.chaves[ultimaPosicaoPreenchida] = chave;
        this.tamanho++;
        swimNadar(ultimaPosicaoPreenchida);
    }
    public void trocar(int posicaoA, int posicaoB) {
        System.out.printf("   Trocando %d por %d.", chaves[posicaoA], chaves[posicaoB]);
        int temp = chaves[posicaoA];
        chaves[posicaoA] = chaves[posicaoB];
        chaves[posicaoB] = temp;
    }
    public int removerMaximo() { //remove o maior elemento, a raiz
        /*
         * Trocar a chave do pai com o último elemento do heap, ou seja o último elemento vira a raiz e a raiz anterior eh removida do heap
         * Isso pode deixar o heap inconsistente, com uma raiz menor que os filhos
         * Entao o algoritmo deve executar a operacao "afundar" até que o heap fique consistente
         * */

        if(tamanho==0) return -1;
        //troca
        int chaveMaxima = chaves[0];
        trocar(0, tamanho-1);

        //remove a antiga raiz
        this.chaves[this.tamanho-1] = -1;
        this.tamanho = this.tamanho - 1;

        System.out.println("Removido " + chaveMaxima);

        ArrayUtils.imprimir(getChaves());
        //inicia o ajuste afundando a nova raiz ate que o heap seja restaurado
        sinkAfundar(0);
        return chaveMaxima;
    }
    private void sinkAfundar(int posicao) {
        while(2*posicao+1 <= this.tamanho) {

            int maior = posicao;
            int filhoEsquerda = posicao*2 + 1;
            int filhoDireita = posicao*2 + 2;

            if(filhoEsquerda < tamanho && chaves[filhoEsquerda] > chaves[maior]) maior = filhoEsquerda;
            if(filhoDireita < tamanho && chaves[filhoDireita] > chaves[maior]) maior = filhoDireita;

            if(maior!=posicao) { //tem que trocar posicao pelo maior
                trocar(posicao, maior);
            }
            ArrayUtils.imprimir(getChaves());
            posicao = 2*posicao+1;

        }
    }
    private int maior(int posicao1, int posicao2) {
        if(posicao1==HeapMaximo.POSICAO_INVALIDA) return posicao2;
        if(posicao2==HeapMaximo.POSICAO_INVALIDA) return posicao1;
        if(chaves[posicao1]>=chaves[posicao2]) return posicao1;
        else return posicao2;
    }
    private void swimNadar(int posicao) {
        while(posicao > 0 && chaves[pai(posicao)] < chaves[posicao]) {
            trocar(posicao, pai(posicao));
            posicao = pai(posicao); //sobe na arvore
        }
    }
    private void aumentarCapacidade() {
        capacidade = capacidade * 2;
        int[] novoArray = new int[capacidade];
        for (int i = 0; i < capacidade; i++) { novoArray[i] = -1; } //inicializa com -1
        for (int i = 0; i < tamanho; i++) {novoArray[i] = chaves[i];} //copia valores anteriores
        chaves = novoArray;
    }


}