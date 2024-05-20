package aula18_grafos_aula;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Grafo g = new Grafo(5);
        g.adicionarAresta(0, 1);
        g.adicionarAresta(0,2);
        g.adicionarAresta(0,3);
        g.adicionarAresta(1,3);
        g.adicionarAresta(2,4);
        System.out.println(g.toDot());
        ArrayList<Integer> caminho0 = g.percorrerProfundidade(0);
        System.out.println(caminho0);
    }
}
