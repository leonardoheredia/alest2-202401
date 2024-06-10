package aula26_grafos_dijkstra;

import java.util.ArrayList;
import java.util.HashSet;

public class GrafoValorado {
    private int numVertices;
    private int numArestas;
    private ArrayList<Aresta>[] listaAdjacencias;
    public GrafoValorado(int numVertices) {
        this.numVertices = numVertices;
        listaAdjacencias = new ArrayList[this.numVertices];
        for(int v = 0; v < this.numVertices; v++) {
            listaAdjacencias[v] = new ArrayList<>();
        }
    }
    public void adicionarAresta(int v, int w, int peso) {
        Aresta e = new Aresta(v, w, peso);
        listaAdjacencias[v].add(e);
        listaAdjacencias[w].add(e);
        numArestas++;
    }
    public int getNumVertices() {
        return numVertices;
    }
    public ArrayList<Aresta> adjacentes(int vertice) {
        return listaAdjacencias[vertice];
    }
    public String toDot() {
        StringBuilder sb = new StringBuilder();
        HashSet<String> arestas = new HashSet<>(); //nao repetir a aresta
        sb.append("graph G {").append(System.lineSeparator());
        for (int i = 0; i < numVertices; i++) {
            for (Aresta a : listaAdjacencias[i]) {
                if(!arestas.contains(a.getV() + " -- " + a.getW()) && !arestas.contains(a.getW() + " -- " + a.getV())) {
                    arestas.add(a.getV() + " -- " + a.getW());
                    sb.append(a.getV()).append(" -- ").append(a.getW()).append(" [label=\"").append(a.getPeso()).append("\"];").append(System.lineSeparator());
                }
            }
        }
        sb.append("}").append(System.lineSeparator());
        return sb.toString();
    }
}
