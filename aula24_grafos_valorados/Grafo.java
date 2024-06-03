package aula24_grafos_valorados;

import java.util.ArrayList;
import java.util.HashSet;

public class Grafo {
    private int numVertices;
    private int numArestas;
    private ArrayList<Aresta>[] listaAdjacencias;
    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        listaAdjacencias = new ArrayList[this.numVertices];
        for (int v = 0; v < this.numVertices; v++) {
            listaAdjacencias[v] = new ArrayList<>();
        }
    }
    public void adicionarAresta(int v, int w, int peso) {
                             //A=0  B=1
        Aresta e1 = new Aresta(v, w, peso);
                            //B=1 A=0
        Aresta e2 = new Aresta(w, v, peso);
        listaAdjacencias[v].add(e1);
        listaAdjacencias[w].add(e2);
        numArestas++;
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
                if(!arestas.contains(i + " -- " + a.getW()) && !arestas.contains(a.getW() + " -- " + i)) {
                    arestas.add(i + " -- " + a.getW());
                    sb.append(i).append(" -- ").append(a.getW()).append(" [label=\"").append(a.getPeso()).append("\"];").append(System.lineSeparator());
                }
            }
        }
        sb.append("}").append(System.lineSeparator());
        return sb.toString();
    }
}
