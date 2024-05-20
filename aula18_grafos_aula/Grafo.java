package aula18_grafos_aula;

import java.util.ArrayList;

//grafo simples usando matriz de adjacencia
public class Grafo {
    private boolean matrizAdj[][];
    private int nArestas;
    private int nVertices;
    public Grafo(int nVertices) {
        this.nVertices = nVertices;
        nArestas = 0;
        matrizAdj = new boolean[this.nVertices][this.nVertices];
    }
    public void adicionarAresta(int v, int w) {
        matrizAdj[v][w] = true;
        matrizAdj[w][v] = true;
        nArestas++;
    }
    public boolean existeAresta(int v, int w) {
        return matrizAdj[v][w];
    }
    public ArrayList<Integer> pegarAdjacentes(int v) {
        ArrayList<Integer> adjacentes = new ArrayList<>();
        for (int w = 0; w < nVertices; w++) {
            if(matrizAdj[v][w]) adjacentes.add(w);
        }
        return adjacentes;
    }
    public String toDot() {
        StringBuilder sb = new StringBuilder("Graph {");
        for (int v = 0; v < nVertices; v++) {
            for(int w=v; w < nVertices; w++) {
                if(matrizAdj[v][w]) {
                    sb.append(System.lineSeparator()).append(v).append("--").append(w);
                }
            }
        }
        sb.append(System.lineSeparator()).append("}");
        return sb.toString();
    }
    public ArrayList<Integer> percorrerProfundidade(int origem) {
        ArrayList<Integer> caminho = new ArrayList<>();
        boolean[] visitados = new boolean[nVertices];
        caminho.add(origem);
        percorrerProfundidadeRecursivo(origem, visitados, caminho);
        return caminho;
    }
    private void percorrerProfundidadeRecursivo(int origem,
                                                boolean[] visitados,
                                                ArrayList<Integer> caminho) {
        visitados[origem] = true;
        ArrayList<Integer> adjacentes = pegarAdjacentes(origem);
        for (int w : adjacentes) {
            if (!visitados[w]) {
                caminho.add(w);
                percorrerProfundidadeRecursivo(w, visitados, caminho);
            }
        }
    }

}
