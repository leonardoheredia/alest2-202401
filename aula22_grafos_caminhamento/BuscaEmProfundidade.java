package aula22_grafos_caminhamento;

import java.util.ArrayList;

public class BuscaEmProfundidade {
    private boolean[] visitados;
    private int[] anteriores;
    private GrafoListaAdjacencia grafo;
    private int origem;
    public BuscaEmProfundidade(GrafoListaAdjacencia grafo, int origem) {
        this.grafo = grafo;
        this.origem = origem;
        visitados = new boolean[this.grafo.getNumVertices()];
        anteriores = new int[this.grafo.getNumVertices()];

        buscarEmProfundidadeRecursivo(origem);
    }
    private void buscarEmProfundidadeRecursivo(int v) {
        visitados[v] = true;
        for(int w: grafo.adjacentes(v)) {
            if(!visitados[w]) {
                visitados[w] = true;
                anteriores[w] = v;
                buscarEmProfundidadeRecursivo(w);
            }
        }
    }
    public ArrayList<Integer> caminhoPara(int destino) {
        ArrayList<Integer> caminho = new ArrayList<>();
        while(destino!=origem) {
            caminho.add(0, destino);
            destino = anteriores[destino];
        }
        caminho.add(0, origem);
        return caminho;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator()).append("Vertice  | Visitado  | Anterior");
        sb.append(System.lineSeparator()).append("---------|-----------|---------");
        for (int v = 0; v < grafo.getNumVertices(); v++) {
            sb.append(System.lineSeparator()).append(v).append("|").append(visitados[v]).append("|").append(anteriores[v]);
        }
        return sb.toString();
    }
}
