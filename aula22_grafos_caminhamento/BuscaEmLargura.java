package aula22_grafos_caminhamento;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BuscaEmLargura {
    private boolean[] visitados;
    private int[] anteriores;
    private int[] distancia;
    private GrafoListaAdjacencia grafo;
    private int origem;
    public BuscaEmLargura(GrafoListaAdjacencia grafo, int origem) {
        this.grafo = grafo;
        this.origem = origem;
        visitados = new boolean[this.grafo.getNumVertices()];
        anteriores = new int[this.grafo.getNumVertices()];
        distancia = new int[this.grafo.getNumVertices()];

        buscarEmLargura(origem);
    }
    private void buscarEmLargura(int origem) {
        Queue<Integer> fila = new LinkedList<>();
        fila.add(origem);
        visitados[origem] = true;

        while(!fila.isEmpty()) {
            int v = fila.poll();
            for(int w:grafo.adjacentes(v)) {
                if(!visitados[w]) {
                    fila.add(w);
                    visitados[w] = true;
                    anteriores[w] = v;
                    distancia[w] = distancia[v] + 1;
                }
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
        sb.append(System.lineSeparator()).append("Vertice  | Visitado  | Anterior | Distancia");
        sb.append(System.lineSeparator()).append("---------|-----------|--------- |----------");
        for (int v = 0; v < grafo.getNumVertices(); v++) {
            sb.append(System.lineSeparator()).append(v).append("|").append(visitados[v]).append("|").append(anteriores[v]).append("|").append(distancia[v]);
        }
        return sb.toString();
    }
}

