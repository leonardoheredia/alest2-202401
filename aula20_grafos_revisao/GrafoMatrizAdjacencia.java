package aula20_grafos_revisao;

import java.util.ArrayList;

public class GrafoMatrizAdjacencia {
    private int nVertices;
    private int nArestas;
    private boolean[][] matrizAdjacencia;
    public GrafoMatrizAdjacencia(int nVertices) {
        this.nVertices = nVertices;
        matrizAdjacencia = new boolean[this.nVertices][this.nVertices];
    }
    public void adicionarAresta(int v, int w) {
        matrizAdjacencia[v][w] = true;
        matrizAdjacencia[w][v] = true;
        nArestas++;
    }
    public String printaMatriz() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator()).append("  ");
        for (int c = 0; c < nVertices; c++) {
            sb.append(c).append(" ");
        }
        sb.append(System.lineSeparator());

        for (int w = 0; w < nVertices; w++) {
            sb.append(w).append(" ");
            for (int v = 0; v < nVertices; v++) {
                if(matrizAdjacencia[w][v]) sb.append("T ");
                else sb.append("F ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
    public String toDot() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator());
        sb.append("graph {").append(System.lineSeparator());
        for (int v = 0; v < nVertices; v++) {
            for(int w = v; w < nVertices; w++) {
                if(matrizAdjacencia[v][w]) sb.append(v).append("--").append(w).append(System.lineSeparator());
            }
        }
        sb.append("}");
        return sb.toString();
    }
    public ArrayList<Integer> pegarAdjacentes(int v) {
        ArrayList<Integer> adjacentes = new ArrayList<>();
        for (int w = 0; w < nVertices; w++) {
            if(matrizAdjacencia[v][w]) adjacentes.add(w);
        }
        return adjacentes;
    }
    public void buscarEmProfundidade(int origem) {
        //DFS
        boolean[] visitados = new boolean[nVertices];
        buscarEmPrundidadeRecursivo(origem, visitados);
    }
    private void buscarEmPrundidadeRecursivo(int vertice, boolean[] visitados) {
        visitados[vertice] = true;
        System.out.print(vertice + " ");
        ArrayList<Integer> adjacentes = pegarAdjacentes(vertice);
        for (int w:adjacentes) {
            if(!visitados[w]) {
                buscarEmPrundidadeRecursivo(w, visitados);
            }
        }
    }




}
