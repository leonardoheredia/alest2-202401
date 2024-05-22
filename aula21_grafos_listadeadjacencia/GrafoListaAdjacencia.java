package aula21_grafos_listadeadjacencia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GrafoListaAdjacencia {
    private int numVertices;
    private int numArestas;
    private ArrayList<Integer>[] listaAdjacencias;
    public GrafoListaAdjacencia(int numVertices) {
        this.numVertices = numVertices;
        this.numArestas = 0;
        listaAdjacencias = new ArrayList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            listaAdjacencias[i] = new ArrayList<Integer>();
        }
    }
    public void adicionarAresta(int v, int w) {
        listaAdjacencias[v].add(w);
        listaAdjacencias[w].add(v);
        numArestas++;
    }
    public void removerAresta(int v, int w) {
        listaAdjacencias[v].remove((Integer) w);
        listaAdjacencias[w].remove((Integer) v);
        numArestas--;
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
                if(i < j) {
                    sb.append(i).append(" -- ").append(j).append(";").append(System.lineSeparator());
                }
            }
        }
        sb.append("}").append(System.lineSeparator());
        return sb.toString();
    }
    public ArrayList<Integer> adjacentes(int v) {
        return listaAdjacencias[v];
    }
    public void buscarEmProfundidade(int v) {
        boolean[] visitados = new boolean[numVertices];
        int[] antecessor = new int[numVertices];
        antecessor[v] = -1;
        buscarEmProfudidadeRecursivo(v, visitados, antecessor);
        System.out.println("Antecessores");
        for (int i = 0; i < numVertices; i++) {
            System.out.println(i + ": " + antecessor[i]);
        }
    }
    public void buscarEmProfudidadeRecursivo(int v, boolean[] visitados, int[] antecessor) {
        visitados[v] = true;
        ArrayList<Integer> adjacentes = adjacentes(v);
        for(int w:adjacentes) {
            if(!visitados[w]) {
                antecessor[w] = v;
                buscarEmProfudidadeRecursivo(w, visitados, antecessor);
            }
        }
    }
    public void buscarEmLargura(int origem) {
        boolean[] visitados = new boolean[numVertices];
        int[] anteriores = new int[numVertices];
        LinkedList<Integer> fila = new LinkedList<Integer>();
        fila.add(origem);
        visitados[origem] = true;
        anteriores[origem] = -1;
        while(!fila.isEmpty()) {
            int v = fila.poll();
            ArrayList<Integer> adjacentes = adjacentes(v);
            for(int w:adjacentes) {
                if(!visitados[w]) {
                    visitados[w] = true;
                    anteriores[w] = v;
                    fila.add(w);
                }
            }
        }
        System.out.println("Anteriores");
        for (int i = 0; i < numVertices; i++) {
            System.out.println(i + ": " + anteriores[i]);
        }
    }
}
