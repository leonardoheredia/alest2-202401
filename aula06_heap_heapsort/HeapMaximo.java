package aula06_heap_heapsort;

import utils.ArrayUtils;

public class HeapMaximo {
    int[] chaves;
    int CAPACIDADE;
    int tamanho;
    public HeapMaximo(int capacidade) {
        this.CAPACIDADE = capacidade;
        chaves = new int[CAPACIDADE];
    }
    public HeapMaximo(int[] chaves) {
        this.chaves = chaves;
        CAPACIDADE = chaves.length;
        tamanho = chaves.length;
        for(int i = (tamanho-1)/2; i>=0; i--) {
            afundar(i);
        }
    }
    public void inserir(int chave) {
        chaves[tamanho] = chave;
        nadarSubindo(tamanho);
        tamanho++;
    }
    public int extrairMaximo() {
        int max = chaves[0];
        chaves[0] = chaves[tamanho-1];
        chaves[tamanho-1] = max;
        tamanho--;
        afundar(0);
        return max;
    }
    private void afundar(int posicao) {
        int maior = posicao;
        int fe = 2*posicao + 1;
        int fd = 2*posicao + 2;
        if(fe < tamanho && chaves[fe] > chaves[maior]) maior = fe;
        if(fd < tamanho && chaves[fd] > chaves[maior]) maior = fd;
        if(maior!=posicao) {
            int temp = chaves[posicao];
            chaves[posicao] = chaves[maior];
            chaves[maior] = temp;
            afundar(maior);
        }
    }
    private void nadarSubindo(int posicao) {
        int pai = (posicao-1)/2;
        if(chaves[posicao]>chaves[pai]) {
            int temp = chaves[posicao];
            chaves[posicao] = chaves[pai];
            chaves[pai] = temp;
            nadarSubindo(pai);
        }
    }
    public int[] getChaves() {
        return chaves;
    }
    public static void main(String[] args) {
        HeapMaximo h = new HeapMaximo(50);
        h.inserir(54);
        h.inserir(30);
        h.inserir(80);
        h.inserir(23);
        h.inserir(90);
        System.out.println(h.extrairMaximo());

        int[] a = {30, 40, 23, 70, 51, 18};
        HeapMaximo h2 = new HeapMaximo(a);
        ArrayUtils.imprimir(a);
    }
}
