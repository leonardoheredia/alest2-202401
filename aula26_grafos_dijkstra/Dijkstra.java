package aula26_grafos_dijkstra;

public class Dijkstra {
    private int[] anteriores;
    private int[] distancias;
    private GrafoValorado grafo;
    private FilaPrioridadeMinima listaAuxiliar;

    public Dijkstra(GrafoValorado gv, int origem) {
        this.grafo = gv;
        anteriores = new int[grafo.getNumVertices()];
        distancias = new int[grafo.getNumVertices()];
        listaAuxiliar = new FilaPrioridadeMinima();
        for (int v = 0; v < grafo.getNumVertices(); v++) {
            anteriores[v] = -1;
            distancias[v] = Integer.MAX_VALUE;
        }

        anteriores[origem] = -1;
        distancias[origem] = 0;
        listaAuxiliar.enfileirar(origem, 0);
        while(!listaAuxiliar.estaVazia()) {
            int v = listaAuxiliar.desenfileirar();
            for(Aresta a:grafo.adjacentes(v)) {
                int w = a.getOutro(v);
                int peso = a.getPeso();
                int distParaW = distancias[v] + peso;
                if(distParaW < distancias[w]) { //se a distancia for menor que a atual entao muda
                    anteriores[w] = v;
                    distancias[w] = distParaW;
                    //atualiza a lista/fila de prioridade
                    if(listaAuxiliar.existe(w)) listaAuxiliar.atualizar(w, distParaW);
                    else listaAuxiliar.enfileirar(w, distParaW);
                }
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator()).append("vertice;anterior;distancia");
        for (int v = 0; v < grafo.getNumVertices(); v++) {
            sb.append(System.lineSeparator()).append(v).append(";").append(anteriores[v]).append(";").append(distancias[v]);
        }
        return sb.toString();
    }
}
