package aula23_grafos_ordenacaotopologica;

import java.util.ArrayList;

public class Grafo {
    protected ArrayList<Integer>[] listaAdjacencias;
    protected int numVertices;
    protected int numArestas;
    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        this.numArestas = 0;
        listaAdjacencias = new ArrayList[numVertices];
        for (int i = 0; i < this.numVertices; i++) {
            listaAdjacencias[i] = new ArrayList<Integer>();
        }
    }
    public void adicionarAresta(int v, int w) {
        listaAdjacencias[v].add(w);
        listaAdjacencias[w].add(v);
        numArestas++;
    }
    public ArrayList<Integer> adjacentes(int vertice) {
        return listaAdjacencias[vertice];
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            sb.append(i).append(": ");
            for (int j : listaAdjacencias[i]) {
                sb.append(j).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
    public String toDot() {
        StringBuilder sb = new StringBuilder();
        sb.append("graph G {").append(System.lineSeparator());
        for (int i = 0; i < numVertices; i++) {
            for (int j : listaAdjacencias[i]) {
                if (i < j) {
                    sb.append(i).append(" -- ").append(j).append(";").append(System.lineSeparator());
                }
            }
        }
        sb.append("}").append(System.lineSeparator());
        return sb.toString();
    }
    public int getNumVertices() {
        return numVertices;
    }

}
