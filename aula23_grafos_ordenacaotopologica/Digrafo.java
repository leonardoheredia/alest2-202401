package aula23_grafos_ordenacaotopologica;

public class Digrafo extends Grafo {
    public Digrafo(int numVertices) {
        super(numVertices);
    }
    @Override
    public void adicionarAresta(int origem, int destino) {
        listaAdjacencias[origem].add(destino);
        numArestas++;
    }

    @Override
    public String toDot() {
        StringBuilder sb = new StringBuilder();
        sb.append("digraph G {").append(System.lineSeparator());
        for (int i = 0; i < numVertices; i++) {
            for (int j : listaAdjacencias[i]) {
                sb.append(i).append(" -> ").append(j).append(";").append(System.lineSeparator());
            }
        }
        sb.append("}").append(System.lineSeparator());
        return sb.toString();
    }
}
