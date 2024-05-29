package aula23_grafos_ordenacaotopologica;

import java.util.Stack;

public class OrdenacaoTopologica {
    private boolean[] visitados;
    private Stack<Integer> pilha;
    private Digrafo digrafo;
    public OrdenacaoTopologica(Digrafo digrafo) {
        this.digrafo = digrafo;
        visitados = new boolean[this.digrafo.numVertices];
        pilha = new Stack<>();

        for (int v = 0; v < this.digrafo.numVertices; v++) {
            if(!visitados[v]) {
                buscarEmProfundidadeRecursivo(v); //DFS(v)
            }
        }
    }
    //  5 4 2 3 1 0
    private void buscarEmProfundidadeRecursivo(int v) {
        visitados[v] = true;
        for(int w:digrafo.adjacentes(v)) {
            if(!visitados[w]) {
                buscarEmProfundidadeRecursivo(w);
            }
        }
        pilha.push(v);
    }
    @Override
    public String toString() {
        //  [5 4 2 3 1 0]
        StringBuilder sb = new StringBuilder("[");
        for (int i = pilha.size()-1; i >=0 ; i--) {
            sb.append(" ").append(pilha.get(i));
        }
        sb.append("]");
        return sb.toString();
    }
}
