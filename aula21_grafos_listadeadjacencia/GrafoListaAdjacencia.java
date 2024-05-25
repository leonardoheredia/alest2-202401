package aula21_grafos_listadeadjacencia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GrafoListaAdjacencia {
    private ArrayList<Integer>[] listaAdjacencias;
    private int numVertices;
    private int numArestas;
    public GrafoListaAdjacencia(int numVertices) {
        this.numVertices = numVertices;
        this.numArestas = 0;
        listaAdjacencias = new ArrayList[numVertices];
        for (int i = 0; i < this.numVertices; i++) {
            listaAdjacencias[i] = new ArrayList<Integer>();
        }
    }
    public void adicionarAresta(int v, int w) {
        //v = 0 w = 2
        //listaAdjacencias[0].add(2);
        //listaAdjacencias[2].add(0);
        listaAdjacencias[v].add(w);
        listaAdjacencias[w].add(v);
        numArestas++;
    }
    public ArrayList<Integer> adjacentes(int v) {
        return listaAdjacencias[v];
    }
    public void buscarEmLargura(int origem) {
        boolean[] visitados = new boolean[numVertices];
        int[] anteriores = new int[numVertices];
        Queue<Integer> fila = new LinkedList<Integer>();
        fila.add(origem);
        visitados[origem] = true;
        anteriores[origem] = -1;
        while(!fila.isEmpty()) {
            int v = fila.poll();
            ArrayList<Integer> adjacentes = adjacentes(v);
            for(int w: adjacentes) {
                if(!visitados[w]) {
                    fila.add(w);
                    visitados[w] = true;
                    anteriores[w] = v;
                }
            }
        }

        System.out.println("Anteriores");
        for (int i = 0; i < numVertices; i++) {
            System.out.println(i + ": " + visitados[i] + ": " + anteriores[i]);
        }
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

}
