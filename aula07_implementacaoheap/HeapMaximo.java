package aula07_implementacaoheap;

public class HeapMaximo {
    int[] chaves;
    int CAPACIDADE;
    int tamanho;
    public HeapMaximo(int capacidade) {
        this.CAPACIDADE = capacidade;
        chaves = new int[CAPACIDADE];
    }
    public void inserir(int chave) {
        chaves[tamanho] = chave;
        nadarSubindo(tamanho);
        tamanho++;
    }
    public void nadarSubindo(int posicao) {
        int pai = (posicao-1)/2;
        if(chaves[posicao]>chaves[pai]) {
            int temp = chaves[posicao];
            chaves[posicao] = chaves[pai];
            chaves[pai] = temp;
            nadarSubindo(pai);
        }
    }

    public static void main(String[] args) {
        HeapMaximo h = new HeapMaximo(50);
        h.inserir(54);
        h.inserir(30);
        h.inserir(80);
        h.inserir(23);
        h.inserir(90);
    }
}
