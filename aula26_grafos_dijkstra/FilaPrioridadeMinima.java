package aula26_grafos_dijkstra;

import java.util.ArrayList;

public class FilaPrioridadeMinima {
    private class Nodo {
        int vertice;
        int distancia;
        public Nodo(int vertice, int distancia) {
            this.vertice = vertice;
            this.distancia = distancia;
        }
    }
    private ArrayList<Nodo> itens;
    public FilaPrioridadeMinima() {
        itens = new ArrayList<>();
    }
    public void enfileirar(int vertice, int distancia) {
        Nodo n = new Nodo(vertice, distancia);
        for (int i = 0; i < itens.size(); i++) {
            if(n.distancia < itens.get(i).distancia) {
                itens.add(i, n);
                return;
            }
        }
        itens.add(n);
    }
    public int desenfileirar() {
        Nodo n = itens.remove(0);
        return n.vertice;
    }
    public void atualizar(int vertice, int novaDistancia) {
        for (int i = 0; i < itens.size(); i++) {
            if(itens.get(i).vertice == vertice) {
                itens.get(i).distancia = novaDistancia;
                return;
            }
        }
    }
    public boolean estaVazia() {
        return itens.isEmpty();
    }
    public boolean existe(int vertice) {
        for (int i = 0; i < itens.size(); i++) {
            if(itens.get(i).vertice==vertice) return true;
        }
        return false;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Nodo n : itens) {
            sb.append(n.vertice).append(" ").append(n.distancia).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
