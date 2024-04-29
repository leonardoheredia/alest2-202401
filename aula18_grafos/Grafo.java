package aula18_grafos;

public class Grafo {
    private int nVertices;
    private int nArestas;
    private boolean[][] matrizAdjacencia;
    public Grafo(int nVertices) {
        this.nVertices = nVertices;
        matrizAdjacencia = new boolean[this.nVertices][this.nVertices];
    }
    public void adicionarAresta(int v, int w) {
        matrizAdjacencia[v][w] = true;
        matrizAdjacencia[w][v] = true;
        nArestas++;
    }
    public String toDot() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator()).append("Graph {");
        for (int v = 0; v < nVertices; v++) {
            for (int w = v; w < nVertices; w++) {
                if(matrizAdjacencia[v][w]) {
                    sb.append(System.lineSeparator());
                    sb.append(v).append("--").append(w);
                }
            }
        }
        sb.append(System.lineSeparator()).append("}");
        return sb.toString();
    }
    public int grau(int vertice) {
        int c = 0;
        for (int w = 0; w < nVertices; w++) {
            if(matrizAdjacencia[vertice][w]) c++;
        }
        return c;
    }
    public void removerAresta(int v, int w) {
        if(matrizAdjacencia[v][w]) {
            matrizAdjacencia[v][w] = false;
            matrizAdjacencia[w][v] = false;
            nArestas--;
        }
    }

















}
