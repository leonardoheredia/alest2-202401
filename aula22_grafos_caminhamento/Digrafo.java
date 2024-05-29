package aula22_grafos_caminhamento;

public class Digrafo extends GrafoListaAdjacencia {
    //implementar 2705
    public Digrafo(int numVertices) {
        super(numVertices);
    }
    @Override
    public void adicionarAresta(int v, int w) {
        listaAdjacencias[v].add(w);
        numArestas++;
    }
}
